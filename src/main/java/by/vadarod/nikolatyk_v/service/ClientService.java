package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.States;
import by.vadarod.nikolatyk_v.repository.ClientRepository;
import by.vadarod.nikolatyk_v.repository.ClientRepositoryImpl;

import java.util.GregorianCalendar;
import java.util.List;

public class ClientService {

    public Client addClient(Client client) {
        ClientRepository ClientRepository = new ClientRepositoryImpl();
        ClientRepository.addClient(client);
        return client;
    }

    public List<Client> getAllClient() {
        ClientRepository ClientRepository = new ClientRepositoryImpl();
        List<Client> clients = ClientRepository.getAllClient();
        return clients;
    }

    public Client deleteClientById(Long id) {
        ClientRepository ClientRepository = new ClientRepositoryImpl();
        Client client = ClientRepository.deleteClientById(id);
        return client;
    }

    public void addFiveClient() {
        ClientRepository clientRepository = new ClientRepositoryImpl();
        Client client;
        if (clientRepository.getClientById(1L) == null) {
            client = new Client(1L, "Вася", "Пупкин", 23, "+375292223344", new GregorianCalendar(2025, 8, 28), States.ACTIVE.toString(), 100.15);
            clientRepository.addClient(client);
        }
        if (clientRepository.getClientById(2L) == null) {
            client = new Client(2L, "Петя", "Васечкин", 23, "+375293333344", new GregorianCalendar(2025, 8, 28), States.ACTIVE.toString(), 150.20);
            clientRepository.addClient(client);
        }
        if (clientRepository.getClientById(3L) == null) {
            client = new Client(3L, "Ваня", "Петкин", 23, "+375294443344", new GregorianCalendar(2025, 8, 28), States.ACTIVE.toString(), 57.50);
            clientRepository.addClient(client);
        }
        if (clientRepository.getClientById(4L) == null) {
            client = new Client(4L, "Дональд", "Ванечкин", 23, "+375295553344", new GregorianCalendar(2025, 8, 28), States.ACTIVE.toString(), 250.0);
            clientRepository.addClient(client);
        }
        if (clientRepository.getClientById(5L) == null) {
            client = new Client(5L, "Илон", "Далькин", 23, "+375296663344", new GregorianCalendar(2025, 8, 28), States.ACTIVE.toString(), 245.90);
            clientRepository.addClient(client);
        }
    }

    public Client updateClientState(Long id, States state){
        ClientRepository ClientRepository = new ClientRepositoryImpl();
        Client client = ClientRepository.updateClientState(id, state);
        return client;
    }
}
