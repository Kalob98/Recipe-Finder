package Models;

/**
 * Helper class used to save array of recipes for populating the RecipeChoice
 * view.
 *
 * @author Brody
 *
 * Last Updated: 11/30/20
 */
public class RecipeArray {

    private static RecipeArray RECIPE_ARRAY_INSTANCE = new RecipeArray();
    private Recipe[] recipes;
    private int FLAG;

    /**
     * Default.
     */
    RecipeArray() {
    }

    /**
     *
     * @param _array
     * @param _flag
     */
    RecipeArray(Recipe[] _array, int _flag) {
        this.recipes = _array;
        this.FLAG = _flag;
    }

    /**
     *
     * @return
     */
    public Recipe[] getRecipes() {
        return this.recipes;
    }

    /**
     *
     * @return
     */
    public int getFlag() {
        return this.FLAG;
    }

    /**
     *
     * @return
     */
    public static RecipeArray getInstance() {
        return RECIPE_ARRAY_INSTANCE;
    }

    /**
     *
     * @param _recipes
     */
    public void setRecipes(Recipe[] _recipes) {
        this.recipes = _recipes;
    }

    /**
     *
     * @param _flag
     */
    public void setFlag(int _flag) {
        this.FLAG = _flag;
    }
}
