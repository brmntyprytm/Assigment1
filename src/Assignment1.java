// NAME : Bramantyo Priyo Utomo
// NPM : 2206821563
// TA : SA
// CLASS : KKI
// FILE : Assignment1.java
// GITHUB REPO : https://github.com/brmntyprytm/Assigment1.git
// COLLABORATOR : Andika Pramudya Wardana, Muhammad Fahmi Habibie
// OUTSIDE SOURCES : https://www.geeksforgeeks.org/program-credit-card-number-validation/
//                   https://coderanch.com/t/342124/java/display-bold-text-JOptionPane
//
// START OF THE PROGRAM!!!

// Imports JOptionPane for the input window and the message boxes
import javax.swing.JOptionPane;
public class Assignment1 {
    public static void main(String[] args) {
        // Prompts the user to enter a credit card number as a long integer
        /* The do while statement prevents the program from exiting while
        the boolean value "quit" remains false.
        */
        boolean quit = false;
        do {
            String in = JOptionPane.showInputDialog(null,
                    """
                    Enter a Credit Card / Debit Card Number as a long integer.
                    Type quit or cancel to end.
                    """,
                 "Credit Card Validity " + "Checker",
                 JOptionPane.PLAIN_MESSAGE);
            /* The program will quit when the user inputs quit in either capital
            or in lowercase as the boolean value will become true.
            */
            if (in.equalsIgnoreCase("quit")) {
                quit = true;
            } else {
                try {
                /* The try and catch statement makes it so that the program
                   will continue as the try statement is fulfilled, and it
                   will return a window either show a valid or invalid according
                   to the user input.
                 */
                    long input = Long.parseLong(in);
                    if (isValid(input)) {
                        JOptionPane.showMessageDialog(null,
                        "<html><b>The number " + input + " is valid.</b><html>",
                        "Credit Card Number Valid",
                        JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                        "<html><b>The number " + input + " is invalid.</b><html>\n" +
                        "Try again.", "Credit Card Number Invalid",
                        JOptionPane.PLAIN_MESSAGE);
                    }
                /* When the try statement is unsuccessful, the program will execute the following
                block, it will pop up a window showing that the user does not input a desired value.
                for example: strings instead of integers.
                */
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                    "<html><b>\"" + in + "\"" + " input is not allowed.</b><html>\n" +
                    "Try again.", "Check Failed ",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        // The program relies on the boolean statement of quit to remain false.
        } while (!quit);
    }
    // This method returns true if the card number is valid
    /* It checks whether the prefix of the user input begins with 4, 5, 37, or 6
       it will also check the sum of both double even place and odd place using
       the sumOfDoubleEvenPlace and sumOfOddPlace, which we will get into shortly.
    */
    public static boolean isValid(long number) {
        int size = getSize(number);
        boolean validPrefix = prefixMatched(number, 4) ||
                              prefixMatched(number, 5) ||
                              prefixMatched(number, 37) ||
                              prefixMatched(number, 6);
        boolean validSum = (sumOfDoubleEvenPlace(number) +
                            sumOfOddPlace(number)) % 10 == 0;
        boolean validSize = size >= 13 && size <= 16;
        return validPrefix && validSum && validSize;
    }
    // This method returns the integer sum of the even place
    /* It sums the double of every even indexed digit of the user input, starting
       from the second last digit.
    */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }
    // This method is used by the sum of even and odd place, returns a single digit
    /* This checks whether the output of sum of even and odd place if it returned
       either a single or double digits. It performs integer division by 10 for the
       power of 1 of the integer and modulo it by 10 for the power of 0.
     */
    public static int getDigit(int number) {
        if (number < 9) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }
    // This method returns the integer sum of the odd place
    /* It sums the odd indexed digit of the user input, starting from the last digit*/
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + ""));
        }
        return sum;
    }
    // The prefix matched method is self-explanatory.
    /* it takes the rightmost index of the user input to the argument using the
       getIndex method which we will get into shortly, and see if it matches the
       given prefix d, which will then be used by the isValid method.
    */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }
    // The getSize method is used for converting the long into a string
    /* so that the length function can be used to determine its length, and is
       again used by the isValid method.
    */
    public static int getSize(long d){
        return Long.toString(d).length();
    }
    // The getPrefix method is used to return the prefix
    /* It is used for the prefixMatched method that we have covered just now.
       It converts and checks the number argument into string and then taking
       a substring of the first k characters. It should return the number itself
       when the length is less than k.
    */
    public static long getPrefix(long number, int k) {
        String num = Long.toString(number);
        if (num.length() < k) {
            return number;
        } else {
            String prefix = num.substring(0, k);
            return Long.parseLong(prefix);
        }
    }
}