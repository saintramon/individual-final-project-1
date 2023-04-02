import java.lang.*;

public class Circle extends Shape {
    private double radius;

    /**
     * Constructs a circle shape with a given radius
     * */
    public Circle(String name, double radius){
        super(name);
        sides = 0;
        this.radius = radius;
    }

    /**
     * Sets the radius of this circle to a given floating point number
     * */
    public void setRadius(double r){
        radius = r;
    }

    /**
     * Returns the radius of this circle
     * */
    public double getRadius(){
        return radius;
    }

    /**
     * Returns the area of this circle
     * */
    public double area(){
        return Math.PI*radius*radius;
    }

    /**
     *Returns the perimeter of this circle where perimeter is the same as circumference
     * */
    public double perimeter(){
        return 2*Math.PI*radius;
    }

    public String toString() {
        return getName() + " with a circular side";
    }

} // end of class Circle
