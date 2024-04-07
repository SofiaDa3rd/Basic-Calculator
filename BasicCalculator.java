import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicCalculator extends JFrame implements ActionListener {
    JLabel LNum1, LNum2, LResult;
    JTextField TNum1, TNum2, TResult;
    JButton BAdd, BSubtract, BMultiply, BDivide, BPercentage;
    JPanel panel;

    public BasicCalculator() {
        LNum1 = new JLabel("Number 1:");
        LNum1.setFont(new Font("Arial", Font.PLAIN, 14));
        LNum2 = new JLabel("Number 2:");
        LNum2.setFont(new Font("Arial", Font.PLAIN, 14));
        LResult = new JLabel("Result:");
        LResult.setFont(new Font("Arial", Font.PLAIN, 14));

        TNum1 = new JTextField(20);
        TNum2 = new JTextField(20);
        TResult = new JTextField(20);
        TResult.setEditable(false);

        BAdd = new JButton("Add");
        BSubtract = new JButton("Subtract");
        BMultiply = new JButton("Multiply");
        BDivide = new JButton("Divide");
        BPercentage = new JButton("Percentage");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(LNum1);
        panel.add(TNum1);
        panel.add(LNum2);
        panel.add(TNum2);
        panel.add(LResult);
        panel.add(TResult);
        panel.add(BAdd);
        panel.add(BSubtract);
        panel.add(BMultiply);
        panel.add(BDivide);
        panel.add(BPercentage);

        setLayout(new FlowLayout());
        add(panel);
        setTitle("Calculator");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BAdd.addActionListener(this);
        BSubtract.addActionListener(this);
        BMultiply.addActionListener(this);
        BDivide.addActionListener(this);
        BPercentage.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        double num1, num2, result;

        try {
            num1 = Double.parseDouble(TNum1.getText());
            num2 = Double.parseDouble(TNum2.getText());

            if (btn == BAdd) {
                result = num1 + num2;
                TResult.setText(String.valueOf(result));
            } else if (btn == BSubtract) {
                result = num1 - num2;
               TResult.setText(String.valueOf(result));
            } else if (btn == BMultiply) {
                result = num1 * num2;
                TResult.setText(String.valueOf(result));
            } else if (btn == BDivide) {
                if (num2 != 0) {
                    result = num1 / num2;
                    TResult.setText(String.valueOf(result));
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (btn == BPercentage) {
                result = (num1 * num2) / 100;
                TResult.setText(String.valueOf(result));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}