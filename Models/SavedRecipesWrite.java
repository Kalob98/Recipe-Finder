package Models;

/**
 * This class is to write the text files and save it into the text file
 *
 * @author Heng Tan
 *
 * Last Updated 11/30/2020
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavedRecipesWrite {

    /**
     * This is the write for the saved recipes in a text file
     *
     * @param _recipe
     * @return
     * @throws IOException
     */
    public static boolean write(Recipe _recipe) throws IOException {

        if (_recipe.getIsSaved() == false) {

            String separator = System.getProperty("file.separator");
            String file = "src" + separator + "RecipeSaver.txt";
            FileWriter fileWriter = new FileWriter(file, true);

            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                PrintWriter pw = new PrintWriter(fileWriter);
                String string = _recipe.getTitle() + "::" + _recipe.getUrl() + "::" + _recipe.getID() + "::" + "true" + "\n";
                pw.append(string);
                System.out.println("New recipes added!");

                return true;
            }
            catch (IOException ex) {
                System.out.println("Error!" + ex);
            }

            System.out.println("The file does not exist.");
            return false;
        }
        System.out.println("Recipe already exists in your saved recipes");
        return false;
    }
}
