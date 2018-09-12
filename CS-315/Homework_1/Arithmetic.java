/*
    Author: Cameron Stark
    Assignment: Homework 1
    Class: CS 315
    File: Arithmetic.java
*/

import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Complex FirstValue = getUserValue(scanner, "First");
        Complex SecondValue = getUserValue(scanner, "Second");
        String Operation = getUserOperation(scanner);

        performOperation(FirstValue, SecondValue, Operation);
        scanner.close();

    }

    public static void printString(String text) {
        System.out.println(text);
    }

    public static Complex getUserValue(Scanner scanner, String value) {
        printString("Please enter the " + value + " number in either of the following formats R Value or C Value Value");

        Complex number = null;

        String[] userInputs = scanner.nextLine().split(" ");
        
        switch (userInputs[0]) {
            case "R":
                number = new Real(Double.parseDouble(userInputs[1]));
                break;
            case "C":
                number = new Complex(Double.parseDouble(userInputs[1]), Double.parseDouble(userInputs[2]));
                break;
        }

        return number;
    }

    public static String getUserOperation(Scanner scanner) {

        printString("Enter the operation you would like to preform. (A, S, M, D, ABS)");

        String[] operation = scanner.nextLine().split(" ");

        return operation[0].toUpperCase();
    }

    public static void performOperation(Complex firstValue, Complex secondValue, String operation) {

        switch (operation) {
            case "A":
                printString(firstValue + " + " + secondValue + " = " + firstValue.Add(secondValue));
                break;
            case "S":
                printString(firstValue + " - " + secondValue + " = " + firstValue.Subtract(secondValue));
                break;
            case "M":
                printString(firstValue + " * " + secondValue + " = " + firstValue.Multiply(secondValue));
                break;
            case "D":
                printString(firstValue + " / " + secondValue + " = " + firstValue.Divide(secondValue));
                break;
            case "ABS":
                printString("|" + firstValue + "| = " + firstValue.Abs());
                printString("|" + secondValue + "| = " + secondValue.Abs());
                break;

        }
    }


}