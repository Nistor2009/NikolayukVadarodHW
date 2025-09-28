package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.config.HibernateConnection;
import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.States;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    public Client addClient(Client client) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
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
        EntityManager entityManager = HibernateConnection.getEntityManager();

        Query query = entityManager.createQuery("select s from Client s where s.id =:id");
        query.setParameter("id", id);
        try {
            client = (Client) query.getSingleResult();
        } catch (NoResultException e) {
            client = null;
        }
        entityManager.close();
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
    public Client updateClientState(Long id, States state) {
        EntityManager entityManager = HibernateConnection.getEntityManager();
        Client client = getClientById(id);
        if (client != null) {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("update Client c set c.state = :state where c.id = :id");
            query.setParameter("state", state.toString());
            query.setParameter("id", id);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        return client;
    }
}
