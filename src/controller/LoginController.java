/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
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
import model.Accountmodel;
import java.util.List;
import javax.persistence.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 *
 * @author Nicol Farias
 */
public class LoginController implements Initializable {

    // Database manager
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loading data from database
        manager = (EntityManager) Persistence.createEntityManagerFactory("NicolFariasFXMLPU").createEntityManager();
      
    }

    //the following code is from scene builder skeleton
    
    //variables
    @FXML
    private Button buttonCreateAccount;

    @FXML
    private Button buttonReadAccounts;

    @FXML
    private Button buttonUpdateAccount;

    @FXML
    private Button buttonDeleteAccount;

    @FXML
    private Button buttonReadEmail;

    @FXML
    private Button buttonNameAndEmail;

    @FXML
    private TableView<Accountmodel> accountModel;

    @FXML
    private TableColumn<Accountmodel, Integer> accountid;

    @FXML
    private TableColumn<Accountmodel, String> accountname;

    @FXML
    private TableColumn<Accountmodel, String> accountemail;

    @FXML
    private TableColumn<Accountmodel, Boolean> ismember;
    
    @FXML
    private TableColumn<Accountmodel, String> accountpassword;

    @FXML
    private TextField emailField;
    
    @FXML 
    private TextField passwordField;

    @FXML
    private Button searchButton;
    
    @FXML
    private Button advancedButton;
    
    @FXML
    private Button showDetailsButton;
    
    @FXML
    private Button showDetailsInPlaceButton;
    
    @FXML
    private Button signUpButton;

    private ObservableList<Accountmodel> accountData;

    //this method finds an account based on both name and email
    public List<Accountmodel> readByEmailPassword(String e, String p) {
        Query q = manager.createNamedQuery("Accountmodel.findByEmailAndPassword");

        q.setParameter("accountemail", e);
        q.setParameter("accountpassword", p);

        List<Accountmodel> accounts = q.getResultList();
        
        return accounts;
    }
    
    //action for advanced search button. searches for account based on email and password
    @FXML
    void advancedAccount(ActionEvent event) throws IOException {
       
        String email = emailField.getText();
        String password = passwordField.getText();

        List<Accountmodel> accounts = readByEmailPassword(email, password);

        //alert pops up if search comes up blank
        if (accounts == null || accounts.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong Username or Password");
            alert.setContentText("Account Not Found");
            alert.showAndWait();
        } else {
            Accountmodel selectAccount = accounts.get(0);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardView.fxml"));

            Parent detailModelView = loader.load();
            Scene tableView = new Scene(detailModelView);
            DashboardController detailControlled = loader.getController();

            detailControlled.initData(selectAccount);

            Scene currentScene = ((Node) event.getSource()).getScene();
            detailControlled.setPreviousScene(currentScene);
        
            Stage stage = (Stage) currentScene.getWindow();

            stage.setScene(tableView);
            stage.show();
        }

    }
    
    @FXML
    void signUpScreen(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUpView.fxml"));

        Parent detailModelView = loader.load();
        Scene signUpView = new Scene(detailModelView);
        SignUpController detailControlled = loader.getController();


        Scene currentScene = ((Node) event.getSource()).getScene();
        detailControlled.setPreviousScene(currentScene);
        
        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(signUpView);
        stage.show();
        
    }

    //data to table
    public void setTableData(List<Accountmodel> accountList) {
        accountData = FXCollections.observableArrayList();

        accountList.forEach(a -> { accountData.add(a);});
        
        accountModel.setItems(accountData);
        accountModel.refresh();
    }

}
