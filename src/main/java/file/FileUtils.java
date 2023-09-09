package file;

import java.io.*;
import java.util.Scanner;
import java.lang.IllegalArgumentException;

/*************************************************
 *    Wrapper for file manipulation function     *
 ************************************************/
public class FileUtils {
    public FileUtils(){

    }

    public static char[] readFileChar(String file){
        String fileReaded = "";
        File inputFile = new File(file);
        try {
            Scanner textParser = new Scanner(inputFile);
            while (textParser.hasNextLine()){
                fileReaded += textParser.nextLine();
            }
            textParser.close();
            return fileReaded.toCharArray();
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public static String readFileString(String file){
        String fileConcatenated = "";
        try {
            File fileToRead = new File(file);
            Scanner textParser = new Scanner(fileToRead);

            while(textParser.hasNextLine()){
                fileConcatenated += textParser.nextLine();
            }
            textParser.close();
            return fileConcatenated;

        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public static String readFileString(String file, int lineNumber){
        String fileConcatenated = "";
        int lineCount = 0;
        if(lineNumber == 0){
            return null;
        }
        try {
            File fileToRead = new File(file);
            Scanner textParser = new Scanner(fileToRead);
            while (textParser.hasNextLine() && lineCount < lineNumber ) {
                fileConcatenated += textParser.nextLine();
                lineCount++;
            }
            textParser.close();
            return fileConcatenated;

        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public static void write(String file, String stringToWrite ){
        if (stringToWrite.isEmpty()){
            throw new IllegalArgumentException("string argument is empty");
        }
        try {
            File fileToWrite = new File(file);
            PrintWriter printWriter = new PrintWriter(fileToWrite);
            printWriter.write(stringToWrite);
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void write(String file, char[] charbuf ){
        String stringToWrite = "";
        if (charbuf.length == 0){
            throw new IllegalArgumentException("string argument is empty");
        }
        for (char character : charbuf){
            stringToWrite += character;
        }
        try {
            File fileToWrite = new File(file);
            PrintWriter printWriter = new PrintWriter(fileToWrite);
            printWriter.write(stringToWrite);
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void write(String file, int integer ){
        String stringToWrite = String.valueOf(integer);
        try {
            File fileToWrite = new File(file);
            PrintWriter printWriter = new PrintWriter(fileToWrite);
            printWriter.write(stringToWrite);
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void append(String file, String string) throws IOException {
        try {
            File fileToRead = new File(file);
            FileWriter fileWriter = new FileWriter(fileToRead, true);
            fileWriter.append(string);
            fileWriter.close();
        } catch (IOException e){
            throw new IOException("Cannot open you're file");
        }
    }

    //charbuf
    public static void append(String file, char[] charbuf) throws IOException {
        try {
            String stringToAppend = "";
            File fileToRead = new File(file);
            FileWriter fileWriter = new FileWriter(fileToRead, true);
            for (Character c : charbuf){
                stringToAppend += c;
            }
            fileWriter.append(stringToAppend);
            fileWriter.close();
        } catch (IOException e){
            throw new IOException("Cannot open you're file");
        }
    }

    public static void append(String file, int integer) throws IOException {
        String stringToAppend = String.valueOf(integer);
        try {
            File fileToRead = new File(file);
            FileWriter fileWriter = new FileWriter(fileToRead, true);
            fileWriter.append(stringToAppend);
            fileWriter.close();
        } catch (IOException e){
            throw new IOException("Cannot open you're file");
        }


    }

    public static void clean(String file) throws IOException {
        try {
            File fileToRead = new File(file);
            PrintWriter pw = new PrintWriter(file);
            pw.close();
        } catch (IOException e){
            throw new IOException("Cannot open you're file");
        }


    }

}
