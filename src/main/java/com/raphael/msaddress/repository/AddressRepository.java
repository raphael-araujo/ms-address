package com.raphael.msaddress.repository;

import com.raphael.msaddress.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByCep(String cep);
}
