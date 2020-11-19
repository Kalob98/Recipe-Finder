/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heng Tan
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
    private Button recipedeleteOne;
    @FXML
    private Button recipedeleteTwo;
    @FXML
    private Button recipedeleteThree;
    @FXML
    private Button recipedeleteFour;
    @FXML
    private Button recipedeleteFive;
    @FXML
    private Button recipedeleteSix;
    @FXML
    private Button backButton;
    private Object _event;

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
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void deleteTwo(ActionEvent event) {
    }
    
}
