package com.mycompany.taratesting;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //create the HBox for the top BorderPane
        HBox toplogo1 = new HBox();
        toplogo1.setStyle("-fx-border-color: #434343; -fx-background-color: #fdf2d7");//الخلفيه بيج فاتح 
        toplogo1.setAlignment(Pos.TOP_RIGHT);
        //create the logoImage for the top porderpane
        Image logoImage = new Image("file:/Users/linasmacbook/Desktop/AP-project/logo.png");
        ImageView logo = new ImageView(logoImage);//Setting the image view 
        logo.setFitHeight(50); //setting the fit height and width of the image view 
        logo.setFitWidth(100);
        toplogo1.getChildren().add(logo);

        //Create the grid pane for input fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        HBox log = new HBox();
        log.setAlignment(Pos.CENTER_LEFT);
        Rectangle r = new Rectangle(100, 50);
        r.setFill(Color.PINK);
        Text text1 = new Text("Login");
        text1.setFont(Font.font("Georgia", FontWeight.MEDIUM, 23));
        StackPane stackPane1 = createStackPane(r, text1);
        log.getChildren().add(stackPane1);
        grid.add(log, 0, 0);

        //Create the lable for the eamil 
        Label userLabel = new Label("User name : ");
        userLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        grid.add(userLabel, 0, 1);

        TextField userInput = new TextField();
        userInput.setPromptText("Enter your user name");
        grid.add(userInput, 1, 1);

        //Create the lable for the password 
        Label passwordLabel = new Label("Password : ");
        passwordLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        grid.add(passwordInput, 1, 2);

        //Create the Login button
        Button lb = new Button("Login");
        lb.setStyle("-fx-base: SEASHELL; -fx-text-fill:BLACK;");
        lb.setPrefWidth(100);

        MainPage Abs = new MainPage();
        //Add event for the Login button
        lb.setOnAction(e -> {

            String PassworInput = passwordInput.getText();
            String userinput = userInput.getText();
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            //retrive student list
            session = HibernateUtil.getSessionFactory().openSession();

            List<customer> cList = null;
            String queryStr = "from customer";
            Query query = session.createQuery(queryStr);
            cList = query.list();
            session.close();
            System.out.println("Customer list size: " + cList.size());

            if (userInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Please enter the required information");
                alert.setContentText("Please enter your user name and password");
                alert.showAndWait();
            } else {

                boolean isFound = false;
                for (customer s : cList) {
                    if (s.getUsername().equals(userinput) && s.getPassword().equals(PassworInput)) {
                        isFound = true;

                        CheckoutService.setCustomerID(s.getCostumerId());

                        Abs.start(stage);

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
        }
        );

        //Create the forget password button
        Button lb2 = new Button("Forget password ?");
        lb2.setStyle("-fx-base: SEASHELL; -fx-text-fill:BLACK;");
        lb2.setPrefWidth(130);

        ForgetPassword forgetPassword = new ForgetPassword();
        lb2.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                forgetPassword.start(stage);
            }
        });

        //Create the hbox to add login and password button
        grid.add(lb, 1, 4);
        grid.add(lb2, 0, 4);

        //----------------------------------------------------------
        //Create the vbox to put the picture in the left PorderPane
        VBox leftpic = new VBox();
        leftpic.setAlignment(Pos.CENTER_LEFT);
        Image im = new Image("file:/Users/linasmacbook/Desktop/AP-project/flower.jpg");
        ImageView img = new ImageView(im);//Setting the image view 
        img.setFitHeight(450); //setting the fit height and width of the image view 
        img.setFitWidth(260);
        leftpic.getChildren().add(img);

        //create the PorderPane
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-border-color: DARKGREY;-fx-background-color: #fcf5f8;");
        bp.setTop(toplogo1);
        bp.setCenter(grid);
        bp.setLeft(leftpic);

        //Create the lable to go to the create accoont 
        Label create = new Label("\tDon't have an account?");
        create.setFont(Font.font("Georgia", FontWeight.NORMAL, 11));

        //Create the create account button
        Label lb3 = new Label("Create Account");
        lb3.setFont(Font.font("Georgia", FontWeight.NORMAL, 11));
        lb3.setStyle("-fx-text-fill:#6F4E37;");
        lb3.setUnderline(true);

        grid.add(create, 0, 5);
        grid.add(lb3, 1, 5);

        SignUp signUp = new SignUp();
        lb3.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                signUp.start(stage);
            }
        });
        // Show the scene
        Scene scene = new Scene(bp, 800, 500);
        stage.setTitle("log in");
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
