/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order implements java.io.Serializable {

    @Id
    @Column(name = "OrderID")
    private int orderId;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "PymentWay")
    private String PymentWay;

    @Column(name = "TotalPrice")
    private double totalPrice;

    @Column(name = "Customer_Id")
    private int Customer_Id;

    public Order() {

    }

    public Order(LocalDate orderDate, String PymentWay, double totalPrice) {
        this.orderDate = orderDate;
        this.PymentWay = PymentWay;
        this.totalPrice = totalPrice;
    }

    // Setters and Getters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPymentWay() {
        return PymentWay;
    }

    public void setPymentWay(String PymentWay) {
        this.PymentWay = PymentWay;
    }

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(int Customer_Id) {
        this.Customer_Id = Customer_Id;
    }

}
