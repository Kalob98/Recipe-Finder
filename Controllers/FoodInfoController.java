/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

<<<<<<< HEAD
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
=======
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
>>>>>>> master

/**
 * FXML Controller class
 *
<<<<<<< HEAD
 * @author Brody
=======
 * @author Kalob Reinholz
>>>>>>> master
 */
public class FoodInfoController implements Initializable {

    @FXML
<<<<<<< HEAD
    private ChoiceBox<String> cuisineChoiceBox;
=======
    private ChoiceBox<?> cuisineChoiceBox;
>>>>>>> master
    @FXML
    private Button randomButton;
    @FXML
    private Button recipesButton;
<<<<<<< HEAD
    @FXML
    private Button backButton;

    public FoodInfoController() {
        
    }
=======
>>>>>>> master

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
=======
        // TODO
>>>>>>> master
    }    

    @FXML
    private void randomButton(ActionEvent event) {
<<<<<<< HEAD
        //applies search with no constraints
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
=======
    }

    @FXML
    private void recipesButton(ActionEvent event) {
>>>>>>> master
    }
    
}
