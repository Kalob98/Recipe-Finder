package Controllers;

/**
 * This controller lets you choose a cuisine and items to include and/or
 * exclude, or the app will find a random recipe for you.
 *
 * @author Brodrick Grimm
 * @author Kalob Reinholz
 *
 * Last updated 11/17/20
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
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        includeString = "";
        excludeString = "";
        intolerances = "";

        included = new CheckBox[INGREDIENTS.values().length];
        excluded = new CheckBox[INGREDIENTS.values().length];
        setUpVboxes();
        loadData();
    }

    /**
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void randomRecipe(ActionEvent _event) throws IOException {

        //change temp
        Recipe temp = Recipe.getInstance();
        Recipe temp2 = SpoonacularAdapter.getRandomRecipe();
        temp.setUrl(temp2.getUrl());
        temp.setTitle(temp2.getTitle());

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
    private void searchRecipe(ActionEvent _event) throws IOException {
        RecipeArray temp = RecipeArray.getInstance();
        temp.setRecipes(SpoonacularAdapter.getRecipe(this.getCuisine(), this.getIncluded(), this.getExcluded(), ""));

        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeChoice.fxml"));
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
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     *
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
     *
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
