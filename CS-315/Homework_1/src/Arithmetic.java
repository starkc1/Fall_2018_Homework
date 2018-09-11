/*
Author: Cameron Stark
Assignment: HomeWork 1
Class: CS 315
*/
import java.util.Scanner;

public class Arithmetic {



    public Arithmetic() {

    }

    public static void main(String[] args){
        Arithmetic arithmetic = new Arithmetic(); //Create Arithmetic object

        Scanner reader = new Scanner(System.in); //Create Scanner object
        //String temp;

        arithmetic.printString("Please Enter A String In Either Of The Following Formats. (R Value or C Value Value):");
        String firstValue = reader.nextLine(); //read the users first inputted value


        arithmetic.printString("Please Enter Another String In Either Of The Following Formats. (R Value or C Value Value):");
        String secondValue = reader.nextLine(); //Read the users second inputted value


        arithmetic.printString("Please Enter An Operation You Would Like To Preform. (Add, Subtract, Multiply, Divide, Absolute):");
        String operationType = reader.nextLine(); //read the users third inputted value

        reader.close(); //close the scanner object

        arithmetic.PreformOperation(firstValue, secondValue, operationType); //send the values to the preform operations method
    }


    public void printString(String text) { //shortcut method for simple printing
        System.out.println(text);
    }

    public void printDouble(Double number) { //shortcut method for simple printing
        System.out.print(number);
    }

    public void PreformOperation(String FirstValue, String SecondValue, String Operation) {
        String[] tempArray; //create empty string array
        Complex firstNumber; //create a placeholder for a complex object
        Complex secondNumber; //create a placeholder for a complex object

        switch (Operation) { //switch statement for the different operations types
            case "Add": //if the user inputted add
                tempArray = FirstValue.split(" "); //split the first inputted value along the white spaces
                firstNumber = TestAssignValue(tempArray); //test whether the input is real or complex and create respected object

                tempArray = SecondValue.split(" "); //
                secondNumber = TestAssignValue(tempArray);

                printString(firstNumber.Add(secondNumber));
                break;

            case "Subtract":
                tempArray = FirstValue.split(" ");
                firstNumber = TestAssignValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestAssignValue(tempArray);

                printString(firstNumber.Subtract(secondNumber));
                break;

            case "Multiply":
                tempArray = FirstValue.split(" ");
                firstNumber = TestAssignValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestAssignValue(tempArray);

                printString(firstNumber.Multiply(secondNumber));
                break;

            case "Divide":
                tempArray = FirstValue.split(" ");
                firstNumber = TestAssignValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestAssignValue(tempArray);

                printString(firstNumber.Divide(secondNumber));
                break;

            case "Absolute":
                tempArray = FirstValue.split(" ");
                firstNumber = TestAssignValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestAssignValue(tempArray);

                printString(firstNumber.abs());
                printString(secondNumber.abs());

        }
    }

    public Complex TestAssignValue(String[] tempArray) {
        Complex value = null;

        if (tempArray[0].equals("R") || tempArray[0].equals("r")) {
            value = new Real(Double.parseDouble(tempArray[1]));
        } else if (tempArray[0].equals("C") || tempArray.equals("c")) {
            value = new Complex(Double.parseDouble(tempArray[1]), Double.parseDouble(tempArray[2]));
        }

        return value;
    }



}
