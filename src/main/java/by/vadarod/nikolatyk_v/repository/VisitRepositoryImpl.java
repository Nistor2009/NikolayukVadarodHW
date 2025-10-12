package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VisitRepositoryImpl implements VisitRepository{
    private final SessionFactory sessionFactory;

    public VisitRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long addVisit(Visit visit) {
        Long id;
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visit);
        session.getTransaction().commit();
        id = visit.getId();
        session.close();
        return id;
    }
}
