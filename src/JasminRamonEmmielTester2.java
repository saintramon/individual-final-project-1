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


    public static void main(String[] args) {
        JasminRamonEmmielTester2 gui = new JasminRamonEmmielTester2();
    }

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


        setTitle("Computations of AREAS and VOLUMES");
        setJMenuBar(menuBar);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

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
    }


}
