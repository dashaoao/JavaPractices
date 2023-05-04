package com.example.pw16to24.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "buildings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creationdate")
    private String creationDate;
    @Column(name = "type")
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Creation date = " + creationDate + ", type = " + type;
    }
}
