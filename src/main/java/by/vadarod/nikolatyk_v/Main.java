package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.entity.Building;
import by.vadarod.nikolatyk_v.entity.BuildingStatus;
import by.vadarod.nikolatyk_v.service.SportCenterService;

public class Main {
    public static void main(String[] args) {
        SportCenterService service = new SportCenterService();
//       service.addFiveClient();
//        System.out.println(service.getAllClient());
//        for (Client client: service.getAllClient()){
//            service.deleteClientById(client.getId());
//        }
//        System.out.println(service.deleteClientById(2L));
//        System.out.println(service.updateClientState(14L, Status.PRIME));
//        System.out.println(service.getClientById(15L));

//        SportServ sportServ;
//        sportServ = new SportServ(null, "Теннис", 75.0);
//        System.out.println(service.addSportServ(sportServ));
//        Building building = new Building(null, "Аякс", "123N", 240, BuildingStatus.ACTIVE.toString(), 1380.0);
//        System.out.println(service.addBuilding(building));

        System.out.println(service.getSportServByName("Теннис"));
        System.out.println(service.getBuildingById(2L));
//        System.out.println( service.updateBuildingPricePerHour(2L, 1391.1));
        System.out.println(service.getBuildingById(2L));
//        System.out.println(service.addBuildingWithDetach(2L, "31R"));
    }
}