package Models;

/**
 *Calls the targeted recipe method a number of times then compares to known return recipes to validate that the method is working properly.
 *
 * @author Brodrick Grimm
 */
public class RecipeSearchTest {
    //Number of times to run the test
    private static final int NUM_TEST_RUNS = 5;

    //To keep track of number of fails
    private static int numFails;
    private static int numFailTests;

    //Known return recipes for targeted recipe search
    private static final Recipe recipe1 = new Recipe("Black Bean and Veggie Burgers with Corn Salsa", "https://spoonacular.com/recipes/Black-Bean-and-Veggie-Burgers-with-Corn-Salsa-635059", "635059");
    private static final Recipe recipe2 = new Recipe("Instant Pot Chili Mac", "https://spoonacular.com/recipes/Instant-Pot-Chili-Mac-1165787", "1165787");
    private static final Recipe recipe3 = new Recipe("17 Bean White Chicken Chili", "https://spoonacular.com/recipes/17-Bean-White-Chicken-Chili-631843", "631843");
    private static final Recipe recipe4 = new Recipe("Instant Pot Chili", "https://spoonacular.com/recipes/Instant-Pot-Chili-1178323", "1178323");
    private static final Recipe recipe5 = new Recipe("An American Beef Burger", "https://spoonacular.com/recipes/An-American-Beef-Burger-632342", "632342");
    private static final Recipe knownRecipes[] = new Recipe[]{recipe1, recipe2, recipe3, recipe4, recipe5};

    //Included and Excludeds that have been tested to return expected Recipes.
    private static final String intolerances = "";
    private static final String includedIngredients = "Tomato,Onions";
    private static final String excludedIngredients = "Almonds,Fish";
    private static final String cuisine = "American";

    /**
     *Does a singular test for one call
     *
     * @param _knownRecipes
     * @param _included
     * @param _excluded
     * @param _cuisine
     * @param _intolerances
     * @return
     */
    public static boolean targetedRecipeTest(Recipe[] _knownRecipes, String _included, String _excluded, String _cuisine, String _intolerances) {
        numFails = 0;
        Recipe[] searchedRecipes = SpoonacularAdapter.getRecipe(_cuisine, _included, _excluded, _intolerances);
        if (searchedRecipes.length != _knownRecipes.length) {
            System.out.println(searchedRecipes.length + " != " + _knownRecipes.length + ":: FAIL");
            System.out.println("Returned different number of arrays.");
            return false;
        }
        if (searchedRecipes.length == _knownRecipes.length) {
            for (int i = 0; i < searchedRecipes.length; i++) {
                if (!_knownRecipes[i].equals(searchedRecipes[i])) {
                    System.out.println(_knownRecipes[i].getID() + " != " + searchedRecipes[i].getID() + ":: FAIL");
                    numFails++;
                } else {
                    System.out.println(_knownRecipes[i].getID() + " = " + searchedRecipes[i].getID() + ":: PASS");
                }
            }
        }
        if (numFails > 1) {
            return false;
        }
        return true;
    }

    /**
     * Does a number of test runs and tracks how many individual fails happens
     *
     * @param _knownRecipes
     * @param _included
     * @param _excluded
     * @param _cuisine
     * @param _intolerances
     * @param _testRuns
     * @return
     */
    public static boolean targetedRecipeMultipleTest(Recipe[] _knownRecipes, String _included, String _excluded, String _cuisine, String _intolerances, int _testRuns) {
        numFailTests = 0;
        for (int i = 0; i <= _testRuns; i++) {
            if (targetedRecipeTest(_knownRecipes, _included, _excluded, _cuisine, _intolerances)) {
            } else {
                numFailTests++;
            }
        }
        if(numFailTests>1){
            System.out.println("Test Failed With " + numFailTests + " Failures.");
            return false;
        }else{
            System.out.println("Test Passed With " + numFailTests + " Failures.");
            return true;
        }
    }
        /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
        targetedRecipeMultipleTest(knownRecipes, includedIngredients, excludedIngredients, cuisine, intolerances, NUM_TEST_RUNS);
    }

}
