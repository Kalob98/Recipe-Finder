/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is to read the text files that are saved in the desktop
 * 
 * @author Heng Tan
 * 
 * Last Updated 11/19/2020
 */
public class SavedRecipesRead {

    public static void main(String args[]) {
        // Name of the file to open
        String file = "/Desktop";
        // Referencing one line at a time
        String line = null;
        // FileReader reads text files 
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Always wrap FileReader in BufferedReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Always closing the file
            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
