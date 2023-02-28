// NAME        : Bramantyo Priyo Utomo
// NPM         : 2206821563
// TA          : SA
// CLASS       : KKI
// FILE        : Assignment1.java
// GitHub Repo :
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
            long input = Long.parseLong(in);
            if (in.equalsIgnoreCase("QUIT")) {
                quit = true;
            } else {
                try {
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
                    "\"" + input + "\"" + " input is not allowed.\n" +
                    "Try again.", "Credit Card Validity " + "Checker",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (!quit);
    }
    public static boolean isValid(long number) {
        if (getSize(number) >= 13 &&
            getSize(number) <= 16 &&
            (prefixMatched(number, 4) ||
             prefixMatched(number, 5) ||
             prefixMatched(number, 37) ||
             prefixMatched(number, 6)) &&
            (sumOfDoubleEvenPlace(number) +
             sumOfOddPlace(number)) % 10 == 0) {
            return true;
        } else {
            return false;
        }
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