package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.config.HibernateConnection;
import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.ClientStatus;
import by.vadarod.nikolatyk_v.entity.PrimeClient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    private final SessionFactory sessionFactory;

    public ClientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Client addClient(Client client) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        session.close();
        return client;
    }

    public List<Client> getAllClient() {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        List<Client> clients;
        try {
            clients = entityManager.createQuery("select s FROM Client s").getResultList();
            entityManager.close();
        } catch (NoResultException e) {
            clients = List.of();
        }
        return clients;
    }

    public Client getClientById(Long id) {
        Client client;
        Session session = sessionFactory.openSession();
        try {
            client = session.get(Client.class, id);
        } catch (NoResultException e) {
            client = null;
        }
        session.close();
        return client;
    }

    public Client deleteClientById(Long id) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        Client client = getClientById(id);
        if (client != null) {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete from Client s where s.id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        return client;
    }

    @Override
    public Client updateClientState(Long id, ClientStatus status) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        Client client = getClientById(id);
        if (client != null) {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("update Client c set c.status = :status where c.id = :id");
            query.setParameter("status", status.toString());
            query.setParameter("id", id);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        return getClientById(id);
    }

    @Override
    public List<PrimeClient> getAllPrimeClient() {
        Session session = sessionFactory.openSession();
        List<PrimeClient> clients;
        try {
            clients = session.createQuery("select s FROM PrimeClient s").getResultList();
            session.close();
        } catch (NoResultException e) {
            clients = List.of();
        }
        return clients;
    }

    @Override
    public List<Client> getClientByName(String name) {
        List<Client> clients = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select c FROM Client c where c.name = :name");
            query.setParameter("name", name);
            clients = (List<Client>)query.getResultList();
        } catch (NoResultException e) {
            clients = List.of();
        }
        session.close();
        return clients;
    }
}
