package com.grybinchak.demo.service;

import com.grybinchak.demo.dto.ClientDto;
import com.grybinchak.demo.entity.Client;
import com.grybinchak.demo.exception.ClientNotFoundException;
import com.grybinchak.demo.mapper.ClientMapper;
import com.grybinchak.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client " + id + " not found"));

        return clientMapper.toDto(client);
    }

    public Client saveClient(ClientDto customerDto) {
        Client customer = clientMapper.fromDto(customerDto);
        return clientRepository.save(customer);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, ClientDto clientDto) {
        Client clientFromDb = clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Client " + id + " not found")
        );
        clientMapper.updateClient(clientFromDb, clientDto);

        return clientRepository.save(clientFromDb);
    }
}