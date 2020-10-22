package APIs;

/**
 * Class that creates a list of all intolerances spoonacular API offers to add
 * to the intolerance choiceBox.
 *
 * @author Kalob Reinholz
 *
 * Last updated 10/21/20
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Intolerance {

    public static ObservableList loadIntolerance() {
        ObservableList<String> intolerance = FXCollections.observableArrayList();

        intolerance.removeAll(intolerance);

        String NULL = "";
        String Dairy = "Dairy";
        String Egg = "Egg";
        String Gluten = "Gluten";
        String Grain = "Grain";
        String Peanut = "Peanut";
        String Seafood = "Seafood";
        String Sesame = "Sesame";
        String Shellfish = "Shellfish";
        String Soy = "Soy";
        String Sulfite = "Sulfite";
        String TreeNut = "Tree Nut";
        String Wheat = "Wheat";

        intolerance.addAll(NULL, Dairy, Egg, Gluten, Grain, Peanut, Seafood,
                Sesame, Shellfish, Soy, Sulfite, TreeNut, Wheat);

        return intolerance;
    }
}
