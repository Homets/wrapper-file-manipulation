
import file.FileUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;

public class FileUtilsTest {
    //File gnuFile
    private final FileUtils utilsBaudelaire = new FileUtils();


    @Order(1)
    @Tag("read")
    @DisplayName("Read a file and return char array")
    @Test
    void readFileChar(){
        char[] fileReaded = utilsBaudelaire.readFileChar("src/test/fileResources/baudelaireFile");
        assertEquals(146, fileReaded.length);
        assertEquals(fileReaded[0], 'V');
        assertEquals(fileReaded[45], ';');
        assertEquals(fileReaded[72], 'p');
        assertEquals(fileReaded[145], '.');

        fileReaded = utilsBaudelaire.readFileChar("src/test/fileResources/gnuFile");
        assertEquals(325, fileReaded.length);
        assertEquals(fileReaded[0], 'T');
        assertEquals(fileReaded[37], 'w');
        assertEquals(fileReaded[324], 'd');

    }
    @Order(2)
    @Tag("read")
    @DisplayName("Read a file and return string array")
    @Test
    void readFileString(){
        String fileReaded = utilsBaudelaire.readFileString("src/test/fileResources/baudelaireFile", 0);
        assertEquals(146, fileReaded.length());
        assertEquals('V',fileReaded.charAt(0));
        assertEquals(';',fileReaded.charAt(45));
        assertEquals('p',fileReaded.charAt(72));
        assertEquals('.',fileReaded.charAt(145));

        fileReaded = utilsBaudelaire.readFileString("src/test/fileResources/gnuFile",1);
        assertEquals(138, fileReaded.length());
        assertEquals( 'T',fileReaded.charAt(0));
        assertEquals('w', fileReaded.charAt(37));
        assertEquals( '.', fileReaded.charAt(137)); //138 not 139 like wc because we delete newline character
    }
}
