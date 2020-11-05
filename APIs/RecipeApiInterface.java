package APIs;

/**
 * This is the interface 
 *
 * @author Brody
 * @author Kalob Reinholz
 *
 * Last updated 11/5/20
 */

public interface RecipeApiInterface {
    
    /**
     * 
     * @param _cuisine
     * @param _inlcudedIngredients
     * @param _excludedIngredients
     * @param _Intolerances
     * @return 
     */
    public String[] loadRecipeId(String _cuisine, String _inlcudedIngredients, 
            String _excludedIngredients, String _Intolerances);
    
    public String[] randomRecipe();
}
