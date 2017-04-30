abstract class Polygonal {
    private long index = 0;
    protected long current = 0;

    public abstract long function(long index);

    long reset() {
        index = 0;
        current = 0;
        return current;
    }

    public long current() {
        return current;
    }

    public long next() {
        index++;
        current = function(index);
        return current;
    }

    boolean isPolygonal(long number) {
        long index = 1;
        while (function(index) < number) index++;
        return function(index) == number;
    }
}

class Triangular extends Polygonal {
    // Triangle	 	P3,n=n(n+1)/2	 	    1, 3, 6, 10, 15, ...
    public long function(long n) {
        return n * (n + 1) / 2;
    }
}

class Square extends Polygonal {
    // Square	 	P4,n=n2	 	            1, 4, 9, 16, 25, ...
    public long function(long n) {
        return n * n;
    }
}

class Pentagonal extends Polygonal {
    // Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
    public long function(long n) {
        return n * (3 * n - 1) / 2;
    }
}

class Hexagonal extends Polygonal {
    // Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
    public long function(long n) {
        return n * (2 * n - 1);
    }
}

class Heptagonal extends Polygonal {
    // Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
    public long function(long n) {
        return n * (5 * n - 3) / 2;
    }
}

class Octagonal extends Polygonal {
    // Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
    public long function(long n) {
        return n * (3 * n - 2);
    }
}
