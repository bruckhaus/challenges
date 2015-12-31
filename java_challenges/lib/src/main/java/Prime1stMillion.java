import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Prime1stMillion extends Prime {

    // file credit: http://www.naturalnumbers.org/primes.html
    private static final String PRIME_1ST_MILLION_FILE = "file/P-1000000.txt";
    //    private final String PRIME_1ST_MILLION = Prime1stMillion.class.getClass().getResource("/textfiles/myfile.txt");

    private final List<Long> primes;

    Prime1stMillion() throws IOException {
        primes = new ArrayList<>();
        getPrimesFromFile();
    }

    private void getPrimesFromFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(PRIME_1ST_MILLION_FILE).getFile());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        readAndParseLines(bufferedReader);
        bufferedReader.close();
    }

    private void readAndParseLines(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) parseLine(line);
    }

    private void parseLine(String line) {
        String[] fields = StringUtils.splitString(line, ", ");
        primes.add(Long.parseLong(fields[1]));
    }

    @Override
    public Boolean isPrime(long tested) {
        return primes.contains(tested);
    }

    @Override
    public long get(int index) {
        return primes.get(index - 1);
    }
}
