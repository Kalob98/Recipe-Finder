/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Kalob Reinholz
 */
public class SavedRecipesController implements Initializable {

    @FXML
    private Label recipeOneLabel;
    @FXML
    private Label recipeTwoLabel;
    @FXML
    private Label recipeThreeLabel;
    @FXML
    private Label recipeFourLabel;
    @FXML
    private Label recipeFiveLabel;
    @FXML
    private Label recipeSixLabel;
    @FXML
    private Button recipeOneButton;
    @FXML
    private Button recipeTwoButton;
    @FXML
    private Button recipeThreeButton;
    @FXML
    private Button recipeFourButton;
    @FXML
    private Button recipeFiveButton;
    @FXML
    private Button recipeSixButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RecipeOneChosen(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void deleteTwo(ActionEvent event) {
    }
    
}
