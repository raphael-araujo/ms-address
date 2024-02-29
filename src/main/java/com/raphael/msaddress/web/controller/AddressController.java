package com.raphael.msaddress.web.controller;

import com.raphael.msaddress.service.AddressService;
import com.raphael.msaddress.web.dto.CepClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public void saveAddressWithUser(@RequestParam("cep") String cep,
                                    @RequestParam("email") String email) {
        addressService.saveAddress(cep, email);
    }

    @GetMapping("/{cep}")
    public CepClientDto findByCep(@PathVariable String cep) {
        return addressService.findByCep(cep);
    }
}
