/*
Author: Cameron Stark
Assignment: HomeWork 1
Class: CS 315
*/

public class Complex {
    public double a;
    public double b;

    public String firstValue;
    public String secondValue;

    public Complex() {
        a = b = 0;
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return (this.firstValue + " + " + this.secondValue + "i");
    }

    public String Add(Complex Value) {
        String result;

        this.firstValue = Double.toString(this.a + Value.a);
        this.secondValue = Double.toString(this.b + Value.b);

        result = toString();

        return result;
    }

    public String Subtract(Complex Value) {
        String result;

        this.firstValue = Double.toString(this.a - Value.a);
        this.secondValue = Double.toString(this.b - Value.b);

        result = toString();

        return result;
    }

    public String Multiply(Complex Value) {
        String result;

        this.firstValue = Double.toString((this.a * Value.a) - (this.b * Value.b));
        this.secondValue = Double.toString((this.b * Value.a) + (this.a * Value.b));

        result = toString();

        return result;
    }

    public String Divide(Complex Value) {
        String result;

        this.firstValue = Double.toString(((this.a * Value.a) + (this.b * Value.b)) / ((Value.a * Value.a) + (Value.b * Value.b)));
        this.secondValue = Double.toString(((this.b * Value.a) - (this.a * Value.b)) / ((Value.a * Value.a) + (Value.b * Value.b)));

        result = toString();

        return result;
    }


    public String abs() {
        String result;

        this.firstValue = Double.toString(Math.sqrt( (this.a * this.a) + (this.b * this.b) ));

        result = this.firstValue;

        return result;

    }

}
