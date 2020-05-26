package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
/**
 * this is a class for saving files operation
 * @author Alireza Ghafari
 * @version 1.0
 */
public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        String st="";
        try(FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            int input;
            while (bufferedReader.ready())
                st += (char)bufferedReader.read();
        }catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }

    public static void fileWriter(String content) {
        String fileName = getProperFileName(content);
        try(FileWriter fileWriter = new FileWriter(new File(NOTES_PATH + fileName+".txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String fileInputStream(File file) {
        String content = "";
        try (FileInputStream fis = new FileInputStream(file)) {
            byte [] bytes = fis.readAllBytes();
            for (byte b : bytes)
                content += (char)b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void fileOutPutStream(String content){
        String fileName = getProperFileName(content);
        try (FileOutputStream fos = new FileOutputStream(NOTES_PATH + fileName)) {
            byte[] bytes = fileName.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Note objectReader(File file){
        Note note=null;
        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fis)){
            note = (Note) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return note;
    }

    public static void objectWriter(Note note){
        String fileName = note.getTitle();
        try (FileOutputStream fos = new FileOutputStream(NOTES_PATH + fileName+".bin");
             ObjectOutputStream out = new ObjectOutputStream(fos)){
            out.writeObject(note);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }

}
