package utils;

/**
 * Class that creates a list of some ingredients spoonacular API offers to add
 * to the include and exclude choiceBoxes.
 *
 * @author Kalob Reinholz
 *
 * Last updated 10/21/20
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ingredients {

    public enum INGREDIENTS {Almonds,Beef,Cheese,Chicken,Eggs,Fish,Flour,Milk,Onions,Pork,Potatoes,Rice,Tomatoes};

    public static ObservableList loadIngredients() {
        ObservableList<String> ingredients = FXCollections.observableArrayList();

        ingredients.removeAll(ingredients);

        String NULL = "";
        String Almonds = "Almonds";
        String Beef = "Beef";
        String Cheese = "Cheese";
        String Chicken = "Chicken";
        String Eggs = "Eggs";
        String Fish = "Fish";
        String Flour = "Flour";
        String Milk = "Milk";
        String Onions = "Onions";
        String Pork = "Pork";
        String Potatoes = "Potatoes";
        String Rice = "Rice";
        String Tomatoes = "Tomatoes";

        ingredients.addAll(NULL, Almonds, Beef, Cheese, Chicken, Eggs, Fish, Flour,
                Milk, Onions, Pork, Potatoes, Rice, Tomatoes);

        return ingredients;
    }
}
