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
public class BabyShower {

    private GridPane grid;

    public BabyShower() {
        grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(30);
        grid.setPadding(new Insets(10, 30, 50, 30));

//---------------product 1----------------------------------------------------------------------------------------------------------------------
        Item item1 = new Item();
        Image img1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Baby Blossom Bouquet.png");
        item1.setImage(img1);
        item1.setName("Baby Blossom Bouquet\t\t\t");
        item1.setPrice("130");
        item1.setDescription("Welcome the arrival\nof a precious little one\nwith this adorable bouquet.\n"
                + "It features soft\nand delicate blooms\nin pastel hues,\nsymbolizing the beauty\nand innocence"
                + "of a newborn baby.");
        item1.setupMouseActions(item1, grid, 0, 0);

        grid.add(item1.getvBox(), 0, 0);

        Product product1 = new Product(item1.getNameText(), 130,
                item1.getDescriptionText(), item1.getImageView(), false);
        product1.add(product1);
        product1.setButton(item1.getCartButton());
//---------------product 2----------------------------------------------------------------------------------------------------------------------
        Item item2 = new Item();
        Image img2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Little Sprout Gift Set.png");
        item2.setImage(img2);
        item2.setName("Little Sprout Gift Set\t\t\t");
        item2.setPrice("200");
        item2.setDescription("Nurture the growth\nof a little sprout\nwith this charming gift set.\n"
                + "It includes a selection\nof baby-friendly flowers,\nalong with baby\ncare essentials,\n"
                + "creating a thoughtful\nand practical gift\nfor a baby shower.");
        item2.setupMouseActions(item2, grid, 1, 0);

        grid.add(item2.getvBox(), 1, 0);

        Product product2 = new Product(item2.getNameText(), 200,
                item2.getDescriptionText(), item2.getImageView(), false);
        product2.add(product2);
        product2.setButton(item2.getCartButton());
//---------------product 3----------------------------------------------------------------------------------------------------------------------
        Item item3 = new Item();
        Image img3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Delicate Petal Surprise Box.png");
        item3.setImage(img3);
        item3.setName("Delicate Petal Surprise Box\t\t\t");
        item3.setPrice("110");
        item3.setDescription("Open this delicate\nsurprise box to reveal\na collection of dainty petals,\n"
                + "carefully arranged to\ncelebrate the upcoming\narrival of a baby.\nIt's a whimsical and\n"
                + "enchanting gift that\nembodies the joy\nof a baby shower.");
        item3.setupMouseActions(item3, grid, 2, 0);

        grid.add(item3.getvBox(), 2, 0);

        Product product3 = new Product(item3.getNameText(), 110,
                item3.getDescriptionText(), item3.getImageView(), false);
        product3.add(product3);
        product3.setButton(item3.getCartButton());
//---------------product 4----------------------------------------------------------------------------------------------------------------------
        Item item4 = new Item();
        Image img4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Baby Bloom Basket.png");
        item4.setImage(img4);
        item4.setName("Baby Bloom Basket\t\t\t");
        item4.setPrice("250");
        item4.setDescription("Celebrate the blossoming\nof new life with this\ndelightful bloom basket.\n"
                + "Filled with gentle\nblooms and accompanied\nby plush toys and baby\naccessories, it's a\n"
                + "perfect gift to shower\nthe parents-to-be with\nlove and blessings.");
        item4.setupMouseActions(item4, grid, 0, 1);

        grid.add(item4.getvBox(), 0, 1);

        Product product4 = new Product(item4.getNameText(), 250,
                item4.getDescriptionText(), item4.getImageView(), false);
        product4.add(product4);
        product4.setButton(item4.getCartButton());
//---------------product 5----------------------------------------------------------------------------------------------------------------------
        Item item5 = new Item();
        Image img5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Tiny Toes Floral Arrangement.png");
        item5.setImage(img5);
        item5.setName("Tiny Toes Floral Arrangement\t\t\t");
        item5.setPrice("300");
        item5.setDescription("Embrace the sweetness\nof newborn feet with\nthis charming floral\narrangement."
                + "It features\npetite blooms and\naccents inspired by\nbaby shoes, creating\n a heartwarming gift\n"
                + "for a baby shower.");
        item5.setupMouseActions(item5, grid, 1, 1);

        grid.add(item5.getvBox(), 1, 1);

        Product product5 = new Product(item5.getNameText(), 300,
                item5.getDescriptionText(), item5.getImageView(), false);
        product5.add(product5);
        product5.setButton(item5.getCartButton());
//---------------product 6----------------------------------------------------------------------------------------------------------------------
        Item item6 = new Item();
        Image img6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Blossoming Joy Gift Box.png");
        item6.setImage(img6);
        item6.setName("Blossoming Joy Gift Box\t\t\t");
        item6.setPrice("400");
        item6.setDescription("Spread joy and happiness\nwith this exquisite gift box.\nIt includes"
                + "a mix of\ncheerful blooms and\npersonalized baby items,\nmaking it a memorable and\n"
                + "meaningful gift for\ncelebrating a baby shower.");
        item6.setupMouseActions(item6, grid, 2, 1);

        grid.add(item6.getvBox(), 2, 1);

        Product product6 = new Product(item6.getNameText(), 400,
                item6.getDescriptionText(), item6.getImageView(), false);
        product6.add(product6);
        product6.setButton(item6.getCartButton());
    }

    public GridPane getGridPane() {
        return grid;
    }

}
