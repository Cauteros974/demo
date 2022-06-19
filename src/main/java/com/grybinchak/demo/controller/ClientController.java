package com.grybinchak.demo.controller;

import com.grybinchak.demo.dto.ClientDto;
import com.grybinchak.demo.entity.Client;
import com.grybinchak.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping(path = "/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ResponseEntity<Client> saveCustomer(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok().body(clientService.saveClient(clientDto));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().body("Client deleted successfully");
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateUser(@PathVariable Long clientId, @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok().body(clientService.updateClient(clientId, clientDto));
    }
}