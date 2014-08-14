import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class FuzzySearch {

    private List<String> FILE_CATALOG = new ArrayList<>();

    public FuzzySearch() throws IOException {
        Path catalogFile = FileSystems.getDefault().getPath("test/resources", "files.txt");
        FILE_CATALOG = Files.readAllLines(catalogFile, StandardCharsets.UTF_8);
    }

    public String[] find(String pattern) {
        String s = FILE_CATALOG.get(0);
        System.out.println("s = " + s);
        return new String[]{};
    }
}