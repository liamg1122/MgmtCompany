/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: class for creating property objects with plots, rent amounts, property names, owners etc.
 * Due: 11/10/2023
 * Platform/compiler: ECLIPSE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: LIAM GHERSHONY
*/




public class Property {
private String city;
private String propertyName;
private String owner;
private double rentAmount;
private Plot plot;

public Property() {
	propertyName = "";
	city = "";
	owner = "";
	rentAmount = 0.0;
	plot = new Plot();
	
}

public Property(Property otherProperty) {
	propertyName = otherProperty.getPropertyName();
	city = otherProperty.getCity();
	owner = otherProperty.getOwner();
	rentAmount = otherProperty.getRentAmount();
	plot = otherProperty.getPlot();
}

public Property(String propertyName, String city, double rentAmount, String owner) {
	this.propertyName = propertyName;
	this.city = city;
	this.rentAmount =rentAmount;
	this.owner =owner;
	plot = new Plot();
}


public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
	this.propertyName = propertyName;
	this.city = city;
	this.rentAmount =rentAmount;
	this.owner =owner;
	plot = new Plot(x,y,width,depth);
}

public String getCity() {
	return city;
}

public void setPropertyName(String n) {
	propertyName = n;
}

public String getPropertyName() {
	return propertyName;
}

public void setCity(String c) {
	city = c;
}

public void setRentAmount(double r) {
	rentAmount = r;
}

public double getRentAmount() {
	return rentAmount;
}

public String getOwner() {
	return owner;

}

public void setOwner(String p) {
	owner = p;
}


public void setPlot(int x, int y, int width, int depth) {
	plot = new Plot(x, y, width, depth);
}

public Plot getPlot() {
	return plot;
}

public String toString() {
	String str = propertyName + "," + city + "," + owner + "," + rentAmount ;
	return str;
}

}
