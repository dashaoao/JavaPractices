package com.example.pw16to24.services;

import com.example.pw16to24.models.Address;
import com.example.pw16to24.repositories.AddressRepository;
import com.example.pw16to24.utils.AddressSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final EmailService emailService;

    @Transactional
    public void addAddress(Address address) {
        log.info("Add new address {}", address);
        addressRepository.save(address);
//        emailService.sendMessage("krendikova.d@yandex.ru","Address object saved","Address "
//                + address.getId() + " has been saved");
    }

    @Transactional(readOnly = true)
    public Address getAddress(String addressText, String zipCode) {
        log.info("Get address with addressText-{} and zipCode-{}", addressText, zipCode);
        return addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
    }

    @Transactional(readOnly = true)
    public boolean existsAddress(String addressText, String zipCode) {
        log.info("Check existing address with addressText-{} and zipCode-{}", addressText, zipCode);
        return addressRepository.existsAddressByAddressTextAndZipCode(addressText, zipCode);
    }

    @Transactional
    public void deleteAddress(String addressText, String zipCode) {
        Address address = addressRepository.findByAddressTextAndZipCode(addressText, zipCode);
        if (address != null) {
            log.info("Delete address {}", address);
            addressRepository.delete(address);
        }
    }

    @Transactional(readOnly = true)
    public List<Address> showAddresses() {
        log.info("Show addresses");
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Address> searchAddresses(String criteria) {
        log.info("Search addresses with criteria-{}", criteria);
        return addressRepository.findAll(new AddressSpecification(criteria));
    }
}
