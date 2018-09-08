/*
Author: Cameron Stark
Assignment: HomeWork 1
Class: CS 315
*/
import java.util.Scanner;
import java.util.concurrent.CompletionException;

public class Arithmetic {



    public Arithmetic() {

    }

    public static void main(String[] args){
        Arithmetic arithmetic = new Arithmetic();

        Scanner reader = new Scanner(System.in);
        //String temp;

        arithmetic.printString("Please Enter A String In Either Of The Following Formats. (R Value or C Value Value):");
        String firstValue = reader.nextLine();

        //temp = reader.nextLine();
        //double[] firstValue = arithmetic.AssignValues(temp);

        arithmetic.printString("Please Enter Another String In Either Of The Following Formats. (R Value or C Value Value):");
        String secondValue = reader.nextLine();

        //temp = reader.nextLine();
        //double[] secondValue = arithmetic.AssignValues(temp);


        arithmetic.printString("Please Enter An Operation You Would Like To Preform. (Add, Subtract, Multiple, Divide, Absolute Value):");
        String operationType = reader.nextLine();

        reader.close();

        arithmetic.PreformOperation(firstValue, secondValue, operationType);
    }



    public void printString(String text) {
        System.out.println(text);
    }

    public void printDouble(Double number) {
        System.out.print(number);
    }

    public void PreformOperation(String FirstValue, String SecondValue, String Operation) {
        String[] tempArray;
        Complex firstNumber;
        Complex secondNumber;

        switch (Operation) {
            case "Add":
                //printString("Add");
                tempArray = FirstValue.split(" ");
                firstNumber = TestFirstValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestSecondValue(tempArray);


                printString(firstNumber.Add(secondNumber));
                break;

            case "Subtract":
                tempArray = FirstValue.split(" ");
                firstNumber = TestFirstValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestSecondValue(tempArray);

                printString(firstNumber.Subtract(secondNumber));
                break;

            case "Multiply":
                tempArray = FirstValue.split(" ");
                firstNumber = TestFirstValue(tempArray);

                tempArray = SecondValue.split(" ");
                secondNumber = TestSecondValue(tempArray);

                printString(firstNumber.Multiply(secondNumber));

        }
    }

    public Complex TestFirstValue(String[] tempArray) {
        Complex firstNumber = new Complex();

        if (tempArray[0] == "R" || tempArray[0] == "r") {
            firstNumber = new Real();
        } else if (tempArray[0].equals("C") || tempArray[0].equals("c")) {
            firstNumber = new Complex(Double.parseDouble(tempArray[1]), Double.parseDouble(tempArray[2]));
        }

        return firstNumber;
    }

    public Complex TestSecondValue(String[] tempArray) {
        Complex secondNumber = new Complex();

        if (tempArray[0] == "R" || tempArray[0] == "r") {
            secondNumber = new Real();
        } else if (tempArray[0].equals("C") || tempArray[0].equals("c")) {
            secondNumber = new Complex(Double.parseDouble(tempArray[1]), Double.parseDouble(tempArray[2]));
        }

        return secondNumber;
    }


}
