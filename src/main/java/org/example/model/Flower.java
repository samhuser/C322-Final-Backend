package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "flowers")
public class Flower {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double price;
    private Color color;
    private Occasion occasion;
    private Type type;

    public Flower(int id, String name, double price, Color color, Occasion occasion, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.occasion = occasion;
        this.type = type;
    }
    public Flower(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public Type getType() {
        return type;
    }

}
