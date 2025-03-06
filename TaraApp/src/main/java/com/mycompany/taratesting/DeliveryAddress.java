/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DeliveryAddress")
public class DeliveryAddress implements java.io.Serializable {

    @Id
    @Column(name = "DeliveryAddressID")
    private int delvid;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "Ragin")
    private String region;

    @Column(name = "Street")
    private String street;

    public DeliveryAddress() {

    }

    public DeliveryAddress(String country, String city, String region, String street) {
        this.country = country;
        this.city = city;
        this.region = region;
        this.street = street;
    }

    public int getDeliveryAddressID() {
        return delvid;
    }

    public void setDeliveryAddressID(int delvid) {
        this.delvid = delvid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{"
                + //                "orderId='" + orderId + '\'' +
                ", country='" + country + '\''
                + ", city='" + city + '\''
                + ", region='" + region + '\''
                + ", street='" + street + '\''
                + '}';
    }

}
