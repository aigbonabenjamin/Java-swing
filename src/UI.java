import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("Physics");
    JTextField tfmass = new JTextField("Enter mass");
    JTextField tfAcceleretion = new JTextField("Acceleration");
    JButton btnCalculate = new JButton("Calculate");

void drawUI(){
    window.add(tfmass);
    window.add(btnCalculate);
    window.add(tfAcceleretion);

    btnCalculate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Physics physics = new Physics();
            try {
                float mass = Float.valueOf(tfmass.getText());
                float acceleration = Float.valueOf(tfAcceleretion.getText());
                JOptionPane.showMessageDialog(null, physics.calculateForce(mass, acceleration));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Enter only numeric values");
                nfe.printStackTrace();
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Something else happened!");
            }
        }
    });
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setLayout(new GridLayout(3, 1));
    window.setSize(200, 250);
    window.setVisible(true);
}



}
