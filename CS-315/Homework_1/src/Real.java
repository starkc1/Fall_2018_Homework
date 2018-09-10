/*
Author: Cameron Stark
Assignment: HomeWork 1
Class: CS 315
*/

public class Real extends Complex {

    public Real() {
        a = b = 0;
    }

    public Real(double a) {
        this.a = a;
        this.b = 0;
    }

    @Override
    public String toString() {
        return(this.firstValue + " + " + this.secondValue + "i");
    }

    public String Add(Real Value) {
         String result;

         this.firstValue = Double.toString(this.a + Value.a);

         result = toString();

         return result;
    }

    public String Subtract(Real Value) {
        String result;

        this.firstValue = Double.toString(this.a - Value.a);

        result = toString();

        return result;
    }

    public String Multiply(Real Value) {
        String result;

        this.firstValue = Double.toString(this.a * Value.a);

        result = toString();

        return result;
    }

    public String Divide(Real Value) {
        String result;

        this.firstValue = Double.toString(this.a / Value.a);

        result = toString();

        return result;
    }


}
