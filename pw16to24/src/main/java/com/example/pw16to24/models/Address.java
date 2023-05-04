package com.example.pw16to24.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "addresstext")
    private String addressText;
    @Column(name = "zipcode")
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private Building building;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        if (building!=null) return "Address text = " + addressText + ", zip code = "
                + zipCode + ", building id = " + building.getId();
        else return "Address text = " + addressText + ", zip code = "
                + zipCode + ", building id = null";
    }
}
