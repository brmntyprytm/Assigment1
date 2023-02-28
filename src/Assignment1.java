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
        String in;
        long num = Long.parseLong(in);
        boolean quit = false;
        do {
            in = JOptionPane.showInputDialog(null,
                 "Enter a Credit Card / Debit Card Number " +
                 "as a long integer, QUIT to end:\n" + "Credit Card Validity "
                 + "Checker", JOptionPane.PLAIN_MESSAGE);
            if (in == null) {
                quit = true;
            }
            if (in.equalsIgnoreCase("quit")) {
                quit = true;
            } else {
                try {
                    if (isValid(num) == true) {
                        JOptionPane.showMessageDialog(null,
                        "The number " + num + " is valid." +
                        "Credit Card Validity " + "Checker" +
                        JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                        "The number " + num + " is invalid." +
                        "Credit Card Validity " + "Checker" +
                        JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                    "The " + num + " input is not allowed." +
                    "Credit Card Validity " + "Checker" +
                    JOptionPane.PLAIN_MESSAGE);
                }
            }
        } while (!quit);
    public static boolean isValid(long number) {
        }
    }
}