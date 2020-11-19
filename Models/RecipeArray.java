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
public class RecipeArray {

    private static RecipeArray RECIPE_ARRAY_INSTANCE = new RecipeArray();
    private Recipe[] recipes;
    private int FLAG;
    public static final int FROM_SEARCH = 0;
    private static final int FROM_SAVED = 1;

    RecipeArray(){
    }

    RecipeArray(Recipe[] _array, int _flag){
        this.recipes = _array;
        this.FLAG = _flag;
    }

    public Recipe[] getRecipes(){
        return this.recipes;
    }

    public int getFlag(){
        return this.FLAG;
    }

    public static RecipeArray getInstance(){
        return RECIPE_ARRAY_INSTANCE;
    }

    public void setRecipes(Recipe[] _recipes){
        this.recipes = _recipes;
    }

    public void setFlag(int _flag){
        this.FLAG = _flag;
    }
}
