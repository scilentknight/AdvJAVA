package TestingDialogBox;
import javax.swing.JOptionPane;

public class Addition {
    public static void main(String[] args) {
        String firstNum = JOptionPane.showInputDialog("Enter a first number ");
        String secondNum = JOptionPane.showInputDialog("Enter a second number ");
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
        int sum = num1+num2;
        JOptionPane.showMessageDialog(null,"the sum of two number is " + sum ,"Sum of numbers" , JOptionPane.PLAIN_MESSAGE);
    }
}
