/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taratesting;

/**
 *
 * @author linasmacbook
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author linasmacbook
 */
public class alert {

    //for secuses massge
    public static void display(String title, String massege) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label lbl = new Label();
        lbl.setText(massege);
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().add(lbl);
        box.setStyle("-fx-background-color: #FFFAFA;");
        Scene scene = new Scene(box, 300, 150);

        window.setScene(scene);
        window.showAndWait();

    }

    //for error massege
    public static void showInvalidInputAlert(String title, String header, String massege) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(massege);
        alert.showAndWait();
    }

}
