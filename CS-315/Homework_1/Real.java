/*
    Author: Cameron Stark
    Assignment: Homework 1
    Class: CS 315
    File: Complex.java
*/

public class Real extends Complex {

    public Real() {
        this.a = 0;
        this.b = 0;
    }

    public Real(double newA) {
        this.a = newA;
        this.b = 0;
    }

    @Override
    public String toString() {
        return("(" + this.a + ")");
    }

    public Real Add(Complex Value) {
        return(
            new Real(
                (this.a + Value.a)
            )
        );
    }

    public Real Subtract(Complex Value) {
        return(
            new Real(
                (this.a + Value.a)
            )
        );
    }

    public Real Multiply(Complex Value) {
        return(
            new Real(
                (this.a * Value.a)
            )
        );
    }

    public Real Divide(Complex Value) {
        if (Value.a == 0) {
            return null;
        }

        return(
            new Real(
                (this.a / Value.a)
            )
        );
    }

    public Double Abs() {
        return(
            Math.sqrt((this.a * this.a) + (this.b * this.b))
        );
    }
}