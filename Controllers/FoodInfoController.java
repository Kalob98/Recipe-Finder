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
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author Kalob Reinholz
 */
public class FoodInfoController implements Initializable {

    @FXML
    private ChoiceBox<?> cuisineChoiceBox;
    @FXML
    private Button randomButton;
    @FXML
    private Button recipesButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void randomButton(ActionEvent event) {
    }

    @FXML
    private void recipesButton(ActionEvent event) {
    }
    
}
