public class Triangle extends Shape {

    private double side1;
    private double side2;
    private double side3;

    /**
     * Constructs a triangle shape with given sides
     * */
    public Triangle(String name, double s1, double s2, double s3){
        super(name);
        sides = 3;
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    /**
     * Sets the first side of this triangle to a given floating point number
     * */
    public void setSide1(double s){
        side1 = s;
    }

    /**
     * Sets the second side of this triangle to a given floating point number
     * */
    public void setSide2(double s){
        side2 = s;
    }

    /**
     * Sets the third side of this triangle to a given floating point number
     * */
    public void setSide3(double s){
        side3 = s;
    }

    /**
     * Returns the first side of this triangle
     * */
    public double getSide1(){
        return side1;
    }

    /**
     * Returns the second side of this triangle
     * */
    public double getSide2(){
        return side2;
    }

    /**
     * Returns the third side of this triangle
     * */
    public double getSide3(){
        return side3;
    }


    /**
     * Returns the area of this triangle by using Heron's Formula if this triangle is valid.
     * A triangle is valid if the sum of the first 2 sides is greater than the third side.
     * semiperimeter = (1.0/2)(perimeter)
     * area of Triangle = square root of (semiperimeter(semiperimter-side1)(semiperimter-side2)(semiperimeter-side3))
     * */
    public double area(){
        double result=0;
        double semiperimeter=0;
        try {
            if (!( ((side1+side2)>side3) && ((side1 + side3)>side2) && ((side2+side3)>side1)))
                throw new Exception("Invalid Triangle. The requirement for a triangle that the sum of 2 sides must be greater than the third side is not followed.");
            else {
                semiperimeter = perimeter() / 2.0;
                result = Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
            }
        } catch (Exception triangleException){
            System.out.println(triangleException.getMessage());
        }
        return result;
    }

    /**
     *Returns the perimeter of this triangle
     * */
    public double perimeter(){
        return (side1 + side2 + side3);
    }

} // end of class Triangle
