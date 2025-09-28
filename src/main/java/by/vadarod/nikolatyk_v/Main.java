package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.entity.Status;
import by.vadarod.nikolatyk_v.service.ClientService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        clientService.addFiveClient();
        System.out.println(clientService.getAllClient());
//        System.out.println(clientService.deleteClientById(2L));
        System.out.println(clientService.updateClientState(3L, Status.BLOCKED));
    }
}