package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*************************************************
 *    Wrapper for file manipulation function     *
 ************************************************/
public class FileUtils {
    public FileUtils(){

    }

    public char[] readFileChar(String file){
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
    public String readFileString(String file, int lineNumber){
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
                while (textParser.hasNextLine() && lineCount < lineNumber ){
                    fileConcatenated += textParser.nextLine();
                    lineCount++;
                }
                System.out.println(fileConcatenated);
                return fileConcatenated;
            }

        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
