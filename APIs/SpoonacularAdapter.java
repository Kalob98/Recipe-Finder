package APIs;

/**
 * Class used to make call to the spoonacular API. Passes information here to
 * the spoonacularAPI class.
 *
 * @author Kalob Reinholz
 *
 * Last Updated 10/29/20
 */
public class SpoonacularAdapter {

    /**
     *
     * @param _cuisine
     * @param _inlcudedIngredients
     * @param _excludedIngredients
     * @param _intolerances
     * @return
     */
    public String[] getRecipe(String _cuisine, String _inlcudedIngredients,
            String _excludedIngredients, String _intolerances) {

        String[] recipe;
        SpoonacularAPI makeCall = new SpoonacularAPI();

        recipe = makeCall.loadRecipeId(_cuisine, _inlcudedIngredients, _excludedIngredients, _intolerances);

        return recipe;
    }

    public String getRandomRecipe() {

        String random;
        SpoonacularAPI makeCall = new SpoonacularAPI();

        random = makeCall.randomRecipe();

        return random;
    }
}
