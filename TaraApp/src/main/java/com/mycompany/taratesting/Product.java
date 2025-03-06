/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author linasmacbook
 */
public class Product {

    public static ArrayList<Product> products = new ArrayList<Product>();

    private Text name;

    private Text description;

    private double price;

    private ImageView imege;
    private boolean inCart;

    private Button InCartButton;

    private Button deleteButton;
    private HBox boxOfTheCart;
    private HBox perantOfBoxOfTheCart;

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    public Product() {

    }

    public Product(Text name, double price, Text description, ImageView imege, boolean inCart) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imege = imege;
        this.inCart = inCart;
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public ImageView getImege() {
        return imege;
    }

    public void setImege(ImageView imege) {
        this.imege = imege;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;

        deleteButton.setOnAction(e -> {
            inCart = false;
            perantOfBoxOfTheCart.getChildren().remove(boxOfTheCart);

            int id = 0;
            session = HibernateUtil.getSessionFactory().openSession();
            List<products> sList = null;
            String queryStr = "from products";
            Query query = session.createQuery(queryStr);
            sList = query.list();
            session.close();
            for (products s : sList) {
                if (this.name.getText().equals(s.getName()) && this.description.getText().equals(s.getDescription()) && this.price == s.getPrice()) {
                    id = s.getId();
                }
            }

            products p = new products(this.name.getText(), this.description.getText(), this.price);
            p.setId(id);
            //Delete          
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx3 = null;
            tx3 = session.beginTransaction();
            session.delete(p);
            tx3.commit();
            session.close();

        });
    }

    public HBox getBoxOfTheCart() {
        return boxOfTheCart;
    }

    public void setBoxOfTheCart(HBox boxOfTheCart) {
        this.boxOfTheCart = boxOfTheCart;
    }

    public HBox getPerantOfBoxOfTheCart() {
        return perantOfBoxOfTheCart;
    }

    public void setPerantOfBoxOfTheCart(HBox perantOfBoxOfTheCart) {
        this.perantOfBoxOfTheCart = perantOfBoxOfTheCart;
    }

    public static ArrayList<Product> getProdects() {
        return products;
    }

    public static void setProdects(ArrayList<Product> prodects) {
        Product.products = prodects;
    }

    public Button getButton() {
        return InCartButton;
    }

    public void setButton(Button InCartButton) {
        this.InCartButton = InCartButton;
        InCartButton.setOnAction(e -> {
            inCart = true;

            products p = new products(name.getText(), description.getText(), price);
//            //insert 
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            int productInCart = (Integer) session.save(p);
            tx.commit();
            session.close();

        });
    }

    public void add(Product p) {
//        for(int i=0 ; i<products.size() ; i++){
//            if(!(products.get(i).getName().getText().equals(this.name.getText()))){
        products.add(p);

//            }
//        }
    }

}
