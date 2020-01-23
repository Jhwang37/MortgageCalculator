package com.company;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double l = 0; //loan amount
        double i = 0; //interest rate
        double mp = 0;
        double bal = 0; // balance
        int trm; //years for loan payment

        System.out.printf("Enter the loan amount: ");
        l = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        i = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        trm = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        mp = processSomething(l, i, trm);// using the method processsomething, to get monthly payments.
        bal = -(mp*(trm*12)); //balance owed to bank
        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", bal);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", mp);
    }


    public static double processSomething(double l, double i, int trm) { //method for monthly payments that takes the parameters loan amt/interest rate/and years

        double rate = (i/ 100) / 12; //
        double base = (1 + rate);
        double months = trm* 12;
        double result = 0.0;
        result = ((rate * l) / (1 - Math.pow(base, -months))); //formula for monthly payments

        return result;
    }
}