package Controllers;

/**
 * This controller is for the RecipeScene, a recipe is shown through a webview.
 *
 * @author Brodrick Grimm
 *
 * Last updated 11/30/20
 */
import Models.Recipe;
import Models.SavedRecipesRead;
import Models.SavedRecipesWrite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RecipeSceneController implements Initializable {

    @FXML
    private WebView webView;
    @FXML
    private WebEngine webEngine;
    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;
    @FXML
    private Button closeButton;
    @FXML
    private VBox deleteBoxVBox;

    private String recipeURL;
    private Recipe recipe;

    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        this.recipe = Recipe.getInstance();
        webEngine = webView.getEngine();

        //if the previous recipes button was pressed
        if (this.recipe.getIsSaved() == true) {
            createDeleteButton();
        }
        webEngine.load(this.recipe.getUrl());
    }

    /**
     * Creates the delete button.
     */
    private void createDeleteButton() {
        Button deleteButton = new Button("Un-Save");
        deleteButton.setPrefWidth(deleteBoxVBox.getPrefWidth());
        deleteButton.setPrefHeight(deleteBoxVBox.getPrefHeight());
        deleteButton.setOnAction(e -> {
            try {
                deleteRecipe();
            }
            catch (IOException ex) {
                Logger.getLogger(RecipeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        deleteBoxVBox.getChildren().add(deleteButton);
    }

    /**
     * Calls the delete method to delete the selected recipe.
     *
     * @throws IOException
     */
    private void deleteRecipe() throws IOException {
        SavedRecipesRead.delete(SavedRecipesRead.getFilePathToTextFile(), this.recipe.getID(), "::");
    }

    /**
     * Calls the write method to save selected recipe.
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void saveRecipe(ActionEvent _event) throws IOException {
        SavedRecipesWrite.write(this.recipe);
    }

    /**
     * Closes the new window with the recipe.
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void close(ActionEvent _event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
