package com.example.pw15.controllers;

import com.example.pw15.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.pw15.models.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/address")
@Controller
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/add")
    public String createAddress(@RequestParam(value = "addressText") String text,
                                 @RequestParam(value = "zipCode") String code,
                                 org.springframework.ui.Model model) {
        Address address = new Address(text, code);
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
}
