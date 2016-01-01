import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ResourceFileTest {

    @Test
    public void getField() throws Exception {
        List lines = new ResourceFile("file/sampleResourceFile.txt").getLines();
        assertEquals(4, lines.size());
        assertEquals("This is a", lines.get(0));
        assertEquals("sample", lines.get(1));
        assertEquals("resource file.", lines.get(2));
        assertEquals("It has 4 lines.", lines.get(3));
    }
}