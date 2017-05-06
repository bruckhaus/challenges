import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FuzzySearch {
// Implement a fuzzy search like the path search on Github, where a path matches a pattern if all characters in the
// pattern appear in the same order in the path.  Return all matching paths in a path catalog.
// E.g., pattern "tilmann" matches path "java_challenges/out/production/java_challenges/RomanNumeral.class"
//                                                         ^        ^           ^         ^^^^


    private static final String FILE_CATALOG_FILE = "file/files.txt";
    private List FILE_CATALOG;

    FuzzySearch(String catalogFile) throws IOException {
        FILE_CATALOG = new ResourceFile(catalogFile).getLines();
    }

    public static void main(String[] args) throws IOException {
        FuzzySearch fuzzy = new FuzzySearch(FILE_CATALOG_FILE);
        String input = "tilmann";
        List matches = fuzzy.getMatches(input);
        System.out.printf("\"%s\" matches:\n%s\n", input, matches);
    }

    List getMatches(String pattern) {
        List<String> result = new ArrayList<>();
        for (Object item : FILE_CATALOG) {
            String path = item.toString();
            if (isMatch(path, pattern)) result.add(path);
        }
        return result;
    }

    static boolean isMatch(String path, String pattern) {
        path = path.toLowerCase();
        pattern = pattern.toLowerCase();
        int i = 0;
        int j = 0;
        while (i < path.length() && j < pattern.length()) {
            if (path.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == pattern.length();
    }
}
