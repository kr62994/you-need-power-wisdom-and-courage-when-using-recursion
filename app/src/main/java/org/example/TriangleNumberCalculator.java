package org.example;

public class TriangleNumberCalculator {
    public int value(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        if (n == 0) {
            return 0;
        }
        return n + value(n - 1);
    }

    public int add(int n, int m) {
        return value(n) + value(m);
    }

    public int subtract(int n, int m) {
        return value(n) - value(m);
    }

    public int multiply(int n, int m) {
        return value(n) * value(m);
    }
}
