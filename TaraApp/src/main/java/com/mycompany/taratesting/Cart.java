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
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author linasmacbook
 */
public class Cart extends Application {

    public Product p = new Product();

    double totalPrice = 0;

    ObservableList<Product> cartProdects = FXCollections.observableArrayList();
    ListView cartProdectsListView = new ListView(cartProdects);

    ArrayList<Product> testing = new ArrayList<Product>();

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    @Override
    public void start(Stage stage) {

        //زبطت ترجع كل اللي فالداتا بيس  
        //retrive products list 
        session = HibernateUtil.getSessionFactory().openSession();
        List<products> sList = null;
        String queryStr = "from products";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();

        //ينضاف العنصر مرتين كل ما ادخل صفحات المنتجات
        for (products s : sList) {
            for (int i = 0; i < p.getProdects().size(); i++) {
                if (p.getProdects().get(i).getName().getText().equals(s.getName()) && p.getProdects().get(i).getDescription().getText().equals(s.getDescription()) && p.getProdects().get(i).getPrice() == s.getPrice()) {
                    testing.add(p.getProdects().get(i));
                }
            }
        }

// for(int j=0 ; j<cartProdects.size() ; j++){
        for (int i = 0; i < testing.size(); i++) {

//                 if(!cartProdects.get(j).getName().equals(testing.get(i).getName())){
//        if(testing.get(i).isInCart())
            cartProdects.add(testing.get(i));
        }
//            }

//        }
        //cart interfase
        BorderPane pane = new BorderPane();

        //top porder
        HBox top = new HBox();
        top.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        top.setAlignment(Pos.TOP_RIGHT);

        Image profileImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/profile.png");
        ImageView profile = new ImageView(profileImage);//Setting the image view 
        profile.setFitHeight(33); //setting the fit height and width of the image view 
        profile.setFitWidth(60);
        top.setMargin(profile, new Insets(10, 650, 0, 0));//b,l,t,r

        top.getChildren().add(profile);

        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(50); //setting the fit height and width of the image view 
        logo.setFitWidth(100);

        top.getChildren().add(logo);

        //center porder
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(30);

        ScrollPane scroller = new ScrollPane(center);

        Text t = new Text();
        t.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));

        center.getChildren().add(t);

        if (cartProdects.isEmpty()) {
            t.setText("\n\n\n                     the cart is empty");
        }

        for (int i = 0; i < cartProdects.size(); i++) {

            HBox perantOfProdect = new HBox();

            HBox prodect = new HBox();
            prodect.setStyle("-fx-border-bottom-color: #434343;");
            prodect.setSpacing(30);
            prodect.setAlignment(Pos.CENTER);

            GridPane GridPaneProdect = new GridPane();
            GridPaneProdect.setVgap(20);
            GridPaneProdect.setHgap(20);

            Text Description = new Text("Description : ");
            Description.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 15));

            Text Price = new Text("Price : ");
            Price.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 15));

            Text Name = new Text("Name :");
            Name.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 15));

            Image trashImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/moveToTrash.png");
            ImageView trash = new ImageView(trashImage);
            trash.setFitHeight(30);
            trash.setFitWidth(30);
            Button deleteBT = new Button("remove", trash);

            cartProdects.get(i).setDeleteButton(deleteBT);

            Text Descriptionv = new Text(cartProdects.get(i).getDescription().getText() + "");
            Descriptionv.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text Pricev = new Text(cartProdects.get(i).getPrice() + "");
            Pricev.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text Namev = cartProdects.get(i).getName();
            Namev.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

            ImageView image = cartProdects.get(i).getImege();
            image.setFitHeight(300);
            image.setFitWidth(200);

            prodect.getChildren().add(image);

            GridPaneProdect.add(Name, 0, 1);
            GridPaneProdect.add(Description, 0, 2);
            GridPaneProdect.add(Price, 0, 3);

            GridPaneProdect.add(Namev, 1, 1);
            GridPaneProdect.add(Descriptionv, 1, 2);
            GridPaneProdect.add(Pricev, 1, 3);

            GridPaneProdect.add(deleteBT, 2, 2);

            prodect.getChildren().add(GridPaneProdect);

            cartProdects.get(i).setBoxOfTheCart(prodect);
            cartProdects.get(i).setPerantOfBoxOfTheCart(perantOfProdect);

            perantOfProdect.getChildren().add(prodect);

            center.getChildren().add(perantOfProdect);

        }

        //bottom brder
        HBox bottom = new HBox(10);
        bottom.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");
        bottom.setAlignment(Pos.CENTER);

        Button reCalculating = new Button("Recalculate Price");
        reCalculating.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;-fx-font-weight:bold;");
        bottom.getChildren().add(reCalculating);

        Text total = new Text("Total :");
        total.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 20));

        bottom.getChildren().add(total);

        for (int i = 0; i < sList.size(); i++) {
            totalPrice += sList.get(i).getPrice();
        }

        // Store the total price in the CheckoutService before opening the CompletePayment screen
        CheckoutService.setTotalPrice(totalPrice);

        Text totalprice = new Text(totalPrice + " RAS");
        totalprice.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //        bottom.setMargin(totalprice, new Insets(0, 0, 8, 0));//b,l,t,r

        reCalculating.setOnAction(e -> {

            session = HibernateUtil.getSessionFactory().openSession();
            List<products> sLists = null;
            String queryStrs = "from products";
            Query querys = session.createQuery(queryStrs);
            sLists = querys.list();
            session.close();

            for (int i = 0; i < sLists.size(); i++) {
                totalPrice = 0;
                totalPrice += sLists.get(i).getPrice();
                totalprice.setText(totalPrice + " RAS");
            }

            CheckoutService.setTotalPrice(totalPrice);

        });

        //------------------------
        bottom.getChildren().add(totalprice);

        Button Confirmation = new Button("Confirm the order");
        Confirmation.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;-fx-font-weight:bold;");

        bottom.getChildren().addAll(Confirmation);

        pane.setCenter(scroller);
        pane.setBottom(bottom);
        pane.setTop(top);

        //events to concatinate between interfaces
        MainPage mainPage = new MainPage();
        logo.setOnMouseClicked(e -> {
            mainPage.start(stage);
        });

        ComplatePayment complatepyment = new ComplatePayment();
        Confirmation.setOnAction(e -> {
            if (cartProdects.isEmpty()) {
                alert.showInvalidInputAlert("Invalid", "Cart Empty", "can not confirm your order without product");
            } else {
                complatepyment.start(stage);
            }
        });

        AccountInfo account = new AccountInfo();
        profile.setOnMouseClicked(e -> {
            account.start(stage);
        });

        Scene scene = new Scene(pane, 800, 500);//Creating a scene object 

        stage.setTitle("cart"); //Setting title to the Stage 

        stage.setScene(scene);  //Adding scene to the stage 
        stage.show();//Displaying the contents of the stage

    }

    public static void main(String[] args) {
        launch();
    }

}
