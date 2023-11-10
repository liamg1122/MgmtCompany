/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: class for testing property objects and methods
 * Due: 11/10/2023
 * Platform/compiler: ECLIPSE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: LIAM GHERSHONY
*/



import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StudentPropertyTest {

    @Test
    public void testNOARGSConstructor() {
        Property property = new Property();
        assertNotNull(property);
    }

    @Test
    public void testCopyConstructor() {
        Property limeabeanshome = new Property("limeabeans's", "limeabeanssville", 1800.0, "limeabeans", 1, 2, 3, 4);
        Property copy = new Property(limeabeanshome);

        assertEquals(limeabeanshome.getPropertyName(), copy.getPropertyName());
        assertEquals(limeabeanshome.getCity(), copy.getCity());
        assertEquals(limeabeanshome.getRentAmount(), copy.getRentAmount());
        assertEquals(limeabeanshome.getOwner(), copy.getOwner());
        assertEquals(limeabeanshome.getPlot(), copy.getPlot());
    }

    @Test
    public void testParameterConstructor() {
        Property property = new Property("limeabeans's Apartment", "limeabeanssville", 1500.0, "limeabeans");
        assertNotNull(property);
        assertEquals("limeabeans's Apartment", property.getPropertyName());
        assertEquals("limeabeanssville", property.getCity());
        assertEquals(1500.0, property.getRentAmount());
        assertEquals("limeabeans", property.getOwner());
    }

    @Test
    public void testPlotConstructor() {
        Property property = new Property("limeabeans's Office", "limeabeanssville", 3000.0, "limeabeans", 5, 5, 10, 10);
        Plot thisone = new Plot(5, 5, 10, 10);
        assertNotNull(property);
        assertEquals("limeabeans's Office", property.getPropertyName());
        assertEquals("limeabeanssville", property.getCity());
        assertEquals(3000.0, property.getRentAmount());
        assertEquals("limeabeans", property.getOwner());
    }

    @Test
    public void testGetCity() {
        Property property = new Property("limeabeans's Home", "limeabeanssville", 1800.0, "limeabeans");
        assertEquals("limeabeanssville", property.getCity());
    }

    @Test
    public void testSetPropertyName() {
        Property property = new Property();
        property.setPropertyName("limeabeans's");
        assertEquals("limeabeans's", property.getPropertyName());
    }

    @Test
    public void testGetPropertyName() {
        Property property = new Property("limeabeans's Home", "limeabeanssville", 1800.0, "limeabeans");
        assertEquals("limeabeans's Home", property.getPropertyName());
    }

    @Test
    public void testSetCity() {
        Property property = new Property();
        property.setCity("limeabeanssville");
        assertEquals("limeabeanssville", property.getCity());
    }

    @Test
    public void testSetRentAmount() {
        Property property = new Property();
        property.setRentAmount(2000.0);
        assertEquals(2000.0, property.getRentAmount());
    }

    @Test
    public void testGetRentAmount() {
        Property property = new Property("limeabeans's", "limeabeanssville", 1800.0, "limeabeans");
        assertEquals(1800.0, property.getRentAmount());
    }

    @Test
    public void testGetOwner() {
        Property property = new Property("limeabeans's", "limeabeanssville", 1800.0, "limeabeans");
        assertEquals("limeabeans", property.getOwner());
    }

    @Test
    public void testSetOwner() {
        Property property = new Property();
        property.setOwner("limeabeans");
        assertEquals("limeabeans", property.getOwner());
    }


    @Test
    public void testToString() {
        Property property = new Property("limeabeans's", "limeabeanssville", 1800.0, "limeabeans");
        assertEquals("limeabeans's,limeabeanssville,limeabeans,1800.0", property.toString());
    }
}
