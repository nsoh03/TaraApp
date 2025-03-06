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
public class Birthday {

    private GridPane grid;

    public Birthday() {
        grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(30);
        grid.setPadding(new Insets(10, 30, 50, 30));

//---------------product 1----------------------------------------------------------------------------------------------------------------------
        Item item1 = new Item();
        Image img1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Blooming Wishes Bouquet.png");
        item1.setImage(img1);
        item1.setName("Blooming Wishes Bouquet\t\t\t");
        item1.setPrice("175");
        item1.setDescription("A vibrant and colorful bouquet\nfilled with a variety of fresh flowers,\n"
                + "radiating joy and happiness.\nPerfect for sending warm birthday\nwishes to your loved ones.");
        item1.setupMouseActions(item1, grid, 0, 0);

        grid.add(item1.getvBox(), 0, 0);

        Product product1 = new Product(item1.getNameText(), 175,
                item1.getDescriptionText(), item1.getImageView(), false);
        product1.add(product1);
        product1.setButton(item1.getCartButton());
//---------------product 2----------------------------------------------------------------------------------------------------------------------
        Item item2 = new Item();
        Image img2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Petal Surprise Box.png");
        item2.setImage(img2);
        item2.setName("Petal Surprise Box\t\t\t");
        item2.setPrice("250");
        item2.setDescription("A delightful box filled with\na mix of fragrant blooms\nand delicate petals.\n"
                + "When opened, it reveals\na burst of colors and scents,\ncreating a memorable surprise\nfor the birthday celebrant.");
        item2.setupMouseActions(item2, grid, 1, 0);

        grid.add(item2.getvBox(), 1, 0);

        Product product2 = new Product(item2.getNameText(), 250,
                item2.getDescriptionText(), item2.getImageView(), false);
        product2.add(product2);
        product2.setButton(item2.getCartButton());
//---------------product 3----------------------------------------------------------------------------------------------------------------------
        Item item3 = new Item();
        Image img3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Floral Fantasy Gift Set.png");
        item3.setImage(img3);
        item3.setName("Floral Fantasy Gift Set\t\t\t");
        item3.setPrice("99.5");
        item3.setDescription("Immerse yourself in a\nworld of floral enchantment\nwith this gift set.\n"
                + "It includes a beautifully\narranged bouquet, scented candles,\nand a luxurious bath bomb infused\n"
                + "with floral essences,\noffering a truly indulgent experience.");
        item3.setupMouseActions(item3, grid, 2, 0);

        grid.add(item3.getvBox(), 2, 0);

        Product product3 = new Product(item3.getNameText(), 99.5,
                item3.getDescriptionText(), item3.getImageView(), false);
        product3.add(product3);
        product3.setButton(item3.getCartButton());
//---------------product 4----------------------------------------------------------------------------------------------------------------------
        Item item4 = new Item();
        Image img4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Blossom Bliss Arrangement.png");
        item4.setImage(img4);
        item4.setName("Blossom Bliss Arrangement\t\t\t");
        item4.setPrice("380");
        item4.setDescription("A breathtaking arrangement\nshowcasing a harmonious\nblend of blossoms,\n"
                + "exuding elegance and charm.\nIt serves as a stunning\ncenterpiece that will captivate\neveryone's "
                + "attention at any\nbirthday celebration.");
        item4.setupMouseActions(item4, grid, 0, 1);

        grid.add(item4.getvBox(), 0, 1);

        Product product4 = new Product(item4.getNameText(), 380,
                item4.getDescriptionText(), item4.getImageView(), false);
        product4.add(product4);
        product4.setButton(item4.getCartButton());
//---------------product 5----------------------------------------------------------------------------------------------------------------------
        Item item5 = new Item();
        Image img5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Birthday Blossom Box.png");
        item5.setImage(img5);
        item5.setName("Birthday Blossom Box\t\t\t");
        item5.setPrice("120");
        item5.setDescription("A charming box\nfilled with a curated\nelection of fresh flowers,\n"
                + "each bloom representing\na special birthday wish.\nThis thoughtful gift will\n"
                + "bring beauty and cheer\nto the recipient's special day.");
        item5.setupMouseActions(item5, grid, 1, 1);

        grid.add(item5.getvBox(), 1, 1);

        Product product5 = new Product(item5.getNameText(), 120,
                item5.getDescriptionText(), item5.getImageView(), false);
        product5.add(product5);
        product5.setButton(item5.getCartButton());
//---------------product 6----------------------------------------------------------------------------------------------------------------------
        Item item6 = new Item();
        Image img6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Garden of Joy Bouquet.png");
        item6.setImage(img6);
        item6.setName("Garden of Joy Bouquet\t\t\t");
        item6.setPrice("190");
        item6.setDescription("Step into a garden\nof pure joy with this\nradiant bouquet. "
                + "Bursting\nwith vibrant blooms,\nit symbolizes happiness\nand celebration,"
                + "making it\nan ideal gift for\nspreading birthday cheer.");
        item6.setupMouseActions(item6, grid, 2, 1);

        grid.add(item6.getvBox(), 2, 1);

        Product product6 = new Product(item6.getNameText(), 190,
                item6.getDescriptionText(), item6.getImageView(), false);
        product6.add(product6);
        product6.setButton(item6.getCartButton());

    }

    public GridPane getGridPane() {
        return grid;
    }

}
