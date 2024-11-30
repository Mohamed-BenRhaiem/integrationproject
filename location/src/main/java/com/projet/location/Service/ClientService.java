package com.projet.location.Service;

import com.projet.location.Repository.ClientRepository;
import com.projet.location.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return  clientRepository.findAll();
    }

    public void add(Client client) {
        clientRepository.save(client);
    }

    public void update(Client client) {

    }
}
