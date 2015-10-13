package com.example;
import java.util.*;

/**
 * Created by Felix on 10/12/15.
 */
public class MoonCalculator {

    private Scanner input = new Scanner(System.in);     //scanner class handles user input
    //Month and date variables hold date thats interesting to user.
    private String month = "";
    private String day = "";
    //Hashmaps will contain month and date info for full moons
    //hashmap containing all full moons except the ones for july (theres two)
    HashMap<String, Integer> mostFullMoons = new HashMap<String, Integer>();
    //hashmap for July
    HashMap<Integer, String> julyFullMoons = new HashMap<Integer, String>();
    //hashmap for number of month
    HashMap<String, Integer> monthToInt = new HashMap<String, Integer>();

    public void runMoonCalculator(){

        initiateDictionaries(); //instantiate dictionary data

        do{

            printToUser("Please enter the name of the Month interested in:");
            month = inputFromUser().toLowerCase();    //receive month from user

            if(mostFullMoons.containsKey(month)){
                //if the month user input is valid Jan - Dec (except for July)
                printToUser("Please enter the day you're interested in (numeric).");
                day = inputFromUser();      //receive day from user
                //convert number type Integer from Hashmap to int type
                int almanacDay = mostFullMoons.get(month).intValue();
                //convert string from user into int
                int userDay = Integer.parseInt(day);
                //check for data integrity
                if(userDay < 1 || userDay > 31){
                    printToUser("Invalid data, please check your entry and try again.");
                    break;
                }
                //now see if date given by user is greater than the one for the full moon
                if( userDay <= almanacDay){
                    //if day given by user is before or same as full moon on month given, then print day
                    printToUser("The next full moon is on: " + month + " " + mostFullMoons.get(month));
                }else{
                    //else if day given is after full moon on month given, look for next months full moon
                    int numericMonth = monthToInt.get(month).intValue();    //get int value of month
                    switch(numericMonth){
                        case 1:
                            printToUser("The next full moon is on: february " + mostFullMoons.get("february"));
                            break;
                        case 2:
                            printToUser("The next full moon is on: march " + mostFullMoons.get("march"));
                            break;
                        case 3:
                            printToUser("The next full moon is on: april " + mostFullMoons.get("april"));
                            break;
                        case 4:
                            printToUser("The next full moon is on: may " + mostFullMoons.get("may"));
                            break;
                        case 5:
                            printToUser("The next full moon is on: june " + mostFullMoons.get("june"));
                            break;
                        case 6:
                            printToUser("The next full moon is on: july 1");
                            break;
                        //no case for july, handled seperately
                        case 8:
                            printToUser("The next full moon is on: september " + mostFullMoons.get("september"));
                            break;
                        case 9:
                            printToUser("The next full moon is on: october " + mostFullMoons.get("october"));
                            break;
                        case 10:
                            printToUser("The next full moon is on: november " + mostFullMoons.get("november"));
                            break;
                        case 11:
                            printToUser("The next full moon is on: december " + mostFullMoons.get("december"));
                            break;
                        case 12:
                            printToUser("The next full moon is next year!");
                        default:
                            printToUser("Value not found");
                            break;
                    }
                }

            }else if (month.equalsIgnoreCase("july")){
                //if the month user input is valid (July)
                printToUser("Please enter the day you're interested in (numeric).");
                day = inputFromUser();      //receive day from user
                //convert string from user into int
                int userDay = Integer.parseInt(day);
                //check for data integrity
                if(userDay < 1 || userDay > 31){
                    printToUser("Invalid data, please check your entry and try again.");
                    break;
                }
                //check for day and print next full moon accordingly
                if(userDay > 1){
                    printToUser("The next full moon is on: july 31");
                }else{
                    printToUser("The next full moon is on: july 1");
                }

            }else{
                printToUser("Entry not found. Please review your entry and try again.");
            }



        }while(checkForYesNo());
        printToUser("Thank you for using Full Moon Calculator.");
        //exited correctly, terminate program
        System.exit(0);
    }


    //Method checks if user wants to try another date
    private boolean checkForYesNo(){
        printToUser("Would you like to try again? ( Y / N )");
        String tempAnswer = input.nextLine();
        if(tempAnswer.equalsIgnoreCase("Y")){
            return true;
        }else{
            return false;
        }
    }

    //Method prints submitted string to console
    private void printToUser(String string){
        System.out.println(string);
    }

    //Method receives user input and stores in global variable
    private String inputFromUser(){
        String tempInputLine = input.nextLine();
        //printToUser("echo: " + tempInputLine);      //testing
        return tempInputLine;
    }

    //Method initiates dictionary data
    private void initiateDictionaries(){

        //Initiate data for mostFullMoons Hashmap
        mostFullMoons.put("january", 4 );
        mostFullMoons.put("february", 3);
        mostFullMoons.put("march", 5);
        mostFullMoons.put("april", 4);
        mostFullMoons.put("may", 3);
        mostFullMoons.put("june", 2);
        mostFullMoons.put("august", 29);
        mostFullMoons.put("september", 27);
        mostFullMoons.put("october", 27);
        mostFullMoons.put("november", 25);
        mostFullMoons.put("december", 25);

        //Initiate data for julyFullMoons Hashmap
        julyFullMoons.put(1, "july");
        julyFullMoons.put(31, "july");

        //Initiate data for monthToInt Hashmap
        monthToInt.put("january", 1);
        monthToInt.put("february", 2);
        monthToInt.put("march", 3);
        monthToInt.put("april", 4);
        monthToInt.put("may", 5);
        monthToInt.put("june", 6);
        monthToInt.put("july", 7);
        monthToInt.put("august", 8);
        monthToInt.put("september", 9);
        monthToInt.put("october", 10);
        monthToInt.put("november", 11);
        monthToInt.put("december", 12);
    }
}
