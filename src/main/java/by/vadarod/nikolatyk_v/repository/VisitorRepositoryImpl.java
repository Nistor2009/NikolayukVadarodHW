package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.config.HibernateConnection;
import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.Visitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class VisitorRepositoryImpl implements VisitorRepository{
    private final SessionFactory sessionFactory;

    public VisitorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Visitor add(Visitor visitor) {
        Session session = sessionFactory.openSession();;
        session.detach(visitor);    
        session.getTransaction().begin();
        session.merge(visitor);
        session.getTransaction().commit();
        session.close();
        return visitor;
    }

    @Override
    public List<Visitor> findALl() {
        Session session = sessionFactory.openSession();
        List<Visitor> visitors;
        try {
            visitors = session.createQuery("select v FROM Visitor v").getResultList();
            session.close();
        } catch (NoResultException e) {
            visitors = List.of();
        }
        return visitors;
    }

    @Override
    public Optional<Visitor> getById(Long id) {
        Visitor visitor;
        Session session = sessionFactory.openSession();
        try {
            visitor = session.get(Visitor.class, id);
        } catch (NoResultException e) {
            visitor = null;
        }
        session.close();
        return Optional.ofNullable(visitor);
    }
}
