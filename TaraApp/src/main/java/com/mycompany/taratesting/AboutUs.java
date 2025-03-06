/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AboutUs extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setStyle("-fx-background-color: #434343");//الخلفيه رمادي غامق

        //center border
        VBox center = new VBox();
        center.setStyle("-fx-border-color: #434343; -fx-background-color: #FFFFFF");
        center.setAlignment(Pos.CENTER);

        ScrollPane scroller = new ScrollPane(center);

        HBox AU1 = new HBox();
        AU1.setStyle("-fx-border-color: #434343; -fx-background-color: #FFFFFF");
        AU1.setSpacing(50);
        AU1.setAlignment(Pos.CENTER);

        Image flowersImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/AUflowers.jpg");
        ImageView flowers = new ImageView(flowersImage);//Setting the image view 
        flowers.setFitHeight(421); //setting the fit height and width of the image view 
        flowers.setFitWidth(237);

        flowers.setOpacity(0.0);

        // Create a Timeline to animate the opacity
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(flowers.opacityProperty(), 0.0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(flowers.opacityProperty(), 1.0))
        );

        // Play the timeline animation
        timeline.play();

        AU1.getChildren().add(flowers);

        Text aboutTheShop = new Text("\nTara is a specialized flower shop"
                + "\nthat aims to provide customers"
                + "\nwith tailored floral arrangements"
                + "\nbased on the specific occasion or"
                + "\nevent they are celebrating."
                + "\nthe boutique will offer a wide "
                + "\nrange of flower options and "
                + "\ndesigns to suit each event's "
                + "\nunique atmosphere and style.\n");
        aboutTheShop.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        AU1.getChildren().add(aboutTheShop);

        center.getChildren().add(AU1);

        HBox AU2 = new HBox();
        AU2.setStyle("-fx-border-color: #434343; -fx-background-color: #FFFFFF");
        AU2.setSpacing(50);
        AU2.setPadding(new Insets(30, 30, 30, 30));
        AU2.setAlignment(Pos.CENTER);

        Text taraName = new Text("The reason we chose the name Tara is"
                + "\nbecause it symbolizes true, strong,"
                + "\ncohesive, serious, far-reaching "
                + "\nfriendship, and this indicates the"
                + "\nbond of friendship that brings"
                + "\nus together through Teamwork.\n");
        taraName.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        AU2.getChildren().add(taraName);

        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(132); //setting the fit height and width of the image view 
        logo.setFitWidth(264);

        AU2.getChildren().add(logo);

        center.getChildren().add(AU2);

        VBox AU3 = new VBox();
        AU3.setStyle("-fx-border-color: #434343; -fx-background-color: #FFFFFF");
        AU3.setAlignment(Pos.CENTER);
        AU3.setPadding(new Insets(30, 30, 30, 30));

        Text ourTeam = new Text("Our Team Members");
        ourTeam.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));

        AU3.getChildren().add(ourTeam);

        GridPane gridPaneAU3 = new GridPane();

        gridPaneAU3.setPadding(new Insets(30, 30, 30, 30));
        gridPaneAU3.setAlignment(Pos.CENTER);
        gridPaneAU3.setHgap(80);
        gridPaneAU3.setVgap(20);

        Image GirlImage1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Girl1.png");
        ImageView Girl1 = new ImageView(GirlImage1);//Setting the image view 
        Girl1.setFitHeight(100); //setting the fit height and width of the image view 
        Girl1.setFitWidth(100);

        Image GirlImage2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Girl2.png");
        ImageView Girl2 = new ImageView(GirlImage2);//Setting the image view 
        Girl2.setFitHeight(100); //setting the fit height and width of the image view 
        Girl2.setFitWidth(100);

        Image GirlImage3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Girl3.png");
        ImageView Girl3 = new ImageView(GirlImage3);//Setting the image view 
        Girl3.setFitHeight(100); //setting the fit height and width of the image view 
        Girl3.setFitWidth(100);

        Image GirlImage4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Girl4.png");
        ImageView Girl4 = new ImageView(GirlImage4);//Setting the image view 
        Girl4.setFitHeight(100); //setting the fit height and width of the image view 
        Girl4.setFitWidth(100);

        Image GirlImage5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/Girl5.png");
        ImageView Girl5 = new ImageView(GirlImage5);//Setting the image view 
        Girl5.setFitHeight(100); //setting the fit height and width of the image view 
        Girl5.setFitWidth(100);

        Image picImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/pic.png");
        ImageView pic = new ImageView(picImage);//Setting the image view 
        pic.setFitHeight(100); //setting the fit height and width of the image view 
        pic.setFitWidth(100);

        Text name1 = new Text("Jana Atiah\n Al-Harthi");
        name1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text name2 = new Text("Leena Ali\n Alymani");
        name2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text name3 = new Text("Jood Hassan\n Al-Sofyani");
        name3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text name4 = new Text("  Norah\nALsuhaimi");
        name4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text name5 = new Text("Khadija Ali \n  Alajmi");
        name5.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text GroupName = new Text("   Group 3\nDr.Shaimaa\n  bajoudah");
        GroupName.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 20));

        gridPaneAU3.add(Girl1, 0, 1);
        gridPaneAU3.add(Girl2, 1, 1);
        gridPaneAU3.add(Girl3, 2, 1);

        gridPaneAU3.add(name1, 0, 2);
        gridPaneAU3.add(name2, 1, 2);
        gridPaneAU3.add(name3, 2, 2);

        gridPaneAU3.add(Girl4, 0, 3);
        gridPaneAU3.add(Girl5, 1, 3);
        gridPaneAU3.add(pic, 2, 3);

        gridPaneAU3.add(name4, 0, 4);
        gridPaneAU3.add(name5, 1, 4);
        gridPaneAU3.add(GroupName, 2, 4);

        AU3.getChildren().add(gridPaneAU3);

        center.getChildren().add(AU3);

        //bottom brder
        HBox bottom = new HBox();
        bottom.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");
        bottom.setAlignment(Pos.CENTER);

        Button backBt = new Button("back");
        backBt.setStyle("-fx-background-color: #EDBEB6;-fx-font-family:\"Courier New\", monospace;");

        bottom.getChildren().add(backBt);

        //events
        MainPage mainPage = new MainPage();
        backBt.setOnAction(e -> {
            mainPage.start(stage);
        });

        pane.setCenter(scroller);
        pane.setBottom(bottom);

        Scene scene = new Scene(pane, 800, 500);//Creating a scene object 

        stage.setTitle("About Us"); //Setting title to the Stage 

        stage.setScene(scene);  //Adding scene to the stage 
        stage.show();//Displaying the contents of the stage

    }

    public static void main(String[] args) {
        launch();
    }
}
