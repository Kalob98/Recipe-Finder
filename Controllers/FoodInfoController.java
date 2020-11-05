package Controllers;

/**
 * This controller lets you choose a cuisine and items to include and/or
 * exclude, or the app will find a random recipe for you.
 *
 * @author Brodrick Grimm
 * @author Kalob Reinholz
 *
 * Last updated 11/05/20
 */
import com.sun.deploy.util.StringUtils;
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
import utils.Ingredients;
import utils.Cuisines;
import utils.Ingredients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class FoodInfoController implements Initializable {

    private String includeString;
    private String excludeString;
    @FXML
    private ChoiceBox<String> cuisineChoiceBox;
    @FXML
    private Button randomButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button backButton;
    @FXML
    private CheckBox include1;
    @FXML
    private CheckBox include2;
    @FXML
    private CheckBox include3;
    @FXML
    private CheckBox include4;
    @FXML
    private CheckBox include5;
    @FXML
    private CheckBox include6;
    @FXML
    private CheckBox include7;
    @FXML
    private CheckBox include8;
    @FXML
    private CheckBox include9;
    @FXML
    private CheckBox include10;
    @FXML
    private CheckBox exclude1;
    @FXML
    private CheckBox exclude2;
    @FXML
    private CheckBox exclude3;
    @FXML
    private CheckBox exclude4;
    @FXML
    private CheckBox exclude5;
    @FXML
    private CheckBox exclude6;
    @FXML
    private CheckBox exclude7;
    @FXML
    private CheckBox exclude8;
    @FXML
    private CheckBox exclude9;
    @FXML
    private CheckBox exclude10;
    @FXML
    private CheckBox[] included[];
    @FXML
    private CheckBox[] excluded[];

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
        loadData();
    }

    @FXML
    private void randomRecipe(ActionEvent _event) throws IOException {
        Parent infoParent1 = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene1 = new Scene(infoParent1);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene1);
        window.show();
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
    private void searchRecipe(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeChoice.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
        System.out.println(this.getCuisine());
    }

    private void loadData() {
        cuisineChoiceBox.getItems().addAll(Cuisines.loadCuisines());
    }
//=================  GETTERS ===============

    private String getIncluded() {
        if (include1.isSelected()) {
            this.includeString = includeString + "Almonds";
        }
        if (include2.isSelected()) {
            this.includeString = includeString + ",Beef";
        }
        if (include3.isSelected()) {
            this.includeString = includeString + ",Cheese";
        }
        if (include4.isSelected()) {
            this.includeString = includeString + ",Chicken";
        }
        if (include5.isSelected()) {
            this.includeString = includeString + ",Eggs";
        }
        if (include6.isSelected()) {
            this.includeString = includeString + ",Fish";
        }
        if (include7.isSelected()) {
            this.includeString = includeString + ",Flour";
        }
        if (include8.isSelected()) {
            this.includeString = includeString + ",Milk";
        }
        if (include9.isSelected()) {
            this.includeString = includeString + ",Onions";
        }
        if (include10.isSelected()) {
            this.includeString = includeString + ",Pork";
        }
        if (includeString.charAt(0) == ',') {
            return includeString.substring(1);
        }
        return includeString;
    }

    private String getExcluded() {
        if (exclude1.isSelected()) {
            this.excludeString = excludeString + "Almonds";
        }
        if (exclude2.isSelected()) {
            this.excludeString = excludeString + ",Beef";
        }
        if (exclude3.isSelected()) {
            this.excludeString = excludeString + ",Cheese";
        }
        if (exclude4.isSelected()) {
            this.excludeString = excludeString + ",Chicken";
        }
        if (exclude5.isSelected()) {
            this.excludeString = excludeString + ",Eggs";
        }
        if (exclude6.isSelected()) {
            this.excludeString = excludeString + ",Fish";
        }
        if (exclude7.isSelected()) {
            this.excludeString = excludeString + ",Flour";
        }
        if (exclude8.isSelected()) {
            this.excludeString = excludeString + ",Milk";
        }
        if (exclude9.isSelected()) {
            this.excludeString = excludeString + ",Onions";
        }
        if (exclude10.isSelected()) {
            this.excludeString = excludeString + ",Pork";
        }
        if (excludeString.charAt(0) == ',') {
            return excludeString.substring(1);
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
