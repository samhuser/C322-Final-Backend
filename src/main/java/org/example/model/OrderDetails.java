package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "flowers")
public class OrderDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String deliveryDate;

    private boolean isSubscription;

    private double total;

    private String status;
    private double price;

    public OrderDetails(String deliveryDate, boolean isSubscription, double total, String status, double price) {
        this.deliveryDate = deliveryDate;
        this.isSubscription = isSubscription;
        this.total = total;
        this.status = status;
        this.price = price;
    }
    public OrderDetails(){

    }

    public int getId() {
        return id;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public boolean isSubscription() {
        return isSubscription;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
