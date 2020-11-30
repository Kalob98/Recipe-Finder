package Models;

/**
 * Class that makes calls to the spoonacular API
 *
 * @author Kalob Reinholz
 *
 * Last updated 11/18/20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static utils.SpoonacularBaseUrl.baseUrlForApiCall;

public class SpoonacularAPI implements RecipeApiInterface {

    private static HttpURLConnection connection;

    //used for creating the urls used to make api calls
    private static final String complexSearch = "complexSearch?"; //used for targetedRecipe method
    private static final String random = "random?number=1"; //used for randomRecipe method
    private static final String number = "&number=5"; //max number of results allowed to be displayed

    //our groups api keys
    private static final String kalobKey = ApiKeys.kalob_ApiKey();
    private static final String brodyKey = ApiKeys.brody_ApiKey();
    private static final String hengKey = ApiKeys.heng_ApiKey();

    //used to place information from the api call in an array
    private static final int TITLE_LOCATION = 0;
    private static final int URL_LOCATION = 1;
    private static final int ID_LOCATION = 2;
    private static final int RANDOM_RECIPE_ARRAY_SIZE = 3;

    private static BufferedReader reader;
    private static String line;
    private static StringBuilder responseContent = new StringBuilder();

    /**
     * Method that calls the spoonacular API to find multiple recipes using user
     * requirement.
     *
     * @param _cuisine
     * @param _includedIngredients
     * @param _excludedIngredients
     * @param _intolerances
     * @return
     *
     * Intolerances are not included in our program as of now. It can be added
     * in the future.
     */
    @Override
    public String[] targetedRecipe(String _cuisine, String _includedIngredients, String _excludedIngredients, String _intolerances) {
        String recipe = (baseUrlForApiCall + complexSearch + "cuisine=" + _cuisine
                + "&includeIngredients=" + _includedIngredients
                + "&excludeIngredients=" + _excludedIngredients
                + "&intolerances=" + _intolerances
                + number + hengKey);

        System.out.println(recipe);
        //array that is returned with recipes information
        String[] recipesInfo = new String[0];
        try {

            int status = loadApi(recipe);
            if(status == 402){
                recipe = (baseUrlForApiCall + complexSearch + "cuisine=" + _cuisine
                + "&includeIngredients=" + _includedIngredients
                + "&excludeIngredients=" + _excludedIngredients
                + "&intolerances=" + _intolerances
                + number + brodyKey);
            }
            status = loadApi(recipe);
            if(status == 402){
                recipe = (baseUrlForApiCall + complexSearch + "cuisine=" + _cuisine
                + "&includeIngredients=" + _includedIngredients
                + "&excludeIngredients=" + _excludedIngredients
                + "&intolerances=" + _intolerances
                + number + kalobKey);
            }
            status = loadApi(recipe);
            if(status == 402){
                System.out.println("We have ran out of API calls for the day. Try again tommorrow. Sorry!");
            }

            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("results");
            JSONObject temp;

            int total = Math.min(obj.getInt("totalResults"), obj.getInt("number"));
            recipesInfo = new String[(total * 2)];

            int arrCounter = 0;
            for (int i = 0; i < total; i++) {
                temp = array.getJSONObject(i);

                recipesInfo[arrCounter] = (String) temp.get("title");
                recipesInfo[arrCounter += 1] = temp.get("id").toString();

                arrCounter += 1;
            }
        }

        catch (JSONException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();

        //returns [recipe1.title, recipe1.id, recipe2.title, ...]
        return recipesInfo;
    }

    /**
     * Method that calls the spoonacular API to find a random recipe.
     *
     * @return
     */
    @Override
    public String[] randomRecipe() {
        String randomRecipe = (baseUrlForApiCall + random + kalobKey);

        String[] randomRecipeInfo = new String[RANDOM_RECIPE_ARRAY_SIZE];

        try {

            loadApi(randomRecipe);

            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("recipes");
            JSONObject temp = array.getJSONObject(0);

            randomRecipeInfo[TITLE_LOCATION] = temp.getString("title");
            randomRecipeInfo[URL_LOCATION] = temp.getString("spoonacularSourceUrl");
            randomRecipeInfo[ID_LOCATION] = temp.getString("id");
        }

        catch (JSONException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();

        //returns [title, spoonacularSourceURL, id]
        return randomRecipeInfo;
    }

    /**
     * Method used to start api call
     *
     * @param recipe
     */
    private int loadApi(String recipe) {

        responseContent = new StringBuilder();
        int status = 0;

        try {
            URL url = new URL(recipe);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000); //10 sec
            connection.setReadTimeout(10000);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0"); //needed to make api call

            status = connection.getResponseCode();
            System.out.println("Response Code: " + status);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
}
