package APIs;

/**
 * Class that makes calls to the spoonacular API
 *
 * @author Kalob Reinholz
 *
 * Last updated 11/5/20
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

public class SpoonacularAPI implements RecipeApiInterface {

    private static HttpURLConnection connection;
    private static final String baseURL = "https://api.spoonacular.com/recipes/"; //move to util in future
    private static final String complexSearch = "complexSearch?";
    private static final String random = "random?number=1";
    private static final String number = "&number=6"; //max number of results allowed to be displayed
    private static final String kalobKey = ApiKeys.kalob_ApiKey();
    private static final String brodyKey = ApiKeys.brody_ApiKey();
    private static final String hengKey = ApiKeys.heng_ApiKey();
    private static final int TITLE_LOCATION = 0;
    private static final int URL_LOCATION = 1;
    private static final int ID_LOCATION = 2;
    private static final int RANDOM_RECIPE_ARRAY_SIZE = 3;

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
    public String[] loadRecipeId(String _cuisine, String _includedIngredients, String _excludedIngredients, String _intolerances) {
        String recipe = (baseURL + complexSearch + "cuisine=" + _cuisine
                + "&includeIngredients=" + _includedIngredients
                + "&excludeIngredients=" + _excludedIngredients
                + "&intolerances=" + _intolerances
                + number + kalobKey);

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        String[] recipesInfo = null;

        try {
            URL url = new URL(recipe);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000); //10 sec
            connection.setReadTimeout(10000);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0"); //needed to make api call

            int status = connection.getResponseCode();
            System.out.println("Response Code: " + status);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();

            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("results");

            int arrCounter = 0;
            for (int i = 0; i < obj.getInt("number"); i++) {
                JSONObject temp = array.getJSONObject(i);
                recipesInfo[arrCounter] = (String) temp.get("title");
                recipesInfo[arrCounter += 1] = (String) temp.get("id");
                arrCounter += 1;
            }
        }

        catch (MalformedURLException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException | JSONException ex) {
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
        String randomRecipe = (baseURL + random + kalobKey);

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        String[] randomRecipeInfo = new String[RANDOM_RECIPE_ARRAY_SIZE];

        try {
            URL url = new URL(randomRecipe);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000); //10 sec
            connection.setReadTimeout(10000);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0"); //needed to make api call

            int status = connection.getResponseCode();
            System.out.println("Response Code: " + status);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();

            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("recipes");
            JSONObject temp = array.getJSONObject(0);

            randomRecipeInfo[TITLE_LOCATION] = temp.getString("title");
            randomRecipeInfo[URL_LOCATION] = temp.getString("spoonacularSourceUrl");
            randomRecipeInfo[ID_LOCATION] = temp.getString("id");
        }

        catch (MalformedURLException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException | JSONException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();

        // return [title and spoonacularSourceURL]
        return randomRecipeInfo;
    }
}
