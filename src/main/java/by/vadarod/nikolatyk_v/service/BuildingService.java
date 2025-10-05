package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.repository.BuildingRepository;
import by.vadarod.nikolatyk_v.repository.BuildingRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;

public class BuildingService {
    private final SessionFactory sessionFactory;
    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Building addBuilding(Building building) {
        BuildingRepository buildingRepository = new BuildingRepositoryImpl(sessionFactory);
        buildingRepository.addBuilding(building);
        return building;
    }
    public Building getBuildingById(Long id){
        BuildingRepository buildingRepository = new BuildingRepositoryImpl(sessionFactory);
        return buildingRepository.getBuildingById(id);
    }

    public Building updatePricePerHour(Long id, double newPrice){
        BuildingRepository buildingRepository = new BuildingRepositoryImpl(sessionFactory);
        return buildingRepository.updatePricePerHour(id, newPrice);
    }
    public Building addBuildingWithDetach(Long id, String newNumber) {
        BuildingRepository buildingRepository = new BuildingRepositoryImpl(sessionFactory);
        return buildingRepository.addBuildingWithDetach(id, newNumber);
    }
    public List<Building> getAllSmallBuildings(){
        BuildingRepository buildingRepository = new BuildingRepositoryImpl(sessionFactory);
        return buildingRepository.getAllSmallBuildings();
    }
}
