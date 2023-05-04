package com.example.pw15.services;

import com.example.pw15.models.Building;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.pw15.repositories.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public void addBuilding(Building building) {
        buildingRepository.save(building);
    }

    public Building getBuilding(String creationDate, String type) {
        return buildingRepository.findByCreationDateAndType(creationDate, type);
    }

    public boolean existsBuilding(String creationDate, String type) {
        return buildingRepository.existsBuildingByCreationDateAndType(creationDate, type);
    }

    public void deleteBuilding(String creationDate, String type) {
        Building building = buildingRepository.findByCreationDateAndType(creationDate, type);
        if (building != null) buildingRepository.delete(building);
    }

    public List<Building> showBuildings() {
        return buildingRepository.findAll();
    }

}
