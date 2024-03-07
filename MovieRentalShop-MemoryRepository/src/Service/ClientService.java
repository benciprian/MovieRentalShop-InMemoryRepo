package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.HashSet;
import java.util.Set;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public Set<Client> getAllClients() {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public Client removeClient(Long id) {
        return clientRepository.delete(id);
    }

    public Client getMovieById(Long id) {
        return clientRepository.findOne(id);

    }
}
