/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Heng Tan
 */
public class SavedRecipesWrite {

    /**
     * This is the write for the saved recipes in a text file
     * @param args
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException {
        String data = "Hi how are you?";
        int numberOfLines = 10000;
        fileWriterWrite(data);
        
        bufferedWriter(data, numberOfLines);
        
        filesWrite(data);
        
        outputStreamWrite(data);
        System.out.println("DONE");
    }
    
    /**
     * This is to stream raw data from the text file
     * @param data
     * @throws IOException 
     */
    private static void outputStreamWrite(String data) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("/Desktop"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            os.close();
        }
    }
    
    /**
     * Internally write the files from the output stream
     * @param data 
     */
    private static void filesWrite(String data) {
        try {
            Files.write((Paths.get("/Desktop")), data.getBytes());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * This is to write with a bunch of operations and lines
     * @param data
     * @param numberOfLines 
     */
    private static void bufferedWriter(String data, int numberOfLines) {
        File file = new File("/Desktop");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String dataWithNewLine = data + System.getProperty("");
        try {
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = numberOfLines; i > 0; i--) {
            bufferedWriter.write(dataWithNewLine);
            }
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Writing when number of write operations is not a lot
     * @param data 
     */
    private static void fileWriterWrite(String data) {
        File file = new File("/Desktop");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.close();               
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
