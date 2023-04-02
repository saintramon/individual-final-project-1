public class RectangularSolid extends Rectangle {
    private double height;
    /**
     * Constructs a rectangular solid with a given height
     * */
    public RectangularSolid(String name, double side1, double side2, double height){
        super(name, side1, side2);
        sides = 5;
        this.height = height;
    }

    /**
     * Sets the height of the rectangular solid to a given floating point number
     * */
    public void setSide2(double h){
        height = h;
    }


    /**
     * Returns the height of this rectangular solid
     * */
    public double getHeight(){
        return height;
    }

    /**
     * Returns the volume of this rectangular .
     * Volume of a rectangular solid  = area of the rectangular base * height
     * */
    public double volume(){
        return area()*height;
    }

} // end of class Rectangle
