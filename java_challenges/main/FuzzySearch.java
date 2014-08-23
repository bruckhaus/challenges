import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FuzzySearch {

    public static final String FILE_CATALOG_FILENAME = "files.txt";
    public static final String FILE_CATALOG_FILE = "test/resources";
    private List<String> FILE_CATALOG = new ArrayList<>();
    private static final HashMap<String, String[]> LOOKUP = new HashMap<>();

    public FuzzySearch() throws IOException {
        populateFileCatalog();

        String fileName = "java_challenges/Hanoi/src/CharacterDisplay.java";
        populateSearchTree(fileName, fileName);

//        for (String fileName : FILE_CATALOG) {
//            populateSearchTree(fileName, fileName);
//            System.out.println();
//        }
    }

    private void populateSearchTree(String partialName, String fileName) {
        boolean found = LOOKUP.containsKey(partialName);
        if (found) {
            String[] fileList = LOOKUP.get(partialName);
            if (!fileList[fileList.length - 1].equals(fileName)) {
                System.out.println("partialName = " + partialName);
                fileList[fileList.length] = fileName;
                LOOKUP.put(partialName, fileList);
            }
        } else {
            System.out.println("partialName = " + partialName);
            LOOKUP.put(partialName, new String[]{fileName});
            for (int i = 0; i < partialName.length(); i++) {
                String front = (i == 0) ? "" : partialName.substring(0, i);
                String back = (i >= partialName.length() - 1) ? "" : partialName.substring(i + 1, partialName.length());
                if (partialName.length() > 1) {
                    populateSearchTree(front + back, fileName);
                }
            }
        }
    }

    private void populateFileCatalog() throws IOException {
        Path catalogFile = FileSystems.getDefault().getPath(FILE_CATALOG_FILE, FILE_CATALOG_FILENAME);
        FILE_CATALOG = Files.readAllLines(catalogFile, StandardCharsets.UTF_8);
    }

    public String[] find(String pattern) {
        String s = FILE_CATALOG.get(0);
        System.out.println("s = " + s);
        return new String[]{};
    }
}