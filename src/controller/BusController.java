/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Busmodel;
import java.util.List;
import java.util.Date;
import javax.persistence.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableCell;

/**
 *
 * @author Nicol Farias
 */
public class BusController implements Initializable {

    
    // Database manager
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loading data from database
        manager = (EntityManager) Persistence.createEntityManagerFactory("NicolFariasFXMLPU").createEntityManager();
        
        busid.setCellValueFactory(new PropertyValueFactory<>("busid"));
        departuredate.setCellFactory(c -> {
                TableCell<Busmodel, Date> d = new TableCell<Busmodel, Date>() {
                private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                @Override
                protected void updateItem(Date departure, boolean none) {
                    super.updateItem(departure, none);
                    if(none) {
                    setText(null);
                    }
                    else {
                    setText(dateFormat.format(departure));
                    }
                }
                };
            return d;
        });
        departuredate.setCellValueFactory(new PropertyValueFactory<>("departuredate"));
        busservice.setCellValueFactory(new PropertyValueFactory<>("busservice"));
        busorigin.setCellValueFactory(new PropertyValueFactory<>("busorigin"));
        busdestination.setCellValueFactory(new PropertyValueFactory<>("busdestination"));
        
        departuretime.setCellFactory(c -> {
                TableCell<Busmodel, Date> t = new TableCell<Busmodel, Date>() {
                private SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm aa");

                @Override
                protected void updateItem(Date departure, boolean none) {
                    super.updateItem(departure, none);
                    if(none) {
                    setText(null);
                    }
                    else {
                    setText(timeFormat.format(departure));
                    }
                }
                };
            return t;
        });
        arrivaltime.setCellFactory(c -> {
                TableCell<Busmodel, Date> d = new TableCell<Busmodel, Date>() {
                private SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm aa");
                
                @Override
                protected void updateItem(Date arrival, boolean none) {
                    super.updateItem(arrival, none);
                    if(none) {
                        setText(null);
                    }
                    else {
                    setText(dateFormat.format(arrival));
                    }
                }
                };
            return d;
        });
        departuretime.setCellValueFactory(new PropertyValueFactory<>("departuretime"));
        arrivaltime.setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));

        busTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    //the following code is from scene builder skeleton
    
    //variables
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button idButton;

    @FXML
    private Button busesButton;

    @FXML
    private Button selectButton;

    @FXML
    private TableView<Busmodel> busTable;

    @FXML
    private TableColumn<Busmodel, Integer> busid;

    @FXML
    private TableColumn<Busmodel, Date> departuredate;

    @FXML
    private TableColumn<Busmodel, String> busservice;

    @FXML
    private TableColumn<Busmodel, String> busorigin;
    
    @FXML
    private TableColumn<Busmodel, String> busdestination;
    
    @FXML
    private TableColumn<Busmodel, Date> departuretime;
    
    @FXML
    private TableColumn <Busmodel, Date> arrivaltime;

    @FXML
    private TextField idField;
    
    @FXML 
    private TextField dateField;
    
    @FXML 
    private TextField originField;
    
    @FXML
    private TextField destinationField;
    
    @FXML
    private Button clickButton;
    
    @FXML 
    private Button backButton;


    private ObservableList<Busmodel> busData;
    
    
    //this method finds a bus based on date, origin and destination
    public List<Busmodel> readDateOriginDestination(Date d, String o, String e) {
        Query q = manager.createNamedQuery("Busmodel.findByDateOriginDestination");
        
        q.setParameter("departuredate", d);
        q.setParameter("busorigin", o);
        q.setParameter("busdestination", e);

        List<Busmodel> buses = q.getResultList();

        return buses;
    }

    //this method finds a bus based on ID
    public List<Busmodel> readByID(int i) {
        Query q = manager.createNamedQuery("Busmodel.findByBusid");

        q.setParameter("busid", i);

        List<Busmodel> buses = q.getResultList();
        
        return buses;
    }

    //action for search button. searches for a bus based on id
    @FXML
    void searchByID(ActionEvent event) {

        int busID = Integer.parseInt(idField.getText());

        List<Busmodel> buses = readByID(busID);

        //alert pops up if search comes up blank
        if (buses == null || buses.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Error");
            alert.setContentText("No Bus Found.");
            alert.showAndWait();
        } else {
            setTableData(buses);
        }
    }
    
    //action for advanced search button. searches for a bus based on departure date, origin and destination
    @FXML
    void searchBuses(ActionEvent event) throws IOException, Exception {
        
        String dateString = dateField.getText();
       
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
        String origin = originField.getText();
        String destination = destinationField.getText();

        List<Busmodel> buses = readDateOriginDestination(date, origin, destination);

        //alert pops up if search comes up blank
        if (buses == null || buses.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Error");
            alert.setContentText("No Bus Found.");
            alert.showAndWait();
        } else {
            setTableData(buses);
        }

    }

    // show details in place button action
    @FXML
    void selectBusDetails(ActionEvent event) throws IOException {
    
        Busmodel selectBus = busTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TicketView.fxml"));

        Parent dashboardView = loader.load();
        Scene tableView = new Scene(dashboardView);
        TicketViewController detailControlled = loader.getController();

        detailControlled.initData();

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

       stage.setScene(tableView);
       stage.show();
    }

    //data to table
    public void setTableData(List<Busmodel> busList) {
        busData = FXCollections.observableArrayList();

        busList.forEach(a -> { busData.add(a);});
        
        busTable.setItems(busData);
        busTable.refresh();
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
    
    @FXML
    void initialize() {
        assert dateField != null : "fx:id=\"dateField\" was not injected: check your FXML file 'BusView.fxml'.";
        assert originField != null : "fx:id=\"originField\" was not injected: check your FXML file 'BusView.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file 'BusView.fxml'.";
        assert destinationField != null : "fx:id=\"destinationField\" was not injected: check your FXML file 'BusView.fxml'.";
        assert idButton != null : "fx:id=\"idButton\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busesButton != null : "fx:id=\"busesButton\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busTable != null : "fx:id=\"busTable\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busid != null : "fx:id=\"busid\" was not injected: check your FXML file 'BusView.fxml'.";
        assert departuredate != null : "fx:id=\"departuredate\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busservice != null : "fx:id=\"busservice\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busorigin != null : "fx:id=\"busorigin\" was not injected: check your FXML file 'BusView.fxml'.";
        assert busdestination != null : "fx:id=\"busdestination\" was not injected: check your FXML file 'BusView.fxml'.";
        assert departuretime != null : "fx:id=\"departuretime\" was not injected: check your FXML file 'BusView.fxml'.";
        assert arrivaltime != null : "fx:id=\"arrivaltime\" was not injected: check your FXML file 'BusView.fxml'.";
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file 'BusView.fxml'.";
        assert clickButton != null : "fx:id=\"clickButton\" was not injected: check your FXML file 'BusView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'BusView.fxml'.";
        
        backButton.setDisable(true);
    }
}
