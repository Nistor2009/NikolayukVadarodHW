package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.States;

import java.util.List;

public interface ClientRepository {
    public Client addClient(Client client);
    public List<Client> getAllClient();
    public Client getClientById(Long id);
    public Client deleteClientById(Long id);
    public Client updateClientState(Long id, States state);
}
