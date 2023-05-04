package com.example.pw15.repositories;

import com.example.pw15.models.Building;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Building findByCreationDateAndType(String name, String address);
    boolean existsBuildingByCreationDateAndType(String name, String address);
}