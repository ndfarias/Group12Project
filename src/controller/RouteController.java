package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RouteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView busRoute;

    @FXML
    private ImageView trainRoute;
    
    @FXML
    private ImageView searchIcon;

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
    
    public void initData() {

        try {
            String busImageName = "/resource/images/busRoute.png";
            Image bus = new Image(getClass().getResourceAsStream(busImageName));
            busRoute.setImage(bus);
            
            String routeImageName = "/resource/images/trainRoute.png";
            Image route = new Image(getClass().getResourceAsStream(routeImageName));
            trainRoute.setImage(route);
            
            String searchImageName = "/resource/images/searchicon.png";
            Image search = new Image(getClass().getResourceAsStream(searchImageName));
            searchIcon.setImage(search);
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert busRoute != null : "fx:id=\"busRoute\" was not injected: check your FXML file 'RouteView.fxml'.";
        assert trainRoute != null : "fx:id=\"trainRoute\" was not injected: check your FXML file 'RouteView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RouteView.fxml'.";
        
        backButton.setDisable(true);

    }
}
