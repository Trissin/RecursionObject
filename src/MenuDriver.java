import java.util.Scanner; // import scanner
public class MenuDriver {
    public static void main (String [] args){ // main method
        RecursionObject program = new RecursionObject(); // create that object
        boolean rValue = false; // assume user cannot enter correct values
        int result = 0; // initialize result variable
        Scanner scanner = new Scanner(System.in); // scanner

        do { // a loop to run the program (until user quits)
            int programSelection = 0; // this variable will hold user's choice
            int limit = 0;  // desired value
            int repeat = 0; // repeat the programs
            // User prompt
            rValue = false; // set boolean false
            while (!rValue){
                System.out.println ("Press 1 for program 1. Press 2 for program 2. Press 3 for program 3."); // prompt user to pick program
                programSelection = scanner.nextInt(); // user inputs program
                if (programSelection <=0 || programSelection > 3){ // wrong input
                    System.out.println("The program you selected does not exist!\nPlease try selecting another program from the list.");// notify user
                }
                else{
                    rValue = true; // correct input, break loop and continue
                }
            }
            rValue = false; // reset to false
            do { // loop in case user enters wrong values
                System.out.println ("Enter the term which you would like to find:"); // prompt nth term
                limit = scanner.nextInt(); // user input
                if (limit <= 0){ // if user sets n <= 0
                    System.out.println("You cannot search for a term less than 1!"); // impossible term
                }
                else {
                    rValue = true; // user enters correct value, break loop and continue
                }
            } while (!rValue);
            rValue = false; // reset this boolean

            if (programSelection == 1){ // user picked first program
                rValue = true;
                result = program.recursiveOne(limit); // run first program
            }
            else if (programSelection == 2){ // user picked second program
                rValue = true;
                result = program.nonRecursiveTwo(limit); // run second program
            }
            else if (programSelection == 3){ // user picked third program
                rValue = true;
                // the user must enter in a second value for the ackermann function
                System.out.println ("You have selected the Ackermann function.\nPlease enter the second term which you would like to find:");
                int secondLimit = scanner.nextInt(); // user input
                result = program.recursiveThree(limit, secondLimit); // run third program
            }
            else { // user did not enter a program that can be used
                System.out.println("The program you selected does not exist!\nPlease try selecting another program from the list.");
            }
            System.out.println("The term is: " + result); // output the result
            if (programSelection == 3){ // only if user selected ackermann
                // prompt user to see # of times ackermann called
                System.out.println("Would you like to see how many times the Ackermann function was called?\nEnter 1 for yes, or 0 for no.");
                rValue = false;
                while (rValue == false){
                    int seeAckermannCalls = scanner.nextInt(); // user input
                    if (seeAckermannCalls == 1) { // user is curious
                        rValue = true;
                        // display # of times method called
                        System.out.println("The function was called " + program.howManyTimesWasTheAckermannFunctionCalled() + " times.");
                    }
                    else if (seeAckermannCalls == 0){ // user is not curious
                        rValue = true;
                    }
                    else {// some wrong input
                        System.out.println("That is not a valid input! Please try again."); // ask user to repeat
                    }
                }
            }
            System.out.println("Would you like to repeat the program?\nEnter 1 for yes, or 0 for no."); // ask user if they want to repeat the program
            repeat = scanner.nextInt(); // user input
            if (repeat == 1){ // user wants to repeat program
                rValue = false;
            }
            else if (repeat == 0){ // user does not want to repeat program
                rValue = true; // break this loop
            }
        } while (!rValue);
        System.out.println("Program closed."); // notify user program close
    }
}
