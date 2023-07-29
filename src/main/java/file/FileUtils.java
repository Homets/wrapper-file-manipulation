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
            return fileReaded.toCharArray();
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    //0 in lineNumber return all the file
    public static String readFileString(String file, int lineNumber){
        String fileConcatenated = "";
        int lineCount = 0;
        try {
            File fileToRead = new File(file);
            Scanner textParser = new Scanner(fileToRead);
            if(lineNumber == 0){
                while (textParser.hasNextLine()){
                    fileConcatenated += textParser.nextLine();
                }
                return fileConcatenated;
            } else {
                while (textParser.hasNextLine() && lineCount < lineNumber ) {
                    fileConcatenated += textParser.nextLine();
                    lineCount++;
                }
                return fileConcatenated;
            }
        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public static void writeString(String file, String stringToWrite ){
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

    public static void appendString(String file, String stringToAppend) throws IOException {
        try {
            File fileToRead = new File(file);
            FileWriter fileWriter = new FileWriter(fileToRead, true);
            fileWriter.append(stringToAppend);
            fileWriter.close();
        } catch (IOException e){
            throw new IOException("Cannot open you're file");
        }
    }

}
