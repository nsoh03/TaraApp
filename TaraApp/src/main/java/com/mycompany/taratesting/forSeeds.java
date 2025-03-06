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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author linasmacbook
 */
public class forSeeds extends Application {
//    public ArrayList<prodect> prodects = new ArrayList<prodect>();

    public VBox item;

    @Override
    public void start(Stage stage) {

        ////////////-------top bar --------//////////
        HBox buttom = new HBox();
        buttom.setPadding(new Insets(13, 13, 13, 13));
        buttom.setAlignment(Pos.CENTER);//setting the text in the center
        buttom.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        Text tx1 = new Text("“It Takes a Seed To Grow a Garden “");
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

///////////////////---- products -------//////////////
        GridPane grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 60, 25, 40));

        //- product-1- 
        VBox pvox1 = new VBox();

        Image cotton = new Image("file:/Users/linasmacbook/Desktop/AP-project/cotton flower.png");
        ImageView cimg = new ImageView(cotton);
        cimg.setFitHeight(170);
        cimg.setFitWidth(150);
        grid.add(cimg, 0, 0);
        pvox1.getChildren().add(cimg);

        Rectangle rec = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle-info box
        Text text1 = new Text("\n\nIt’s grown in the fall\nand spring\n "
                + "and it can be grown\n throughout the year in\n temperate regions.");
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane1 = createStackPane(rec, text1);
        stackPane1.setPadding(new Insets(0, 20, 45, 0));// bottom,left , top , right
        cimg.setOnMouseEntered(e -> {
            grid.add(stackPane1, 0, 0);
        });
        rec.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane1);
        });

        HBox phox1 = new HBox();
        Text p1N = new Text("Cotton Flower\t\t\t");
        Text p1P = new Text("30.0SR");
        phox1.getChildren().addAll(p1N, p1P);

        //---cart1-------
        VBox cart1 = new VBox();

        Image basket1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas1 = new ImageView(basket1);
        bas1.setFitHeight(21);
        bas1.setFitWidth(21);
        Button bt1 = new Button("cart", bas1);
        bt1.setPrefWidth(70);

        cart1.getChildren().add(bt1);

        pvox1.getChildren().addAll(phox1, cart1);
        grid.add(pvox1, 0, 0);

        //another class
        Product product1 = new Product(p1N, 30.0, text1, cimg, false);
        product1.add(product1);
        product1.setButton(bt1);

        //-product-2- 
        VBox pvox2 = new VBox();

        Image tulip = new Image("file:/Users/linasmacbook/Desktop/AP-project/tulip flower.png");
        ImageView tul = new ImageView(tulip);//Setting the image view 
        tul.setFitHeight(170); //setting the fit height and width of the image view 
        tul.setFitWidth(150);
        grid.add(tul, 1, 0);
        pvox2.getChildren().add(tul);

        Rectangle rec1 = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text2 = new Text("\n\n Tulips grow best in full sun"
                + "\n in the North\n and partial shade \nin the South.");
        text2.setFill(Color.WHITE);
        text2.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane2 = createStackPane(rec1, text2);
        stackPane2.setPadding(new Insets(0, 0, 45, 0));// bottom,left , top , right
        tul.setOnMouseEntered(e -> {
            grid.add(stackPane2, 1, 0);
        });
        rec1.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane2);
        });

        HBox phox2 = new HBox();
        Text p2N = new Text("Tulip Seeds\t\t\t");
        Text p2P = new Text("30,0SR");
        phox2.getChildren().addAll(p2N, p2P);

        //-----cart2-----  
        VBox cart2 = new VBox();

        Image basket2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas2 = new ImageView(basket2);
        bas2.setFitHeight(21);
        bas2.setFitWidth(21);
        Button bt2 = new Button("cart", bas2);
        bt2.setPrefWidth(70);

        cart2.getChildren().add(bt2);

        pvox2.getChildren().addAll(phox2, cart2);
        grid.add(pvox2, 1, 0);

        //another class
        Product product2 = new Product(p2N, 30.0, text2, tul, false);
        product2.add(product2);
        product2.setButton(bt2);

        //-product-3-
        VBox pvox3 = new VBox();

        Image Ageratum = new Image("file:/Users/linasmacbook/Desktop/AP-project/Ageratum mexicanum pink.jpg");
        ImageView Ageimg = new ImageView(Ageratum);//Setting the image view 
        Ageimg.setFitHeight(170); //setting the fit height and width of the image view 
        Ageimg.setFitWidth(150);
        grid.add(Ageimg, 2, 0);
        pvox3.getChildren().add(Ageimg);

        Rectangle rec2 = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text3 = new Text("\n\nThey are planted\nduring the spring\n "
                + "and can be grown\nthroughout the year\nin temperate\nand warm areas.");
        text3.setFill(Color.WHITE);
        text3.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane3 = createStackPane(rec2, text3);
        stackPane3.setPadding(new Insets(0, 20, 45, 0));// bottom,left , top , right
        Ageimg.setOnMouseEntered(e -> {
            grid.add(stackPane3, 2, 0);
        });
        rec2.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane3);
        });

        HBox phox3 = new HBox();
        Text p3N = new Text("Ageratum Mexicanum\t");
        Text p3P = new Text("30,0SR");
        phox3.getChildren().addAll(p3N, p3P);

        //-----cart3----
        VBox cart3 = new VBox();

        Image basket3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas3 = new ImageView(basket3);
        bas3.setFitHeight(21);
        bas3.setFitWidth(21);
        Button bt3 = new Button("cart", bas3);
        bt3.setPrefWidth(70);

        cart3.getChildren().add(bt3);

        pvox3.getChildren().addAll(phox3, cart3);
        grid.add(pvox3, 2, 0);

        //another class
        Product product3 = new Product(p3N, 30.0, text3, Ageimg, false);
        product3.add(product3);
        product3.setButton(bt3);

        //-product-4-
        VBox pvox4 = new VBox();

        Image sunflower = new Image("file:/Users/linasmacbook/Desktop/AP-project/sunflower.jpg");
        ImageView sunimg = new ImageView(sunflower);//Setting the image view 
        sunimg.setFitHeight(170); //setting the fit height and width of the image view 
        sunimg.setFitWidth(150);
        grid.add(sunimg, 0, 1);
        pvox4.getChildren().add(sunimg);

        Rectangle rec3 = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text4 = new Text("\n\nSunflower plants\n are best grown in\nfull sun. Choose a location \n"
                + "that will receive\nat least 6 hours of\nfull sun each day.");
        text4.setFill(Color.WHITE);
        text4.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane4 = createStackPane(rec3, text4);
        stackPane4.setPadding(new Insets(0, 20, 45, 0));// bottom,left , top , right
        sunimg.setOnMouseEntered(e -> {
            grid.add(stackPane4, 0, 1);
        });
        rec3.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane4);
        });

        HBox phox4 = new HBox();
        Text p4N = new Text("SunFlower\t\t\t");
        Text p4P = new Text("30,0SR");
        phox4.getChildren().addAll(p4N, p4P);

        //---cart4---  
        VBox cart4 = new VBox();

        Image basket4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas4 = new ImageView(basket4);
        bas4.setFitHeight(21);
        bas4.setFitWidth(21);
        Button bt4 = new Button("cart", bas4);
        bt4.setPrefWidth(70);

        cart4.getChildren().add(bt4);

        pvox4.getChildren().addAll(phox4, cart4);
        grid.add(pvox4, 0, 1);

        //another class
        Product product4 = new Product(p4N, 30.0, text4, sunimg, false);
        product4.add(product4);
        product4.setButton(bt4);

        //-product-5-
        VBox pvox5 = new VBox();

        Image rosea = new Image("file:/Users/linasmacbook/Desktop/AP-project/aleca rosea.jpg");
        ImageView rosa = new ImageView(rosea);//Setting the image view 
        rosa.setFitHeight(170); //setting the fit height and width of the image view 
        rosa.setFitWidth(150);
        grid.add(rosa, 1, 1);
        pvox5.getChildren().add(rosa);

        Rectangle rec4 = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text5 = new Text("\n\n It needs sunny Places\nand Can be grown\nall year round in cold reigons");
        text5.setFill(Color.WHITE);
        text5.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane5 = createStackPane(rec4, text5);
        stackPane5.setPadding(new Insets(0, 0, 45, 0));// bottom,left , top , right
        rosa.setOnMouseEntered(e -> {
            grid.add(stackPane5, 1, 1);
        });
        rec4.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane5);
        });

        HBox phox5 = new HBox();
        Text p5N = new Text("Alecea Rosea\t\t");
        Text p5P = new Text("30,0SR");
        phox5.getChildren().addAll(p5N, p5P);

        //----cart5----
        VBox cart5 = new VBox();

        Image basket5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas5 = new ImageView(basket5);
        bas5.setFitHeight(21);
        bas5.setFitWidth(21);
        Button bt5 = new Button("cart", bas5);
        bt5.setPrefWidth(70);

        cart5.getChildren().add(bt5);

        pvox5.getChildren().addAll(phox5, cart5);
        grid.add(pvox5, 1, 1);

        //another class
        Product product5 = new Product(p5N, 30.0, text5, rosa, false);
        product5.add(product5);
        product5.setButton(bt5);

        //-product-6-
        VBox pvox6 = new VBox();

        Image zinia = new Image("file:/Users/linasmacbook/Desktop/AP-project/white Zinnia .jpg");
        ImageView zimg = new ImageView(zinia);//Setting the image view 
        zimg.setFitHeight(170); //setting the fit height and width of the image view 
        zimg.setFitWidth(150);
        grid.add(zimg, 2, 1);
        pvox6.getChildren().add(zimg);

        Rectangle rec5 = new Rectangle(150, 170, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text6 = new Text("\n\nOne of the most\n heat-tolerant flowers\nIt thrives in sandy \n"
                + "and clay soils and withstands\n the relative salinity of \nthe soil.");
        text6.setFill(Color.WHITE);
        text6.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane6 = createStackPane(rec5, text6);
        stackPane6.setPadding(new Insets(0, 20, 45, 0));// bottom,left , top , right
        zimg.setOnMouseEntered(e -> {
            grid.add(stackPane6, 2, 1);
        });
        rec5.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane6);
        });

        HBox phox6 = new HBox();
        Text p6N = new Text("White Zinnia elegans\t");
        Text p6P = new Text("30,0SR");
        phox6.getChildren().addAll(p6N, p6P);

        //----cart6---    
        VBox cart6 = new VBox();

        Image basket6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");// basket icon 
        ImageView bas6 = new ImageView(basket6);
        bas6.setFitHeight(21);
        bas6.setFitWidth(21);
        Button bt6 = new Button("cart", bas6);
        bt6.setPrefWidth(70);

        cart6.getChildren().add(bt6);

        pvox6.getChildren().addAll(phox6, cart6);
        grid.add(pvox6, 2, 1);

        //another class
        Product product6 = new Product(p6N, 30.0, text6, zimg, false);
        product6.add(product6);
        product6.setButton(bt6);

        /////////////////////////-----side bar------//////////////////
        //shop by type -- important 
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(40, 10, 10, 10));
        vbox1.setSpacing(20);
        Text text7 = new Text(" Shop\nfor\nSeeds");
        text7.setFill(Color.BLACK);
        text7.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        vbox1.getChildren().add(text7);

        String[] Type = {"Cotton flower Seeds", "Tulip Seeds", "White Zinia seeds",
            "Aleca rosea Seeds", "SunFlower Seeds", "Ageratum mexicanum Seeds", ""};
        ComboBox<String> cbo = new ComboBox<>();
        cbo.setEditable(true);
        cbo.setPrefWidth(150);
        cbo.setValue("Shop By Type :");
        cbo.getItems().addAll(Type);
        cbo.setVisibleRowCount(3);//for setting the number of visible items in the list
        vbox1.getChildren().add(cbo);

        cbo.setOnAction(e -> {

            String selectedType = cbo.getValue();

            switch (selectedType) {
                case "Cotton flower Seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox1);
                    break;

                case "Tulip Seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox2);
                    break;

                case "White Zinia seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox6);
                    break;

                case "SunFlower Seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox4);
                    break;

                case "Aleca rosea Seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox5);
                    break;

                case "Ageratum mexicanum Seeds":
                    grid.getChildren().clear();
                    grid.getChildren().add(pvox3);
                    break;

                case "":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(pvox1, pvox2, pvox3, pvox4, pvox5, pvox6);

                default:
                    grid.getChildren().clear();
                    grid.getChildren().addAll(pvox1, pvox2, pvox3, pvox4, pvox5, pvox6);
                    break;
            }

        });

        //////////------background-------///////////
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: #fcf5f8;");
        bp.setTop(top);
        grid.setStyle("-fx-background-color:radial-gradient(center 50% 50% , radius 70% , #ffcaca,#ffffff");
        bp.setCenter(grid);
        bp.setLeft(vbox1);
        bp.setBottom(buttom);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(bp);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        MainPage mainPage = new MainPage();
        logo.setOnMouseClicked(e -> {
            mainPage.start(stage);
        });

        Scene scene = new Scene(scrollPane, 800, 500);
        stage.setTitle("shop for seeds");
        stage.setScene(scene);
        stage.show();
    }

    private StackPane createStackPane(Rectangle rectangle, Text text) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);
        StackPane.setAlignment(text, Pos.CENTER);
        return stackPane;

    }

    public static void main(String[] args) {
        launch();
    }

}
