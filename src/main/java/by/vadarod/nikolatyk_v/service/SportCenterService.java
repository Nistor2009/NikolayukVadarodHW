package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.config.HibernateJavaConfig;
import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.SportServ;
import by.vadarod.nikolatyk_v.entity.ClientStatus;
import org.hibernate.SessionFactory;

import java.util.List;

public class SportCenterService {

    private final SessionFactory sessionFactory;
    private final ClientService clientService;
    private final SportServService sportServService;
    private final BuildingService buildingService;

    public SportCenterService() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
        clientService = new ClientService(sessionFactory);
        sportServService = new SportServService(sessionFactory);
        buildingService = new BuildingService(sessionFactory);
    }

    public List<Client>  getAllClient(){
        return clientService.getAllClient();
    }

    public Client getClientById(Long id){
        return clientService.getClientById(id);
    }

    public void addFiveClient(){
        clientService.addFiveClient();
    }

    public Client deleteClientById(Long id){
        return clientService.deleteClientById(id);
    }

    public Client updateClientState(Long id, ClientStatus state){
        return clientService.updateClientState(id, state);
    }
/*
    SportServ
 */
    public SportServ addSportServ(SportServ sportServ){
        return sportServService.addSportServ(sportServ);
    }
    public SportServ getSportServByName(String name){
        return sportServService.getSportServByName(name);
    }

    /*
        Building
     */
    public Building addBuilding(Building building){
        return buildingService.addBuilding(building);
    }
    public Building getBuildingById(Long id){
        return buildingService.getBuildingById(id);
    }

    public Building updateBuildingPricePerHour(Long id, double newPrice){
        return buildingService.updatePricePerHour(id, newPrice);
    }

    public Building addBuildingWithDetach(Long id, String newNumber){
        return buildingService.addBuildingWithDetach(id, newNumber);
    }

}
