package com.example.pw15.controllers;

import org.springframework.stereotype.Controller;
import com.example.pw15.models.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@RequestMapping("/address")
@Controller
public class AddressController {
    private ArrayList<Address> addresses = new ArrayList<>();

    @GetMapping("/add")
    public String createAddress(@RequestParam(value = "addressText") String text,
                                 @RequestParam(value = "zipCode") String code,
                                 org.springframework.ui.Model model) {
        Address address = new Address(text, code);
        addresses.add(address);
        System.out.println("Count of addresses: " + addresses.size() + "\nAdded address: " + address);
        model.addAttribute("type", "add address");
        model.addAttribute("data", address);
        return "address";
    }

    @GetMapping("/delete")
    public String deleteAddress(@RequestParam(value = "creationDate") String date,
                                 @RequestParam(value = "type") String type,
                                 org.springframework.ui.Model model) {
        Address cloneAddress = new Address(date, type);
        model.addAttribute("type", "delete address");
        if (addresses.removeIf(address -> Objects.equals(address.getAddressText(), date) && Objects.equals(address.getZipCode(), type))) {
            System.out.println("Count of addresses: " + addresses.size() + "\nRemoved address: " + cloneAddress);
            model.addAttribute("data", cloneAddress);
        } else {
            System.out.println("Count of addresses: " + addresses.size() + "\nRemoved address: " + "not found");
            model.addAttribute("data", "not found");
        }
        return "address";
    }

    @GetMapping("/show")
    public String showAddresses(org.springframework.ui.Model model) {
        model.addAttribute("type", "show addresses");
        if (addresses.isEmpty()){
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("addresses", addresses);
        }
        System.out.println("All addresses: ");
        int cnt=0;
        for (Address address: addresses) {
            System.out.println(++cnt+". "+address);
        }
        return "address";
    }
}
