package Models;

/**
 * This class is to read, delete and copies the text file, where only one text
 * file will show
 *
 * @author Heng Tan
 *
 * Last Updated 11/29/2020
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SavedRecipesRead {

    public static Recipe[] getSavedRecipes() throws IOException {
        ArrayList<Recipe> recipe = new ArrayList<Recipe>();
        //Files.list(Paths.get(".")).forEach(System.out::println);
        // Name of the file to open
        String separator = System.getProperty("file.separator");
        String file = "src" + separator + "RecipeSaver.txt";
        // Referencing one line at a time
        String line;
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
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (!br.ready()) {
                throw new IOException();
            }
            while ((line = br.readLine()) != null) {
                //Create new recipe from parameter separated by commas
                List<String> list = Arrays.asList(line.split("::"));
                //Insert into arraylist
                //recipe.add(new Recipe(list.get(0), list.get(1), list.get(2), Boolean.parseBoolean(list.get(3))));
                recipe.add(new Recipe(list.get(0), list.get(1), list.get(2), true));

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
        Recipe[] recipes = new Recipe[recipe.size()];
        recipes = recipe.toArray(recipes);

        return recipes;
    }

    public static void delete(String _file, String _remove, String _delimiter) throws IOException {
        //Files.list(Paths.get(".")).forEach(System.out::println);
        String separator = System.getProperty("file.separator");
        String _tempFile = "src" + separator + "RecipeSaver.txt";
        File _newFile = new File(_tempFile);

        String _line;
        String _data[];

        try {
            FileWriter _fileWriter = new FileWriter(_tempFile);
            BufferedWriter _bufferedWriter = new BufferedWriter(_fileWriter);
            PrintWriter _printWriter = new PrintWriter(_bufferedWriter);

            FileReader _fileReader = new FileReader(_file);
            BufferedReader _bufferedReader = new BufferedReader(_fileReader);

            while ((_line = _bufferedReader.readLine()) != null) {
                _data = _line.split("::");
                if (_data[2].equalsIgnoreCase(_remove)) {

                } else {
                    _printWriter.println(_line);
                }
            }

            _printWriter.flush();
            _printWriter.close();
            _fileReader.close();
            _bufferedReader.close();
            _bufferedWriter.close();
            _fileWriter.close();

            File _newFile2 = new File(_tempFile);
            File _replace = new File(_file);
            _newFile2.renameTo(_replace);
        } catch (IOException ex) {
            System.out.println("Error, File is not found!");
        }
    }

    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    public static String getFilePathToTextFile() {
        String separator = System.getProperty("file.separator");
        String _tempFile = "src" + separator + "RecipeSaver.txt";

        return _tempFile;
    }
}
