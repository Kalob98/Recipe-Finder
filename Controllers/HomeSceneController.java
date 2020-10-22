<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> master
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
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.stage.Stage;
=======
import javafx.stage.Stage;
import javafx.scene.control.Button;
>>>>>>> master

/**
 * FXML Controller class
 *
<<<<<<< HEAD
 * @author Kalob Reinholz, Brodrick Grimm
=======
 * @author Kalob Reinholz
>>>>>>> master
 */
public class HomeSceneController implements Initializable {

    @FXML
    private Button prevRecipe;
    @FXML
    private Button howToUse;
    @FXML
    private Button next;
<<<<<<< HEAD
    @FXML
    private Button quitButton;
=======
>>>>>>> master

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
<<<<<<< HEAD
    }

    @FXML
    private void prevRecipe(ActionEvent event) throws IOException {
    }

    @FXML
    private void howToUse(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HowToUse.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
=======
    }    

    @FXML
    private void prevRecipe(ActionEvent event) {
    }

    @FXML
    private void howToUse(ActionEvent event) {
>>>>>>> master
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
<<<<<<< HEAD
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene = new Scene(infoParent);
=======
        Parent infoParnet = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene = new Scene(infoParnet);
>>>>>>> master

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }
<<<<<<< HEAD

    @FXML
    private void quit(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

=======
    
>>>>>>> master
}
