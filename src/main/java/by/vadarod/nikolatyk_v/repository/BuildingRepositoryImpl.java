package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BuildingRepositoryImpl implements BuildingRepository{
    private final SessionFactory sessionFactory;

    public BuildingRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Building addBuilding(Building building) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(building);
        session.getTransaction().commit();
        session.close();
        return building;
    }

    @Override
    public Building getBuildingById(Long id) {
        Building building;
        Session session = sessionFactory.openSession();
        try {
            building = session.get(Building.class, id);
        } catch (NoResultException e) {
            building = null;
        }
        session.close();
        return building;
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
}
