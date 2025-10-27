package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Employee;
import by.vadarod.nikolatyk_v.entity.SportServ;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<SportServ> getLowerPriceCriteria(){
        Optional<SportServ> sportServ;
        List<SportServ> sportServs;
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SportServ> criteriaQuery = criteriaBuilder.createQuery(SportServ.class);
        Root<SportServ> root = criteriaQuery.from(SportServ.class);
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("price")));
        try {
            sportServs = entityManager.createQuery(criteriaQuery).getResultList();
            sportServ = sportServs.stream().findFirst();
        } catch (NoResultException e) {
            sportServ = Optional.empty();
        }
        entityManager.close();
        return sportServ;
    }
}
