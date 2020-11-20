package Models;

/**
 * Class used to make call to the spoonacular API. Passes information here to
 * the spoonacularAPI class.
 *
 * @author Kalob Reinholz
 *
 * Last Updated 11/12/20
 */
import Models.Recipe;

public class SpoonacularAdapter {

    /**
     *
     * @param _cuisine
     * @param _inlcudedIngredients
     * @param _excludedIngredients
     * @param _intolerances
     * @return
     */
    public static Recipe[] getRecipe(String _cuisine, String _inlcudedIngredients,
            String _excludedIngredients, String _intolerances) {

        String[] recipe;
        Recipe[] recipeObjects = new Recipe[0];
        SpoonacularAPI makeCall = new SpoonacularAPI();

        recipe = makeCall.targetedRecipe(_cuisine, _inlcudedIngredients, _excludedIngredients, _intolerances);
        int recipeObjectSize = recipe.length / 2;
        recipeObjects = new Recipe[recipeObjectSize];
        
        int arrCounter = 0;
        for (int i = 0; i < recipeObjectSize; i++) {
            Recipe temp = new Recipe(recipe[arrCounter], recipe[arrCounter += 1]);
            recipeObjects[i] = temp;
            arrCounter += 1;
        }

        return recipeObjects;
    }

    /**
     * 
     * @return 
     */
    public static Recipe getRandomRecipe() {

        String[] random;
        SpoonacularAPI makeCall = new SpoonacularAPI();

        random = makeCall.randomRecipe();

        Recipe randomRecipe = new Recipe(random[0], random[1], random[2]);

        //[title, sourceurl]
        return randomRecipe;
    }
}
