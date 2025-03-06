/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author linasmacbook
 */
public class byOccation extends Application {

    @Override
    public void start(Stage stage) {

        HBox buttom = new HBox();
        buttom.setPadding(new Insets(13, 13, 13, 13));
        buttom.setAlignment(Pos.CENTER);//setting the text in the center
        buttom.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 

        Text tx1 = new Text("“Flowers don’t tell, they show.” — Stephanie Skeem");
        tx1.setFont(Font.font("Garamond", FontWeight.BOLD, 17));
        buttom.getChildren().add(tx1);

        HBox top = new HBox();
        top.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        top.setAlignment(Pos.TOP_RIGHT);

        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(50); //setting the fit height and width of the image view 
        logo.setFitWidth(100);
        top.getChildren().add(logo);

//***************************************************************** OCCASION BAR *****************************************************************
        BorderPane occ = new BorderPane();

        Text byOcc = new Text("  Shop\n  By\n  Occasion");
        byOcc.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        HBox occBarButtons = new HBox(20);

//---------------------------------------------------------------Buttons and images---------------------------------------------------------------
// [BIRTHDAY]
        // Load the PNG image
        Image pngImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/birthday-hat.png");
        // Load the GIF image
        Image gifImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/birthday-hat.gif");

        // Create the image view with the PNG image
        ImageView imageView = new ImageView(pngImage);
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);

        // Create the button
        Button imageButton = new Button();
        imageButton.setStyle("-fx-background-color:rgba(0,0,0,0)");
        imageButton.setGraphic(imageView);

// [BABY SHOWER]
        // Load the PNG image
        Image pngImage2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/baby-clothing-bib.png");
        // Load the GIF image
        Image gifImage2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/baby-clothing-bib.gif");

        // Create the image view with the PNG image
        ImageView imageView2 = new ImageView(pngImage2);
        imageView2.setFitHeight(60);
        imageView2.setFitWidth(60);

        // Create the button
        Button imageButton2 = new Button();
        imageButton2.setStyle("-fx-background-color:rgba(0,0,0,0)");
        imageButton2.setGraphic(imageView2);

// [GRADUATION]
        // Load the PNG image
        Image pngImage3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/graduation.png");
        // Load the GIF image
        Image gifImage3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/graduation.gif");

        // Create the image view with the PNG image
        ImageView imageView3 = new ImageView(pngImage3);
        imageView3.setFitHeight(60);
        imageView3.setFitWidth(60);

        // Create the button
        Button imageButton3 = new Button();
        imageButton3.setStyle("-fx-background-color:rgba(0,0,0,0)");
        imageButton3.setGraphic(imageView3);

// [WEDDING]
        // Load the PNG image
        Image pngImage4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/wedding.png");
        // Load the GIF image
        Image gifImage4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/wedding.gif");

        // Create the image view with the PNG image
        ImageView imageView4 = new ImageView(pngImage4);
        imageView4.setFitHeight(60);
        imageView4.setFitWidth(60);

        // Create the button
        Button imageButton4 = new Button();
        imageButton4.setStyle("-fx-background-color:rgba(0,0,0,0)");
        imageButton4.setGraphic(imageView4);

//----------------- flag to track the active button ---------------------------------------------------------------------------------- 
        AtomicBoolean activeButton = new AtomicBoolean(false);
//-------------------- Occasions Top Bar ---------------------------------------------------------------------------------------------
        occBarButtons.setAlignment(Pos.CENTER);
        occBarButtons.getChildren().addAll(imageButton, imageButton2, imageButton3, imageButton4);
        occ.setTop(occBarButtons);
//-------------------Prouducts--------------------------------------------------------------------------------------------------------      
        Birthday bdgridPaneContainer = new Birthday();
        GridPane bd = bdgridPaneContainer.getGridPane();
        BabyShower bsgridPaneContainer = new BabyShower();
        GridPane bs = bsgridPaneContainer.getGridPane();
        Graduation ggridPaneContainer = new Graduation();
        GridPane g = ggridPaneContainer.getGridPane();
        Wedding wgridPaneContainer = new Wedding();
        GridPane w = wgridPaneContainer.getGridPane();

        Birthday bdgridPaneContainer2 = new Birthday();
        GridPane bd2 = bdgridPaneContainer2.getGridPane();
        BabyShower bsgridPaneContainer2 = new BabyShower();
        GridPane bs2 = bsgridPaneContainer2.getGridPane();
        Graduation ggridPaneContainer2 = new Graduation();
        GridPane g2 = ggridPaneContainer2.getGridPane();
        Wedding wgridPaneContainer2 = new Wedding();
        GridPane w2 = wgridPaneContainer2.getGridPane();
        VBox All = new VBox();
        All.getChildren().addAll(bd2, bs2, g2, w2);

//---------------------------------------------------------------Pane---------------------------------------------------------------
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: radial-gradient(center 50% 50% , radius 70% , #ffcaca, #ffffff);");
        bp.setTop(top);
        occ.setCenter(All);
        bp.setLeft(byOcc);
        bp.setCenter(occ);
        bp.setBottom(buttom);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(bp);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
//-------------------------------------------------Event handling---------------------------------------------------------------------
        imageButton.setOnMouseEntered(e -> {
            if (!activeButton.get()) {
                imageView.setImage(gifImage);
                imageButton.setText("Birthday");
                imageButton.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            }
        });

        imageButton.setOnMouseExited(e -> {
            if (!activeButton.get()) {
                imageView.setImage(pngImage);
                imageButton.setText("");
            }
        });

        imageButton.setOnAction(e -> {
            activeButton.set(true);
            occ.setCenter(bd);
            imageView.setImage(gifImage);
            imageButton.setText("Birthday");
            imageButton.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            tx1.setText("Birthday");

            // Reset other buttons
            imageView2.setImage(pngImage2);
            imageButton2.setText("");
            imageView3.setImage(pngImage3);
            imageButton3.setText("");
            imageView4.setImage(pngImage4);
            imageButton4.setText("");

        });

        imageButton2.setOnMouseEntered(e -> {
            if (!activeButton.get()) {
                imageView2.setImage(gifImage2);
                imageButton2.setText("Baby Shower");
                imageButton2.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            }
        });

        imageButton2.setOnMouseExited(e -> {
            if (!activeButton.get()) {
                imageView2.setImage(pngImage2);
                imageButton2.setText("");
            }
        });

        imageButton2.setOnAction(e -> {
            activeButton.set(true);
            occ.setCenter(bs);
            imageView2.setImage(gifImage2);
            imageButton2.setText("Baby Shower");
            imageButton2.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            tx1.setText("Baby Shower");

            // Reset other buttons
            imageView.setImage(pngImage);
            imageButton.setText("");
            imageView3.setImage(pngImage3);
            imageButton3.setText("");
            imageView4.setImage(pngImage4);
            imageButton4.setText("");

        });

        imageButton3.setOnMouseEntered(e -> {
            if (!activeButton.get()) {
                imageView3.setImage(gifImage3);
                imageButton3.setText("Graduation");
                imageButton3.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            }
        });

        imageButton3.setOnMouseExited(e -> {
            if (!activeButton.get()) {
                imageView3.setImage(pngImage3);
                imageButton3.setText("");
            }
        });

        imageButton3.setOnAction(e -> {
            activeButton.set(true);
            occ.setCenter(g);
            imageView3.setImage(gifImage3);
            imageButton3.setText("Graduation");
            imageButton3.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            tx1.setText("Graduation");

            // Reset other buttons
            imageView.setImage(pngImage);
            imageButton.setText("");
            imageView2.setImage(pngImage2);
            imageButton2.setText("");
            imageView4.setImage(pngImage4);
            imageButton4.setText("");

        });

        imageButton4.setOnMouseEntered(e -> {
            if (!activeButton.get()) {
                imageView4.setImage(gifImage4);
                imageButton4.setText("Wedding");
                imageButton4.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            }
        });

        imageButton4.setOnMouseExited(e -> {
            if (!activeButton.get()) {
                imageView4.setImage(pngImage4);
                imageButton4.setText("");
            }
        });

        imageButton4.setOnAction(e -> {
            activeButton.set(true);
            occ.setCenter(w);
            imageView4.setImage(gifImage4);
            imageButton4.setText("Wedding");
            imageButton4.setFont(Font.font("Garamond", FontWeight.BOLD, 12));
            tx1.setText("Wedding");

            // Reset other buttons
            imageView.setImage(pngImage);
            imageButton.setText("");
            imageView2.setImage(pngImage2);
            imageButton2.setText("");
            imageView3.setImage(pngImage3);
            imageButton3.setText("");

        });

        byOcc.setOnMouseClicked(e -> {
            activeButton.set(false);
            occ.setCenter(All);
            tx1.setText("“Flowers don’t tell, they show.” — Stephanie Skeem");
            // Reset all buttons
            imageView.setImage(pngImage);
            imageButton.setText("");
            imageView2.setImage(pngImage2);
            imageButton2.setText("");
            imageView3.setImage(pngImage3);
            imageButton3.setText("");
            imageView4.setImage(pngImage4);
            imageButton4.setText("");

        });

        MainPage mainPage = new MainPage();
        logo.setOnMouseClicked(e -> {
            mainPage.start(stage);
        });

        Scene scene = new Scene(scrollPane, 800, 500);
        stage.setTitle("shop by occasion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
