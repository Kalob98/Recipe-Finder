package Models;

/**
 * Recipe Class used to store title, url, and id of each recipe.
 *
 * @author Brodrick Grimm
 *
 * Last updated 11/12/20
 */
import utils.SpoonacularBaseUrl;

public class Recipe {

    private static final Recipe INSTANCE = new Recipe();
    private String title;
    private String url;
    private String id;

    public Recipe(String _title, String _url, String _id) {
        this.title = _title;
        this.url = _url;
        this.id = _id;
    }

    public Recipe(String _title, String _id) {
        this.id = _id;
        this.title = _title;
        this.url = createURL();
    }

    public Recipe() {
    }

    public static Recipe getInstance() {
        return INSTANCE;
    }

    //will change when "baseURL" is moved
    public String createURL() {
        url = SpoonacularBaseUrl.baseUrl() + this.title.replace(' ', '-') 
                + "-" + this.id;
        return url;
    }

    //=================  GETTERS ===============
    public String getTitle() {
        return this.title;
    }

    public String getID() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    //=================  SETTERS ===============
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
