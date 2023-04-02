import java.lang.*;

public class Cylinder extends Circle {
    private double height;

    /**
     * Constructs a cylinder with a given height
     * */
    public Cylinder(String name, double radius, double height){
        super(name, radius);
        sides = 3;
        this.height = height;
    }

    /**
     * Sets the height of this cylinder to a given floating point number
     * */
    public void setHeight(double h){
        height = h;
    }

    /**
     * Returns the height of this cylinder
     * */
    public double getHeight(){
        return height;
    }

    /**
     * Returns the volume of this cylinder
     * Volume of a cylinder = area of the circular base * height
     * */
    public double volume(){
        return area()*height;
    }


    public String toString() {
        return   "cylinder with a circular base";
    }

} // end of class Circle
