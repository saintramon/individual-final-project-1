import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Tester extends JFrame{

    private JMenu mainMenuChoice1;
    private JMenu mainMenuChoice2;
    //private JMenu mainMenuExitChoice;
    private JMenu subMenu;
    private JMenuItem itemCircle;
    private JMenuItem itemTriangle;
    private JMenuItem itemSquare;
    private JMenuItem itemRectangle;

    private JFrame frameForCircle;
    private JFrame frameForTriangle;
    private JFrame frameForRectangle;
    private JFrame frameForSquare;


    private Shape shape;


    public static void main(String[] args){
        Tester program;
        try {
            program = new Tester();
        } catch(Exception exx){
            exx.printStackTrace();
        }
    }

    public Tester() throws Exception{
        setTitle("Computations of Geometric Areas" );

        JPanel mainPanel = new JPanel();
        //mainPanel.setFont(new Font(Font.SANS_SERIF, Font.BOLD,60));
        mainPanel.setLayout(new GridLayout(8,1));
        JLabel mainLabel1 = new JLabel("Hello User!");
        JLabel mainLabel2 = new JLabel("This application helps you compute the area of a simple geometric figure.");
        JLabel mainLabel3 = new JLabel("Please choose the geometric figure from the menu.");
        JLabel mainLabel6 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel7 = new JLabel("Close the window showing the data for a geometric figure before choosing another figure.");
        JLabel mainLabel8 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel4 = new JLabel("Programmer: Name of Student");
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


        JMenuBar mb =new JMenuBar();
        mainMenuChoice1 = new JMenu("Choose Geometric Figure");
        mainMenuChoice2 = new JMenu("Exit");
        /*
        // The following may replace mainMenuChoice2 so that exit may be done immediately after choosing Exit
        mainMenuExitChoice = new JMenu("Exit");
        mainMenuExitChoice.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                System.exit(0);
            }

            public void menuDeselected(MenuEvent e) {
               // System.out.println("menuDeselected");
               // This method must be implemented here because it is an abstract method of the MenuListener interface

            }

            public void menuCanceled(MenuEvent e) {
                //System.out.println("menuCanceled");
                // This method must be implemented here because it is an abstract method of the MenuListener interface

            }
        });
        */

        JMenuItem quit = new JMenuItem("Close this Application");
        quit.addActionListener((e)-> System.exit(0));
        /* An anonymous function (i.e. lambda expression) may be used because ActionListener is a Functional Interface, */
        mainMenuChoice2.add(quit);

        subMenu = new JMenu("Area of a Four-sided Polygon");
        itemCircle=new JMenuItem("Area of a Circle");

        itemCircle.addActionListener((e)-> {
            try {
                showCircleUI();

            } catch (Exception ex){
                ex.printStackTrace();
            }

        });
        itemTriangle=new JMenuItem("Area of a Triangle");
        itemTriangle.addActionListener((e)-> {
            try {
                showTriangleUI();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        });
        itemRectangle=new JMenuItem("Area of a Rectangle");
        itemRectangle.addActionListener((e)-> {
            try {
                showRectangleUI();
            } catch (Exception e3){
                e3.printStackTrace();
            }
        });
        itemSquare=new JMenuItem("Area of a Square");
        itemSquare.addActionListener((e)-> {
            try {
                showSquareUI();
            } catch (Exception e4){
                e4.printStackTrace();
            }
        });

        mainMenuChoice1.add(itemCircle);
        mainMenuChoice1.add(itemTriangle);

        subMenu.add(itemRectangle);
        subMenu.add(itemSquare);

        mainMenuChoice1.add(subMenu);
        mb.add(mainMenuChoice1);
        mb.add(mainMenuChoice2);
        //mb.add(mainMenuExitChoice); /* needed in place of add(mainMenuChoice2 with the code in above commenr */

        setJMenuBar(mb);
        setSize(500,500);
        pack();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    private void showCircleUI() throws Exception{
        frameForCircle = new JFrame("Area of a Circle");
        JPanel circlePanel = new JPanel();
        JLabel radiusInputLabel = new JLabel("Enter the radius of the circle ");
        JTextField radiusTextField = new JTextField(20);
        JTextField circleOutputTextField = new JTextField(60);
        circleOutputTextField.setEditable(false);
        JButton circleOutputButton = new JButton("Click to show area of the circle");
        circlePanel.setLayout(new GridLayout(2,2));
        circlePanel.add(radiusInputLabel);
        circlePanel.add(radiusTextField);
        circlePanel.add(circleOutputButton);
        circlePanel.add(circleOutputTextField);

        circleOutputButton.addActionListener((e) -> {
            if (!radiusTextField.getText().equals("")) {
                double radius = Double.parseDouble(radiusTextField.getText());
                shape = new Circle("circle", radius);
                if (shape instanceof Circle)
                    circleOutputTextField.setText("The area of " + ((Circle) shape).toString() + " is " + ((Circle) shape).area() + " square units.");
                else
                    circleOutputTextField.setText("No circle has been instantiated.");
            }
            else
                circleOutputTextField.setText("You have to enter the radius of the circle.");
        });

        frameForCircle.getContentPane().add(circlePanel);
        frameForCircle.pack();
        frameForCircle.setVisible(true);
        frameForCircle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    } // end showCircleUI method


    private void showTriangleUI(){
        frameForTriangle = new JFrame("Area of a Triangle");

        JLabel inputLabel1 = new JLabel("Enter the length of the first side of the triangle");
        JLabel inputLabel2 = new JLabel("Enter the length of the second side of the triangle");
        JLabel inputLabel3 = new JLabel("Enter the length of the third side of the triangle");

        JTextField side1TextField = new JTextField(20);
        JTextField side2TextField = new JTextField(20);
        JTextField side3TextField = new JTextField(20);
        JButton triangleOutputButton = new JButton("Click to show area of the triangle");
        JTextField triangleOutputTextField = new JTextField(60);
        triangleOutputTextField.setEditable(false);

        JPanel trianglePanel = new JPanel();
        trianglePanel.setLayout(new GridLayout(4,2));

        trianglePanel.add(inputLabel1);
        trianglePanel.add(side1TextField);
        trianglePanel.add(inputLabel2);
        trianglePanel.add(side2TextField);
        trianglePanel.add(inputLabel3);
        trianglePanel.add(side3TextField);
        trianglePanel.add(triangleOutputButton);
        trianglePanel.add(triangleOutputTextField);

        triangleOutputButton.addActionListener((e)->{
            if (side1TextField.getText().equals("")|| side2TextField.getText().equals("")|| side3TextField.getText().equals(""))
                triangleOutputTextField.setText("You have to enter the length of each of the 3 sides");
            else {
                double side1 = Double.parseDouble(side1TextField.getText());
                double side2 = Double.parseDouble(side2TextField.getText());
                double side3 = Double.parseDouble(side3TextField.getText());

                if (!(((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1))) {
                    triangleOutputTextField.setText("The area cannot be computed because the given lengths of sides do not form a valid triangle.");
                } else {
                    shape = new Triangle("triangle", side1, side2, side3);
                    if (shape instanceof Triangle)
                        triangleOutputTextField.setText("The area of " + shape.toString() + " is " + ((Triangle) shape).area() + " square units.");
                    else
                        triangleOutputTextField.setText("No triangle has been instantiated");
                }
            }
        });

        frameForTriangle.getContentPane().add(trianglePanel);
        frameForTriangle.pack();
        frameForTriangle.setVisible(true);
        frameForTriangle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    } // end showTriangleUI method

    private void showSquareUI() throws Exception{
        frameForSquare = new JFrame("Area of a Square");

        JLabel inputLabel = new JLabel("Enter the length of the side of the square");

        JTextField sideTextField = new JTextField(20);

        JButton squareOutputButton = new JButton("Click to show area of the square");
        JTextField squareOutputTextField = new JTextField(60);
        squareOutputTextField.setEditable(false);

        JPanel squarePanel = new JPanel();
        squarePanel.setLayout(new GridLayout(2,2));

        squarePanel.add(inputLabel);
        squarePanel.add(sideTextField);
        squarePanel.add(squareOutputButton);
        squarePanel.add(squareOutputTextField);

        squareOutputButton.addActionListener((e)->{
            if (!sideTextField.getText().equals("")) {
                double side = Double.parseDouble(sideTextField.getText());
                shape = new Square("square", side);
                if (shape instanceof  Square)
                    squareOutputTextField.setText("The area of " + shape.toString() + " is " + ((Square) shape).area() + " square units.");
                else
                    squareOutputTextField.setText("No square has been instantiated");
            }
            else
                squareOutputTextField.setText("You have to enter the measurement of the side of the square.");
        });

        frameForSquare.getContentPane().add(squarePanel);
        frameForSquare.pack();
        frameForSquare.setVisible(true);
        frameForSquare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void showRectangleUI() throws Exception{

        frameForRectangle = new JFrame("Area of a Rectangle");

        JLabel inputLabel1 = new JLabel("Enter the length of the rectangle");
        JTextField lengthTextField = new JTextField(20);
        JLabel inputLabel2 = new JLabel("Enter the width of the rectangle");
        JTextField widthTextField = new JTextField(20);

        JButton rectangleOutputButton = new JButton("Click to show area of the rectangle");
        JTextField rectangleOutputTextField = new JTextField(60);
        rectangleOutputTextField.setEditable(false);

        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setLayout(new GridLayout(3,2));

        rectanglePanel.add(inputLabel1);
        rectanglePanel.add(lengthTextField);
        rectanglePanel.add(inputLabel2);
        rectanglePanel.add(widthTextField);
        rectanglePanel.add(rectangleOutputButton);
        rectanglePanel.add(rectangleOutputTextField);

        rectangleOutputButton.addActionListener((e)->{
            if (lengthTextField.getText().equals("") || widthTextField.getText().equals(""))
                rectangleOutputTextField.setText("You have to enter the length and width of the rectangle.");
            else {
                double length = Double.parseDouble(lengthTextField.getText());
                double width = Double.parseDouble(widthTextField.getText());
                shape = new Rectangle("rectangle", length, width);
                if (shape instanceof Rectangle)
                    rectangleOutputTextField.setText("The area of " + shape.toString() + " is " + ((Rectangle) shape).area() + " square units.");
                else
                    rectangleOutputTextField.setText("No rectangle has been instantiated.");
            }
        });

        frameForRectangle.getContentPane().add(rectanglePanel);
        frameForRectangle.pack();
        frameForRectangle.setVisible(true);
        frameForRectangle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
} // end of class Tester
