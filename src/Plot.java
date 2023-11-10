/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: objects created from this class have (x,y,width,depth) -fields -- and can be tested for overlap using methods
 * Due: 11/10/2023
 * Platform/compiler: ECLIPSE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: LIAM GHERSHONY
*/


public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() { //no arg
		x=0;
		y=0;
		width = 1;
		depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) { //basic constructor
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth = depth;
	}
	
	public Plot(Plot plot) {  // copy constructor
		x= plot.getX();
		y=plot.getY();
		depth = plot.getDepth();
		width =plot.getWidth();
	}
	
	
	public int getWidth() {
		return this.width;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		
		boolean overlapsX = ((this.x < plot.x) && (plot.x < (this.x + this.width))) || (( plot.x < this.x ) && ( this.x < (plot.x +plot.width )));
		boolean overlapsY = (((this.y < plot.y) && (plot.y < (this.y + this.depth))) || (( plot.y <this.y) && ( this.y < plot.y+plot.depth )));
		
		if (overlapsX && overlapsY)
			return true;
		else
			return false;
			

	}
	
	public boolean encompasses(Plot plot) {
		int otherX = plot.getX();
		int otherY = plot.getY();
		int otherDepth = plot.getDepth();
		int otherWidth = plot.getWidth();
		
		if ((this.x <= otherX) && (otherX <= (this.x + this.width)) && ((otherX + otherWidth)<=(this.x + this.width))) {
			if((this.y <= otherY) && (otherY <= (this.y + this.depth)) && ((otherY + otherDepth) <=(this.y +this.depth)))
			return true;}
		
		
		return false;
		
	}
	
	public String toString() { 
		
		String str =  x + "," + y + "," + width + "," + depth;
		return str;
			
		}
	
		
	}


