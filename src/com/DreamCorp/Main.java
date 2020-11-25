package com.DreamCorp;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ", 1_000, 1_000_000);
        double annualInterest = (readNumber("Annual Interest Rate: ", 1, 30));
        int years = (int) readNumber("Period (Years): ", 1, 30);
        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("");
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.print("Monthly Payments: " + mortgageFormatted);

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        double loanBalance;

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + "!");
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            double annualInterest,
            int years) {

        final int monthsInYear = 12;
        final int percent = 100;

        double monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = years * monthsInYear;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double loanBalance(
                                     int numberOfPaymentsMade,
                                     int principal,
                                     double monthlyInterest,
                                     int numberOfPayments) {

        if (numberOfPayments > 0) {
            numberOfPaymentsMade = numberOfPayments - 1;
            return numberOfPaymentsMade;
        }

        double loanBalance = principal *
                (Math.pow((1 + monthlyInterest), numberOfPayments)
                        - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);

        System.out.println(loanBalance);
        return loanBalance;
    }
}



