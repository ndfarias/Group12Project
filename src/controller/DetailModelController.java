
//Taken and updated from demo for Quiz 4

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Accountmodel;

public class DetailModelController {
    

    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML 
    private Button backButton; 

    @FXML
    private Button transportButton;

    @FXML
    private Button ticketButton;

    @FXML
    private ImageView ticketImage;

    @FXML
    private ImageView transportImage;
    
    @FXML
    private Label labelName;
    
    @FXML
    void ticketView(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TicketView.fxml"));
        
        Parent detailModelView = loader.load();
        Scene ticketView = new Scene(detailModelView);
        TicketViewController detailControlled = loader.getController();
        
        detailControlled.initData();

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(ticketView);
        stage.show();
    }
    
    @FXML
    void transportView(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TransportView.fxml"));

        Parent detailModelView = loader.load();
        Scene transportView = new Scene(detailModelView);
        TransportController detailControlled = loader.getController();
        
        detailControlled.initData();

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(transportView);
        stage.show();
    }

    // this back button action serves to go back to the previous scene 
    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (previousScene != null) {
            stage.setScene(previousScene);
        }

    }

    Accountmodel selectedModel;
    Scene previousScene;

    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);

    }

    public void initData(Accountmodel model) {
        
        String name = model.getAccountname();
        String firstName = name.substring(0, name.indexOf(" "));
        
        labelName.setText("Welcome " + firstName + "!");

        try {
            String busImageName = "/resource/images/bus icon.png";
            Image bus = new Image(getClass().getResourceAsStream(busImageName));
            transportImage.setImage(bus);
            
            String ticketImageName = "/resource/images/ticket icon.png";
            Image ticket = new Image(getClass().getResourceAsStream(ticketImageName));
            ticketImage.setImage(ticket);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert transportButton!= null : "fx:id=\"transportButton\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert ticketButton != null : "fx:id=\"ticketButton\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert ticketImage != null : "fx:id=\"ticketImage\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert transportImage != null : "fx:id=\"transportImage\" was not injected: check your FXML file 'DashboardView.fxml'.";
        assert labelName != null : "fx:id=\"labelName\" was not injected: check your FXML file 'DashboardView.fxml'.";
        
        backButton.setDisable(true);
    }
}