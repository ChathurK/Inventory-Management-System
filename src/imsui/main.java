package imsui;
import javax.swing.JFrame;

public class main {
    // Entry point of the program
    public static void main(String[] args) {
        // Create an instance of the login window(class)       
        JFrame Window1 = new login();

        Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Window1.setVisible(true);
    }
}