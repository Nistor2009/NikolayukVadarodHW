package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.ClientStatus;
import by.vadarod.nikolatyk_v.entity.PrimeClient;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    public Client addClient(Client client);
    public List<Client> getAllClient();
    public List<PrimeClient> getAllPrimeClient();
    public Client getClientById(Long id);
    public Client deleteClientById(Long id);
    public List<Client> getClientByName(String name);
    public Client updateClientState(Long id, ClientStatus state);
}
