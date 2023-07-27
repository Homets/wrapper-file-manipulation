package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*************************************************
 *    Wrapper for file manipulation function     *
 ************************************************/
public class FileUtils {
    private File file = null;
    public FileUtils(File file){
        this.file = file;
    }

    public char[] readFileChar(){
        String allFile = "";

        try {
            Scanner textParser = new Scanner(this.file);
            while (textParser.hasNextLine()){
                allFile += textParser.nextLine();
            }

            System.out.println(allFile);
            char[] fileReaded = allFile.toCharArray();
            return fileReaded;

        } catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public String readFileString(String file, int lineNumber){
        String fileReaded = null;
        int lineCount = 0;
        try {
            File fileToRead = new File(file);
            Scanner textParser = new Scanner(fileToRead);
            while (textParser.hasNextLine() && lineCount < lineNumber ){
                fileReaded.concat(textParser.nextLine());


            }
        } catch (FileNotFoundException e){
            return null;
        }
        return null;
    }
}
