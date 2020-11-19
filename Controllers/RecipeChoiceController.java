package Controllers;

/**
 * This controller allows the selection of one out of six recipes.
 *
 * @author Brodrick Grimm
 *
 * Last updated 11/17/20
 */
import Models.Recipe;
import Models.RecipeArray;
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

public class RecipeChoiceController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private VBox recipesVbox;

    private Recipe[] recipes;
    private int flag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.recipes = RecipeArray.getInstance().getRecipes();
        this.flag = RecipeArray.getInstance().getFlag();
        prepVbox(this.recipes);
    }

    /**
     *populates the VBox with the clickable recipes
     * @param recipes
     */
    private void prepVbox(Recipe[] recipes) {
        for (int i = 0; i < this.recipes.length ; i++) {
            Hyperlink hLink = new Hyperlink();
            hLink.setText(this.recipes[i].getTitle());
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

    /**
     *
     * @throws IOException
     */
    private void hyperLinkClicked() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Recipe Finder");
        stage.getIcons().add(new Image("assets/ChickenLeg.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void RecipeChosen(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

}
