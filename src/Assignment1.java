// NAME : Bramantyo Priyo Utomo
// NPM : 2206821563
// TA : SA
// CLASS : KKI
// FILE : Assignment1.java
// GITHUB REPO : https://github.com/brmntyprytm/Assigment1.git
// COLLABORATOR : Andika Pramudya Wardana, Muhammad Fahmi Habibie
// OUTSIDE SOURCES : https://www.geeksforgeeks.org/program-credit-card-number-validation/
//
// START OF THE PROGRAM!!!

import javax.swing.JOptionPane;
public class Assignment1 {
    public static void main(String[] args) {
        boolean quit = false;
        do {
            String in = JOptionPane.showInputDialog(null,
                 "Enter a Credit Card / Debit Card Number " +
                 "as a long integer, QUIT to end:\n",
                 "Credit Card Validity " + "Checker",
                 JOptionPane.PLAIN_MESSAGE);
            if (in.equalsIgnoreCase("quit")) {
                quit = true;
            } else {
                try {
                    long input = Long.parseLong(in);
                    if (isValid(input)) {
                        JOptionPane.showMessageDialog(null,
                        "The number " + input + " is valid.",
                        "Credit Card Validity " + "Checker",
                        JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                        "The number " + input + " is invalid.",
                        "Credit Card Validity " + "Checker",
                        JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                    "\"" + in + "\"" + " input is not allowed.\n" +
                    "Try again.", "Credit Card Validity " + "Checker",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (!quit);
    }
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

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 9) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + ""));
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d){
        String num = Long.toString(d);
        return num.length();
    }

    public static long getPrefix(long number, int k) {
        String num = Long.toString(number);
        if (num.length() < k) {
            return number;
        } else {
            String prefixString = num.substring(0, k);
            return Long.parseLong(prefixString);
        }
    }
}