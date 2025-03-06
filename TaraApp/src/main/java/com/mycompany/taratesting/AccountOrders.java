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
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author linasmacbook
 */
public class AccountOrders extends Application {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    @Override
    public void start(Stage primaryStage) {

        HBox top2 = new HBox();
        top2.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7"); //background bagie
        top2.setAlignment(Pos.TOP_CENTER);

        ImageView logo2 = new ImageView("file:/Users/linasmacbook/Desktop/AP-project/logo.png");//Setting the image view 
        logo2.setFitHeight(50); //setting the fit height and width of the image view 
        logo2.setFitWidth(100);

        top2.getChildren().addAll(logo2);

        //-------------------------------------
        //user profile window order
        Label newLabel1 = new Label("Orders");
        newLabel1.setStyle("-fx-font-size: 30px;-fx-font-family:\"Courier New\", monospace;");

        Line line1 = new Line();
        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(1);
        line1.setStartX(100);
        line1.setEndX(400);

        Button button1 = new Button("Account Information");
        button1.setStyle("-fx-background-color: WHITE;-fx-font-family:\"Courier New\", monospace;-fx-font-weight:bold;");

        Button button2 = new Button("Orders");
        button2.setStyle("-fx-background-color: WHITE;-fx-font-family:\"Courier New\", monospace;");

        GridPane grid1 = new GridPane();
        GridPane.setMargin(grid1, new Insets(1, 1, 1, 15));
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setVgap(5);
        grid1.setHgap(10);
        grid1.add(button1, 0, 0);
        grid1.add(button2, 0, 1);
        grid1.add(newLabel1, 2, 0);
        grid1.add(line1, 2, 1);

        //------------------------------------
        // Clear previous order details from the display
        VBox allOrdersBox = new VBox(10); // 10 is the spacing between children
        allOrdersBox.setStyle("-fx-background-color: #FFFAFA;");
        allOrdersBox.setAlignment(Pos.CENTER_RIGHT);

        allOrdersBox.getChildren().add(grid1);

        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> OrdersList = null;
        String orderQ = "from Order";
        Query query1 = session.createQuery(orderQ);
        OrdersList = query1.list();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        List<DeliveryAddress> AddressesList = null;
        String AddressesQ = "from DeliveryAddress";
        Query query2 = session.createQuery(AddressesQ);
        AddressesList = query2.list();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        List<customer> customerList = null;
        String customerQ = "from customer";
        Query query3 = session.createQuery(customerQ);
        customerList = query3.list();
        session.close();

        for (Order currentOrder : OrdersList) {
            if (currentOrder.getCustomer_Id() == CheckoutService.getCustomerID()) {

                // Create a VBox for each order's details
                VBox orderBox = new VBox(5);
                orderBox.setAlignment(Pos.TOP_CENTER);
                orderBox.setStyle("-fx-background-color: WHITE;");

                Label orderNumberLabel = new Label("Order Number: " + currentOrder.getOrderId());
                orderNumberLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");
                Label totalPriceLabel = new Label("Total Price: " + currentOrder.getTotalPrice());
                totalPriceLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");
                Label orderDateLabel = new Label("Order Date: " + currentOrder.getOrderDate());
                orderDateLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");
                Label paymentWayLabel = new Label("Payment Way: " + currentOrder.getPymentWay());
                paymentWayLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");

                orderBox.getChildren().addAll(orderNumberLabel, totalPriceLabel, orderDateLabel, paymentWayLabel);

                for (DeliveryAddress currentDeliveryAddress : AddressesList) {
                    if (currentDeliveryAddress.getDeliveryAddressID() == currentOrder.getOrderId() - 2) {

                        Label deliveryAddressLabel = new Label(
                                "Delivery Address: "
                                + currentDeliveryAddress.getCountry() + ","
                                + currentDeliveryAddress.getCity() + ","
                                + currentDeliveryAddress.getRegion() + ","
                                + currentDeliveryAddress.getStreet());
                        deliveryAddressLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");

                        orderBox.getChildren().add(deliveryAddressLabel);
                    }
                }

                allOrdersBox.getChildren().add(orderBox);
            }
        }

        BorderPane sn = new BorderPane();

        BorderPane.setMargin(allOrdersBox,
                new Insets(1, 1, 330, 1));
        sn.setStyle(
                "-fx-background-color: #FFFAFA;");
        sn.setTop(top2);

        sn.setCenter(allOrdersBox);

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(sn);

        scrollPane.setFitToWidth(
                true);
        scrollPane.setFitToHeight(
                true);

        MainPage mainPage = new MainPage();

        logo2.setOnMouseClicked(e
                -> {
            mainPage.start(primaryStage);
        });

        //to go Account Information page
        AccountInfo acc = new AccountInfo();

        button1.setOnAction(e
                -> {
            acc.start(primaryStage);
        });

        Scene scene3 = new Scene(scrollPane, 800, 500);

        primaryStage.setScene(scene3);

        primaryStage.setTitle(
                "Orders");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
