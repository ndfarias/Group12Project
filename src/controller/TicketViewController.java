/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.TicketModel;

/**
 *
 * @author Malcolm Gemmell
 */
public class TicketViewController implements Initializable {
    
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loading data from database
        manager = (EntityManager) Persistence.createEntityManagerFactory("NicolFariasFXMLPU").createEntityManager();
        
        ticketID.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
        ticketName.setCellValueFactory(new PropertyValueFactory<>("ticketName"));
        

       // ticketModel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
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
    private TableView<TicketModel> ticketModel;

    @FXML
    private TableColumn<TicketModel, Integer> ticketID;

    @FXML
    private TableColumn<TicketModel, String> ticketName;

    @FXML
    private TableColumn<TicketModel, Integer> referenceCode;
    
    @FXML
    private TableColumn<TicketModel, Double> ticketPrice;
    
    public List<TicketModel> readAll() {
        Query query = manager.createNamedQuery("TicketModel.findAll");
        List<TicketModel> tickets = query.getResultList();

        return tickets;
    }

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
    
    public void initData() {
        
        List<TicketModel> tickets = readAll();
        setTableData(tickets);
    }

}
    
