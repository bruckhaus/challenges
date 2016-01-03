import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Prime1stMillion extends Prime {

    // http://www.naturalnumbers.org/primes.html
    private static final String PRIME_1ST_MILLION_FILE = "file/P-1000000.txt";
    private List<Long> primes;
    private Set<Long> primeSet;

    Prime1stMillion() throws IOException {
        ResourceFile primeFile = new ResourceFile(PRIME_1ST_MILLION_FILE);
        addPrimes(primeFile.getLines());
        primeFile.close();
    }

    private void addPrimes(List items) {
        primes = new ArrayList<>();
        primeSet = new HashSet<>();
        for (Object item : items) {
            String line = String.valueOf(item);
            long prime = getPrime(line);
            primes.add(prime);
            primeSet.add(prime);
        }
    }

    private long getPrime(String line) {
        String[] fields = StringUtils.splitString(line, ", ");
        return Long.parseLong(fields[1]);
    }

    @Override
    public Boolean isPrime(long tested) {
        return primeSet.contains(tested);
    }

    @Override
    public long get(int index) {
        return primes.get(index - 1);
    }
}
