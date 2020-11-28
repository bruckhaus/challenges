import java.util.HashMap;
import java.util.Map;

public class Cheers {
    @SuppressWarnings("FieldCanBeLocal")
    private final int MAX_PIXELS = 10000;
    HashMap<String, Integer> moteCounts = new HashMap<>();
    HashMap<String, Integer> partMoteCounts = new HashMap<>();
    private int minPixels;

    public String reportCheers(int minPixels, String messages, String[] motes) {
        boolean valid;
        this.minPixels = minPixels;
        initMotes(motes);
        String[] parts = messages.split(",");
        for (String part : parts) {
            partMoteCounts.clear();
            valid = getPartMoteCounts(part);
            if (valid) {
                addPartMoteCounts(partMoteCounts, moteCounts);
            }
        }
        return getReport(moteCounts);
    }

    public boolean getPartMoteCounts(String part) {
        Mote mote;
        String[] words = part.split("[ ,.;:!?]");

        for (String word : words) {
            mote = getMote(word);
            if (mote.count > 0) {
                if (mote.count < minPixels || mote.count > MAX_PIXELS) {
                    return false;
                }
                addPartMoteCount(mote);
            }
        }
        return true;
    }

    public Mote getMote(String word) {
        Mote mote = new Mote();
        int i = word.length() - 1;
        StringBuilder numStr = new StringBuilder();
        while (i >= 0 && word.charAt(i) >= '0' && word.charAt(i) <= '9') {
            numStr.insert(0, word.charAt(i));
            i--;
        }
        if (numStr.length() > 0) {
            mote.count = Integer.parseInt(numStr.toString());
            mote.word = word.substring(0, i + 1);
        }
        return mote;
    }

    public void addPartMoteCount(Mote mote) {
        int newCount;
        if (partMoteCounts.containsKey(mote.word)) {
            newCount = partMoteCounts.get(mote.word) + mote.count;
        } else {
            newCount = mote.count;
        }
        partMoteCounts.put(mote.word, newCount);
    }

    public void addPartMoteCounts(HashMap<String, Integer> partMoteCounts, HashMap<String, Integer> moteCounts) {
        int newCount;
        for (Map.Entry<String, Integer> entry : partMoteCounts.entrySet()) {
            String mote = entry.getKey();
            Integer count = entry.getValue();
            if (moteCounts.containsKey(mote)) {
                newCount = moteCounts.get(mote) + count;
            } else {
                newCount = count;
            }
            moteCounts.put(mote, newCount);
        }
    }

    public void initMotes(String[] motes) {
        for (String mote : motes) {
            moteCounts.put(mote, 0);
        }
    }

    public String getReport(HashMap<String, Integer> moteCounts) {
        StringBuilder report = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Integer> entry : moteCounts.entrySet()) {
            Integer count = entry.getValue();
            if (count >  0) {
                if (!first) {
                    report.append(",");
                }
                String mote = entry.getKey();
                report.append(mote).append(":").append(count);
                first = false;
            }
        }
        if (report.toString().equals("")) {
            return("NO CHEERS");
        } else {
            return report.toString();
        }
    }

    static class Mote {
        String word = "";
        int count = 0;

        public Mote(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public Mote() {
        }
    }
}
