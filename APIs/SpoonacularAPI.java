package APIs;

/**
 * Class that makes calls to the spoonacular API
 *
 * @author Kalob Reinholz
 *
 * Last updated 10/29/20
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
    private static String baseURL = "https://api.spoonacular.com/recipes/";
    private static String complexSearch = "complexSearch?";
    private static String random = "random?number=1";
    private static String number = "&number=6"; //max number of results allowed to be displayed
    private static String kalobKey = ApiKeys.kalob_ApiKey();
    private static String brodyKey = ApiKeys.brody_ApiKey();
    private static String hengKey = ApiKeys.heng_ApiKey();

    /**
     *
     * @param _cuisine
     * @param _includedIngredients
     * @param _excludedIngredients
     * @param _intolerances
     * @return
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
            for (int i = 0; i < obj.getInt("totalResults"); i++) {
                JSONObject temp = array.getJSONObject(i);
                recipesInfo[arrCounter] = (String) temp.get("id");
                recipesInfo[arrCounter += 1] = (String) temp.get("title");
            }
        }

        catch (MalformedURLException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException | JSONException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();

        return recipesInfo;
    }

    @Override
    public String randomRecipe() {
        String randomRecipe = (baseURL + random + kalobKey);

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        String recipeUrl = null;

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

            //prints the json info
            //System.out.println(responseContent.toString());
            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("recipes");
            JSONObject temp = array.getJSONObject(0);

            recipeUrl = temp.getString("sourceUrl");

            //prints the info in the .get()
            //System.out.println(temp.get("id"));
        }

        catch (MalformedURLException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException | JSONException ex) {
            Logger.getLogger(SpoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();

        return recipeUrl;
    }
}
