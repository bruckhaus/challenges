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

    public abstract long next();

    public void incrementIndex() {
        index++;
    }
}

class Triangular extends Polygonal {
    public long next() {
        incrementIndex();
        current = index * (index + 1) / 2;
        return current;
    }
}

class Pentagonal extends Polygonal {
    public long next() {
        incrementIndex();
        current = index * (3 * index - 1) / 2;
        return current;
    }
}

class Hexagonal extends Pentagonal {
    public long next() {
        incrementIndex();
        current = index * (2 * index - 1);
        return current;
    }
}

