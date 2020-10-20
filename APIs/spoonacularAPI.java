package APIs;

/**
 * Class that makes calls to the spoonacular API
 *
 * @author Kalob Reinholz
 *
 * Last updated 10/20/20
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

public class spoonacularAPI {

    private static HttpURLConnection connection;

    public static void main(String[] args) {
        String baseURL = "https://api.spoonacular.com/recipes/complexSearch?";
        String query = "cuisine=italian&includeIngredients=chicken";
        String key = apiKeys.kalob_ApiKey();

        String finalAPI = (baseURL + query + key);

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL(finalAPI);
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

            System.out.println(responseContent.toString());

            JSONObject obj = new JSONObject(responseContent.toString());
            JSONArray array = obj.getJSONArray("results");
            JSONObject temp = array.getJSONObject(0);

            System.out.println(temp.getString("id"));

        }

        catch (MalformedURLException ex) {
            Logger.getLogger(spoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (IOException | JSONException ex) {
            Logger.getLogger(spoonacularAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.disconnect();
    }
}
