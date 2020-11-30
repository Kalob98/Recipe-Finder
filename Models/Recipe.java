package Models;

/**
 * Recipe Class used to store title, url, and id of each recipe.
 *
 * @author Brodrick Grimm
 *
 * Last updated 11/12/20
 */
import static utils.SpoonacularBaseUrl.baseUrlForUrlCreation;

public class Recipe {

    private static Recipe INSTANCE = new Recipe();
    private String title;
    private String url;
    private String id;
    private boolean isSaved;

    public Recipe(String _title, String _url, String _id, boolean _isSaved) {
        this.title = _title;
        this.url = _url;
        this.id = _id;
        this.isSaved = _isSaved;
        System.out.println("TRUE!");
    }

    public Recipe(String _title, String _url, String _id) {
        this.title = _title;
        this.url = _url;
        this.id = _id;
        this.isSaved = false;
    }

    public Recipe(String _title, String _id) {
        this.id = _id;
        this.title = _title;
        this.url = createURL();
        this.isSaved = false;
    }

    public Recipe() {
    }

    public static Recipe getInstance() {
        return INSTANCE;
    }


    public String createURL() {
        if(this.title != null){
            url = baseUrlForUrlCreation + this.title.replace(' ', '-')
                + "-" + this.id;
            return url;
        }
        return "";
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

    public boolean getIsSaved(){
        return this.isSaved;
    }

    //=================  SETTERS ===============
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIsSaved(boolean _isSaved){
        this.isSaved = _isSaved;
    }
    public void setId(String id){
        this.id = id;
    }
}
