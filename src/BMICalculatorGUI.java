import javax.swing.*;
import java.awt.*;

public class BMICalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(380, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(21, 32, 43)); // dark blue-gray

        JLabel lblHeight = new JLabel("Height (meters):");
        JLabel lblWeight = new JLabel("Weight (kg):");
        JLabel lblResult = new JLabel("");
        lblHeight.setForeground(Color.WHITE);
        lblWeight.setForeground(Color.WHITE);
        lblResult.setForeground(Color.YELLOW);

        JTextField txtHeight = new JTextField();
        JTextField txtWeight = new JTextField();
        JButton btnCalculate = new JButton("Calculate BMI");
        btnCalculate.setBackground(new Color(60, 90, 130));
        btnCalculate.setForeground(Color.WHITE);

        lblHeight.setBounds(30, 40, 120, 28);
        txtHeight.setBounds(160, 40, 120, 28);
        lblWeight.setBounds(30, 80, 120, 28);
        txtWeight.setBounds(160, 80, 120, 28);
        btnCalculate.setBounds(90, 130, 160, 35);
        lblResult.setBounds(30, 200, 300, 30);
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(lblHeight);
        panel.add(txtHeight);
        panel.add(lblWeight);
        panel.add(txtWeight);
        panel.add(btnCalculate);
        panel.add(lblResult);

        frame.add(panel);

        btnCalculate.addActionListener(e -> {
            try {
                double height = Double.parseDouble(txtHeight.getText());
                double weight = Double.parseDouble(txtWeight.getText());
                BMI bmiObj = new BMI(height, weight);
                double bmi = bmiObj.calculateBMI();
                String category = bmiObj.getCategory();
                lblResult.setText(String.format("Your BMI: %.2f (%s)", bmi, category));
                JOptionPane.showMessageDialog(frame,
                        "BMI: " + String.format("%.2f", bmi) + "\nCategory: " + category,
                        "BMI Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter valid height and weight.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}