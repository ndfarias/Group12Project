package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Accountmodel;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpController implements Initializable {
    
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loading data from database
        manager = (EntityManager) Persistence.createEntityManagerFactory("NicolFariasFXMLPU").createEntityManager();
        
        /*accountid.setCellValueFactory(new PropertyValueFactory<>("accountid"));
        accountname.setCellValueFactory(new PropertyValueFactory<>("accountname"));
        accountemail.setCellValueFactory(new PropertyValueFactory<>("accountemail"));
        ismember.setCellValueFactory(new PropertyValueFactory<>("ismember"));
        accountpassword.setCellValueFactory(new PropertyValueFactory<>("accountpassword"));

        accountModel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);*/
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField memberField;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Button createButton;
    
    @FXML
    private Button backButton;
    
    private Boolean isMember;

    @FXML
    void createAccount(ActionEvent event) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        
        //random accountid  
        int accountId = (int)(Math.random() * 89999) + 10000;

        String accountName = firstName + " " + lastName;
        
        String accountEmail = emailField.getText();
        
        String accountPassword = passwordField.getText();

        // create account instance
        Accountmodel account = new Accountmodel();

        account.setAccountid(accountId);
        account.setAccountname(accountName);
        account.setAccountemail(accountEmail);
        account.setIsmember(isMember);
        account.setAccountpassword(accountPassword);

        // save this account to the database        
        create(account);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }

    @FXML
    void memberAction(ActionEvent event) {
        isMember = true;
        
    }
    
    @FXML
    void noMemberAction(ActionEvent event) {
        isMember = false;
    }
    
    //method to create an account 
    public void create(Accountmodel account) {
        try {
            manager.getTransaction().begin();

            if (account.getAccountid() != null) {

                // create account
                manager.persist(account);

                manager.getTransaction().commit();

                System.out.println(account.toString() + " is created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
        assert firstNameField != null : "fx:id=\"firstNameField\" was not injected: check your FXML file 'SignUpView'.";
        assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'SignUpView'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'SignUpView'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'SignUpView'.";
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'SignUpView'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'SignUpView'.";
        assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'SignUpView'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'SignUpView'.";
        
        backButton.setDisable(true);
    }
}
