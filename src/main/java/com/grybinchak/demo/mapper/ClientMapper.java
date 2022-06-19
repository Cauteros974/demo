package com.grybinchak.demo.mapper;

import com.grybinchak.demo.dto.ClientDto;
import com.grybinchak.demo.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client fromDto(ClientDto userDto);

    ClientDto toDto(Client user);

    @Mapping(target = "id", ignore = true)
    void updateClient(@MappingTarget Client client, ClientDto clientDto);
}