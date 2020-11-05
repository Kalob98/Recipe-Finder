package utils;

/**
 * Class that creates a list of all cuisines spoonacular API offers to add to
 * the cuisine choiceBox. The cuisine choiceBox can be left blank/null
 *
 * @author Kalob Reinholz
 *
 * Last updated 10/20/20
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cuisines {

    public static ObservableList loadCuisines() {
        ObservableList<String> cuisineOptions = FXCollections.observableArrayList();
        
        cuisineOptions.removeAll(cuisineOptions);

        String NULL = "";
        String African = "African";
        String American = "American";
        String British = "British";
        String Cajun = "Cajun";
        String Caribbean = "Caribbean";
        String Chinese = "Chinese";
        String EasternEuropean = "Eastern European";
        String European = "European";
        String French = "French";
        String German = "German";
        String Greek = "Greek";
        String Indian = "Indian";
        String Irish = "Irish";
        String Italian = "Italian";
        String Japanese = "Japanese";
        String Jewish = "Jewish";
        String Korean = "Korean";
        String LatinAmerican = "Latin American";
        String Mediterranean = "Mediterranean";
        String Mexican = "Mexican";
        String MiddleEastern = "Middle Eastern";
        String Nordic = "Nordic";
        String Southern = "Southern";
        String Spanish = "Spanish";
        String Thai = "Thai";
        String Vietnamese = "Vietnamese";
        
        cuisineOptions.addAll(NULL, African, American, British, Cajun, Caribbean, 
                Chinese, EasternEuropean, European, French, German, Greek, 
                Indian, Irish, Italian, Japanese, Jewish, Korean, LatinAmerican, 
                Mediterranean, Mexican, MiddleEastern, Nordic, Southern, 
                Spanish, Thai, Vietnamese);
        
        return cuisineOptions;
    }
}
