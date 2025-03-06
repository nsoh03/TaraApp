/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * JavaFX App
 */
public class MainPage extends Application {

    @Override
    public void start(Stage stage) {

        //main pane
        BorderPane pane = new BorderPane();

        //top porder
        HBox top = new HBox();
        top.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 

        Image profileImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/profile.png");
        ImageView profile = new ImageView(profileImage);//Setting the image view 
        profile.setFitHeight(33); //setting the fit height and width of the image view 
        profile.setFitWidth(60);
        top.setMargin(profile, new Insets(10, 0, 0, 0));//b,l,t,r

        top.getChildren().add(profile);

        Image cartImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/cartLogo.png");
        ImageView cart = new ImageView(cartImage);//Setting the image view 
        cart.setFitHeight(40); //setting the fit height and width of the image view 
        cart.setFitWidth(50);
        top.setMargin(cart, new Insets(5, 0, 0, 0));//b,l,t,r

        top.getChildren().add(cart);

        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(50); //setting the fit height and width of the image view 
        logo.setFitWidth(100);
        top.setMargin(logo, new Insets(0, 0, 0, 590));//b,l,t,r

        top.getChildren().add(logo);

        //center porder 
        VBox center = new VBox();
        center.setStyle("-fx-border-color: #434343; -fx-background-color: #FFFFFF");//الخلفيه ابيض  
        center.setAlignment(Pos.CENTER);
        center.setSpacing(20);

        Text welcoming = new Text("welcome to our shop");
        welcoming.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));

        center.getChildren().add(welcoming);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF");//الخلفيه  ابيض 

        //flower 
        Text flowerT = new Text("shop by type");
        flowerT.setFill(Color.WHITE);
        flowerT.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Rectangle flowersR = new Rectangle();
        flowersR.setWidth(232);
        flowersR.setHeight(232);
        flowersR.setFill(Color.web("#434343", 0.7));

        StackPane flowersStackPane = CreateStackPane(flowersR, flowerT);

        Image flowersImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/flowers.jpg");
        ImageView flowers = new ImageView(flowersImage);//Setting the image view 
        flowers.setFitHeight(232); //setting the fit height and width of the image view 
        flowers.setFitWidth(232);

        //celebration
        Text celebrationT = new Text("shop by occation");
        celebrationT.setFill(Color.WHITE);
        celebrationT.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Rectangle celebrationR = new Rectangle();
        celebrationR.setWidth(237);
        celebrationR.setHeight(232);
        celebrationR.setFill(Color.web("#434343", 0.7));

        StackPane celebrationsStackPane = CreateStackPane(celebrationR, celebrationT);

        Image celebrationImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/celebration.jpg");
        ImageView celebration = new ImageView(celebrationImage);//Setting the image view 
        celebration.setFitHeight(232); //setting the fit height and width of the image view 
        celebration.setFitWidth(237);

        //seeds
        Text seedsT = new Text("shop for seeds");
        seedsT.setFill(Color.WHITE);
        seedsT.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Rectangle seedsR = new Rectangle();
        seedsR.setWidth(230);
        seedsR.setHeight(230);
        seedsR.setFill(Color.web("#434343", 0.7));

        StackPane seedsStackPane = CreateStackPane(seedsR, seedsT);

        Image seedsImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/seeds.jpg");
        ImageView seeds = new ImageView(seedsImage);//Setting the image view 
        seeds.setFitHeight(230); //setting the fit height and width of the image view 
        seeds.setFitWidth(230);

        gridPane.add(flowers, 0, 1);
        gridPane.add(celebration, 1, 1);
        gridPane.add(seeds, 2, 1);

        center.getChildren().add(gridPane);

        //bottom
        HBox bottom = new HBox();
        bottom.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        bottom.setAlignment(Pos.CENTER);

        Text aboutUsText = new Text("About Us");
        aboutUsText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        bottom.getChildren().add(aboutUsText);

        pane.setBottom(bottom);
        pane.setTop(top);
        pane.setCenter(center);

        //events 
        //flower image
        flowers.setOnMouseEntered(e -> {
            gridPane.add(flowersStackPane, 0, 1);
        });
        flowersR.setOnMouseExited(e -> {
            gridPane.getChildren().remove(flowersStackPane);
        });

        //celebration image
        celebration.setOnMouseEntered(e -> {
            gridPane.add(celebrationsStackPane, 1, 1);
        });
        celebrationR.setOnMouseExited(e -> {
            gridPane.getChildren().remove(celebrationsStackPane);
        });

        //seeds image
        seeds.setOnMouseEntered(e -> {
            gridPane.add(seedsStackPane, 2, 1);
        });
        seedsR.setOnMouseExited(e -> {
            gridPane.getChildren().remove(seedsStackPane);
        });

        //events to concatinate between interfaces
        //####################################################################################
        //about us text 
        AboutUs aboutUs = new AboutUs();
        aboutUsText.setOnMouseClicked(e -> {
            aboutUs.start(stage);
        });

        //by type page
        byType pytype = new byType();
        flowersStackPane.setOnMouseClicked(e -> {
            pytype.start(stage);
        });

        //by seeds page
        forSeeds byseeds = new forSeeds();
        seedsStackPane.setOnMouseClicked(e -> {
            byseeds.start(stage);
        });

        //by byOccation page
        byOccation byoccation = new byOccation();
        celebrationsStackPane.setOnMouseClicked(e -> {
            byoccation.start(stage);
        });

        //cart
        Cart cartPage = new Cart();
        cart.setOnMouseClicked(e -> {
            cartPage.start(stage);
        });

        //profile 
        AccountInfo account = new AccountInfo();
        profile.setOnMouseClicked(e -> {
            account.start(stage);
        });

        Scene scene = new Scene(pane, 800, 500);

        stage.setTitle("main page"); //Setting title to the Stage 
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    private StackPane CreateStackPane(Rectangle r, Text t) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(r, t);
        stackPane.setAlignment(t, Pos.CENTER);
        return stackPane;

    }
}
