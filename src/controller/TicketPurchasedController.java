/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Malcolm Gemmell
 */



public class TicketPurchasedController {

    @FXML
    private Label ticketLabel;

    @FXML
    private Button backButton;

    @FXML
    void backButton(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (previousScene != null) {
            stage.setScene(previousScene);
        }
        
    }
    Scene previousScene;
    
       public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);

    }


}

   
