package com.example.pw16to24.services;

import com.example.pw16to24.models.Building;
import com.example.pw16to24.models.Address;
import com.example.pw16to24.repositories.BuildingRepository;
import com.example.pw16to24.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@ManagedResource(objectName = "bean:name=SchedulerService")
@Service
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerService {

    private final AddressRepository addressRepository;
    private final BuildingRepository buildingRepository;

    @Scheduled(fixedRate = 1800000)
    public void updateData() throws IOException {
        File dir = new File("C:\\Users\\79299\\IdeaProjects\\pw16to24\\src\\main\\resources\\entityData");
        FileUtils.cleanDirectory(dir);
        List<Address> addresses = addressRepository.findAll();
        List<Building> buildings = buildingRepository.findAll();
        createFileForEntity(dir, addresses, "addresses");
        createFileForEntity(dir, buildings, "buildings");
    }

    @ManagedOperation()
    public void updateDataJmx() throws IOException {
        updateData();
    }

    private <E> void createFileForEntity(File dir, List<E> entities, String nameClass) throws IOException {
        File file = new File(dir + "\\" + nameClass + ".txt");
        FileWriter writer = new FileWriter(file);
        for (E entity : entities) {
            writer.write(entity.toString()+"\n");
        }
        writer.close();
    }
}