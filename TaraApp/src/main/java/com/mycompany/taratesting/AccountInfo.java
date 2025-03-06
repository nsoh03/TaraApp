/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class AccountInfo extends Application {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    @Override
    public void start(Stage primaryStage) {

        //top
        HBox top1 = new HBox();
        top1.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7"); //background bagie
        top1.setAlignment(Pos.TOP_CENTER);

        ImageView logo1 = new ImageView("file:/Users/linasmacbook/Desktop/AP-project/logo.png");//Setting the image view 
        logo1.setFitHeight(50); //setting the fit height and width of the image view 
        logo1.setFitWidth(100);

        top1.getChildren().addAll(logo1);

        //---------------------------------
        //user profile window account info
        Label newLabel = new Label("Account Information");
        newLabel.setStyle("-fx-font-size: 30px;-fx-font-family:\"Courier New\", monospace;");

        Line line = new Line();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1);
        line.setStartX(100);
        line.setEndX(460);

        Label lblmsg = new Label();
        lblmsg.setTextFill(Color.BLACK);
        lblmsg.setStyle("-fx-font-size: 20px;-fx-font-family:\"Courier New\", monospace;");
        lblmsg.setAlignment(Pos.CENTER);

        Button button1 = new Button("Account Information");
        button1.setStyle("-fx-background-color: WHITE;-fx-font-family:\"Courier New\", monospace;");

        Button button2 = new Button("Orders");
        button2.setStyle("-fx-background-color: WHITE;-fx-font-family:\"Courier New\", monospace;-fx-font-weight:bold;");

        Button button3 = new Button("Log Out");
        button3.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;-fx-font-weight:bold;");

        GridPane grid1 = new GridPane();
        GridPane.setMargin(grid1, new Insets(1, 1, 1, 15));
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setVgap(5);
        grid1.setHgap(10);
        grid1.add(button1, 0, 0);
        grid1.add(button2, 0, 1);
        grid1.add(newLabel, 2, 0);
        grid1.add(line, 2, 1);

        VBox allOrdersBox = new VBox(10);
        allOrdersBox.setStyle("-fx-background-color: #FFFAFA;");
        allOrdersBox.setAlignment(Pos.CENTER_RIGHT);
        allOrdersBox.getChildren().addAll(grid1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session = HibernateUtil.getSessionFactory().openSession();
        List<customer> resultList = null;
        String queryStr = "FROM customer ";
        Query query = session.createQuery(queryStr);
        resultList = query.list();
        session.close();

        App p = new App();
        for (customer cust : resultList) {
            if (cust.getCostumerId() == CheckoutService.getCustomerID()) {

                VBox customerBox = new VBox(5);
                customerBox.setAlignment(Pos.TOP_CENTER);
                customerBox.setStyle("-fx-background-color: WHITE;");

                String username = cust.getUsername();
                String email = cust.getEmail();
                String phoneNumber = cust.getPhoneNumber();

                // Create labels and add data to vbox layout
                Label usernameLabel = new Label("Username: " + username);
                usernameLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");
                Label emailLabel = new Label("Email: " + email);
                emailLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");
                Label phoneNumberLabel = new Label("Phone Number: " + phoneNumber);
                phoneNumberLabel.setStyle("-fx-font-size: 15px;-fx-font-family:\"Courier New\", monospace;");

                customerBox.getChildren().addAll(usernameLabel, emailLabel, phoneNumberLabel);

                allOrdersBox.getChildren().add(customerBox);

            }

        }
        //---------------------------------
        // put it all in border pane 
        BorderPane kn = new BorderPane();
        kn.setStyle("-fx-background-color: #FFFAFA;");
        BorderPane.setMargin(allOrdersBox, new Insets(1, 1, 300, 1));
        BorderPane.setAlignment(button3, Pos.TOP_RIGHT);
        BorderPane.setMargin(button3, new Insets(0, 8, 8, 1));//b,l,t,r
        kn.setTop(top1);
        kn.setCenter(allOrdersBox);
        kn.setBottom(button3);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(kn);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        //actions
        //to back main page
        MainPage mainPage = new MainPage();
        logo1.setOnMouseClicked(e -> {
            mainPage.start(primaryStage);
        });

        //to go order page
        AccountOrders orders = new AccountOrders();
        button2.setOnAction(e -> {
            orders.start(primaryStage);
        });

        //log out and go to sigup page
        App app = new App();
        button3.setOnAction(e -> {
            app.start(primaryStage);
        });

        Scene scene2 = new Scene(scrollPane, 800, 500);
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Account Information");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
