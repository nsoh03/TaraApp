/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

import java.time.LocalDate;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author linasmacbook
 */
public class ComplatePayment extends Application {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    final int delv = 15;

    Product p = new Product();

    @Override
    public void start(Stage primaryStage) {

        //top porder
        HBox top = new HBox();

        top.setAlignment(Pos.TOP_CENTER);

        ImageView logo = new ImageView("file:/Users/linasmacbook/Desktop/AP-project/logo.png");//Setting the image view 
        logo.setFitHeight(100); //setting the fit height and width of the image view 
        logo.setFitWidth(200);

        top.getChildren().add(logo);

        //---------------------------------
        //delivery address:
        Label lbl = new Label("Delivery Address:");
        lbl.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold; -fx-font-size:20px;");
        Label lbl1 = new Label("Country");
        Label lbl2 = new Label("Region");
        Label lbl4 = new Label("City");
        Label lbl5 = new Label("Street");

        //check for every entrey and display error massge for wrong entry
        TextField fnametex = new TextField();
        fnametex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z\\s-]*")) {
                alert.showInvalidInputAlert("Invalid Input", " letters,spaces,'-' are accepted ", "Please enter letters");
                fnametex.setText(oldValue);
            }
        });

        TextField lnametex = new TextField();
        lnametex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z\\s-]*")) {
                alert.showInvalidInputAlert("Invalid Input", " letters,spaces,'-' are accepted ", "Please enter letters");
                lnametex.setText(oldValue);
            }
        });

        TextField addresstex = new TextField();
        addresstex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z\\s-]*")) {
                alert.showInvalidInputAlert("Invalid Input", " letters,spaces,'-' are accepted ", "Please enter letters");
                addresstex.setText(oldValue);
            }
        });
        TextField citytex = new TextField();
        citytex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z\\s-]*")) {
                alert.showInvalidInputAlert("Invalid Input", " letters,spaces,'-' are accepted ", "Please enter letters");
                citytex.setText(oldValue);
            }
        });

        Line line = new Line();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1);
        line.setStartX(2);
        line.setEndX(165);

        Button button = new Button("Save");
        button.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;");

        //to check every filed is NOT EMPTY
        button.setOnAction(e -> {
            if (fnametex.getText().isEmpty() || lnametex.getText().isEmpty()
                    || addresstex.getText().isEmpty() || citytex.getText().isEmpty()) {
                alert.showInvalidInputAlert("Invalid Input", " Empty Fields", " fill it please");
            } else {
                alert.display("alert", "\tDelivery address data \n  has been saved successfully");
                String country = fnametex.getText();
                String region = lnametex.getText();
                String city = addresstex.getText();
                String street = citytex.getText();

                DeliveryAddress delvadd = new DeliveryAddress(country, city, region, street);

                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                int productInCart = (Integer) session.save(delvadd);
                tx.commit();
                session.close();

            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(17, 1, 1, 1));
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(lbl, 0, 0);
        grid.add(line, 0, 1);
        grid.add(lbl1, 0, 2);
        grid.add(fnametex, 0, 3);
        grid.add(lbl2, 0, 4);
        grid.add(lnametex, 0, 5);
        grid.add(lbl4, 0, 6);
        grid.add(addresstex, 0, 7);
        grid.add(lbl5, 0, 8);
        grid.add(citytex, 0, 9);
        grid.add(button, 4, 12);

        //------------------------------
        //payment
        Label lbl6 = new Label("Payment:");
        lbl6.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold; -fx-font-size:20px;");

        Line line1 = new Line();
        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(1);
        line1.setStartX(2);
        line1.setEndX(165);

        RadioButton v = new RadioButton("Visa/Mada");
        RadioButton c = new RadioButton("Cash");

        ToggleGroup group = new ToggleGroup();
        v.setToggleGroup(group);
        c.setToggleGroup(group);

        ImageView img = new ImageView("file:/Users/linasmacbook/Desktop/AP-project/credit.png");
        ImageView img1 = new ImageView("file:/Users/linasmacbook/Desktop/AP-project/dollar.png");

        img.setFitWidth(50);
        img.setFitHeight(50);

        img1.setFitWidth(40);
        img1.setFitHeight(40);

        //check for every entrey and display error massge for wrong entry
        TextField carnumtex = new TextField();
        carnumtex.setPromptText("Card Number");

        carnumtex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d{17}") && newValue.matches("[a-zA-Z\\s-]*")) {
                alert.showInvalidInputAlert("Invalid Input", " Only 16-digit are accepted ", "Please enter your 16-digit card number");

                carnumtex.setText(oldValue);
            }
        });
        TextField mmtex = new TextField();
        mmtex.setPromptText("MM");

        mmtex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d{3}")) {
                alert.showInvalidInputAlert("Invalid Input", " Only 2-digit are accepted ", "Please enter 2-digit expiration month number");

                mmtex.setText(oldValue);
            }
        });

        TextField yytex = new TextField();
        yytex.setPromptText("YY");

        yytex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d{3}")) {
                alert.showInvalidInputAlert("Invalid Input", " Only 2-digit are accepted ", "Please enter 2-digit expiration year number");
                yytex.setText(oldValue);
            }
        });

        TextField cvvtex = new TextField();
        cvvtex.setPromptText("CVV");
        cvvtex.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d{4}")) {
                alert.showInvalidInputAlert("Invalid Input", " Only 3-digit are accepted ", "Please enter 3-digit of security code");
                cvvtex.setText(oldValue);
            }
        });

        Button button2 = new Button("Save&Continue");
        button2.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;");

        //to check every filed is NOT EMPTY
        button2.setOnAction(e -> {
            if (carnumtex.getText().isEmpty() || mmtex.getText().isEmpty()
                    || yytex.getText().isEmpty() || cvvtex.getText().isEmpty()) {
                alert.showInvalidInputAlert("Invalid Input", " Empty Fields", " fill it please");
            } else {
                alert.display("alert", "  Your payment information \nhas been saved successfully");
            }
        });

        GridPane grid1 = new GridPane();
        GridPane.setMargin(grid1, new Insets(1, 1, 1, 15));
        grid.setAlignment(Pos.CENTER);
        grid1.setVgap(5);
        grid1.setHgap(10);
        grid1.add(carnumtex, 0, 0);
        grid1.add(mmtex, 0, 1);
        grid1.add(yytex, 1, 1);
        grid1.add(cvvtex, 1, 0);
        grid1.add(button2, 1, 2);

        VBox box = new VBox(5);
        VBox.setMargin(lbl6, new Insets(1, 75, 1, 1));
        VBox.setMargin(grid1, new Insets(1, 1, 1, 50));
        VBox.setMargin(c, new Insets(1, 85, 1, 1));
        VBox.setMargin(v, new Insets(1, 60, 1, 1));
        VBox.setMargin(img1, new Insets(1, 70, 1, 1));
        VBox.setMargin(img, new Insets(1, 70, 1, 1));

        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.getChildren().addAll(lbl6, line1, c, img1, v, img);

        HBox boxes = new HBox(10);
        boxes.setAlignment(Pos.CENTER);
        boxes.setPadding(new Insets(20, 20, 11, 5));
        boxes.getChildren().add(box);

        v.setOnAction(e -> {
            box.getChildren().add(grid1);
        });

        c.setOnAction(e -> {
            box.getChildren().remove(grid1);
        });

        //-----------------------------------------------------------------------------------------------------
        //place order
        Line line2 = new Line();
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(1);
        line2.setStartX(2);
        line2.setEndX(165);

        double totalPrice = CheckoutService.getTotalPrice();

        Label lbl8 = new Label("Subtotal:" + totalPrice);

        lbl8.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold; -fx-font-size:20px;");

        Label lbl9 = new Label("Delivery:" + delv);

        lbl9.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold; -fx-font-size:20px;");

        double totalall = delv + totalPrice;
        Label lbl10 = new Label("Total:" + totalall);

        lbl10.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold; -fx-font-size:20px;");

        Button button1 = new Button("Place Order");
        button1.setStyle("-fx-font-family:\"Courier New\", monospace; -fx-font-weight:bold;-fx-background-color: #EDBEB6;");

        MainPage main = new MainPage();
        button1.setOnAction(e -> {

            if (fnametex.getText().isEmpty() || lnametex.getText().isEmpty()
                    || addresstex.getText().isEmpty() || citytex.getText().isEmpty()
                    || !group.getSelectedToggle().isSelected()) {
                alert.showInvalidInputAlert("Invalid Input", " Empty Fields", " fill it please");
            } else {
                alert.display("alert", "Your order has been received");

                String pymentWay = null;
                if (v.isSelected()) {
                    pymentWay = "Visa/Mada";
                }
                if (c.isSelected()) {
                    pymentWay = "Cash";
                }

                Order newOrder = new Order(LocalDate.now(), pymentWay, totalall);
                newOrder.setCustomer_Id(CheckoutService.getCustomerID());

                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                int productInCart = (Integer) session.save(newOrder);
                tx.commit();
                session.close();

                // Delete all records from the products table using HQL (making the cart empty)
                session = HibernateUtil.getSessionFactory().openSession();
                List<products> sList = null;
                String queryStr = "from products";
                Query query = session.createQuery(queryStr);
                sList = query.list();
                session.close();

                for (int i = 0; i < sList.size(); i++) {
                    session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx3 = null;
                    tx3 = session.beginTransaction();
                    session.delete(sList.get(i));
                    tx3.commit();
                    session.close();
                }

                main.start(primaryStage);
            }
        });

        Line line3 = new Line();
        line3.setStroke(Color.BLACK);
        line3.setStrokeWidth(1);
        line3.setStartX(2);
        line3.setEndX(165);

        VBox bo = new VBox(5);
        bo.setMargin(button1, new Insets(6, 6, 6, 30));
        bo.setPadding(new Insets(20, 1, 1, 310));
        bo.setSpacing(15);
        bo.setAlignment(Pos.CENTER_LEFT);
        bo.getChildren().addAll(line2, lbl8, lbl9, lbl10, button1, line3);
        //--------------------------

        VBox allgroup = new VBox();
        VBox.setMargin(grid, new Insets(1, 1, 1, 85));
        allgroup.setAlignment(Pos.CENTER);
        allgroup.getChildren().addAll(top, grid, boxes, bo);

        Rectangle rec = new Rectangle();
        rec.setHeight(900);
        rec.setWidth(700);
        rec.setFill(Color.rgb(255, 255, 240));

        StackPane s = new StackPane();
        StackPane.setMargin(rec, new Insets(60, 1, 1, 1));
        s.setStyle("-fx-background-color: #FFFAFA;");
        s.getChildren().addAll(rec, allgroup);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(s);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        MainPage mainPage = new MainPage();
        logo.setOnMouseClicked(e -> {
            mainPage.start(primaryStage);
        });

        Scene scene = new Scene(scrollPane, 800, 500);

        primaryStage.setTitle("Complate Payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
