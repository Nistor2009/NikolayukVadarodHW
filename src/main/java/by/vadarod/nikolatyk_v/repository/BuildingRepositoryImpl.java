package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.Record;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
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
}
