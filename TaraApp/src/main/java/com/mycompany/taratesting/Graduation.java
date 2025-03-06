/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 *
 * @author linasmacbook
 */
public class Graduation {

    private GridPane grid;
//    public ArrayList<prodect> products = new ArrayList<prodect>();

    public Graduation() {
        grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(10, 0, 50, 0));

//---------------product 1----------------------------------------------------------------------------------------------------------------------
        Item item1 = new Item();
        Image img1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Graduation Glory Bouquet.png");
        item1.setImage(img1);
        item1.setName("Graduation Glory Bouquet\t\t\t");
        item1.setPrice("97.5");
        item1.setDescription("Celebrate the achievements\nand glory of graduation\nwith this stunning bouquet.\n"
                + "It combines bold and\nvibrant blooms that signify\nsuccess and accomplishment,\nmaking it the"
                + "perfect\ngift for a proud graduate.");
        item1.setupMouseActions(item1, grid, 0, 0);

        grid.add(item1.getvBox(), 0, 0);

        Product product1 = new Product(item1.getNameText(), 97.5,
                item1.getDescriptionText(), item1.getImageView(), false);
        product1.add(product1);
        product1.setButton(item1.getCartButton());
//---------------product 2----------------------------------------------------------------------------------------------------------------------
        Item item2 = new Item();
        Image img2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Cap Gift.png");
        item2.setImage(img2);
        item2.setName("Cap Gift\t\t\t");
        item2.setPrice("250");
        item2.setDescription("Commemorate the milestone\nof graduation with this \nspecial gift .\n"
                + "It includes a bouquet\nof flowers, accompanied\nby a graduation cap,\n"
                + "symbolizing the graduate's\njourney and success.");
        item2.setupMouseActions(item2, grid, 1, 0);

        grid.add(item2.getvBox(), 1, 0);

        Product product2 = new Product(item2.getNameText(), 250,
                item2.getDescriptionText(), item2.getImageView(), false);
        product2.add(product2);
        product2.setButton(item2.getCartButton());
//---------------product 3----------------------------------------------------------------------------------------------------------------------
        Item item3 = new Item();
        Image img3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Scholarly Blooms Surprise Box.png");
        item3.setImage(img3);
        item3.setName("Scholarly Blooms Surprise Box\t\t\t");
        item3.setPrice("380");
        item3.setDescription(" Open this surprise\nbox to discover a collection\nof scholarly blooms,\n"
                + "representing the knowledge\nand growth achieved through\nyears of hard work.\nIt's a"
                + "unique and meaningful\ngift for a graduate.");
        item3.setupMouseActions(item3, grid, 2, 0);

        grid.add(item3.getvBox(), 2, 0);

        Product product3 = new Product(item3.getNameText(), 380,
                item3.getDescriptionText(), item3.getImageView(), false);
        product2.add(product3);
        product2.setButton(item3.getCartButton());
//---------------product 4----------------------------------------------------------------------------------------------------------------------
        Item item4 = new Item();
        Image img4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Achievement Blossom Arrangement.png");
        item4.setImage(img4);
        item4.setName("Achievement Blossom Arrangement\t\t\t");
        item4.setPrice("170");
        item4.setDescription("Honor the graduate's\nachievements with this\nelegant blossom arrangement.\n"
                + "It features a mix\nof sophisticated blooms,\nreflecting the beauty\nof their accomplishments\n"
                + "and the bright future\nthat lies ahead.");
        item4.setupMouseActions(item4, grid, 0, 1);

        grid.add(item4.getvBox(), 0, 1);

        Product product4 = new Product(item4.getNameText(), 170,
                item4.getDescriptionText(), item4.getImageView(), false);
        product4.add(product4);
        product4.setButton(item4.getCartButton());
//---------------product 5----------------------------------------------------------------------------------------------------------------------
        Item item5 = new Item();
        Image img5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Graduation Day Bloom Box.png");
        item5.setImage(img5);
        item5.setName("Graduation Day Bloom Box\t\t\t");
        item5.setPrice("400");
        item5.setDescription("Capture the excitement of\ngraduation day with this\nexquisite bloom box.\n"
                + "Filled with a vibrant\narray of flowers,\nit's a joyful gift that\ncelebrates the graduate's\n"
                + "accomplishments and marks the\nbeginning of a new chapter.");
        item5.setupMouseActions(item5, grid, 1, 1);

        grid.add(item5.getvBox(), 1, 1);

        Product product5 = new Product(item5.getNameText(), 400,
                item5.getDescriptionText(), item5.getImageView(), false);
        product5.add(product5);
        product5.setButton(item5.getCartButton());
//---------------product 6----------------------------------------------------------------------------------------------------------------------
        Item item6 = new Item();
        Image img6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Academic Success Bouquet.png");
        item6.setImage(img6);
        item6.setName("Academic Success Bouquet\t\t\t");
        item6.setPrice("300");
        item6.setDescription("Acknowledge the academic\nsuccess of a graduate with\nthis refined bouquet.\n"
                + "It combines elegant\nblooms with scholarly accents,\ncreating a gift that symbolizes\nintelligence,"
                + "dedication,\nand achievement.");
        item6.setupMouseActions(item6, grid, 2, 1);

        grid.add(item6.getvBox(), 2, 1);

        Product product6 = new Product(item6.getNameText(), 300,
                item6.getDescriptionText(), item6.getImageView(), false);
        product6.add(product6);
        product6.setButton(item6.getCartButton());

    }

    public GridPane getGridPane() {
        return grid;
    }

}
