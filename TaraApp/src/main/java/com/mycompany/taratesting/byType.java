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
public class byType extends Application {

//   public ArrayList<prodect> prodects = new ArrayList<prodect>();
    @Override
    public void start(Stage stage) {

        //create the HBox for the top BorderPane
        HBox toplogo = new HBox();
        toplogo.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        toplogo.setAlignment(Pos.TOP_RIGHT);

        //create the logoImage for the top BorderPane
        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        //setting the height and width of the image view 
        logo.setFitHeight(50);
        logo.setFitWidth(100);
        toplogo.getChildren().add(logo);

        //-------------------------------------------------------------------
        //create the GridPane for the center BorderPane
        GridPane grid = new GridPane();
        grid.setHgap(40);
        grid.setVgap(30);
        grid.setPadding(new Insets(50, 30, 50, 30));
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 1 to put each of the photo,price,description and cart button in the center of the PorderPane 

        VBox vpeon = new VBox();
        //create the peonies image 
        Image peonies = new Image("file:/Users/linasmacbook/Desktop/AP-project/3.jpg");
        ImageView peo = new ImageView(peonies);
        peo.setFitHeight(170);
        peo.setFitWidth(150);
        vpeon.getChildren().add(peo);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text1 = new Text("\nPeony has the meaning\nof wealth and\nit symbolize family\nand good luck.");
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane1 = createStackPane(rec, text1);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        peo.setOnMouseEntered(e -> {
            grid.add(stackPane1, 0, 0);
        });
        rec.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane1);
        });
        //create the HBox for the name and the price for the product
        HBox hbox = new HBox();
        Text txpeo = new Text("Peoines\t\t\t");
        Text txpeo1 = new Text("37,5SR");
        hbox.getChildren().addAll(txpeo, txpeo1);
        //------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button1 = new VBox();
        Image basket = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas = new ImageView(basket);
        bas.setFitHeight(21);
        bas.setFitWidth(21);
        Button bt = new Button("cart", bas);
        bt.setPrefWidth(70);
        button1.getChildren().add(bt);
        vpeon.getChildren().addAll(hbox, button1);
        grid.add(vpeon, 0, 0);

        //#################################################################
        Product p1 = new Product(txpeo, 37.5, text1, peo, false);
        p1.add(p1);
        p1.setButton(bt);

        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 2 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vtul = new VBox();
        Image tulip = new Image("file:/Users/linasmacbook/Desktop/AP-project/4.jpg");
        ImageView tul = new ImageView(tulip);//Setting the image view 
        tul.setFitHeight(170); //setting the fit height and width of the image view 
        tul.setFitWidth(150);
        vtul.getChildren().add(tul);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec1 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text2 = new Text("\nThe tulip flower\nconsidered a symbol of\ncelebrating marriage.");
        text2.setFill(Color.WHITE);
        text2.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane2 = createStackPane(rec1, text2);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        tul.setOnMouseEntered(e -> {
            grid.add(stackPane2, 1, 3);
        });
        rec1.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane2);
        });
        //create the HBox for the name and the price for the product
        HBox hbox1 = new HBox();
        Text txtul = new Text("Tulip\t\t\t\t");
        Text txtul1 = new Text("21,5SR");
        hbox1.getChildren().addAll(txtul, txtul1);
        //------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button2 = new VBox();
        Image basket1 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas1 = new ImageView(basket1);
        bas1.setFitHeight(21);
        bas1.setFitWidth(21);
        Button bt1 = new Button("cart", bas1);
        bt1.setPrefWidth(70);
        button2.getChildren().add(bt1);
        vtul.getChildren().addAll(hbox1, button2);
        grid.add(vtul, 1, 3);
        //#################################################################
        Product p2 = new Product(txtul, 21.5, text2, tul, false);
        p2.add(p2);
        p2.setButton(bt1);

        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 3 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vlil = new VBox();
        Image lilac = new Image("file:/Users/linasmacbook/Desktop/AP-project/5.jpg");
        ImageView lil = new ImageView(lilac);//Setting the image view 
        lil.setFitHeight(170); //setting the fit height and width of the image view 
        lil.setFitWidth(150);
        vlil.getChildren().add(lil);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec2 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text3 = new Text("\nThe lilac flower is\nconsidered a symbol of\ntrue love and loyalty.");
        text3.setFill(Color.WHITE);
        text3.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane3 = createStackPane(rec2, text3);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        lil.setOnMouseEntered(e -> {
            grid.add(stackPane3, 0, 1);
        });
        rec2.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane3);
        });
        //create the HBox for the name and the price for the product
        HBox hbox2 = new HBox();
        Text txtlil = new Text("Lilac\t\t\t\t");
        Text txtlil1 = new Text("24,5SR");
        hbox2.getChildren().addAll(txtlil, txtlil1);
        //------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button3 = new VBox();
        Image basket2 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas2 = new ImageView(basket2);
        bas2.setFitHeight(21);
        bas2.setFitWidth(21);
        Button bt2 = new Button("cart", bas2);
        bt2.setPrefWidth(70);
        button3.getChildren().add(bt2);
        vlil.getChildren().addAll(hbox2, button3);
        grid.add(vlil, 0, 1);
        //#################################################################
        Product p3 = new Product(txtlil, 24.5, text3, lil, false);
        p3.add(p3);
        p3.setButton(bt2);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 4 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vlily = new VBox();
        Image lily = new Image("file:/Users/linasmacbook/Desktop/AP-project/13.jpg");
        ImageView lily1 = new ImageView(lily);//Setting the image view 
        lily1.setFitHeight(170); //setting the fit height and width of the image view 
        lily1.setFitWidth(150);
        vlily.getChildren().add(lily1);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec3 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text4 = new Text("\nlilies have come to\nrepresent purity\nand remembrance.");
        text4.setFill(Color.WHITE);
        text4.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane4 = createStackPane(rec3, text4);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        lily1.setOnMouseEntered(e -> {
            grid.add(stackPane4, 1, 0);
        });
        rec3.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane4);
        });
        //create the HBox for the name and the price for the product
        HBox hbox3 = new HBox();
        Text txtlily = new Text("Lily\t\t\t\t");
        Text txtlily1 = new Text("29,5SR");
        hbox3.getChildren().addAll(txtlily, txtlily1);
        //------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button4 = new VBox();
        Image basket3 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas3 = new ImageView(basket3);
        bas3.setFitHeight(21);
        bas3.setFitWidth(21);
        Button bt3 = new Button("cart", bas3);
        bt3.setPrefWidth(70);
        button4.getChildren().add(bt3);
        vlily.getChildren().addAll(hbox3, button4);
        grid.add(vlily, 1, 0);
        //#################################################################
        Product p4 = new Product(txtlily, 29.5, text4, lily1, false);
        p4.add(p4);
        p4.setButton(bt3);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 5 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vlav = new VBox();
        Image lavender = new Image("file:/Users/linasmacbook/Desktop/AP-project/14.jpg");
        ImageView lav = new ImageView(lavender);//Setting the image view 
        lav.setFitHeight(170); //setting the fit height and width of the image view 
        lav.setFitWidth(150);
        vlav.getChildren().add(lav);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec4 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text5 = new Text("\nLavender flowers\nrepresent purity,silence,\ndevotion and serenity,");
        text5.setFill(Color.WHITE);
        text5.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane5 = createStackPane(rec4, text5);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        lav.setOnMouseEntered(e -> {
            grid.add(stackPane5, 1, 1);
        });
        rec4.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane5);
        });
        //create the HBox for the name and the price for the product
        HBox hbox4 = new HBox();
        Text txtlav = new Text("Lavender\t\t\t");
        Text txtlav1 = new Text("30,5SR");
        hbox4.getChildren().addAll(txtlav, txtlav1);
        //------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button5 = new VBox();
        Image basket4 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas4 = new ImageView(basket4);
        bas4.setFitHeight(21);
        bas4.setFitWidth(21);
        Button bt4 = new Button("cart", bas4);
        bt4.setPrefWidth(70);
        button5.getChildren().add(bt4);
        vlav.getChildren().addAll(hbox4, button5);
        grid.add(vlav, 1, 1);
        //#################################################################
        Product p5 = new Product(txtlav, 30.5, text5, lav, false);
        p5.add(p5);
        p5.setButton(bt4);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 6 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vsun = new VBox();
        Image sunflower = new Image("file:/Users/linasmacbook/Desktop/AP-project/8.jpg");
        ImageView sun = new ImageView(sunflower);//Setting the image view 
        sun.setFitHeight(170); //setting the fit height and width of the image view 
        sun.setFitWidth(150);
        vsun.getChildren().add(sun);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec5 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text6 = new Text("\nSunflowers symbolise\nWarmth,dedication\nand love or family.");
        text6.setFill(Color.WHITE);
        text6.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane6 = createStackPane(rec5, text6);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        sun.setOnMouseEntered(e -> {
            grid.add(stackPane6, 2, 1);
        });
        rec5.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane6);
        });
        //create the HBox for the name and the price for the product
        HBox hbox5 = new HBox();
        Text txtsun = new Text("Sunflower\t\t");
        Text txtsun1 = new Text("30,5SR");
        hbox5.getChildren().addAll(txtsun, txtsun1);
        //------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button6 = new VBox();
        Image basket5 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas5 = new ImageView(basket5);
        bas5.setFitHeight(21);
        bas5.setFitWidth(21);
        Button bt5 = new Button("cart", bas5);
        bt5.setPrefWidth(70);
        button6.getChildren().add(bt5);
        vsun.getChildren().addAll(hbox5, button6);
        grid.add(vsun, 2, 1);
        //#################################################################
        Product p6 = new Product(txtsun, 30.5, text6, sun, false);
        p6.add(p6);
        p6.setButton(bt5);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 7 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vchar = new VBox();
        Image charysant = new Image("file:/Users/linasmacbook/Desktop/AP-project/9.jpg");
        ImageView chary = new ImageView(charysant);//Setting the image view 
        chary.setFitHeight(170); //setting the fit height and width of the image view 
        chary.setFitWidth(150);
        vchar.getChildren().add(chary);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec6 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text7 = new Text("\nchrysanthemums\nsymbolizetrust,joy,\noptimism and longevity.");
        text7.setFill(Color.WHITE);
        text7.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane7 = createStackPane(rec6, text7);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        chary.setOnMouseEntered(e -> {
            grid.add(stackPane7, 0, 3);
        });
        rec6.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane7);
        });
        //create the HBox for the name and the price for the product
        HBox hbox6 = new HBox();
        Text txtchary = new Text("Charysant\t\t\t");
        Text txtchary1 = new Text("34,5SR");
        hbox6.getChildren().addAll(txtchary, txtchary1);
        //---------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button7 = new VBox();
        Image basket6 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas6 = new ImageView(basket6);
        bas6.setFitHeight(21);
        bas6.setFitWidth(21);
        Button bt6 = new Button("cart", bas6);
        bt6.setPrefWidth(70);
        button7.getChildren().add(bt6);
        vchar.getChildren().addAll(hbox6, button7);
        grid.add(vchar, 0, 3);
        //#################################################################
        Product p7 = new Product(txtchary, 34.5, text7, chary, false);
        p7.add(p7);
        p7.setButton(bt6);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 8 to put each of the photo,price,description and cart button in the center of the PorderPane 
        VBox vcarn = new VBox();
        Image carnation = new Image("file:/Users/linasmacbook/Desktop/AP-project/10.jpg");
        ImageView carn = new ImageView(carnation);//Setting the image view 
        carn.setFitHeight(170); //setting the fit height and width of the image view 
        carn.setFitWidth(150);
        vcarn.getChildren().add(carn);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec7 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text8 = new Text("\nIn Ancient Rome\ncarnations symbolized\nvictory.");
        text8.setFill(Color.WHITE);
        text8.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane8 = createStackPane(rec7, text8);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        carn.setOnMouseEntered(e -> {
            grid.add(stackPane8, 2, 0);
        });
        rec7.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane8);
        });
        //create the HBox for the name and the price for the product
        HBox hbox7 = new HBox();
        Text txtcarn = new Text("carnation\t\t\t");
        Text txtcarn1 = new Text("26,5SR");
        hbox7.getChildren().addAll(txtcarn, txtcarn1);
        //---------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button8 = new VBox();
        Image basket7 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas7 = new ImageView(basket7);
        bas7.setFitHeight(21);
        bas7.setFitWidth(21);
        Button bt7 = new Button("cart", bas7);
        bt7.setPrefWidth(70);
        button8.getChildren().add(bt7);
        vcarn.getChildren().addAll(hbox7, button8);
        grid.add(vcarn, 2, 0);
        //################################################
        Product p8 = new Product(txtcarn, 26.5, text8, carn, false);
        p8.add(p8);
        p8.setButton(bt7);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 9 to put each of the photo,price,description and cart button in the center of the PorderPane
        VBox vorch = new VBox();
        Image orchid = new Image("file:/Users/linasmacbook/Desktop/AP-project/11.jpg");
        ImageView orch = new ImageView(orchid);//Setting the image view 
        orch.setFitHeight(170); //setting the fit height and width of the image view 
        orch.setFitWidth(150);
        vorch.getChildren().add(orch);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec8 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text9 = new Text("\nIn China,orchids\nsymbolized the union\nof marriage.");
        text9.setFill(Color.WHITE);
        text9.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane9 = createStackPane(rec8, text9);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        orch.setOnMouseEntered(e -> {
            grid.add(stackPane9, 2, 3);
        });
        rec8.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane9);
        });
        //create the HBox for the name and the price for the product
        HBox hbox8 = new HBox();
        Text txtorch = new Text("Orchid\t\t\t");
        Text txtorch1 = new Text("27,5SR");
        hbox8.getChildren().addAll(txtorch, txtorch1);
        //---------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button9 = new VBox();
        Image basket8 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas8 = new ImageView(basket8);
        bas8.setFitHeight(21);
        bas8.setFitWidth(21);
        Button bt8 = new Button("cart", bas8);
        bt8.setPrefWidth(70);
        button9.getChildren().add(bt8);
        vorch.getChildren().addAll(hbox8, button9);
        grid.add(vorch, 2, 3);
        //#########################################
        Product p9 = new Product(txtorch, 27.5, text9, orch, false);
        p9.add(p9);
        p9.setButton(bt8);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 10 to put each of the photo,price,description and cart button in the center of the PorderPane
        VBox vblos = new VBox();
        Image charyblossom = new Image("file:/Users/linasmacbook/Desktop/AP-project/12.jpg");
        ImageView charyblo = new ImageView(charyblossom);//Setting the image view 
        charyblo.setFitHeight(170); //setting the fit height and width of the image view 
        charyblo.setFitWidth(150);
        vblos.getChildren().add(charyblo);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec9 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text10 = new Text("\ncherry blossoms It\nsymbolizes both life\nand death,beauty\nand violence.");
        text10.setFill(Color.WHITE);
        text10.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane10 = createStackPane(rec9, text10);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        charyblo.setOnMouseEntered(e -> {
            grid.add(stackPane10, 3, 3);
        });
        rec9.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane10);
        });
        //create the HBox for the name and the price for the product
        HBox hbox9 = new HBox();
        Text txtblo = new Text("Charyblossom\t\t");
        Text txtblo1 = new Text("20,5SR");
        hbox9.getChildren().addAll(txtblo, txtblo1);
        //---------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button10 = new VBox();
        Image basket9 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas9 = new ImageView(basket9);
        bas9.setFitHeight(21);
        bas9.setFitWidth(21);
        Button bt9 = new Button("cart", bas9);
        bt9.setPrefWidth(70);
        button10.getChildren().add(bt9);
        vblos.getChildren().addAll(hbox9, button10);
        grid.add(vblos, 3, 3);
        //##################################
        Product p10 = new Product(txtblo, 20.5, text10, charyblo, false);
        p10.add(p10);
        p10.setButton(bt9);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 11 to put each of the photo,price,description and cart button in the center of the PorderPane
        VBox vmari = new VBox();
        Image marigold = new Image("file:/Users/linasmacbook/Desktop/AP-project/15.jpg");
        ImageView mari = new ImageView(marigold);//Setting the image view 
        mari.setFitHeight(170); //setting the fit height and width of the image view 
        mari.setFitWidth(150);
        vmari.getChildren().add(mari);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec10 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text11 = new Text("\nMarigolds represent\nstrength,and light\nthat lives inside\nof a person.");
        text11.setFill(Color.WHITE);
        text11.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane11 = createStackPane(rec10, text11);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        mari.setOnMouseEntered(e -> {
            grid.add(stackPane11, 3, 1);
        });
        rec10.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane11);
        });
        //create the HBox for the name and the price for the product
        HBox hbox10 = new HBox();
        Text txtmari = new Text("Marigold\t\t");
        Text txtmari1 = new Text("18,5SR");
        hbox10.getChildren().addAll(txtmari, txtmari1);
        //create the VBox for the button to add it below the picture
        VBox button11 = new VBox();
        Image basket10 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas10 = new ImageView(basket10);
        bas10.setFitHeight(21);
        bas10.setFitWidth(21);
        Button bt10 = new Button("cart", bas10);
        bt10.setPrefWidth(70);
        button11.getChildren().add(bt10);
        vmari.getChildren().addAll(hbox10, button11);
        grid.add(vmari, 3, 1);
        //#######################################
        Product p11 = new Product(txtmari, 18.5, text11, mari, false);
        p11.add(p11);
        p11.setButton(bt10);
        //------------------------------------------------------
        //------------------------------------------------------
        //create Vbox for product 12 to put each of the photo,price,description and cart button in the center of the PorderPane
        VBox vsnow = new VBox();
        Image snowdrop = new Image("file:/Users/linasmacbook/Desktop/AP-project/16.jpg");
        ImageView snow = new ImageView(snowdrop);//Setting the image view 
        snow.setFitHeight(170); //setting the fit height and width of the image view 
        snow.setFitWidth(150);
        vsnow.getChildren().add(snow);
        //create the Rectangle to put it inside the picture in transparent color to show the description of each photo
        Rectangle rec11 = new Rectangle(150, 125, Color.color(0, 0, 0, 0.5)); // Creating a transparent rectangle
        Text text12 = new Text("\nsnowdrop said to\nsymbolize hope and\nnew beginnings.");
        text12.setFill(Color.WHITE);
        text12.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        StackPane stackPane12 = createStackPane(rec11, text12);
        //setOnMouseEntered method allows to specify what action should be performed,
        //when the mouse pointer enters a specific region
        snow.setOnMouseEntered(e -> {
            grid.add(stackPane12, 3, 0);
        });
        rec11.setOnMouseExited(e -> {
            grid.getChildren().remove(stackPane12);
        });
        //create the HBox for the name and the price for the product
        HBox hbox11 = new HBox();
        Text txtsnow = new Text("Snowdrop\t\t");
        Text txtsnow1 = new Text("15,5SR");
        hbox11.getChildren().addAll(txtsnow, txtsnow1);
        //---------------------------------------------
        //create the VBox for the button to add it below the picture
        VBox button12 = new VBox();
        Image basket11 = new Image("file:/Users/linasmacbook/Desktop/AP-project/bas1.png");
        ImageView bas11 = new ImageView(basket11);
        bas11.setFitHeight(21);
        bas11.setFitWidth(21);
        Button bt11 = new Button("cart", bas11);
        bt11.setPrefWidth(70);
        button12.getChildren().add(bt11);
        vsnow.getChildren().addAll(hbox11, button12);
        grid.add(vsnow, 3, 0);

        //######################################
        Product p12 = new Product(txtsnow, 15.5, text12, snow, false);
        p12.add(p12);
        p12.setButton(bt11);

        //---------------------------------------
        //shop by type
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.setSpacing(20);
        Text text = new Text("Shop\nBy\nType");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        vbox.getChildren().add(text);

        //--------------------------------------
        //create the VBox to the ComboBox for the type to add it in the left PorderPane
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(20, 10, 10, 10));
        vbox1.setSpacing(20);
        String[] Type = {"Peonies", "Tulip", "Lilac", "Lily", "Lavender", "Sunflower", "Charysanthemum", "Carnation", "Orchid", "Cherry Blossom", "Marigold", "Snowdrop"};
        ComboBox<String> cbo = new ComboBox<>();
        cbo.setEditable(true);
        cbo.setPrefWidth(150);
        cbo.setValue("Shop By Type :");
        cbo.getItems().addAll(Type);
        cbo.setVisibleRowCount(5);//for setting the number of visible items in the list
        vbox1.getChildren().add(cbo);
        vbox.getChildren().add(vbox1);
        //action for the combo box where chosing one product
        cbo.setOnAction(e -> {
            String selectedType = cbo.getValue();
            switch (selectedType) {
                case "Peonies":
                    grid.getChildren().clear();
                    grid.getChildren().add(vpeon);
                    break;

                case "Tulip":
                    grid.getChildren().clear();
                    grid.getChildren().add(vtul);
                    break;
                case "Lilac":
                    grid.getChildren().clear();
                    grid.getChildren().add(vlil);
                    break;

                case "Lily":
                    grid.getChildren().clear();
                    grid.getChildren().add(vlily);
                    break;

                case "Lavender":
                    grid.getChildren().clear();
                    grid.getChildren().add(vlav);
                    break;

                case "Sunflower":
                    grid.getChildren().clear();
                    grid.getChildren().add(vsun);
                    break;

                case "Charysanthemum":
                    grid.getChildren().clear();
                    grid.getChildren().add(vchar);
                    break;

                case "Carnation":
                    grid.getChildren().clear();
                    grid.getChildren().add(vcarn);
                    break;

                case "Orchid":
                    grid.getChildren().clear();
                    grid.getChildren().add(vorch);
                    break;

                case "Cherry Blossom":
                    grid.getChildren().clear();
                    grid.getChildren().add(vblos);
                    break;

                case "Marigold":
                    grid.getChildren().clear();
                    grid.getChildren().add(vmari);
                    break;

                case "Snowdrop":
                    grid.getChildren().clear();
                    grid.getChildren().add(vsnow);
                    break;

                case "":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vpeon, vtul, vlil, vlily, vlav, vsun, vchar, vcarn, vorch, vblos, vmari, vsnow);

                default:
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vpeon, vtul, vlil, vlily, vlav, vsun, vchar, vcarn, vorch, vblos, vmari, vsnow);
                    break;
            }
        });
        //--------------------------------------
        //create the VBox to the ComboBox for the color to add it in the left PorderPane
        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(5, 5, 5, 1));
        vbox2.setSpacing(10);
        String[] Type1 = {"White", "Pink", "Yellow", "Purple"};
        ComboBox<String> cbo1 = new ComboBox<>();
        cbo1.setEditable(true);
        cbo1.setPrefWidth(150);
        cbo1.setValue("Shop By Color :");
        cbo1.getItems().addAll(Type1);
        cbo1.setVisibleRowCount(5);//for setting the number of visible items in the list
        vbox2.getChildren().add(cbo1);
        vbox1.getChildren().add(vbox2);
        //action for the combo box where chosing one product(color)
        cbo1.setOnAction(e -> {
            String selectedColor = cbo1.getValue();
            switch (selectedColor) {

                case "White":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vpeon, vlily, vcarn, vsnow);
                    break;

                case "Pink":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vchar, vtul, vorch, vblos);

                    break;

                case "Yellow":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vsun, vmari);
                    break;

                case "Purple":
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vlav, vlil);
                    break;
                default:
                    grid.getChildren().clear();
                    grid.getChildren().addAll(vpeon, vtul, vlil, vlily, vlav, vsun, vchar, vcarn, vorch, vblos, vmari, vsnow);
                    break;
            }
        });
        //create the HBox to add it in the bouttom of the PorderPane
        HBox buttomphrase = new HBox();
        buttomphrase.setPadding(new Insets(13, 13, 13, 13));
        buttomphrase.setAlignment(Pos.CENTER);//setting the text in the center
        buttomphrase.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        Text tx1 = new Text("“Flowers don’t tell, they show.” — Stephanie Skeem");
        tx1.setFont(Font.font("Garamond", FontWeight.BOLD, 17));
        buttomphrase.getChildren().add(tx1);

        //create the PorderPane
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: #fcf5f8;");
        bp.setTop(toplogo);
        bp.setCenter(grid);
        bp.setLeft(vbox);
        bp.setBottom(buttomphrase);
        //create the ScrollPane to be able to scrol to the same page
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(bp);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        MainPage mainPage = new MainPage();
        logo.setOnMouseClicked(e -> {
            mainPage.start(stage);
        });

        // Show the scene
        Scene scene = new Scene(scrollPane, 800, 500);
        stage.setTitle("shop by type");
        stage.setScene(scene);
        stage.show();

    }

    //StackPane is a layout container in JavaFX that stacks its children on top of each other, allowing you to overlay multiple elements within a single container.
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
