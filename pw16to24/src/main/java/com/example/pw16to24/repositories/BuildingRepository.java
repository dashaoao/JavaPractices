package com.example.pw16to24.repositories;

import com.example.pw16to24.models.Address;
import com.example.pw16to24.models.Building;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>, JpaSpecificationExecutor<Building> {
    Building findByCreationDateAndType(String name, String address);
    boolean existsBuildingByCreationDateAndType(String name, String address);
}