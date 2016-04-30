import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.*;

class Prime1stMillion extends Prime {

    // http://www.naturalnumbers.org/primes.html
    private static final String PRIME_1ST_MILLION_FILE = "file/P-1000000.txt";
    private static final int MAX_INDEX = 1000000 - 1;
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
    public Set<Long> getPrimeFactorSet(long number) {
        Set<Long> primeFactorSet = new TreeSet<>();
        int index = 1;
        long prime = this.get(index);
        while (number > 1) {
            if (number % prime == 0) {
                primeFactorSet.add(prime);
                number /= prime;
            } else {
                index++;
                prime = this.get(index);
            }
        }
        return primeFactorSet;
    }

    @Override
    public Boolean isPrime(long tested) {
        if (isCached(tested)) return primeSet.contains(tested);
        return Prime.checkPrime(tested);
    }

    private boolean isCached(long tested) {
        return tested <= primes.get(MAX_INDEX);
    }

    @Override
    public long get(int index) {
        return primes.get(index - 1);
    }
}
