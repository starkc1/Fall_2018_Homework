// Author: Cameron Stark
// Class: CS 315
// Assignment: Homework 3
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = getUsersType();

        if (type == 'B') {
            int bits = getNumberBits();
            generateBinaryCode(bits, new ArrayList<String>(0));
        } else if (type == 'G') {
            int bits = getNumberBits();
            generateGrayCode(bits, new ArrayList<String>(0));
        } else {
            System.out.println("Wrong input");
        }


        scanner.close();
    }

    public static String getUsersType() {
        System.out.println("Please Enter B for Binary or G for Gray");
        return(scanner.nextLine().toUpperCase());
    }

    public static int getNumberBits() {
        System.out.println("Please Enter the number of bits you would like");
        return(scanner.nextLine());
    }

    public static void generateBinaryCode(int bits, ArrayList<String> list) {

    }

    public static void generateGrayCode(int bits, ArrayList<String> list) {
        
    }
}