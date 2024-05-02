package org.example.model;

import jakarta.persistence.*;

@Entity
@Table (schema ="flowers")
public class Customer{
    @Id
    @GeneratedValue
    private Integer id;
    private String password;

    private String email;

    public Customer(){

    }
    public Customer(String password, String email){
        this.password = password;
        this.email = email;
    }

    public long getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}