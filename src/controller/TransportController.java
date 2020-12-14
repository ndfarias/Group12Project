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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Accountmodel;

public class TransportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button busButton;

    @FXML
    private Button trainButton;

    @FXML
    private ImageView trainImage;

    @FXML
    private ImageView busImage;

    @FXML
    private Button routesButton;

    @FXML
    private ImageView routeImage;
    
    @FXML
    void busView(ActionEvent event) throws IOException {
        System.out.println("Clicked.");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/BusView.fxml"));

        Parent detailModelView = loader.load();
        Scene busView = new Scene(detailModelView);
        BusController detailControlled = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(busView);
        stage.show();
    }
    
    @FXML
    void trainView(ActionEvent event) throws IOException {
        System.out.println("Clicked.");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TrainView.fxml"));

        Parent detailModelView = loader.load();
        Scene trainView = new Scene(detailModelView);
        TrainController detailControlled = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(trainView);
        stage.show();
    }

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
            String busImageName = "/resource/images/bus.png";
            Image bus = new Image(getClass().getResourceAsStream(busImageName));
            busImage.setImage(bus);
            
            String routeImageName = "/resource/images/map.png";
            Image route = new Image(getClass().getResourceAsStream(routeImageName));
            routeImage.setImage(route);
            
            String trainImageName = "/resource/images/train.png";
            Image train = new Image(getClass().getResourceAsStream(trainImageName));
            trainImage.setImage(train);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert busButton != null : "fx:id=\"busButton\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert trainButton != null : "fx:id=\"trainButton\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert trainImage != null : "fx:id=\"trainImage\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert busImage != null : "fx:id=\"busImage\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert routesButton != null : "fx:id=\"routesButton\" was not injected: check your FXML file 'TransportView.fxml'.";
        assert routeImage != null : "fx:id=\"routeImage\" was not injected: check your FXML file 'TransportView.fxml'.";
        
        backButton.setDisable(true);
    }
}
