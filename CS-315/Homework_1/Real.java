/*
    Author: Cameron Stark
    Assignment: Homework 1
    Class: CS 315
    File: Complex.java
*/

public class Real extends Complex { //creates the real which is an extension of the complex class

    public Real() { //creates a default real class with both values set to 0
        this.a = 0;
        this.b = 0;
    }

    public Real(double newA) { //creates a real value with a set to the request and b set to 0
        this.a = newA;
        this.b = 0;
    }

    @Override
    public String toString() {
        return("(" + this.a + ")");
    }

    public Real Add(Complex Value) { //add method for adding the real values
        return(
            new Real(
                (this.a + Value.a)
            )
        );
    }

    public Real Subtract(Complex Value) { //subtract method for subtracting the real values
        return(
            new Real(
                (this.a + Value.a)
            )
        );
    }

    public Real Multiply(Complex Value) { //multiply method for multiplying the real values
        return(
            new Real(
                (this.a * this.b)
            )
        );
    }

    public Real Divide(Complex Value) { //divide method for diving the real values
        if (Value.a == 0) {
            return null;
        }

        return(
            new Real(
                (this.a / this.b)
            )
        );
    }

    public Double Abs() {
        return(
            Math.sqrt((this.a * this.a) + (this.b * this.b))
        );
    }
}