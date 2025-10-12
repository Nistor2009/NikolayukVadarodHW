package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.repository.BuildingRepository;
import by.vadarod.nikolatyk_v.repository.BuildingRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class BuildingService {
    private final BuildingRepository buildingRepository;
    public BuildingService(SessionFactory sessionFactory) {
        buildingRepository = new BuildingRepositoryImpl(sessionFactory);
    }
    public Long addBuilding(Building building) {
        return buildingRepository.addBuilding(building);
    }
    public Optional<Building> getBuildingById(Long id){
        return buildingRepository.getBuildingById(id);
    }

    public Building updatePricePerHour(Long id, double newPrice){
        return buildingRepository.updatePricePerHour(id, newPrice);
    }
    public Building addBuildingWithDetach(Long id, String newNumber) {
        return buildingRepository.addBuildingWithDetach(id, newNumber);
    }
    public List<Building> getAllSmallBuildings(){
        return buildingRepository.getAllSmallBuildings();
    }
    public Building deleteBuildingById(Long id){
        return buildingRepository.deleteBuildingById(id);
    }
}
