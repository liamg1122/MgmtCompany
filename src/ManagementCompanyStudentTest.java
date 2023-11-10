/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: class for testing Management company class and methods
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

public class ManagementCompanyStudentTest {
ManagementCompany liamco;
Property home;
Property school;
Property library;
Property restaurant;
Property restaurant2;
Property restaurant3;



	@Test
	public void testConstructor1() {
		liamco = new ManagementCompany();
		
		 assertEquals("", liamco.getName());

	}
	
	@Test
	public void testConstructor2() {
		liamco = new ManagementCompany("liamco", "555", 5.0);
		
		 assertEquals("555", liamco.getTaxID());

	}
	
	public void testCopyConstructor() {
		liamco = new ManagementCompany("liamco", "555", 5.0,10,10,20,20); //constructor 3
		ManagementCompany copyliamco = new ManagementCompany(liamco); // constructor 4
       
		assertEquals("liamco", copyliamco.getName());
        assertEquals("555", copyliamco.getTaxID());
        assertEquals(5.0, copyliamco.getMgmFeePer(), 0.0);
        assertEquals(0, copyliamco.getPropertiesCount());

	}
	
	@Test
	public void testGetHighestRent() {
		liamco = new ManagementCompany("liamco", "555", 5.0); 
		school = new Property ("school", "Rockville", 10000, "liam",2,5,2,2);	
		library = new Property ("lib", "eeee", 4000, "liam",5,5,1,1);	
		restaurant = new Property ("1", "eeee", 5000, "liam",6,6,1,1);	


		 assertEquals(0, liamco.addProperty("home", "555", 5.0,"liam"));
		 assertEquals(1, liamco.addProperty(school));
		 assertEquals(2, liamco.addProperty(library));
		 assertEquals(3, liamco.addProperty(restaurant));
		
		 assertEquals(10000, liamco.getHighestRentProperty().getRentAmount()); //got highest rent
	
	}

	@Test
	public void testAddPropertyWithBadPlot() {
		
		liamco = new ManagementCompany("liamco", "555", 5.0);
		Property badProperty = new Property("Invalid", "City", 1000, "Owner", 12, 12, 10, 10);
		
		
		assertEquals(liamco.addProperty(badProperty), -3); //invalid plot size
}

	@Test
	public void testAddPropertyMethods() {
		
		liamco = new ManagementCompany("liamco", "555", 5.0); 
		
			school = new Property ("school", "Rockville", 10000, "liam",2,5,2,2);	
			library = new Property ("lib", "eeee", 4000, "liam",5,5,1,1);	
			restaurant = new Property ("1", "eeee", 5000, "liam",6,6,1,1);	
			restaurant2 = new Property ("2", "eeee", 6000, "liam",8,8,1,1);	
			restaurant3 = new Property ("2", "eeee", 7000, "liam",9,9,1,1);	




		 assertEquals(0, liamco.addProperty("home", "555", 5.0,"liam"));
			 assertEquals(1, liamco.addProperty(school));
			 assertEquals(2, liamco.addProperty(library));
			 assertEquals(3, liamco.addProperty(restaurant));
			 assertEquals(4, liamco.addProperty(restaurant2));
		 assertEquals(-1, liamco.addProperty("2", "eeee", 7000, "liam",9,9,1,1));


	}
	
	

	    @Test
		public void testToString() {
			home = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
			liamco= new ManagementCompany("Railey", "555555555",6);
			liamco.addProperty(home);
			String expectedString = "List of the properties for Railey, taxID: 555555555\n"
					+ "______________________________________________________\n"
					+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
					+ "______________________________________________________\n"
					+"\n"
					+ " total management Fee: 156.78";
			System.out.println(expectedString);
			System.out.println(liamco.toString());
			assertEquals(expectedString, liamco.toString());
					
		}
	

	
	@Test
	public void testGetters() {
		liamco = new ManagementCompany("liamco", "555", 5.0,10,10,20,20); //constructor 3
		ManagementCompany copyliamco = new ManagementCompany(liamco); // constructor 4
       
		assertEquals("liamco", copyliamco.getName());
        assertEquals("555", copyliamco.getTaxID());
        assertEquals(5.0, copyliamco.getMgmFeePer(), 0.0);
        assertEquals(0, copyliamco.getPropertiesCount());
        
        ManagementCompany liamco2 = new ManagementCompany("liamco2", "666", 7.0, 1, 2, 3, 4);
		ManagementCompany copyliamco2 = new ManagementCompany(liamco2);
		
		assertEquals("liamco2", copyliamco2.getName()); 
        assertEquals("666", copyliamco2.getTaxID());
        assertEquals(7.0, copyliamco2.getMgmFeePer(), 0.0);
        assertEquals(0, copyliamco2.getPropertiesCount());
        assertEquals(liamco2.getPlot(), copyliamco2.getPlot());
	}
	
	@Test
    public void testRemoveLastProperty() {
        ManagementCompany liamco = new ManagementCompany("LiamCo", "123", 5.0);
        liamco.addProperty("Home", "Rockv", 1000, "Liam", 1, 1, 1, 1);
        liamco.addProperty("Apartment", "Rockv", 1500, "Liam", 3, 3, 2, 2);

        assertEquals(2, liamco.getPropertiesCount());
        
        liamco.removeLastProperty();

        assertEquals(1, liamco.getPropertiesCount());
        assertNull(liamco.getProperties()[1]); 

        
    }

	@Test
    public void testGetPropertyCount() {
        ManagementCompany liamco = new ManagementCompany("LiamCo", "123", 5.0);
        liamco.addProperty("Home", "Rockv", 1000, "Liam", 1, 1, 1, 1);
        liamco.addProperty("Apartment", "Rockv", 1500, "Liam", 3, 3, 2, 2);

        assertEquals(2, liamco.getPropertiesCount());

	}
	

    @Test
    public void testIsMangementFeeValid() {
        ManagementCompany liamco = new ManagementCompany("Liam", "333", 15.0);
        assertTrue(liamco.isMangementFeeValid());
    }

    @Test
    public void testGetProperties() {
        ManagementCompany liamco = new ManagementCompany();
        liamco.addProperty(home);
        assertNotNull(liamco.getProperties());
    }

    @Test
    public void testGetMgmFeePer() {
        ManagementCompany liamco = new ManagementCompany("Liam", "333", 15.0);
        assertEquals(15.0, liamco.getMgmFeePer(), 0.0);
    }

    @Test
    public void testGetPlot() {
        ManagementCompany liamco = new ManagementCompany("Liam", "333", 15.0);
        liamco.addProperty(home);
        assertNotNull(liamco.getPlot());
    }

}
