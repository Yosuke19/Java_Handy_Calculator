import java.util.InputMismatchException;
import java.util.Scanner;

public class OOPCalculator {
	
	int menuChoice;  
    float firstFloat;
    float secondFloat;
    
    Scanner readInput = new Scanner(System.in);
    float result;

    public int askCalcChoice() {
    	int inputInt;
		System.out.print("Welcome to Yosuke's Handy Calculator\n\n");
    	System.out.println("\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n\t4. Division\n\t5. Exit\n\n ");
    	System.out.print("What would you like to do?");
    	do {
    		try {
    			inputInt = readInput.nextInt();
    			if (inputInt >= 1 && inputInt <= 5) {
    				break;
    			} else {
    				System.out.println("You have not entered a number between 1 and 5. Try again.");
    				readInput.nextLine();
    				continue;
    			}
    		} catch (final InputMismatchException e) {
    			System.out.println("You have entered an invalid choice. Try again.");
    			readInput.nextLine();
    			continue;
    			}
    		} 
    	while (true);
    	menuChoice = inputInt;
    	return menuChoice;
    }
    
    public void askTwoValues () {
		float float1;
		float float2;
		do {
			System.out.print("Enter two floats separated by a space: ");
			try {
				float1 = readInput.nextFloat();
				float2 = readInput.nextFloat();
				break;
				}
			catch (final InputMismatchException e) {
				System.out.print("You have entered an invalid input. Try again.");
				readInput.nextLine();
				continue;
				}
		} while (true);
		firstFloat = float1;
		secondFloat = float2;
    }
    
    public void displayResults() {
    	switch (menuChoice) { 
		case 1:
			result = firstFloat + secondFloat; 
			System.out.printf("Result of adding %.2f and %.2f is %.2f.\n\n",firstFloat, secondFloat, result);
			break;
		case 2:
			result = firstFloat - secondFloat; 
			System.out.printf("Result of subtracting %.2f and %.2f is %.2f.\n\n",firstFloat, secondFloat, result);
			break;
		case 3:
			result = firstFloat * secondFloat; 
			System.out.printf("Result of multiplying %.2f and %.2f is %.2f.\n\n",firstFloat, secondFloat, result);
			break;
		case 4:
			
			if (secondFloat == 0) {
				// Give a second chance to enter other than a zero.
				System.out.print("You can’t divide by zero please re-enter both floats:");
				try {
					firstFloat = readInput.nextFloat();
					secondFloat = readInput.nextFloat();
				} catch (final InputMismatchException e) {
					// If the input is invalid, give up
					System.out.println("You have entered an invalid input.");
					break;
				}
				if (secondFloat == 0) {
					// If second float is still zero, give up
					System.out.println("You can’t divide by zero.");
					break;
				}
			}
				
			result = firstFloat/secondFloat;	
			System.out.printf("Result of dividing %.2f by %.2f is %.2f.\n\n",firstFloat, secondFloat, result);
			break;
    	}
    
    }
    
    public void displayBye() {
    	System.out.print("Thank you for using Yosuke's Handy Calculator");
    }

}

