package Controllers;

/**
 * This controller is for the RecipeScene, a recipe is shown through a webview.
 *
 * @author Brodrick Grimm
 *
 * Last updated 11/15/20
 */
import Models.Recipe;
import Models.SavedRecipesRead;
import static Models.SavedRecipesWrite.write;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        if(this.recipe.getIsSaved() == true){
            createDeleteButton();
        }
        webEngine.load(this.recipe.getUrl());
        System.out.println(this.recipe.getIsSaved());
    }

    private void createDeleteButton(){
        Button deleteButton = new Button("Un-Save");
        deleteButton.setPrefWidth(deleteBoxVBox.getPrefWidth());
        deleteButton.setPrefHeight(deleteBoxVBox.getPrefHeight());
        deleteButton.setOnAction(e->{
            try {
                deleteRecipe();
            } catch (IOException ex) {
                Logger.getLogger(RecipeSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        deleteBoxVBox.getChildren().add(deleteButton);
    }

    private void deleteRecipe() throws IOException{
        SavedRecipesRead.delete(SavedRecipesRead.getFilePathToTextFile(), this.recipe.getID(),"::");
        System.out.println("ID: " + this.recipe.getID());
    }

    @FXML
    private void saveRecipe(ActionEvent _event) throws IOException{
        write(this.recipe);
    }

    /**
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
