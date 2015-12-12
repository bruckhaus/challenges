public abstract class Polygonal {
    protected long index = 0;
    protected long current = 0;

    public void reset() {
        index = 0;
        current = 0;
    }

    public long current() {
        return current;
    }

    public void incrementIndex() {
        index++;
    }

    public abstract long next();

    public boolean isPentagonal(long number) {
        long savedIndex = index;
        long savedCurrent = current;
        reset();
        while (current() <= number) next();
        boolean result = current() == number;
        index = savedIndex;
        current = savedCurrent;
        return result;
    }
}

class Triangular extends Polygonal {
    @Override
    public long next() {
        incrementIndex();
        current = index * (index + 1) / 2;
        return current;
    }
}

class Pentagonal extends Polygonal {
    @Override
    public long next() {
        incrementIndex();
        current = index * (3 * index - 1) / 2;
        return current;
    }
}

class Hexagonal extends Pentagonal {
    @Override
    public long next() {
        incrementIndex();
        current = index * (2 * index - 1);
        return current;
    }
}
