package com.example.pw16to24.controllers;


import org.springframework.ui.Model;
import com.example.pw16to24.services.AddressService;
import com.example.pw16to24.services.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.pw16to24.models.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@RequestMapping("/address")
@Controller
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final BuildingService buildingService;

    @GetMapping("/add")
    public String createAddress(@RequestParam(value = "addressText") String text,
                                 @RequestParam(value = "zipCode") String code,
                                 org.springframework.ui.Model model) {
        Address address = new Address(text, code);
        String city = address.getAddressText();

        if (Objects.equals(city, "Moscow")) {
            if (buildingService.existsBuilding("31.01.2020", "apartment")) address.setBuilding(buildingService.getBuilding("31.01.2020", "apartment"));
            else address.setBuilding(null);
        } else if (Objects.equals(city, "Mozhaysk")) {
            if (buildingService.existsBuilding("24.05.2007", "cottage")) address.setBuilding(buildingService.getBuilding("24.05.2007", "cottage"));
            else address.setBuilding(null);
        } else if (Objects.equals(city, "Tula")) {
            if (buildingService.existsBuilding("27.11.2012", "house")) address.setBuilding(buildingService.getBuilding("27.11.2012", "house"));
            else address.setBuilding(null);
        }
        
        if (!addressService.existsAddress(text, code)) addressService.addAddress(address);
        System.out.println("Added address: " + address);
        model.addAttribute("type", "add address");
        model.addAttribute("data", addressService.getAddress(text, code));
        return "address";
    }

    @GetMapping("/delete")
    public String deleteAddress(@RequestParam(value = "addressText") String text,
                                 @RequestParam(value = "zipCode") String code,
                                 org.springframework.ui.Model model) {
        model.addAttribute("type", "delete address");
        Address address = addressService.getAddress(text, code);
        addressService.deleteAddress(text, code);
        System.out.println("Removed address: " + address);
        model.addAttribute("data", address);
        return "address";
    }

    @GetMapping("/show")
    public String showAddresses(org.springframework.ui.Model model) {
        model.addAttribute("type", "show addresses");
        List<Address> addresses = addressService.showAddresses();
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

    @GetMapping("/search")
    public String searchAddresses(@RequestParam(value = "criteria") String criteria, Model model) {
        model.addAttribute("type", "search addresses");
        List<Address> addresses = addressService.searchAddresses(criteria);
        if (addresses.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("addresses", addresses);
        }
        System.out.println("All search addresses: ");
        int cnt = 0;
        for (Address address : addresses) {
            System.out.println(++cnt + ". " + address);
        }
        return "address";
    }
}
