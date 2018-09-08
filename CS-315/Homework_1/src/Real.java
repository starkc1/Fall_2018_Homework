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
        return(this.firstValue);
    }



}
