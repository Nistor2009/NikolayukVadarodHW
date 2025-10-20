package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.Record;
import by.vadarod.nikolatyk_v.entity.Visitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecordRepositoryImpl implements RecordRepository{
    private final SessionFactory sessionFactory;

    public RecordRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long addRecord(Record record) {
        Long id;
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(record);
        session.getTransaction().commit();
        id = record.getId();
        session.close();
        return id;
    }
}
