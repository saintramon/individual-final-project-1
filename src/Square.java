public class Square extends Shape {
    protected double side;

    /**
     * Constructs a square shape with a given side
     * */
    public Square(String name, double s){
        super(name);
        sides = 4;
        side = s;
    }

    /**
     * Sets the side of this square to a given floating point number
     * */
    public void setSide(double s){
        side = s;
    }

    /**
     * Returns the side of this square
     * */
    public double getSide(){
        return side;
    }


    /**
     * Returns the area of this square .
     * Area of Square = side * side
     * */
    public double area(){
        return side*side;
    }

    /**
     *Returns the perimeter of this square
     * */
    public double perimeter(){
        return 4*side;
    }

} // end of class Square
