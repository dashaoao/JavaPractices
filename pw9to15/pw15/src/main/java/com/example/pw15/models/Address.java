package com.example.pw15.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "address")
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

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address text = " + addressText + ", zip code = " + zipCode + ".\n";
    }
}
