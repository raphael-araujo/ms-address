package com.raphael.msaddress.repository;


import com.raphael.msaddress.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AddressRepositoryTest {

List<String> userEmails = List.of("teste@email.com", "teste2@email.com");
Address ADDRESS = new Address(null, 0, "77900-000", "complemento",
        "uf", "TO", "logradouro", userEmails);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveAddress_WithValidData_ReturnAddress() {
        Address address = addressRepository.save(ADDRESS);

        Address sut = testEntityManager.find(Address.class, address.getId());

        assertThat(sut).isNotNull();
        assertThat(sut.getNumero()).isEqualTo(address.getNumero());
        assertThat(sut.getCep()).isEqualTo(address.getCep());
        assertThat(sut.getComplemento()).isEqualTo(address.getComplemento());
        assertThat(sut.getUf()).isEqualTo(address.getUf());
        assertThat(sut.getLocalidade()).isEqualTo(address.getLocalidade());
        assertThat(sut.getLogradouro()).isEqualTo(address.getLogradouro());
        assertThat(sut.getUsersInThisAddress().contains("teste@email.com")).isTrue();
    }

    @Test
    public void FindAddressByNonexistentCep_ReturnEmpty() {
        Address addressOpt = addressRepository.findByCep("00000-000");
        assertThat(addressOpt).isNull();
    }
}
