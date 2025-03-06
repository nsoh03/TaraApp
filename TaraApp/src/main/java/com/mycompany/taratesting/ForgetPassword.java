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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
public class ForgetPassword extends Application {

    @Override
    public void start(Stage stage) {
        // Grid pane for input fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        VBox center = new VBox();
        StackPane stack1 = new StackPane();
        Text prompt = new Text("Forgot Password ?");
        prompt.setFont(Font.font("Georgia", FontWeight.NORMAL, 35));
        stack1.setAlignment(Pos.CENTER); // Center the text within the StackPane
        stack1.getChildren().add(prompt);
        center.getChildren().add(stack1);

        // Email input
        Label emailLabel = new Label("Email:");
        emailLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 16));
        grid.add(emailLabel, 0, 2);

        TextField emailInput = new TextField();
        emailInput.setPromptText("Enter your email");
        grid.add(emailInput, 1, 2);

        // Login button
        Button reset = new Button("Get Password");
        reset.setPrefWidth(100);

        Button cancel = new Button("Cancel");
        cancel.setPrefWidth(100);

        App login = new App();
        cancel.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                login.start(stage);
            }
        });

        HBox hbox = new HBox(10); // Set spacing between buttons
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(reset, cancel);

        grid.add(hbox, 1, 3);

        center.setAlignment(Pos.CENTER);
        center.getChildren().add(grid);

        // event
        reset.setOnAction(e -> {

            String emailinput = emailInput.getText();
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            customer st2 = new customer();

            Boolean isFound = false;

            //retrive student list
            session = HibernateUtil.getSessionFactory().openSession();

            List<customer> cPList = null;
            String queryStr = "from customer";
            Query query = session.createQuery(queryStr);
            cPList = query.list();
            session.close();
            System.out.println("Customer list size: " + cPList.size());

            if (emailInput.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Please enter the required information");
                alert.setContentText("Please enter your email");
                alert.showAndWait();
            } else {
                for (customer c : cPList) {
                    if (c.getEmail().equals(emailinput)) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Get Your Password");
                        alert.setHeaderText("Here is your password");
                        alert.setContentText(c.getPassword());
                        alert.showAndWait();
                        emailInput.clear();
                        emailInput.setDisable(true);
                        emailLabel.setText("your password");
                        emailInput.setPromptText(c.getPassword());
                        cancel.setText("Back to login");
                        reset.setDisable(true);
                        reset.setStyle("-fx-border-color:WHITE;-fx-background-color:LINEN;");

                        isFound = true;

                        break;
                    }
                }

                if (isFound == false) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Account Not Found");
                    alert.setContentText("Please go back to the registration page");
                    alert.showAndWait();

                }
            }

        });

        //--------------------top border--------------------
        HBox top = new HBox();
        top.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");
        top.setAlignment(Pos.TOP_RIGHT);

        // Assuming the logo image path is correct
        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);
        logo.setFitHeight(50);
        logo.setFitWidth(100);
        top.getChildren().add(logo);

        //--------------------left--------------------
        VBox left = new VBox();
        left.setAlignment(Pos.CENTER_LEFT);
        // Assuming the image URL is correct
        Image im = new Image("file:/Users/linasmacbook/Desktop/AP-project/flower.jpg");
        ImageView img = new ImageView(im);
        img.setFitHeight(450);
        img.setFitWidth(260);
        left.getChildren().add(img);

        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: radial-gradient(center 50% 50% , radius 70% , #ffcaca, #ffffff);");
        bp.setTop(top);
        bp.setCenter(center);
        bp.setLeft(left);

        // Show the scene
        Scene scene = new Scene(bp, 800, 500);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                reset.fire();
            }
            reset.requestFocus();
        });
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png"));
        stage.setTitle("forget password");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
