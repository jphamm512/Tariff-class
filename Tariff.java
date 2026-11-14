
import java.util.*;
import java.util.Scanner;
/* This program calculates the price of an imported item
based on three different tariffs throughout a 30 day month.
this will show a calendar showing the price each day
and calculates the average price per week and month.*/
public class Tariff{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //Print out my title and versions
            System.out.println("Fall 2026 - CS1083 - Section 001 - Project 1 - Tariff - written by John Pham");
            System.out.println();
        //Get the user input of the base price of the item
            System.out.println("Input the base price of the imported item: ");
            double basePrice = scnr.nextDouble();
        //Get the user input of the first, second, and third Tariff and the percentage and what day it is placed
            System.out.println("Input the first tariff day: ");
            int firstTariff = scnr.nextInt();
            System.out.println("Input the % starting first tariff day: ");
            double firstTariffPercent = scnr.nextDouble();

            System.out.println("Input the second tariff day: ");
            int secondTariff = scnr.nextInt();
            System.out.println("Input the % starting second tariff day: ");
            double secondTariffPercent = scnr.nextDouble();

            System.out.println("Input the third tariff day: ");
            int thirdTariff = scnr.nextInt();
            System.out.println("Input the % starting third tariff day: ");
            double thirdTariffPercent = scnr.nextDouble();
   // ask the user which day it will start
            System.out.println("First day of the month (0-Sun, 1-Mon, 2-Tue, 3-Wed, 4-Thu, 5-Fri, 6-Sat): ");
            int theDay = scnr.nextInt();

            System.out.println("Price Change Based on Tariffs");
            System.out.println();
            System.out.println("Sunday       Monday       Tuesday      Wednesday    Thursday     Friday       Saturday     AVG/Week");
     /*  a count is in place for days, newPrice is when the tariff is affected, averagePrice is the average of the newPrice per week, monthTotal is 
      * the average of that month, and daysInWeek is just counting the days in a week*/
            int count = 1;
            double newPrice;
            double averagePrice = 0;
            double monthTotal = 0;
            int daysInWeek = 0;
        /* This is a nested for loop that creates the rows and columns; after 7 days, it will go to the next line. 
         * The first loop is the week, which is going to create the columns. After every iteration, averagePrice and daysInWeek will reset to zero so that when we find the average, it will use those variables. */
            for(int week = 1; count <= 30; week++){
                    averagePrice = 0;
                    daysInWeek = 0;
/* This is the second loop, so if theDay variable, which is given from the user input, it will start on that day of the week, 
 * and the day variable will go through each if statement to apply the tariff that the user input*/
                for(int day = 1; day <= 7; day++) {
                    if (week == 1 && day <= theDay) {
                            System.out.printf("%02d- %7.2f  ", 0, 0.0);
                        }
                    else if (count <= 30){
                            if (count >= thirdTariff) {
                                    newPrice = basePrice * (1 + thirdTariffPercent / 100);
                            }
                            else if (count >= secondTariff) {
                                newPrice = basePrice * (1 + secondTariffPercent / 100);
                            }
                            else if (count >= firstTariff) {
                                newPrice = basePrice * (1 + firstTariffPercent / 100);
                            }
                            else {
                                newPrice = basePrice;
                            }
// this is what it prints after if goes through the if statements: the average of the prices are also being updated here as well
                            System.out.printf("%02d- %7.2f ", count, newPrice);
                            System.out.print(" ");
                            averagePrice = averagePrice + newPrice;
                            monthTotal = monthTotal + newPrice;
                            daysInWeek++;
                            count++;
                        }
// once it hits 30 days, it will just print zero for the day and price
                    else {
                        System.out.printf("%02d- %7.2f ", 0, 0.0);
                    }
                }
// print out the average price of that week    
            averagePrice = averagePrice / daysInWeek;
            System.out.printf("W%02d- %7.2f%n", week, averagePrice);
            System.out.println();
                    
        }
// print out the average price of that month   
        System.out.printf("Average per month: %.2f%n", monthTotal / 30);

        
    }
}
