package com.projet.location.Controller;

import com.projet.location.Service.ClientService;
import com.projet.location.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("get-all")
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @PostMapping("add")
    public Client addClient(@RequestBody Client client){
            if(client != null)
                clientService.add(client);

            return client;

    }
    @PutMapping("add")
    public Client updateClient(@RequestBody Client client){
            if(client != null)
                clientService.update(client);

            return client;

    }
}
