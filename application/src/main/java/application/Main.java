package application;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    /** Prints the main menu and navigates the user to other menus
     */
    public static void menu(){
        Boolean stay = true;
        printMenu();
        while(stay && keyboard.hasNext()){
            String input = keyboard.next();
            
            switch(input){
                case "1":
                printNewTab();
                break;

                case "2":
                printCurrTabs();
                break;

                case "3":
                editTabs();
                break;

                case "4":
                stay = false;
                break;

                default:
                System.out.println("This is an invalid menu choice, please enter 1,2,3 or 4");
            }
            if(stay){
                printMenu();
            }

        }
        keyboard.close();
        System.out.println("Thank you for using the bass tabs workshop!");
    }

    /** Prints the main menu.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("Welcome to the bass tabs workshop!");
        System.out.println("Navigation:");
        System.out.println("1. Create a new tab");
        System.out.println("2. View all my current tabs");
        System.out.println("3. Edit an existing tab");
        System.out.println("4. Exit");
        System.out.println("Please choose an option (1,2,3,4):");
    }

    /** Prints the create tabs menu.
     */
    private static void printNewTab() {
        
        Boolean stay = true;
        System.out.println("Input the base chords:");
        System.out.println("Enter 'exit' to exit to main menu");
        while(stay && keyboard.hasNext()){
            String input = keyboard.next();

            switch(input){
                case "exit":
                stay = false;
                break;

                default:
                //call function to create new tab
                System.out.println("Here is your new bass line:");
                
                System.out.println();
                System.out.println("Input the base chords:");
                System.out.println("Enter 'exit' to exit to main menu");
            }

            
        }
    }

    /** Prints the current tabs.
     */
    private static void printCurrTabs() {
        // call function to retrieve currently stored tabs
        System.out.println("Show current tabs"); 
        boolean stay = true;
        System.out.println("Enter 'exit' to exit to main menu");
        while(stay && keyboard.hasNext()){
            String input = keyboard.next();

            switch(input){
                case "exit":
                    stay = false;
                    break;

                default:
                    System.out.println("Your input is invalid");
            }

        }
    }

    /** Prints the edit tabs menu.
     */
    private static void editTabs() {
        // call function to retrieve currently stored tabs
        System.out.println("Please choose a tab to edit:");
        System.out.println("Enter 'exit' to exit to main menu");
        boolean stay = true;
        while(stay && keyboard.hasNext()){
            String input = keyboard.next();

            switch(input){
                case "exit":
                    stay = false;
                    break;

                default:
                    System.out.println("There is currently no tabs");
            }

        }
        System.out.println("Please choose a tab to edit:");
        System.out.println("Enter 'exit' to exit to main menu");
    }
}

