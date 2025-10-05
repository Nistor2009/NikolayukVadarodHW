package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.SportServ;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SportServRepositoryImpl implements SportServRepository {

    private final SessionFactory sessionFactory;

    public SportServRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SportServ addSportServ(SportServ services) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(services);
        session.getTransaction().commit();
        session.close();
        return services;
    }
    public SportServ getSportServByName(String name) {
        SportServ sportServ;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from SportServ s where s.name =:name", SportServ.class);
        query.setParameter("name", name);
        try {
            sportServ = (SportServ) query.getSingleResult();
        } catch (NoResultException e) {
            sportServ = null;
        }
        session.close();
        return sportServ;
    }
}
