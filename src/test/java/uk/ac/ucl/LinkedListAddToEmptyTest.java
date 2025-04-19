package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListAddToEmptyTest {
    private LinkedList<Integer> LL;

    @BeforeEach
    public void setUp() {
        LL = new LinkedList<>();
    }

    @Test
    public void aNewLLSetShouldBeEmpty() {
        assertTrue(LL.isEmpty());
    }

    @Test
    public void afterInsertingOneElementLLShouldNotBeEmpty() {
        LL.add(5);
        assertFalse(LL.isEmpty());
    }
}
