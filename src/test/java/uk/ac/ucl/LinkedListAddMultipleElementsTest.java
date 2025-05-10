package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListAddMultipleElementsTest {
    LinkedList<Integer> LL;
    java.util.LinkedList<Integer> LL2;
    @BeforeEach
    public void setUp() {
        LL = new LinkedList<>();
        int[] vals = {1,2,3,4,5,532,2};
        for (int val : vals) LL.add(val);
    }

    @Test
    public void headIsPreservedWhenMultipleElementsAreAdded(){
        assertEquals(1, (int) LL.getHead());
    }
}
