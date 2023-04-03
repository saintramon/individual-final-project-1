/**
 * @author Jasmin, Ramon Emmiel P.
 * @date April 3, 2023
 */

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class JasminRamonEmmielTester2 extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu areaOfGeometricFigure = new JMenu("AREA of a Geometric Figure");
    JMenu volumeOfASolid = new JMenu("VOLUME of a Solid");
    JMenuItem areaCircle = new JMenuItem("Area of a CIRCLE");
    JMenuItem areaRectangle = new JMenuItem("Area of a REACTANGLE");
    JMenuItem areaSquare = new JMenuItem("Area of a SQUARE");
    JMenuItem areaTriangle = new JMenuItem("Area of a TRIANGLE");

    JMenuItem volumeCylinder = new JMenuItem("Volume of a CYLINDER");
    JMenuItem volumeRectangularSolid = new JMenuItem("Volume of a RECTANGULAR SOLID");

    /**
     * This is the main method that initializes a main class object to run the program
     * @param args
     */
    public static void main(String[] args) {
        JasminRamonEmmielTester2 gui = new JasminRamonEmmielTester2();
    }

    /**
     * This is the default constructor which the whole GUI is initialized
     */
    public JasminRamonEmmielTester2(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8,1));
        JLabel mainLabel1 = new JLabel("Hello User!");
        JLabel mainLabel2 = new JLabel("This application helps you compute the area of a simple geometric figure.");
        JLabel mainLabel3 = new JLabel("Please choose the geometric figure from the menu.");
        JLabel mainLabel6 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel7 = new JLabel("Close the window showing the data for a geometric figure before choosing another figure.");
        JLabel mainLabel8 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel4 = new JLabel("Programmer: JASMIN, RAMON EMMIEL P.");
        GregorianCalendar dateToday = new GregorianCalendar();
        String today = "Today is "+ dateToday.getTime() +".";
        JLabel mainLabel5 = new JLabel(today);
        mainPanel.add(mainLabel5);
        mainPanel.add(mainLabel1);
        mainPanel.add(mainLabel2);
        mainPanel.add(mainLabel3);
        mainPanel.add(mainLabel6);
        mainPanel.add(mainLabel7);
        mainPanel.add(mainLabel8);
        mainPanel.add(mainLabel4);
        add(mainPanel);


        menuBar.add(areaOfGeometricFigure);
        menuBar.add(volumeOfASolid);

        areaOfGeometricFigure.add(areaCircle);
        areaOfGeometricFigure.add(areaRectangle);
        areaOfGeometricFigure.add(areaSquare);
        areaOfGeometricFigure.add(areaTriangle);

        volumeOfASolid.add(volumeCylinder);
        volumeOfASolid.add(volumeRectangularSolid);

        areaCircle.addActionListener((e) -> {
            try {
                showAreaCircle();
            }catch (Exception ac){
                ac.printStackTrace();
            }
        });
        areaRectangle.addActionListener((e) -> {
            try {
                showAreaRectangle();
            }catch (Exception r){
                r.printStackTrace();
            }
        });
        areaSquare.addActionListener((e) -> {
            try {
                showAreaSquare();
            }catch (Exception s){
                s.printStackTrace();
            }
        });
        areaTriangle.addActionListener((e) -> {
            try {
                showAreaTriangle();
            }catch (Exception t){
                t.printStackTrace();
            }
        });
        volumeCylinder.addActionListener((e) -> {
            try {
                showVolumeCylinder();
            }catch (Exception c){
                c.printStackTrace();
            }
        });
        volumeRectangularSolid.addActionListener((e) -> {
            try {
                showVolumeRectangularSolid();
            }catch (Exception rs){
                rs.printStackTrace();
            }
        });



        setTitle("Computation of AREAS and VOLUMES");
        setJMenuBar(menuBar);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    /**
     * This is the method that builds the GUI for the computation of area of the circle
     * @throws Exception
     */
    private void showAreaCircle() throws Exception{
        JFrame circleGUI = new JFrame("Area of a Circle");
        JPanel circlePanel = new JPanel();

        JLabel radiusLabel = new JLabel("Enter the radius of the circle: ");

        JTextField radiusTextField = new JTextField(20);
        JTextField circleResultField = new JTextField(60);
        JButton circleOutputBtn = new JButton("Show area");

        circleResultField.setEditable(false);
        circlePanel.setLayout(new GridLayout(2,2));
        circlePanel.add(radiusLabel);
        circlePanel.add(radiusTextField);
        circlePanel.add(circleOutputBtn);
        circlePanel.add(circleResultField);


        circleOutputBtn.addActionListener((e) -> {
            if (!radiusTextField.getText().equals("")) {
                double radius = Double.parseDouble(radiusTextField.getText());
                Circle shape = new Circle("circle", radius);
                if (shape instanceof Circle)
                    circleResultField.setText("The area of " + ((Circle) shape).toString() + " is " + ((Circle) shape).area() + " square units.");
                else
                    circleResultField.setText("No circle has been instantiated.");
            }
            else
                circleResultField.setText("You have to enter the radius of the circle.");
        });

        circleGUI.getContentPane().add(circlePanel);
        circleGUI.pack();
        circleGUI.setVisible(true);
        circleGUI.setResizable(false);
        circleGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        circleGUI.setLocationRelativeTo(null);
    }

    /**
     * This is the method that builds the GUI of the computation for the Area of the Rectangle
     * @throws Exception
     */
    private void showAreaRectangle() throws Exception{
        JFrame rectangleGUI = new JFrame("Area of a Rectangle");
        JPanel rectanglePanel = new JPanel();

        JLabel lengthLabel = new JLabel("Enter length of the rectangle:");
        JLabel widthLabel = new JLabel("Enter width of the rectangle:");

        JTextField lengthTextField = new JTextField(20);
        JTextField widthTextField = new JTextField(20);
        JTextField rectangleResult = new JTextField(60);
        rectangleResult.setEditable(false);

        JButton rectangleOutputBtn = new JButton("Click to compute Rectangle Area");

        rectangleOutputBtn.addActionListener((e)->{
            if (lengthTextField.getText().equals("") || widthTextField.getText().equals(""))
                rectangleResult.setText("You have to enter the length and width of the rectangle.");
            else {
                double length = Double.parseDouble(lengthTextField.getText());
                double width = Double.parseDouble(widthTextField.getText());
                Rectangle shape = new Rectangle("rectangle", length, width);
                if (shape instanceof Rectangle)
                    rectangleResult.setText("The area of " + shape.toString() + " is " + ((Rectangle) shape).area() + " square units.");
                else
                    rectangleResult.setText("No rectangle has been instantiated.");
            }
        });

        rectanglePanel.setLayout(new GridLayout(3,2));

        rectanglePanel.add(lengthLabel);
        rectanglePanel.add(lengthTextField);
        rectanglePanel.add(widthLabel);
        rectanglePanel.add(widthTextField);
        rectanglePanel.add(rectangleOutputBtn);
        rectanglePanel.add(rectangleResult);

        rectangleGUI.getContentPane().add(rectanglePanel);
        rectangleGUI.setResizable(false);
        rectangleGUI.setVisible(true);
        rectangleGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        rectangleGUI.pack();
        rectangleGUI.setLocationRelativeTo(null);
    }

    /**
     * This is the method that builds the GUI for the computation of the Area of the Square
     * @throws Exception
     */
    private void showAreaSquare() throws Exception{
        JFrame squareGUI = new JFrame("Area of a Square");
        JPanel squarePanel = new JPanel();

        JLabel sideLabel = new JLabel("Enter one side of the Square:");

        JTextField sideTextField = new JTextField();
        JTextField squareResult = new JTextField(60);
        squareResult.setEditable(false);

        JButton squareOutputBtn = new JButton("Calculate Area of Square");

        squareOutputBtn.addActionListener((e)->{
            if (!sideTextField.getText().equals("")) {
                double side = Double.parseDouble(sideTextField.getText());
                Square shape = new Square("square", side);
                if (shape instanceof  Square)
                    squareResult.setText("The area of " + shape.toString() + " is " + ((Square) shape).area() + " square units.");
                else
                    squareResult.setText("No square has been instantiated");
            }
            else
                squareResult.setText("You have to enter the measurement of the side of the square.");
        });

        squarePanel.setLayout(new GridLayout(2,2));

        squarePanel.add(sideLabel);
        squarePanel.add(sideTextField);
        squarePanel.add(squareOutputBtn);
        squarePanel.add(squareResult);

        squareGUI.getContentPane().add(squarePanel);
        squareGUI.setVisible(true);
        squareGUI.setResizable(false);
        squareGUI.pack();
        squareGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        squareGUI.setLocationRelativeTo(null);
    }

    /**
     * This is the method that builds the GUI for the computation of the Area of a Triangle
     * @throws Exception
     */
    private void showAreaTriangle() throws Exception{
        JFrame triangleGUI = new JFrame("Area of a Triangle");
        JPanel trianglePanel = new JPanel();

        JLabel side1Label = new JLabel("Enter 1st side of the Triangle:");
        JLabel side2Label = new JLabel("Enter 2nd side of the Triangle:");
        JLabel side3Label = new JLabel("Enter 3rd side of the Triangle:");

        JTextField side1TextField = new JTextField();
        JTextField side2TextField = new JTextField();
        JTextField side3TextField = new JTextField();
        JTextField triangleResult = new JTextField(60);
        triangleResult.setEditable(false);

        JButton triangleOutputBtn = new JButton("Calculate area of Triangle");

        triangleOutputBtn.addActionListener((e)->{
            if (side1TextField.getText().equals("")|| side2TextField.getText().equals("")|| side3TextField.getText().equals(""))
                triangleResult.setText("You have to enter the length of each of the 3 sides");
            else {
                double side1 = Double.parseDouble(side1TextField.getText());
                double side2 = Double.parseDouble(side2TextField.getText());
                double side3 = Double.parseDouble(side3TextField.getText());

                if (!(((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1))) {
                    triangleResult.setText("The area cannot be computed because the given lengths of sides do not form a valid triangle.");
                } else {
                    Triangle shape = new Triangle("triangle", side1, side2, side3);
                    if (shape instanceof Triangle)
                        triangleResult.setText("The area of " + shape.toString() + " is " + ((Triangle) shape).area() + " square units.");
                    else
                        triangleResult.setText("No triangle has been instantiated");
                }
            }
        });

        trianglePanel.setLayout(new GridLayout(4,2));

        trianglePanel.add(side1Label);
        trianglePanel.add(side1TextField);
        trianglePanel.add(side2Label);
        trianglePanel.add(side2TextField);
        trianglePanel.add(side3Label);
        trianglePanel.add(side3TextField);
        trianglePanel.add(triangleOutputBtn);
        trianglePanel.add(triangleResult);

        triangleGUI.getContentPane().add(trianglePanel);
        triangleGUI.setVisible(true);
        triangleGUI.pack();
        triangleGUI.setResizable(false);
        triangleGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        triangleGUI.setLocationRelativeTo(null);
    }

    /**
     * This is the method that builds the GUI for the computation of the Volume of a Cylinder
     * @throws Exception
     */
    private void showVolumeCylinder() throws Exception{
        JFrame cylinderGUI = new JFrame("Volume of a Cylinder");
        JPanel cylinderPanel = new JPanel();

        JLabel radiusLabel = new JLabel("Enter Radius of the Circular Base:");
        JLabel heightLabel = new JLabel("Enter Height of the Cylinder:");

        JTextField radiusTextField = new JTextField();
        JTextField heightTextField = new JTextField();
        JTextField cylinderResult = new JTextField(60);
        cylinderResult.setEditable(false);

        JButton cylinderOutputBtn = new JButton("Calculate Volume of the Cylinder");

        cylinderOutputBtn.addActionListener(e -> {
            if (radiusTextField.getText().equals("") || heightTextField.getText().equals("")){
                cylinderResult.setText("You have to enter the radius and the height of the Cylinder");
            }else {
                double radius = Double.parseDouble(radiusTextField.getText());
                double height = Double.parseDouble(heightTextField.getText());

                Cylinder cylinder = new Cylinder("Cylinder", radius, height);

                if (cylinder instanceof  Cylinder){
                    cylinderResult.setText("The volume of " + cylinder.toString() + " is " + cylinder.volume() + " cubic units.");
                }
            }
        });

        cylinderPanel.setLayout(new GridLayout(3,2));
        cylinderPanel.add(radiusLabel);
        cylinderPanel.add(radiusTextField);
        cylinderPanel.add(heightLabel);
        cylinderPanel.add(heightTextField);
        cylinderPanel.add(cylinderOutputBtn);
        cylinderPanel.add(cylinderResult);

        cylinderGUI.getContentPane().add(cylinderPanel);
        cylinderGUI.setVisible(true);
        cylinderGUI.setResizable(false);
        cylinderGUI.pack();
        cylinderGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cylinderGUI.setLocationRelativeTo(null);
    }

    /**
     * This is the method that builds the GUI for the computation of the Volume of a Rectangular Solid
     * @throws Exception
     */
    private void showVolumeRectangularSolid() throws Exception{
        JFrame rectangularSolidGUI = new JFrame("Volume of a Rectangular Solid");
        JPanel rsPanel = new JPanel();

        JLabel lengthLabel = new JLabel("Enter the length:");
        JLabel widthLabel = new JLabel("Enter the width:");
        JLabel heightLabel = new JLabel("Enter the height:");

        JTextField lengthTF = new JTextField();
        JTextField widthTF = new JTextField();
        JTextField heightTF = new JTextField();
        JTextField rsResult = new JTextField(60);
        rsResult.setEditable(false);

        JButton rsOutputBtn = new JButton("Calculate Volume of Rectangular Solid");

        rsOutputBtn.addActionListener(e -> {
            if (lengthTF.getText().equals("") || widthTF.getText().equals("") || heightTF.getText().equals("")){
                rsResult.setText("You have to enter the length, width, and height of the Rectangular Solid");
            }else {
                double length = Double.parseDouble(lengthTF.getText());
                double width = Double.parseDouble(widthTF.getText());
                double height = Double.parseDouble(heightTF.getText());

                RectangularSolid rs = new RectangularSolid("Rectangular Solid", length, width, height);

                if (rs instanceof RectangularSolid){
                    rsResult.setText("The volume of " + rs.toString() + " is " + rs.volume() + " cubic units.");
                }
            }
        });

        rsPanel.setLayout(new GridLayout(4,2));
        rsPanel.add(lengthLabel);
        rsPanel.add(lengthTF);
        rsPanel.add(widthLabel);
        rsPanel.add(widthTF);
        rsPanel.add(heightLabel);
        rsPanel.add(heightTF);
        rsPanel.add(rsOutputBtn);
        rsPanel.add(rsResult);

        rectangularSolidGUI.getContentPane().add(rsPanel);
        rectangularSolidGUI.setVisible(true);
        rectangularSolidGUI.setResizable(false);
        rectangularSolidGUI.pack();
        rectangularSolidGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        rectangularSolidGUI.setLocationRelativeTo(null);
    }

}
