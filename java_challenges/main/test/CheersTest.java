import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CheersTest {
    Cheers cheers;

    @BeforeEach
    void beforeEach() {
        cheers = new Cheers();
    }

    @Test
    void testReportCheers() {
        String[] motes = {"cheers", "nice"};

        String messages = "cheers10 cheers5, cheers10";
        String expected = "cheers:25";
        String result = cheers.reportCheers(1, messages, motes);
        assertEquals(expected, result);

        messages = "Wow!! Nic job. cheers10 cheers5, cheers10 nice10, nice5, cheers45 nice nice40 cool! nice10";
        expected = "cheers:70,nice:65";
        result = cheers.reportCheers(1, messages, motes);
        assertEquals(expected, result);
    }

    @Test
    void testGetReport() {
        HashMap<String, Integer> moteCounts = new HashMap<>();
        moteCounts.put("a", 10);
        moteCounts.put("b", 15);
        String expected = "a:10,b:15";
        String result = cheers.getReport(moteCounts);
        assertEquals(expected, result);
    }

    @Test
    void testAddPartMoteCounts() {
        HashMap<String, Integer> moteCounts = new HashMap<>();
        moteCounts.put("a", 10);
        moteCounts.put("b", 15);
        HashMap<String, Integer> partMoteCounts = new HashMap<>();
        partMoteCounts.put("a", 17);
        partMoteCounts.put("b", 155);
        cheers.addPartMoteCounts(partMoteCounts, moteCounts);
        String result = cheers.getReport(moteCounts);
        String expected = "a:27,b:170";
        assertEquals(expected, result);
    }
}