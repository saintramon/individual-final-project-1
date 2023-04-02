public class Rectangle extends Square {
    private double side2;
    /**
     * Constructs a rectangle shape with a given sides
     * */
    public Rectangle(String name, double side1, double side2){
        super(name, side1);
        sides = 4;
        this.side2 = side2;
    }

    /**
     * Sets the second side of this rectangle to a given floating point number
     * */
    public void setSide2(double s){
        side2 = s;
    }


    /**
     * Returns the first side of this rectangle
     * */
    public double getSide1(){
        return getSide();
    }
    /**
     * Returns the second side of this rectangle
     * */
    public double getSide2(){
        return side2;
    }


    /**
     * Returns the area of this rectangle .
     * Area of Square = length * width
     * */
    public double area(){
        return side*side2;
    }

    /**
     *Returns the perimeter of this rectangle
     * */
    public double perimeter(){
        return 2*side + 2*side2;
    }

} // end of class Rectangle
