/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Brody
 */
public class Recipe {


    private String title;
    private String url;

    public Recipe(String _id, String _title, String _url){
        this.title = _title;
        this.url = _url;
    }





    //=================  GETTERS ===============
    public String getTitle(){
        return this.title;
    }
    public String getUrl(){
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
