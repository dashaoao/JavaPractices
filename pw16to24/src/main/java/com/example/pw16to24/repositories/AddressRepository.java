package com.example.pw16to24.repositories;

import com.example.pw16to24.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {
    Address findByAddressTextAndZipCode(String name, String address);
    boolean existsAddressByAddressTextAndZipCode(String name, String address);

}