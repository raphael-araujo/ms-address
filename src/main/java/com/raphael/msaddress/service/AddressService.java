package com.raphael.msaddress.service;

import com.raphael.msaddress.entity.Address;
import com.raphael.msaddress.repository.AddressRepository;
import com.raphael.msaddress.web.client.ViaCepClient;
import com.raphael.msaddress.web.dto.CepClientDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepClient viaCepClient;
    private final ModelMapper modelMapper;

    public void saveAddress(String cep, String userEmail) {

        Address address = addressRepository.findByCep(cep);

        if (address != null) {
            if (!address.getUsersInThisAddress().contains(userEmail)) {
                address.addUserInThisAddress(userEmail);
                addressRepository.save(address);
            }
        } else {
            var viaCepResponse = findByCep(cep);
            if (viaCepResponse.getUf() != null) {
                Address newAddress = modelMapper.map(viaCepResponse, Address.class);
                newAddress.addUserInThisAddress(userEmail);
                addressRepository.save(newAddress);
            }
        }
    }

    public CepClientDto findByCep(String cep) {
        return viaCepClient.findByCep(cep);
    }
}
