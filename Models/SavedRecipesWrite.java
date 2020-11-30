package Models;

/**
 * This class is to write the text files and save it into the text file
 *
 * @author Heng Tan
 *
 * Last Updated 11/29/2020
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

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

            Files.list(Paths.get(".")).forEach(System.out::println);
            String separator = System.getProperty("file.separator");
            String file = "src" + separator + "RecipeSaver.txt";
            FileWriter fileWriter = new FileWriter(file, true);
            try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                PrintWriter pw = new PrintWriter(fileWriter);
                String string = _recipe.getTitle() + "::" + _recipe.getUrl() + "::" + _recipe.getID() + "::" + "true" + "\n";
                pw.append(string);
                System.out.println("New recipes added!");

                return true;
            } catch (IOException ex) {
                System.out.println("Error!" + ex);
            }

            System.out.println("The file does not exist.");
            return false;
        }
        System.out.println("Recipe is already exists in the saved recipes");
        return false;
    }
}
