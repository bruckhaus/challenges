import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ResourceFile {

    private final BufferedReader bufferedReader;

    ResourceFile(String resourceFileName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        @SuppressWarnings("ConstantConditions")
        String fileName = classLoader.getResource(resourceFileName).getFile();
        if (fileName == null)
            throw new FileNotFoundException(resourceFileName + " not found");
        File resourceFile = new File(fileName);
        FileReader fileReader = new FileReader(resourceFile);
        bufferedReader = new BufferedReader(fileReader);
    }

    void close() throws IOException {
        bufferedReader.close();
    }

    List getLines() throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) lines.add(line);
        return lines;
    }

}