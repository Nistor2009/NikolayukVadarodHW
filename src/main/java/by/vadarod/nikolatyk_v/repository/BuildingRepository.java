package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.SportServ;

public interface BuildingRepository {
    public Building addBuilding(Building building);
    public Building getBuildingById(Long id);
    public Building updatePricePerHour(Long id, double newPrice);
    public Building addBuildingWithDetach(Long id, String newNumber);
}
