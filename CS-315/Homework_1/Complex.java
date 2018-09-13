/*
    Author: Cameron Stark
    Assignment: Homework 1
    Class: CS 315
    File: Complex.java
*/

public class Complex {

    public double a;
    public double b;

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex(double newA, double newB) {
        this.a = newA;
        this.b = newB;
    }

    @Override
    public String toString() {
        return("(" + this.a + " + " + this.b + "i)");
    }

    public Complex Add(Complex Value) {
        return(
            new Complex(
                (this.a + Value.a),
                (this.b + Value.b)
            )
        );
    }

    public Complex Subtract(Complex Value) {
        return(
            new Complex(
                (this.a - Value.a),
                (this.b - Value.b)
            )
        );
    }

    public Complex Multiply(Complex Value) {
        return(
            new Complex(
                (
                    (this.a * Value.a) - (this.b * Value.b)
                ),
                (
                    (this.b * Value.a) + (this.a * Value.b)
                )
            )
        );
    }

    public Complex Divide(Complex Value) {

        if (this.a == 0 & this.b == 0) {
            return null;
        }
        return(
            new Complex(
                (
                    ((this.a * Value.a) + (this.b * Value.b)) / ((Value.a * Value.a) + (Value.b * Value.b))
                ),
                (
                    ((this.b * Value.a) - (this.a * Value.b)) / ((Value.a * Value.a) + (Value.b * Value.b))
                )
            )
        );
    }

    public Double Abs() {
        return(
            Math.sqrt((this.a * this.a) + (this.b * this.b))
        );
    }

}