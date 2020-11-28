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

        messages = "Wow!! Nic job. cheers10 cheers5, cheers10 nice10, nice5, cheers45 nice nice40 cool! nice10";
        expected = "cheers:55,nice:60";
        result = cheers.reportCheers(10, messages, motes);
        assertEquals(expected, result);

        messages = "Wow!! Nic job. cheers10 cheers5, cheers10 nice10, nice40 nice55555 cheers4, nice nice40 nice10";
        expected = "cheers:25,nice:60";
        result = cheers.reportCheers(1, messages, motes);
        assertEquals(expected, result);

        messages = "Wow!! Nic job, nice job, I want to see that again!";
        expected = "NO CHEERS";
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

    @Test
    void testGetPartMoteCounts() {
        assertEquals(0, cheers.partMoteCounts.size());
        boolean valid = cheers.getPartMoteCounts("Wow!! Nice job. cheers10 cheers5");
        assertTrue(valid);
        assertEquals(1, cheers.partMoteCounts.size());
        assertEquals(15, cheers.partMoteCounts.get("cheers"));
        valid = cheers.getPartMoteCounts("super game win15. you rocked star20 cheers10");
        assertTrue(valid);
        assertEquals(3, cheers.partMoteCounts.size());
        assertEquals(25, cheers.partMoteCounts.get("cheers"));
        assertEquals(20, cheers.partMoteCounts.get("star"));
        assertEquals(15, cheers.partMoteCounts.get("win"));
        assertFalse(cheers.partMoteCounts.containsKey("super"));
    }

    @Test
    void testGetMote() {
        Cheers.Mote mote = cheers.getMote("cheers15");
        assertEquals("cheers", mote.word);
        assertEquals(15, mote.count);
        mote = cheers.getMote("cheers15dd");
        assertEquals("", mote.word);
        assertEquals(0, mote.count);
    }

    @Test
    void testAddPartMoteCount() {
        assertEquals(0, cheers.partMoteCounts.size());
        cheers.addPartMoteCount(new Cheers.Mote("big", 99));
        assertEquals(1, cheers.partMoteCounts.size());
        assertEquals(99, cheers.partMoteCounts.get("big"));

        cheers.addPartMoteCount(new Cheers.Mote("smol", 5));
        cheers.addPartMoteCount(new Cheers.Mote("big", 4));
        assertEquals(2, cheers.partMoteCounts.size());
        assertEquals(103, cheers.partMoteCounts.get("big"));
        assertEquals(5, cheers.partMoteCounts.get("smol"));
    }

    @Test
    void testInitMotes() {
        assertEquals(0, cheers.moteCounts.size());
        String[] motes = {"yo", "cheers", "yay", "wow"};
        cheers.initMotes(motes);
        assertEquals(4, cheers.moteCounts.size());
        assertFalse(cheers.moteCounts.containsKey("USA"));
        assertEquals(0, cheers.moteCounts.get("yo"));
        assertEquals(0, cheers.moteCounts.get("cheers"));
        assertEquals(0, cheers.moteCounts.get("yay"));
        assertEquals(0, cheers.moteCounts.get("wow"));
    }

    @Test
    void testMote() {
        Cheers.Mote mote = new Cheers.Mote();
        assertEquals("", mote.word);
        assertEquals(0, mote.count);
        mote = new Cheers.Mote("babel", 19);
        assertEquals("babel", mote.word);
        assertEquals(19, mote.count);
    }
}
