package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.Record;
import by.vadarod.nikolatyk_v.entity.SportServ;
import by.vadarod.nikolatyk_v.entity.Visitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BuildingRepositoryImpl implements BuildingRepository{
    private final SessionFactory sessionFactory;

    public BuildingRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long addBuilding(Building building) {
        Long id;
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(building);
        session.getTransaction().commit();
        id = building.getId();
        session.close();
        return id;
    }

    @Override
    public Optional<Building> getBuildingById(Long id) {
        Building building;
        Session session = sessionFactory.openSession();
        try {
            building = session.get(Building.class, id);
        } catch (NoResultException e) {
            building = null;
        }
        session.close();
        return Optional.ofNullable(building);
    }
    @Override
    public Building addBuildingWithDetach(Long id, String newNumber) {
        Session session = sessionFactory.openSession();
        Building building = session.get(Building.class, id);
        session.detach(building);
        building.setId(null);
        building.setIdentNumber(newNumber);
        session.beginTransaction();
        session.merge(building);
        session.getTransaction().commit();
        session.close();
        return building;
    }
    @Override
    public Building updatePricePerHour(Long id, double newPrice) {
        Session session = sessionFactory.openSession();
        Building building = session.get(Building.class, id);
        building.setPricePerHour(newPrice);
        session.beginTransaction();
        session.merge(building);
        session.getTransaction().commit();
        session.close();
        return building;
    }

    @Override
    public List<Building> getAllSmallBuildings() {
        Session session = sessionFactory.openSession();
        List<Building> buildings;
        try {
            buildings = session.createQuery("select s FROM SmallBuilding s").getResultList();
            session.close();
        } catch (NoResultException e) {
            buildings = List.of();
        }
        return buildings;
    }

    @Override
    public Building deleteBuildingById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Building building = session.get(Building.class, id);
        session.remove(building);
        session.getTransaction().commit();
        session.close();
        return building;
    }

    @Override
    public double getPriceForPerson(Long id) {
        double pricePerHour;
        int maxPeopleCount;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select b.pricePerHour as pricePerHour, b.maxPeopleCount as maxPeopleCount from Building b where b.id = :id");
        query.setParameter("id", id);
        try {
            Object[] result = (Object[]) query.getSingleResult();
            try {
                pricePerHour = (Double) result[0];
            }catch (NullPointerException e){
                throw new RuntimeException("No pricePerHour for building " + id);
            }
            try {
                maxPeopleCount = (Integer)result[1];
            }catch (NullPointerException e){
                throw new RuntimeException("No max_people_count for building " + id);
            }
        }catch (NoResultException e){
            throw new RuntimeException("No such building " + id);
        }
        session.close();
        return pricePerHour/maxPeopleCount;
    }

    @Override
    public int getAllPeopleCriteria(){
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Building> root = criteriaQuery.from(Building.class);
        criteriaQuery.select(criteriaBuilder.sum(root.get("maxPeopleCount")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Building> findOlderFiftyCriteria(){
//        select b.* from work.building b
//        left join work.record r on r.building_id = b.id
//        join work.client cl on cl.id = r.client_id
//        where cl.age > 50
        List<Building> buildings;
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Building> criteriaQuery = criteriaBuilder.createQuery(Building.class);
        Root<Building> rootBuilding = criteriaQuery.from(Building.class);
        Root<Record> rootRecord = criteriaQuery.from(Record.class);
        System.out.println( rootRecord.getJoins());
        /*
        getJoins выдал пустой массив. Далее попытка join выдает Attribute 'by.vadarod.nikolatyk_v.entity.Record#buildingId(BASIC)' is not joinable
        что с этим делать я, честно не знаю
         */
//        Join<Record, Building> buildingJoin = rootRecord.join("buildingId");
//        buildingJoin.on(criteriaBuilder.equal(rootBuilding.get("id"), rootRecord.get("buildingId")));
//        Join<Record, Visitor> visitorJoin = buildingJoin.join("clientId");
//        criteriaQuery.where(criteriaBuilder.gt(visitorJoin.get("age"), 50));
        criteriaQuery.select(rootBuilding);
        try {
            buildings = entityManager.createQuery(criteriaQuery).getResultList();;
        } catch (NoResultException e) {
            buildings = List.of();
        }
        entityManager.close();
        return buildings;
    }
}

