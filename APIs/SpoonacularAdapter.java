package APIs;

/**
 * Class used to make call to the spoonacular API. Passes information here to
 * the spoonacularAPI class.
 *
 * @author Kalob Reinholz
 *
 * Last Updated 10/29/20
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
    public Recipe[] getRecipe(String _cuisine, String _inlcudedIngredients,
            String _excludedIngredients, String _intolerances) {

        String[] recipe;
        Recipe[] recipeObjects = null;
        SpoonacularAPI makeCall = new SpoonacularAPI();

        recipe = makeCall.loadRecipeId(_cuisine, _inlcudedIngredients, _excludedIngredients, _intolerances);
        
        int arrCounter = 0;
        for(int i = 0; i < (recipe.length / 2); i++){
            Recipe temp = new Recipe(recipe[arrCounter], recipe[arrCounter += 1]);
            recipeObjects[i] = temp;
            arrCounter += 1;
        }

        return recipeObjects;
    }

    public Recipe getRandomRecipe() {

        String[] random;
        SpoonacularAPI makeCall = new SpoonacularAPI();

        random = makeCall.randomRecipe();

        Recipe randomRecipe = new Recipe(random[0], random[1]);

        //[title, sourceurl]
        return randomRecipe;
    }
}
