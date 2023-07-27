
import file.FileUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;

import java.io.File;

public class FileUtilsTest {
    File stringFile = new File("src/test/fileResources/testReadChar");
    private final FileUtils fileUtils = new FileUtils(stringFile);

    @Order(1)
    @Tag("read")
    @DisplayName("Read a file and return char array")
    @Test
    void readFileChar(){
        char[] fileReaded = fileUtils.readFileChar();
        assertEquals(18, fileReaded.length);
    }
}
