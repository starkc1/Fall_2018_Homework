// Author: Cameron Stark
// Class: CS 315
// Assignment: Homework 3
import java.util.ArrayList;
import java.util.Scanner;


public class BinaryCodes {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String type = getUsersType(scanner);

        if (type.equals("B")) {
            int bits = getNumberBits(scanner);
            generateBinaryCode(bits, new ArrayList<String>(0));
        } else if (type.equals("G")) {
            int bits = getNumberBits(scanner);
            generateGrayCode(bits);
        } else {
            System.out.println("Wrong input");
        }


        scanner.close();
    }

    public static String getUsersType(Scanner scanner) {
        System.out.println("Please Enter B for Binary or G for Gray");
        return(scanner.nextLine().toUpperCase());
    }

    public static int getNumberBits(Scanner scanner) {
        System.out.println("Please Enter the number of bits you would like");
        return(Integer.parseInt(scanner.nextLine()));
    }

    public static void generateBinaryCode(int bits, ArrayList<String> list) {
        int expListSize = (int)Math.pow(2, bits);
        int listSize = list.size();

        if (listSize == expListSize) {
            for (int i = 0; i < listSize; i++) {
                System.out.println(list.get(i));
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder(bits);

            for (int i = bits - 1; i >= 0; i--) {
                stringBuilder.append((listSize >> i) & 1);
            }

            list.add(stringBuilder.toString());

            generateBinaryCode(bits, list);
        }
    }

    public static void generateGrayCode(int bits) {
        grayCode("", bits);
    }

    public static void grayCode(String pref, int bits) {
        if (bits == 0) {
            System.out.println(pref);
        } else {
            grayCode(pref + "0", bits - 1);
            reverseGrayCode(pref + "1", bits - 1);
        }
    }

    public static void reverseGrayCode(String pref, int bits) {
        if (bits == 0) {
            System.out.println(pref);
        } else {
            grayCode(pref + "1", bits - 1);
            reverseGrayCode(pref + "0", bits - 1);
        }
    }  



}