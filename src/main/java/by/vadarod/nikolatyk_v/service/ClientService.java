package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.*;
import by.vadarod.nikolatyk_v.repository.ClientRepository;
import by.vadarod.nikolatyk_v.repository.ClientRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(SessionFactory sessionFactory) {
        clientRepository = new ClientRepositoryImpl(sessionFactory);
    }

    public Client addClient(Client client) {
        clientRepository.addClient(client);
        return client;
    }
    public Client getClientById(Long id) {
        Client client = clientRepository.getClientById(id);
        return client;
    }

    public List<Client> getAllClient() {
        List<Client> clients = clientRepository.getAllClient();
        return clients;
    }
    public List<PrimeClient> getAllPrimeClient() {
        List<PrimeClient> clients = clientRepository.getAllPrimeClient();
        return clients;
    }

    public Client deleteClientById(Long id) {
        Client client = clientRepository.deleteClientById(id);
        return client;
    }

    public void addFiveClient() {
        Client client;
            client = new Client(null, "Вася", "Пупкин", 23, "+375292223344"
                            , new Address("Минск", "Гоголя", "4","1235513"));
            addClient(client);
            client = new Client(null, "Петя", "Васечкин", 23, "+375293333344"
                            , new Address("Минск", "Гоголя", "4","1235513"));
            addClient(client);
            client = new Client(null, "Ваня", "Петкин", 23, "+375294443344"
                    , new Address("Минск", "Гоголя", "4","1235513"));
            addClient(client);
            client = new Client(null, "Дональд", "Ванечкин", 23, "+375295553344"
                    , new Address("Минск", "Гоголя", "4","1235513"));
            addClient(client);
            client = new Client(null, "Илон", "Далькин", 23, "+375296663344"
                    , new Address("Минск", "Гоголя", "4","1235513"));
            addClient(client);
    }

    public Client updateClientState(Long id, ClientStatus state){
        Client client = clientRepository.updateClientState(id, state);
        return client;
    }
    public List<Client> getClientByName(String name){
        return clientRepository.getClientByName(name);
    }
}
