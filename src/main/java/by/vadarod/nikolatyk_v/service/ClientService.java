package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.ClientStatus;
import by.vadarod.nikolatyk_v.repository.ClientRepository;
import by.vadarod.nikolatyk_v.repository.ClientRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.GregorianCalendar;
import java.util.List;

public class ClientService {
    private final SessionFactory sessionFactory;
    public ClientService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Client addClient(Client client) {
        ClientRepository clientRepository = new ClientRepositoryImpl(sessionFactory);
        clientRepository.addClient(client);
        return client;
    }
    public Client getClientById(Long id) {
        ClientRepository clientRepository = new ClientRepositoryImpl(sessionFactory);
        Client client = clientRepository.getClientById(id);
        return client;
    }

    public List<Client> getAllClient() {
        ClientRepository clientRepository = new ClientRepositoryImpl(sessionFactory);
        List<Client> clients = clientRepository.getAllClient();
        return clients;
    }

    public Client deleteClientById(Long id) {
        ClientRepository clientRepository = new ClientRepositoryImpl(sessionFactory);
        Client client = clientRepository.deleteClientById(id);
        return client;
    }

    public void addFiveClient() {
        Client client;
            client = new Client(null, "Вася", "Пупкин", 23, "+375292223344", new GregorianCalendar(2025, 8, 28), ClientStatus.ACTIVE.toString(), 100.15);
            addClient(client);
            client = new Client(null, "Петя", "Васечкин", 23, "+375293333344", new GregorianCalendar(2025, 8, 28), ClientStatus.ACTIVE.toString(), 150.20);
            addClient(client);
            client = new Client(null, "Ваня", "Петкин", 23, "+375294443344", new GregorianCalendar(2025, 8, 28), ClientStatus.ACTIVE.toString(), 57.50);
            addClient(client);
            client = new Client(null, "Дональд", "Ванечкин", 23, "+375295553344", new GregorianCalendar(2025, 8, 28), ClientStatus.ACTIVE.toString(), 250.0);
            addClient(client);
            client = new Client(null, "Илон", "Далькин", 23, "+375296663344", new GregorianCalendar(2025, 8, 28), ClientStatus.ACTIVE.toString(), 245.90);
            addClient(client);
    }

    public Client updateClientState(Long id, ClientStatus state){
        ClientRepository clientRepository = new ClientRepositoryImpl(sessionFactory);
        Client client = clientRepository.updateClientState(id, state);
        return client;
    }
}
