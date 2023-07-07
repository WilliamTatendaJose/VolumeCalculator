import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;


public class VolumeCalculator extends JFrame{
    private JPanel MainPanel;
    private JButton clearbutton;
    private JButton calculateButton;
    private JLabel heightLabel;
    private JTextField heightTf;
    private JTextField volumeTf;
    private JLabel volumeLabel;
    private JLabel errorsLabel;

    double volume, height;
   double length= 2000;
   double radius= 900;

    public VolumeCalculator() {

        setContentPane(MainPanel);
        setTitle("Volume Calculator");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volumeTf.setText("");
                heightTf.setText("");
                errorsLabel.setText("");

            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                  double height = Double.parseDouble(heightTf.getText());
                  if(height>1800){
                      errorsLabel.setText("Please enter a number between 0 and 1800");

                  }else {

                      volumeTf.setText((int) calculateVolume(height) + " L");
                  }
              }catch(NumberFormatException ex) {
                  errorsLabel.setText("Please Enter a number");
              }

            }
        });
    }

    public static void main(String[] args){
        VolumeCalculator myVolume= new VolumeCalculator();

    }

    double calculateVolume(double height)
    {
        double radius_height = radius - height;
        double radian_angle = Math.acos((radius_height) / radius); //*radian;
        double sqr_root = Math.sqrt((2 * radius * height - Math.pow(height, 2)));

        double volume = length * (Math.pow(radius, 2) * radian_angle - radius_height * sqr_root);

        return volume/1000000;
    }
}

