/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import APIs.cuisines;

/**
 * FXML Controller class
 *
 * @author Brody
 */
public class FoodInfoController implements Initializable {

    @FXML
    private ChoiceBox<String> cuisineChoiceBox;
    @FXML
    private Button randomButton;
    @FXML
    private Button recipesButton;
    @FXML
    private Button backButton;

    public FoodInfoController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    @FXML
    private void randomButton(ActionEvent event) throws IOException {
        Parent infoParent1 = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene1 = new Scene(infoParent1);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(infoScene1);
        window.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void recipesButton(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    private void loadData() {
        cuisineChoiceBox.getItems().addAll(cuisines.loadCuisines());
    }
}
