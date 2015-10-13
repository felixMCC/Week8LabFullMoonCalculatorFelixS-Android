package com.example;

public class MainClassMoonCalc {

    public static void main(String [] args){
        System.out.println("Week 8 Lab: Full Moon Calculator\n\nBy: Nestor (Felix) Sotres\n\nThis program receives a date from the user" +
                " and prints out the next Full Moon date using the Farmers Almanac data from 2015.");

        //Create instance of MoonCalculator class to run program
        MoonCalculator run = new MoonCalculator();
        run.runMoonCalculator();                    //call starter function

    }
}
