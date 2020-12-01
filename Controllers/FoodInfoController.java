package Controllers;

/**
 * This controller lets you choose a cuisine and items to include and/or
 * exclude, or the app will find a random recipe for you.
 *
 * @author Brodrick Grimm
 * @author Kalob Reinholz
 *
 * Last updated 11/30/20
 */
import Models.SpoonacularAdapter;
import Models.Recipe;
import Models.RecipeArray;
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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import utils.Cuisines;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import utils.Ingredients.INGREDIENTS;

public class FoodInfoController implements Initializable {

    private String includeString;
    private String excludeString;
    private String intolerances;
    @FXML
    private ChoiceBox<String> cuisineChoiceBox;
    @FXML
    private Button randomButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button backButton;
    @FXML
    private VBox includeVBox;
    @FXML
    private VBox excludeVBox;
    @FXML
    private CheckBox included[];
    @FXML
    private CheckBox excluded[];

    /**
     * Adds the ingredients to the checkboxes.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        clearStrings();
        included = new CheckBox[INGREDIENTS.values().length];
        excluded = new CheckBox[INGREDIENTS.values().length];
        setUpVboxes();
        loadData();
    }

    /**
     * Gets a random recipe
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void randomRecipe(ActionEvent _event) throws IOException {

        //copying all instance variables from randomly generated recipe to singleton recipe
        Recipe singletonRandomRecipe = Recipe.getInstance();
        Recipe randomRecipe = SpoonacularAdapter.getRandomRecipe();
        singletonRandomRecipe.setUrl(randomRecipe.getUrl());
        singletonRandomRecipe.setTitle(randomRecipe.getTitle());
        singletonRandomRecipe.setId(randomRecipe.getID());
        singletonRandomRecipe.setIsSaved(false);

        clearStrings();

        //when random button is clicked RecipeScene view is loaded
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Recipe Finder");
        stage.getIcons().add(new Image("assets/ChickenLeg.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Gets targeted recipe.
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void searchRecipe(ActionEvent _event) throws IOException {

        //copys the instance variables from all targeted recipes
        RecipeArray temp = RecipeArray.getInstance();
        temp.setRecipes(SpoonacularAdapter.getRecipe(this.getCuisine(), this.getIncluded(), this.getExcluded(), ""));

        //when search button is clicked RecipeChoice view is loaded
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeChoice.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     * When back button clicked returns to the home scene
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     * Fils the include and exclude boxes with the checkboxes.
     */
    private void setUpVboxes() {

        int enumSize = INGREDIENTS.values().length;
        for (int i = 0; i < enumSize; i++) {
            CheckBox box = new CheckBox(INGREDIENTS.values()[i].name());
            CheckBox box2 = new CheckBox(INGREDIENTS.values()[i].name());
            box.setOnAction(e -> box2.setSelected(false));
            box2.setOnAction(e -> box.setSelected(false));
            included[i] = box;
            excluded[i] = box2;
            includeVBox.getChildren().add(box);
            excludeVBox.getChildren().add(box2);
        }
    }

    /**
     * Clears the instance strings.
     */
    private void clearStrings() {
        this.includeString = "";
        this.excludeString = "";
        this.intolerances = "";
    }

    /**
     * Fills in all the cuisines.
     */
    private void loadData() {
        cuisineChoiceBox.getItems().addAll(Cuisines.loadCuisines());
    }

//=================  GETTERS ===============
    private String getIncluded() {
        for (CheckBox box : included) {
            if (box.isSelected()) {
                includeString = includeString + box.getText();
                includeString = includeString + ",";
            }
        }
        if (includeString.length() > 1) {
            if (includeString.charAt(includeString.length() - 1) == ',') {
                includeString = includeString.substring(0, includeString.length() - 1);
            }
        }
        return includeString;
    }

    private String getExcluded() {
        for (CheckBox box : excluded) {
            if (box.isSelected()) {
                excludeString = excludeString + box.getText();
                excludeString = excludeString + ",";
            }
        }
        if (excludeString.length() > 1) {
            if (excludeString.charAt(excludeString.length() - 1) == ',') {
                excludeString = excludeString.substring(0, excludeString.length() - 1);
            }
        }
        return excludeString;
    }

    private String getCuisine() {
        if (this.cuisineChoiceBox.getValue() == null) {
            return "";
        }
        return this.cuisineChoiceBox.getValue();
    }
}
