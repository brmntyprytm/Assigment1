// NAME  : Bramantyo Priyo Utomo
// NPM   : 2206821563
// TA    : SA
// CLASS : KKI
// FILE  : Assignment1.java
//
// START OF THE PROGRAM!!!

import javax.swing.JOptionPane;
public class Assignment1 {
    public static void main(String[] args) {
        String in = JOptionPane.showInputDialog(null,
                "Enter a credit card number:\n", "Credit Card Validity " +
                "Checker", JOptionPane.PLAIN_MESSAGE);
        long num = Long.parseLong(in);
    }
}