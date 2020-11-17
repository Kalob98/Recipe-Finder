package Controllers;

/**
 * This controller allows the selection of one out of six recipes.
 *
 * @author Brodrick Grimm
 *
 * Last updated 10/28/20
 */
import Models.Recipe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brody
 */
public class RecipeChoiceController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private VBox recipesVbox;

    private Recipe[] recipes = {new Recipe("Oreo Cookie Ball Turkeys","https://spoonacular.com/recipes/oreo-cookie-balls-%E2%80%93-thanksgiving-turkey-715449","715449")} ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prepVbox(recipes);
    }

    private void prepVbox(Recipe[] recipes) {
        for (int i = 0; i < recipes.length ; i++) {
            Hyperlink hLink = new Hyperlink();
            hLink.setText(recipes[i].getTitle());
            hLink.setOnAction(e -> {
                try {
                    hyperLinkClicked();
                } catch (IOException ex) {
                    Logger.getLogger(RecipeChoiceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            recipesVbox.getChildren().add(hLink);
        }
    }

    private void hyperLinkClicked() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Recipe Finder");
        stage.getIcons().add(new Image("assets/ChickenLeg.png"));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void RecipeChosen(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

}
