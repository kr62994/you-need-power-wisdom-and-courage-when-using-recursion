package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleNumberCalculatorTest {
    private TriangleNumberCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TriangleNumberCalculator();
    }

    @Test
    void calculatesTriangularNumbers() {
        assertEquals(1, calculator.value(1));
        assertEquals(3, calculator.value(2));
        assertEquals(6, calculator.value(3));
        assertEquals(10, calculator.value(4));
        assertEquals(5050, calculator.value(100));
    }

    @Test
    void addsTriangularNumbers() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(9, calculator.add(2, 3));
        assertEquals(13, calculator.add(4, 2));
    }

    @Test
    void subtractsTriangularNumbers() {
        assertEquals(0, calculator.subtract(1, 1));
        assertEquals(-3, calculator.subtract(2, 3));
        assertEquals(7, calculator.subtract(4, 2));
    }

    @Test
    void acceptsZero() {
        assertEquals(0, calculator.value(0));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(6, calculator.add(0, 3));
        assertEquals(6, calculator.add(3, 0));
        assertEquals(0, calculator.subtract(0, 0));
        assertEquals(-6, calculator.subtract(0, 3));
        assertEquals(6, calculator.subtract(3, 0));
    }

    @Test
    void rejectsNegativeIndices() {
        assertThrows(IllegalArgumentException.class, () -> calculator.value(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.value(Integer.MIN_VALUE));
        assertThrows(IllegalArgumentException.class, () -> calculator.add(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> calculator.add(2, -1));
        assertThrows(IllegalArgumentException.class, () -> calculator.subtract(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> calculator.subtract(2, -1));
    }
}
