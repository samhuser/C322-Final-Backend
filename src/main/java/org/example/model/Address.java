package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(schema ="flowers")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;
    private State state;
    private String city;
    private String street;
    private String zipCode;
    private String aptNumber;

    public Address( State state, String city, String street, String zipCode, String aptNumber) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.aptNumber = aptNumber;
    }
    public Address() {
    }
    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAptNumber() {
        return aptNumber;
    }


}
