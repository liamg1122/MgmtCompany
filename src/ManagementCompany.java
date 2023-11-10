/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: class for creating management company objects that hold 5>= to >= 0 properties
 * Due: 11/10/2023
 * Platform/compiler: ECLIPSE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: LIAM GHERSHONY
*/





public class ManagementCompany {

	private String name;
	private String taxID;
	private double mgmFee;
	private int count;
	public final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	
	
	//default constructor w/ default depth, width

	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		count = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		
	}
	
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID =taxID;
		this.mgmFee =mgmFee;
		count = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	//constructor with custom plot input - parameterized
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) 
{
		this.name = name;
		this.taxID =taxID;
		this.mgmFee =mgmFee;
		count = 0;
		plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	//copy constructor
	public ManagementCompany(ManagementCompany mgmCompany) {
		name = mgmCompany.name;
		taxID = mgmCompany.taxID;
		mgmFee = mgmCompany.mgmFee;
		plot = mgmCompany.plot;
		properties = mgmCompany.properties;
		count = mgmCompany.count;
	}
	
	//add a property to mgmt company passing property object to methods
	public int addProperty(Property property) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		 if(property == null) {
			return -2;
		}
		if(!plot.encompasses(property.getPlot())){
			return -3;
		}
		
		for (int i=0;i<count; i++) {
			if (property.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		
		Property addAProp = new Property(property);
		properties[count]= addAProp;
		count++;
		
		return count-1;
	}
	
	
	//add a property to mgmt company passing field values to method, default plot size
	public int addProperty(String name, String city, double rent, String owner) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		
		Property addAProp = new Property(name, city, rent, owner);
		
		
		if (!plot.encompasses(addAProp.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i<count; i++) {
			if(addAProp.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		
		properties[count] = addAProp;
		count++;
		
		return count-1;
	}
	
	
	//add a property to mgmt company passing field values to method, parameterized plot size

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		if (count == MAX_PROPERTY) {
			return -1;
		}
		
		Property addAProp = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (!plot.encompasses(addAProp.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i<count; i++) {
			if(addAProp.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		properties[count] = addAProp;
		count++;
		
		return count-1; // index
	}
	
	
	public String toString() {
		String str = "List of the properties for " + name +", taxID: " + taxID +
		
				"\n______________________________________________________\n";	
		
		for(int i=0; i<count; i++) {
			str += properties[i].toString() + "\n";
		}
		
		str += "______________________________________________________\n";
		
		double totalManagementFee = (getTotalRent()*mgmFee)/100;
		
		str += "\n total management Fee: " + totalManagementFee;
		
		return str;
	}
	
	
	//get rent from all properties in mgmt company.
	public double getTotalRent() {
		double tot = 0.0;
		
		for(int i = 0; i< count; i++) {
			tot+= properties[i].getRentAmount();
		}
		return tot;
	}
	
	
	public int getPropertiesCount() {
	    return count;
	}
	
    
	public Property getHighestRentProperty() {
	    
		if (count == 0) {
	        return null;
	    }

	    Property highRentProperty = properties[0];

	    for (int i = 1; i < count; i++) {
	        if (properties[i].getRentAmount() > highRentProperty.getRentAmount()) {
	        	highRentProperty = properties[i];
	        }
	    }

	    return highRentProperty;
	}
	
	public boolean isMangementFeeValid() {
	    return 0<= mgmFee && mgmFee <= 100;
	}

	public Property[] getProperties() {
	    return properties;
	}
	
	public double getMgmFeePer() {
	    return (mgmFee);
	}
	
	public Plot getPlot() {
	    return plot;
	}
	
	public void removeLastProperty() {
	    if (count > 0) {
	        properties[count - 1] = null;  
	        count--;
	    }
	}
	
	public String getTaxID() {
	    return taxID;
	}
	
	public String getName() {
	    return name;
	}
	
	public boolean isPropertiesFull() {
	    return count == MAX_PROPERTY;
	}

	
}
