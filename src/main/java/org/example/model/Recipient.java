package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "flowers")
public class Recipient {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private Relationship relationship;

    public Recipient(String firstName, String lastName, Relationship relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
    }
    public Recipient() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Relationship getRelationship() {
        return relationship;
    }

}
