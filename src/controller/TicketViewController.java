/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.TicketModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Malcolm Gemmell
 */
public class TicketViewController {

    @FXML
    private TableView<TicketModel> TicketModel;

    @FXML
    private Label ticketLabel;

    @FXML
    private Button purchaseButton;

    @FXML
    private Button backButton;
    
    private ObservableList<TicketModel> ticketData;
    
     @FXML
    private TableView<TicketModel> accountModel;

    @FXML
    private TableColumn<TicketModel, Integer> ticketId;

    @FXML
    private TableColumn<TicketModel, String> ticketName;

    @FXML
    private TableColumn<TicketModel, Integer> referenceCode;
    
    @FXML
    private TableColumn<TicketModel, Double> ticketPrice;

    @FXML
    void backButton(ActionEvent event) {
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (previousScene != null) {
            stage.setScene(previousScene);
        }

    }
    Scene previousScene;

    @FXML
    void purchaseButton(ActionEvent event) throws IOException {
        System.out.println("Clicked");
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TicketPurchasedView.fxml"));

        Parent TicketView = loader.load();
        Scene TicketPurchasedView = new Scene(TicketView);
        TicketPurchasedController detailControlled = loader.getController();


        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(TicketPurchasedView);
        stage.show();
        }
    
    public void setPreviousScene(Scene scene) {
    previousScene = scene;
    backButton.setDisable(false);

    }
    
        //data to table
    public void setTableData(List<TicketModel> ticketList) {
        ticketData = FXCollections.observableArrayList();

        ticketList.forEach(a -> { ticketData.add(a);});
        
        TicketModel.setItems(ticketData);
        TicketModel.refresh();
    }

}
    
