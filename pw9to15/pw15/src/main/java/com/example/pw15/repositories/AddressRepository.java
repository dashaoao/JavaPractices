package com.example.pw15.repositories;

import com.example.pw15.models.Address;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByAddressTextAndZipCode(String name, String address);
    boolean existsAddressByAddressTextAndZipCode(String name, String address);
}