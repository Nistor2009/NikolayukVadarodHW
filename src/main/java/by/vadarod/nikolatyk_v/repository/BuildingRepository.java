package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository {
    public Long addBuilding(Building building);
    public Optional<Building> getBuildingById(Long id);
    public Building updatePricePerHour(Long id, double newPrice);
    public Building addBuildingWithDetach(Long id, String newNumber);
    public List<Building> getAllSmallBuildings();
    public Building deleteBuildingById(Long id);
    public double getPriceForPerson(Long id);
}
