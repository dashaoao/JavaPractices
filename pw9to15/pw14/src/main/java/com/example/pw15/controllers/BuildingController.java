package com.example.pw15.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.example.pw15.models.Building;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@RequestMapping("/building")
@Controller
public class BuildingController {
    private ArrayList<Building> buildings = new ArrayList<>();

    @GetMapping("/add")
    public String createBuilding(@RequestParam(value = "creationDate") String date,
                             @RequestParam(value = "type") String type,
                             Model model) {
        Building building = new Building(date, type);
        buildings.add(building);
        System.out.println("Count of buildings: " + buildings.size() + "\nAdded building: " + building);
        model.addAttribute("type", "add building");
        model.addAttribute("data", building);
        return "building";
    }

    @GetMapping("/delete")
    public String deleteBuilding(@RequestParam(value = "creationDate") String date,
                             @RequestParam(value = "type") String type,
                             Model model) {
        Building cloneBuilding = new Building(date, type);
        model.addAttribute("type", "delete building");
        if (buildings.removeIf(building -> Objects.equals(building.getCreationDate(), date) && Objects.equals(building.getType(), type))) {
            System.out.println("Count of buildings: " + buildings.size() + "\nRemoved building: " + cloneBuilding);
            model.addAttribute("data", cloneBuilding);
        } else {
            System.out.println("Count of buildings: " + buildings.size() + "\nRemoved building: " + "not found");
            model.addAttribute("data", "not found");
        }
        return "building";
    }

    @GetMapping("/show")
    public String showBuildings(Model model) {
        model.addAttribute("type", "show buildings");
        if (buildings.isEmpty()){
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("buildings", buildings);
        }
        System.out.println("All buildings: ");
        int cnt=0;
        for (Building building: buildings) {
            System.out.println(++cnt+". "+building);
        }
        return "building";
    }
}
