package com.example.pw16to24.services;

import com.example.pw16to24.models.Building;
import com.example.pw16to24.repositories.BuildingRepository;
import com.example.pw16to24.utils.BuildingSpecification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final EmailService emailService;

    @Transactional
    public void addBuilding(Building building) {
        log.info("Add new building {}", building);
        buildingRepository.save(building);
//        emailService.sendMessage("krendikova.d@yandex.ru","Building object saved","Building "
//                + building.getId() + " has been saved");
    }

    @Transactional(readOnly = true)
    public Building getBuilding(String creationDate, String type) {
        log.info("Get building with creationDate-{} and type-{}", creationDate, type);
        return buildingRepository.findByCreationDateAndType(creationDate, type);
    }

    @Transactional(readOnly = true)
    public boolean existsBuilding(String creationDate, String type) {
        log.info("Check existing building with creationDate-{} and type-{}", creationDate, type);
        return buildingRepository.existsBuildingByCreationDateAndType(creationDate, type);
    }

    @Transactional
    public void deleteBuilding(String creationDate, String type) {
        Building building = buildingRepository.findByCreationDateAndType(creationDate, type);
        if (building != null) {
            log.info("Delete building {}", building);
            buildingRepository.delete(building);
        }
    }

    @Transactional(readOnly = true)
    public List<Building> showBuildings() {
        log.info("Show buildings");
        return buildingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Building> searchBuildings(String criteria) {
        log.info("Search buildings with criteria-{}", criteria);
        return buildingRepository.findAll(new BuildingSpecification(criteria));
    }
}
