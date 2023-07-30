
import file.FileUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class FileUtilsTest {

    @Order(1)
    @Tag("read")
    @DisplayName("Read a file and return char array")
    @Test
    void readFileChar(){
        char[] fileReaded = FileUtils.readFileChar("src/test/fileResources/baudelaireFile");
        assertEquals(146, fileReaded.length);
        assertEquals(fileReaded[0], 'V');
        assertEquals(fileReaded[45], ';');
        assertEquals(fileReaded[72], 'p');
        assertEquals(fileReaded[145], '.');

        fileReaded = FileUtils.readFileChar("src/test/fileResources/gnuFile");
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
        String fileReaded = FileUtils.readFileString("src/test/fileResources/baudelaireFile", 0);
        assertEquals(146, fileReaded.length());
        assertEquals('V',fileReaded.charAt(0));
        assertEquals(';',fileReaded.charAt(45));
        assertEquals('p',fileReaded.charAt(72));
        assertEquals('.',fileReaded.charAt(145));

        fileReaded = FileUtils.readFileString("src/test/fileResources/gnuFile",1);
        assertEquals(138, fileReaded.length());
        assertEquals( 'T',fileReaded.charAt(0));
        assertEquals('w', fileReaded.charAt(37));
        assertEquals( '.', fileReaded.charAt(137)); //138 not 139 like wc because we delete newline character
    }

    @Order(3)
    @Tag("write")
    @DisplayName("delete all content of a file and write to it")
    @Test
    void writeString(){
        FileUtils.writeString("src/test/fileResources/writeFile", "write");
        String fileReaded = FileUtils.readFileString("src/test/fileResources/writeFile",0);
        assertEquals(5, fileReaded.length());
        assertThrows(IllegalArgumentException.class, () -> {
            FileUtils.writeString("src/test/fileResources/writeFile", "");
        });
    }

    @Order(4)
    @Tag("write")
    @DisplayName("Append string to a file")
    @Test
    void appendString() throws IOException {
        FileUtils.writeString("src/test/fileResources/appendFile", "write");
        String fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(5, fileReaded.length());
        assertThrows(IllegalArgumentException.class, () -> {
            FileUtils.writeString("src/test/fileResources/appendFile", "");
        });
        FileUtils.append("src/test/fileResources/appendFile", " and append");
        fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(16, fileReaded.length());

    }

    @Order(5)
    @Tag("write")
    @DisplayName("Append char buffer to a file")
    @Test
    void appendStringWithCharBuf() throws IOException {
        FileUtils.writeString("src/test/fileResources/appendFile", "write");
        String fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(5, fileReaded.length());
        assertThrows(IllegalArgumentException.class, () -> {
            FileUtils.writeString("src/test/fileResources/appendFile", "");
        });
        char[] charbuf = {' ', 'a','n','d',' ','a','p','p','e','n','d'};
        FileUtils.append("src/test/fileResources/appendFile", charbuf);
        fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(16, fileReaded.length());

    }
    @Order(6)
    @Tag("write")
    @DisplayName("Append integer to a file")
    @Test
    void appendStringWithInteger() throws IOException {
        FileUtils.writeString("src/test/fileResources/appendFile", "write");
        String fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(5, fileReaded.length());
        assertThrows(IllegalArgumentException.class, () -> {
            FileUtils.writeString("src/test/fileResources/appendFile", "");
        });
        FileUtils.append("src/test/fileResources/appendFile", 65);
        fileReaded = FileUtils.readFileString("src/test/fileResources/appendFile",0);
        assertEquals(7, fileReaded.length());

    }


}
