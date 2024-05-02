package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(schema = "flowers")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    private int customerId;
    private int flowerId;
    private int recipientId;
    private int orderDetailsId;
    private int addressId;
    public Order(int customerId, int flowerId, int recipientId, int orderDetailsId, int addressId) {
        this.customerId = customerId;
        this.flowerId = flowerId;
        this.recipientId = recipientId;
        this.orderDetailsId = orderDetailsId;
        this.addressId = addressId;
    }
    public Order(){

    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public int getAddressId() {
        return addressId;
    }
}
