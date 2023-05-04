package com.example.pw16to24.controllers;

import com.example.pw16to24.models.Building;
import com.example.pw16to24.services.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/building")
@Controller
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;

    @GetMapping("/add")
    public String createBuilding(@RequestParam(value = "creationDate") String date,
                             @RequestParam(value = "type") String type,
                             Model model) {
        Building building = new Building(date, type);
        if (!buildingService.existsBuilding(date, type)) buildingService.addBuilding(building);
        System.out.println("Added building: " + building);
        model.addAttribute("type", "add building");
        model.addAttribute("data", buildingService.getBuilding(date, type));
        return "building";
    }

    @GetMapping("/delete")
    public String deleteBuilding(@RequestParam(value = "creationDate") String date,
                             @RequestParam(value = "type") String type,
                             Model model) {
        model.addAttribute("type", "delete building");
        Building building = buildingService.getBuilding(date, type);
        buildingService.deleteBuilding(date, type);
        System.out.println("Removed building: " + building);
        model.addAttribute("data", building);
        return "building";
    }

    @GetMapping("/show")
    public String showBuildings(Model model) {
        model.addAttribute("type", "show buildings");
        List<Building> buildings = buildingService.showBuildings();
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

    @GetMapping("/search")
    public String searchBuildings(@RequestParam(value = "criteria") String criteria,
                              Model model) {
        model.addAttribute("type", "search buildings");
        List<Building> buildings = buildingService.searchBuildings(criteria);
        if (buildings.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("buildings", buildings);
        }
        System.out.println("All search buildings: ");
        int cnt = 0;
        for (Building building : buildings) {
            System.out.println(++cnt + ". " + building);
        }
        return "building";
    }
}
