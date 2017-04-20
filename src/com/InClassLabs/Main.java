package com.InClassLabs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double atBat;

        String keepGoing = "yes";

        System.out.println("Batting Average Calculator");


        do {
            System.out.println("Enter number of at-bats for your player: ");

            atBat = scan.nextDouble();

            double[] numBasesEarned = new double[(int) atBat];

            for (int i = 0; i < numBasesEarned.length; i++) {
                System.out.println("Enter number of bases earned for your player: ");
                double result = scan.nextDouble();
                numBasesEarned[i] = result;
            }
            scan.nextLine();

            System.out.println("SLUGGING PERCENTAGE IS " + (sluggingPercentCalc(numBasesEarned, atBat)));

            System.out.println("BATTING AVERAGE IS " + (battingAverageCalc(numBasesEarned, atBat)));

            System.out.println("Would you like to enter data for another player? Enter 'yes' or 'no': ");
            keepGoing = scan.nextLine();


        } while (keepGoing.equalsIgnoreCase("yes"));
        System.out.println("Exiting the batting calculator.");

    }




    public static double sluggingPercentCalc(double[] numBasesEarned, double atBat) {

        double sum = DoubleStream.of(numBasesEarned).sum();
        double sluggingPercent = sum / atBat;
        return sluggingPercent;

    }


    public static double battingAverageCalc(double [] numBasesEarned, double atBat) {

        double numBasesEarnedLessStrike = 0.0;
        for (int i = 0; i < numBasesEarned.length; i++){
            if (numBasesEarned[i] > 0){
                numBasesEarnedLessStrike = numBasesEarnedLessStrike + 1;
            }
        }
        double battingAvg = numBasesEarnedLessStrike / atBat;
        return battingAvg;
    }





}



