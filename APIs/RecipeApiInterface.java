package APIs;

/**
 * This is the interface 
 *
 * @author Brody
 * @author Kalob Reinholz
 *
 * Last updated 10/20/20
 */

public interface RecipeApiInterface {
    public int loadRecipeId(String _cuisine, String _inlcudedIngredients, 
            String _excludedIngredients, String _Intolerances);
            
    /*
    public int loadRecipeIdByCuisine(String _cuisine);
    
    public int loadRecipeIdByIncludedIngredients(String _inlcudedIngredients);
    
    public int loadRecipeIdByExcludedIngredients(String _excludedIngredients);
    
    public int loadRecipeIdByIntolerances(String _Intolerances);
    */
}
