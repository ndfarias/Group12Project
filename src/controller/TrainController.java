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
import model.Trainmodel;
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
public class TrainController implements Initializable {

    
    // Database manager
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loading data from database
        manager = (EntityManager) Persistence.createEntityManagerFactory("NicolFariasFXMLPU").createEntityManager();
        
        trainid.setCellValueFactory(new PropertyValueFactory<>("trainid"));
        departuredate.setCellFactory(c -> {
                TableCell<Trainmodel, Date> d = new TableCell<Trainmodel, Date>() {
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
        trainservice.setCellValueFactory(new PropertyValueFactory<>("trainservice"));
        trainorigin.setCellValueFactory(new PropertyValueFactory<>("trainorigin"));
        traindestination.setCellValueFactory(new PropertyValueFactory<>("traindestination"));
        
        departuretime.setCellFactory(c -> {
                TableCell<Trainmodel, Date> t = new TableCell<Trainmodel, Date>() {
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
                TableCell<Trainmodel, Date> d = new TableCell<Trainmodel, Date>() {
                private SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm aa");
                
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
        departuretime.setCellValueFactory(new PropertyValueFactory<>("departuretime"));
        arrivaltime.setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));

        trainTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
    private Button trainsButton;

    @FXML
    private Button selectButton;

    @FXML
    private TableView<Trainmodel> trainTable;

    @FXML
    private TableColumn<Trainmodel, Integer> trainid;

    @FXML
    private TableColumn<Trainmodel, Date> departuredate;

    @FXML
    private TableColumn<Trainmodel, String> trainservice;

    @FXML
    private TableColumn<Trainmodel, String> trainorigin;
    
    @FXML
    private TableColumn<Trainmodel, String> traindestination;
    
    @FXML
    private TableColumn<Trainmodel, Date> departuretime;
    
    @FXML
    private TableColumn <Trainmodel, Date> arrivaltime;

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


    private ObservableList<Trainmodel> trainData;
    

    //this method finds a train based on date, origin, and destination
    public List<Trainmodel> readDateOriginDestination(Date d, String o, String e) {
        Query q = manager.createNamedQuery("Trainmodel.findByDateOriginDestination");
        
        q.setParameter("departuredate", d);
        q.setParameter("trainorigin", o);
        q.setParameter("traindestination", e);
        

        List<Trainmodel> trains = q.getResultList();

        return trains;
    }

    //this method finds a train based on ID
    public List<Trainmodel> readByID(int i) {
        Query q = manager.createNamedQuery("Trainmodel.findByTrainid");

        q.setParameter("trainid", i);

        List<Trainmodel> trains = q.getResultList();
        
        return trains;
    }

    //action for search button. searches for train based on ID
    @FXML
    void searchByID(ActionEvent event) {
        System.out.println("Clicked");

        int trainID = Integer.parseInt(idField.getText());

        List<Trainmodel> trains = readByID(trainID);

        //alert pops up if search comes up blank
        if (trains == null || trains.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Error");
            alert.setContentText("No train Found.");
            alert.showAndWait();
        } else {
            setTableData(trains);
        }
    }
    
    //action for advanced search button. searches for train based on departure date, origin and destination
    @FXML
    void searchTrains(ActionEvent event) throws IOException, Exception {
        System.out.println("Clicked");
        
        String dateString = dateField.getText();
       
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
        String origin = originField.getText();
        String destination = destinationField.getText();

        List<Trainmodel> trains = readDateOriginDestination(date, origin, destination);

        //alert pops up if search comes up blank
        if (trains == null || trains.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong Username or Password");
            alert.setContentText("No train Found.");
            alert.showAndWait();
        } else {
            setTableData(trains);
        }

    }
    

    // show details in place button action
    @FXML
    void selectTrainDetails(ActionEvent event) throws IOException {
        System.out.println("Clicked");

    
        Trainmodel selectTrain = trainTable.getSelectionModel().getSelectedItem();

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
    public void setTableData(List<Trainmodel> trainList) {
        trainData = FXCollections.observableArrayList();

        trainList.forEach(a -> { trainData.add(a);});
        
        trainTable.setItems(trainData);
        trainTable.refresh();
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
        assert dateField != null : "fx:id=\"dateField\" was not injected: check your FXML file 'trainView.fxml'.";
        assert originField != null : "fx:id=\"originField\" was not injected: check your FXML file 'trainView.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file 'trainView.fxml'.";
        assert destinationField != null : "fx:id=\"destinationField\" was not injected: check your FXML file 'trainView.fxml'.";
        assert idButton != null : "fx:id=\"idButton\" was not injected: check your FXML file 'trainView.fxml'.";
        assert trainsButton != null : "fx:id=\"trainsButton\" was not injected: check your FXML file 'trainView.fxml'.";
        assert trainTable != null : "fx:id=\"trainTable\" was not injected: check your FXML file 'trainView.fxml'.";
        assert trainid != null : "fx:id=\"trainid\" was not injected: check your FXML file 'trainView.fxml'.";
        assert departuredate != null : "fx:id=\"departuredate\" was not injected: check your FXML file 'trainView.fxml'.";
        assert trainservice != null : "fx:id=\"trainservice\" was not injected: check your FXML file 'trainView.fxml'.";
        assert trainorigin != null : "fx:id=\"trainorigin\" was not injected: check your FXML file 'trainView.fxml'.";
        assert traindestination != null : "fx:id=\"traindestination\" was not injected: check your FXML file 'trainView.fxml'.";
        assert departuretime != null : "fx:id=\"departuretime\" was not injected: check your FXML file 'trainView.fxml'.";
        assert arrivaltime != null : "fx:id=\"arrivaltime\" was not injected: check your FXML file 'trainView.fxml'.";
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file 'trainView.fxml'.";
        assert clickButton != null : "fx:id=\"clickButton\" was not injected: check your FXML file 'trainView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'trainView.fxml'.";
        
        backButton.setDisable(true);
    }
}
