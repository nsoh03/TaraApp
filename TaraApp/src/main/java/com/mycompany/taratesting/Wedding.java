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
public class Wedding {

    private GridPane grid;

    public Wedding() {
        grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(30);
        grid.setPadding(new Insets(10, 30, 50, 30));

//---------------product 1----------------------------------------------------------------------------------------------------------------------
        Item item1 = new Item();
        Image img1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Everlasting Love Bouquet.png");
        item1.setImage(img1);
        item1.setName("Everlasting Love Bouquet\t\t\t");
        item1.setPrice("200");
        item1.setDescription("Celebrate eternal love\nwith this exquisite bouquet.\n"
                + "It features a harmonious\nblend of romantic blooms,\nsymbolizing the"
                + "everlasting\nbond between two souls\nunited in matrimony.");
        item1.setupMouseActions(item1, grid, 0, 0);

        grid.add(item1.getvBox(), 0, 0);

        Product product1 = new Product(item1.getNameText(), 200,
                item1.getDescriptionText(), item1.getImageView(), false);
        product1.add(product1);
        product1.setButton(item1.getCartButton());
//---------------product 2----------------------------------------------------------------------------------------------------------------------
        Item item2 = new Item();
        Image img2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Enchanted Garden Gift.png");
        item2.setImage(img2);
        item2.setName("Enchanted Garden Gift\t\t\t");
        item2.setPrice("200");
        item2.setDescription(" Create a whimsical and\nenchanting atmosphere"
                + "with this\ngarden-inspired gift.\nIt includes a bouquet of\n"
                + "ethereal blooms,along\nwith scented candles\n"
                + "to enhance the ambiance\nof a wedding.");
        item2.setupMouseActions(item2, grid, 1, 0);

        grid.add(item2.getvBox(), 1, 0);

        Product product2 = new Product(item2.getNameText(), 200,
                item2.getDescriptionText(), item2.getImageView(), false);
        product2.add(product2);
        product2.setButton(item2.getCartButton());
//---------------product 3----------------------------------------------------------------------------------------------------------------------
        Item item3 = new Item();
        Image img3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Romantic Petal Surprise Box.png");
        item3.setImage(img3);
        item3.setName("Romantic Petal Surprise Box\t\t\t");
        item3.setPrice("430");
        item3.setDescription("Open this romantic surprise\nbox to reveal acollection\nof delicate"
                + "petals that\nevoke passion and love.\nIt's a charming and intimate\ngift that adds"
                + "a touch\nof romance to any\nwedding celebration.");
        item3.setupMouseActions(item3, grid, 2, 0);

        grid.add(item3.getvBox(), 2, 0);

        Product product3 = new Product(item3.getNameText(), 430,
                item3.getDescriptionText(), item3.getImageView(), false);
        product3.add(product3);
        product3.setButton(item3.getCartButton());
//---------------product 4----------------------------------------------------------------------------------------------------------------------
        Item item4 = new Item();
        Image img4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Wedding Bliss Arrangement.png");
        item4.setImage(img4);
        item4.setName("Wedding Bliss Arrangement\t\t\t");
        item4.setPrice("360");
        item4.setDescription("Experience pure bliss with\nthis stunning floral arrangement.\n"
                + "It combines elegant and\nromantic blooms, creating a\ncaptivating centerpiece"
                + "that embodies\nthe joy and beauty\nof a wedding day.");
        item4.setupMouseActions(item4, grid, 0, 1);

        grid.add(item4.getvBox(), 0, 1);

        Product product4 = new Product(item4.getNameText(), 360,
                item4.getDescriptionText(), item4.getImageView(), false);
        product4.add(product4);
        product4.setButton(item4.getCartButton());
//---------------product 5----------------------------------------------------------------------------------------------------------------------
        Item item5 = new Item();
        Image img5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Eternal Love Bloom Box.png");
        item5.setImage(img5);
        item5.setName("Eternal Love Bloom Box\t\t\t");
        item5.setPrice("290");
        item5.setDescription("Express your eternal\nlove with this\ncaptivating bloom box.\n"
                + "Filled with timeless and\nenduring blooms,\nit serves as a symbol of\n"
                + "everlasting commitment\nand devotion.");
        item5.setupMouseActions(item5, grid, 1, 1);

        grid.add(item5.getvBox(), 1, 1);

        Product product5 = new Product(item5.getNameText(), 290,
                item5.getDescriptionText(), item5.getImageView(), false);
        product5.add(product5);
        product5.setButton(item5.getCartButton());
//---------------product 6----------------------------------------------------------------------------------------------------------------------
        Item item6 = new Item();
        Image img6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Bridal Bouquet of Dreams.png");
        item6.setImage(img6);
        item6.setName("Bridal Bouquet of Dreams\t\t\t");
        item6.setPrice("150");
        item6.setDescription("Fulfill the bride's\nfloral dreams with this\nenchanting bridal bouquet.\n"
                + "It combines a carefully\nselected assortment of blooms,\nreflecting her unique style\n"
                + "and adding a touch of\nelegance to her special day.");
        item6.setupMouseActions(item6, grid, 2, 1);

        grid.add(item6.getvBox(), 2, 1);

        Product product6 = new Product(item6.getNameText(), 150,
                item6.getDescriptionText(), item6.getImageView(), false);
        product6.add(product6);
        product6.setButton(item6.getCartButton());

    }

    public GridPane getGridPane() {
        return grid;
    }

}
