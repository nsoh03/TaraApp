/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author norahm.s
 */
public class SignUp extends Application {

    Session session;

    @Override
    public void start(Stage stage) {
        // Grid pane for input fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

///---------- the form info----------
        VBox center = new VBox();

        StackPane stack1 = new StackPane();
        Text tx = new Text("Create Account ");
        tx.setFont(Font.font("Georgia", FontWeight.NORMAL, 25));
        stack1.setAlignment(Pos.CENTER); // Center the text within the StackPane
        stack1.getChildren().add(tx);
        center.getChildren().add(stack1);

        // Email input
        Label emailLabel = new Label("Email : ");
        emailLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        grid.add(emailLabel, 0, 2);

        TextField emailInput = new TextField();
        emailInput.setPromptText("Enter your email");
        grid.add(emailInput, 1, 2);

        // Password input
        Label passwordLabel = new Label("Password : ");
        passwordLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        grid.add(passwordLabel, 0, 3);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        grid.add(passwordInput, 1, 3);

        //UserName first
        Label UserName = new Label("Username : ");
        UserName.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        grid.add(UserName, 0, 0);

        TextField UserInput = new TextField();
        UserInput.setPromptText("Enter your username");
        grid.add(UserInput, 1, 0);

        //PhoneNumber
        Label PhoneNumber = new Label("Phone Number : ");
        PhoneNumber.setFont(Font.font("Georgia", FontWeight.BOLD, 12));

        TextField PhoneInput = new TextField();
        PhoneInput.setPromptText("Enter your Phone Number");

        //--- a listener to only add digits & a pop massage----
        PhoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                PhoneInput.setText(newValue.replaceAll("[^\\d]", ""));

                // Display a popup message when a letter is inserted
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please enter only digits in the phone number.");

                alert.showAndWait();
                // Revert the text value to the previous valid value
                PhoneInput.setText(oldValue);
            }
        });

        grid.add(PhoneNumber, 0, 1);
        grid.add(PhoneInput, 1, 1);

        ///-----form buttons --------
        // creating button
        Button lb1 = new Button("Create account");
        lb1.setPrefWidth(130);

        App Login = new App();
        lb1.setOnAction(e -> {
            lb1.setStyle("-fx-border-color:WHITE;-fx-background-color:LINEN;");

            if (emailInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Please enter the required information");
                alert.setContentText("Please enter your email and password");
                alert.showAndWait();
            } else {
                // Restriction on the email format 
                String emailformat = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(emailformat);
                Matcher match = pattern.matcher(emailInput.getText());

                if (!match.matches()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Email");
                    alert.setHeaderText("Please enter a valid email address");
                    alert.setContentText("The email address must contain a '@' symbol");
                    alert.showAndWait();
                } else {
                    // Restriction on the password format 
                    String passformat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
                    Pattern passwordPattern = Pattern.compile(passformat);
                    Matcher passwordMatcher = passwordPattern.matcher(passwordInput.getText());

                    if (!passwordMatcher.matches()) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Invalid Password");
                        alert.setHeaderText("Please enter a valid password");
                        alert.setContentText("The password must contain at least 8 characters, including a number, a lowercase letter"
                                + ", an uppercase letter, and a special character");
                        alert.showAndWait();

                    } else {
                        // Inserting customer information
                        customer costumerinfo = new customer(UserInput.getText(), passwordInput.getText(),
                                emailInput.getText(), PhoneInput.getText());
                        session = HibernateUtil.getSessionFactory().openSession();
                        Transaction tx0 = session.beginTransaction();
                        int sId2 = (Integer) session.save(costumerinfo);
                        tx0.commit();
                        session.close();

                        Login.start(stage);
                    }
                }
            }

        });

        // back page button
        Button lb2 = new Button("< Back to login ");
        lb2.setPrefWidth(100);
        App logIn = new App();
        lb2.setOnAction(e -> {
            logIn.start(stage);

        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(lb1, lb2);
        grid.add(hbox, 1, 4);
        grid.add(lb2, 0, 4);
        grid.add(lb1, 1, 4);

        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(grid, hbox);

        //-------------------layouts--------------------------
        //top border
        HBox top = new HBox();
        top.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        top.setAlignment(Pos.TOP_RIGHT);

        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(50); //setting the fit height and width of the image view 
        logo.setFitWidth(100);
        top.getChildren().add(logo);

        //left
        VBox left = new VBox();
        left.setAlignment(Pos.CENTER_LEFT);
        Image im
                = new Image("file:/Users/linasmacbook/Desktop/AP-project/flower.jpg");
        ImageView img = new ImageView(im);//Setting the image view 
        img.setFitHeight(450); //setting the fit height and width of the image view 
        img.setFitWidth(260);
        left.getChildren().add(img);

        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: #fcf5f8;");
        bp.setTop(top);
        bp.setCenter(center);
        bp.setLeft(left);

        Scene scene = new Scene(bp, 800, 500);
        stage.setScene(scene);
        stage.setTitle("sign up");

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {

                if (emailInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing Information");
                    alert.setHeaderText("Please enter the required information");
                    alert.setContentText("Please enter your email and password");
                    alert.showAndWait();
                } else {
                    // Restriction on the email format 
                    String emailformat = "^(.+)@(.+)$";
                    Pattern pattern = Pattern.compile(emailformat);
                    Matcher match = pattern.matcher(emailInput.getText());

                    if (!match.matches()) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Invalid Email");
                        alert.setHeaderText("Please enter a valid email address");
                        alert.setContentText("The email address must contain a '@' symbol");
                        alert.showAndWait();
                    } else {
                        // Restriction on the password format 
                        String passformat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
                        Pattern passwordPattern = Pattern.compile(passformat);
                        Matcher passwordMatcher = passwordPattern.matcher(passwordInput.getText());

                        if (!passwordMatcher.matches()) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Invalid Password");
                            alert.setHeaderText("Please enter a valid password");
                            alert.setContentText("The password must contain at least 8 characters, including a number, a lowercase letter"
                                    + ", an uppercase letter, and a special character");
                            alert.showAndWait();

                        } else {
                            // Inserting customer information
                            customer costumerinfo = new customer(UserInput.getText(), passwordInput.getText(),
                                    emailInput.getText(), PhoneInput.getText());
                            session = HibernateUtil.getSessionFactory().openSession();
                            Transaction tx0 = session.beginTransaction();
                            int sId2 = (Integer) session.save(costumerinfo);
                            tx0.commit();
                            session.close();
                        }
                    }
                }

            }
        });

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
