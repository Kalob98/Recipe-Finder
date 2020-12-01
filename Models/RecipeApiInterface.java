package Models;

/**
 * This is the API interface
 *
 * @author Brody
 * @author Kalob Reinholz
 *
 * Last updated 11/5/20
 */
public interface RecipeApiInterface {

    /**
     * Method that controllers call to access API
     *
     * @param _cuisine
     * @param _inlcudedIngredients
     * @param _excludedIngredients
     * @param _intolerances
     * @return
     */
    public String[] targetedRecipe(String _cuisine, String _inlcudedIngredients,
            String _excludedIngredients, String _intolerances);

    /**
     * Method that controllers call randomRecipes from API
     *
     * @return
     */
    public String[] randomRecipe();
}
