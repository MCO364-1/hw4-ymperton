package mco364;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameOfLifeTest {
    /**
     * Picking random points to test upon.
     */
    @Test
    public void testIsAliveNextGeneration() {
        GameOfLife g = new GameOfLife(0); //blinker
        assertFalse(g.isAliveNextGeneration(0, 0));
        assertTrue(g.isAliveNextGeneration(1, 2));
        assertFalse(g.isAliveNextGeneration(2, 1));
    }

    @Test
    public void testNeighbourCount() {
        GameOfLife g = new GameOfLife(0);
        assertEquals(3, g.neighborCount(1, 2));
        assertEquals(2, g.neighborCount(1, 1));
        assertEquals(1, g.neighborCount(2, 0));
    }

}
