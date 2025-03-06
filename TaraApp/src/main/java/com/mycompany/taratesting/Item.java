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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author linasmacbook
 */
public class Item {

    private VBox vBox;
    private ImageView imageView;
    private Rectangle rectangle;
    private Text descriptionText;
    private StackPane stackPane;
    private HBox hBox;
    private Text nameText;
    private Text priceText;
    private VBox buttonBox;
    private ImageView basketImageView;
    private Button cartButton;

    public Item() {
        vBox = new VBox();
        imageView = new ImageView(new Image("file:/Users/linasmacbook/Desktop/AP-project/unknown.jpg"));
        imageView.setFitHeight(170);
        imageView.setFitWidth(150);
        vBox.getChildren().add(imageView);

        rectangle = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5));
        descriptionText = new Text("Description:\n");
        descriptionText.setFill(Color.WHITE);
        descriptionText.setFont(Font.font("Georgia", FontWeight.NORMAL, 9));
        stackPane = createStackPane(rectangle, descriptionText);

        hBox = new HBox();
        nameText = new Text();
        nameText.setFont(Font.font("Georgia", FontWeight.NORMAL, 9));
        priceText = new Text();
        priceText.setFont(Font.font("Georgia", FontWeight.BOLD, 9));
        hBox.getChildren().addAll(nameText, priceText);

        buttonBox = new VBox();
        basketImageView = new ImageView(new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png"));
        basketImageView.setFitHeight(21);
        basketImageView.setFitWidth(21);
        cartButton = new Button("cart", basketImageView);
        cartButton.setPrefWidth(70);
        buttonBox.getChildren().add(cartButton);
        buttonBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox, buttonBox);
        vBox.setAlignment(Pos.CENTER);
    }

    public Item(Text name, Text price, Text description, ImageView image) {
        this();
        setName(name.getText());
        setPrice(price.getText());
        setDescription(description.getText());
        setImage(image.getImage());
    }

    private StackPane createStackPane(Rectangle rectangle, Text text) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);
        return stackPane;
    }

    //setters
    public void setImage(Image image) {
        imageView.setImage(image);
    }

    public void setName(String name) {
        nameText.setText(name);
    }

    public void setPrice(String price) {
        priceText.setText(price + "SAR");
    }

    public void setDescription(String description) {
        descriptionText.setText("\n" + description);

    }

    //getters
    public ImageView getImageView() {
        return imageView;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public VBox getvBox() {
        return vBox;
    }

    public Text getDescriptionText() {
        return descriptionText;
    }

    public Text getNameText() {
        return nameText;
    }

    public Text getPriceText() {
        return priceText;
    }

    public Button getCartButton() {
        return cartButton;
    }

    //mouse event
    public void setupMouseActions(Item item, GridPane gridPane, int columnIndex, int rowIndex) {
        ImageView imageView = item.getImageView();
        Rectangle rectangle = item.getRectangle();
        StackPane stackPane = item.getStackPane();

        stackPane.setAlignment(Pos.CENTER);
        StackPane.setMargin(rectangle, new Insets(0, 0, 0, 0));

        imageView.setOnMouseEntered(e -> {
            gridPane.add(stackPane, columnIndex, rowIndex);
        });

        rectangle.setOnMouseExited(e -> {
            gridPane.getChildren().remove(stackPane);
        });
    }

}
