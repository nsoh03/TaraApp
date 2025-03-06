/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
public class CheckoutService {

    private static double totalPrice = 0.0;

    private static int CustomerID;

    public static double getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(double price) {
        totalPrice = price;
    }

    public static int getCustomerID() {
        return CustomerID;
    }

    public static void setCustomerID(int CustomerID) {
        CheckoutService.CustomerID = CustomerID;
    }

}
