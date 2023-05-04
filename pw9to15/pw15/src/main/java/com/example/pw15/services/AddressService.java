package com.example.pw15.services;

import com.example.pw15.models.Address;
import com.example.pw15.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getAddress(String addressText, String zipCode) {
        return addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
    }

    public boolean existsAddress(String addressText, String zipCode) {
        return addressRepository.existsAddressByAddressTextAndZipCode(addressText, zipCode);
    }

    public void deleteAddress(String addressText, String zipCode) {
        Address address = addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
        if (address != null) addressRepository.delete(address);
    }

    public List<Address> showAddresses() {
        return addressRepository.findAll();
    }

}
