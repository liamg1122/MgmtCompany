/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: class for testing plot objects and methods
 * Due: 11/10/2023
 * Platform/compiler: ECLIPSE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: LIAM GHERSHONY
*/



import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class StudentPlotTest {

    @Test
    public void testFirstConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testSecondConstructor() {
        Plot plot = new Plot(1, 1, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(1, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot toto = new Plot(1, 2, 3, 4);
        Plot copy = new Plot(toto);
        assertEquals(toto.getX(), copy.getX());
        assertEquals(toto.getY(), copy.getY());
        assertEquals(toto.getWidth(), copy.getWidth());
        assertEquals(toto.getDepth(), copy.getDepth());
    }

    @Test
    public void testGetWidth() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(3, plot.getWidth());
    }

    @Test
    public void testGetDepth() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testGetX() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
    }
    
    @Test
    public void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        String str = "1,2,3,4";
        assertEquals(str, plot.toString());
    }

    @Test
    public void testGetY() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(2, plot.getY());
    }

    @Test
    public void testSetWidth() {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setWidth(5);
        assertEquals(5, plot.getWidth());
    }

    @Test
    public void testSetX() {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setX(33);
        assertEquals(33, plot.getX());
    }

    @Test
    public void testSetY() {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setY(22);
        assertEquals(22, plot.getY());
    }

    @Test
    public void testSetDepth() {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setDepth(19);
        assertEquals(19, plot.getDepth());
    }

    @Test
    public void testOverlap() {
        Plot plot1 = new Plot(1, 2, 3, 4);
        Plot plot2 = new Plot(3, 4, 5, 6);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    public void testNotOverlap() {
        Plot plot1 = new Plot(1, 2, 1, 2);
        Plot plot2 = new Plot(10, 10, 1, 1);
        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    public void testEncompasses() {
        Plot plot1 = new Plot(1, 1, 8, 8);
        Plot plot2 = new Plot(2, 2, 1, 1);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testNotEncompass() {
        Plot plot1 = new Plot(1, 2, 1, 4);
        Plot plot2 = new Plot(2, 3, 5, 6);
        assertFalse(plot1.encompasses(plot2));
    }

}

