package Models;

/**
 * This class is to read, delete and copies the text file, where only one text
 * file will show
 *
 * @author Heng Tan
 *
 * Last Updated 11/30/2020
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SavedRecipesRead {

    private static final int idLoc = 2;

    /**
     * Method used to determine if a recipe has already been saved. (method not
     * in use).
     *
     * @return
     * @throws IOException
     */
    public static Recipe[] getSavedRecipes() throws IOException {
        ArrayList<Recipe> recipe = new ArrayList<Recipe>();

        // Name of the file to open
        String separator = System.getProperty("file.separator");
        String file = "src" + separator + "RecipeSaver.txt";

        // Referencing one line at a time
        String line;

        // FileReader reads text files
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Always wrap FileReader in BufferedReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            if ((line = br.readLine()) != null) {
                while (line != null) {

                    //Create new recipe from parameter separated by commas
                    List<String> list = Arrays.asList(line.split("::"));

                    //Insert into arraylist
                    recipe.add(new Recipe(list.get(0), list.get(1), list.get(2), true));

                    line = br.readLine();
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            // Always closing the file
            bufferedReader.close();
        }
        catch (IOException ex) {
            Logger.getLogger(SavedRecipesRead.class.getName()).log(Level.SEVERE, null, ex);
        }

        Recipe[] recipes = new Recipe[recipe.size()];
        recipes = recipe.toArray(recipes);

        return recipes;
    }

    /**
     * Method used to delete saved recipe.
     *
     * @param _file
     * @param _remove
     * @param _delimiter
     * @throws IOException
     */
    public static void delete(String _file, String _remove, String _delimiter) throws IOException {

        String separator = System.getProperty("file.separator");

        //temp file created to keep RecipeSaver.txt clean
        String _tempFile = "src" + separator + "temp.txt";
        File newFile = new File(_tempFile);

        String line;
        String data[];

        try {
            FileWriter fileWriter = new FileWriter(_tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileReader fileReader = new FileReader(_file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                data = line.split("::");

                if (data[idLoc].equalsIgnoreCase(_remove)) {

                }
                else {
                    printWriter.println(line);
                }
            }

            //closing everything
            printWriter.flush();
            printWriter.close();
            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            fileWriter.close();

        }
        catch (IOException ex) {
            System.out.println("Error, File is not found!");
        }

        //calls the copyingFile method
        copyingFile(newFile, new File(_file));

        //deleting temp.txt
        newFile.delete();
    }

    /**
     * Copies temp.txt to RecipeSaver.txt.
     *
     * @param _source
     * @param _location
     * @throws IOException
     */
    private static void copyingFile(File _source, File _destination) throws IOException {
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(_source).getChannel();
            destination = new FileOutputStream(_destination).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            source.close();
            destination.close();
        }
    }

    /**
     * Gets the path of the txt file.
     *
     * @return
     */
    public static String getFilePathToTextFile() {
        String separator = System.getProperty("file.separator");
        String _tempFile = "src" + separator + "RecipeSaver.txt";

        return _tempFile;
    }
}
