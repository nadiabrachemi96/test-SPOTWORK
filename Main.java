import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		int min = 0;
		int max = 500;

		writeInFile(min, max);
	}
	// Writes FizzBuzz output to a file named fizzbuzz.log
	// Appends results for numbers from min to max (inclusive) with specific rules
	// Returns true if the operation is successful, false otherwise
	private static boolean writeInFile(int min, int max) {
	    try (FileWriter writer = new FileWriter("fizzbuzz.log", true)) {
	        // Iterate through numbers from min to max (inclusive)
	        for (int i = min; i <= max; i++) {
	            // Generate FizzBuzz output for the current number
	            String output = generateOutput(i);
	            // Write the output to the file with a newline character
	            writer.write(output + "\n");
	        }
	        // Return true indicating successful execution
	        return true;
	    } catch (IOException e) {
	        // If an IOException occurs, print the stack trace and return false
	        e.printStackTrace();
	        return false;
	    }
	}

	// Generates FizzBuzz output for a given number
	private static String generateOutput(int number) {
	    // Initialize a StringBuilder with the string representation of the number
	    StringBuilder output = new StringBuilder(String.valueOf(number));

	    // Check divisibility by both 3 and 5
	    if (number % 3 == 0 && number % 5 == 0) {
	        output.append("FIZZBUZZ");
	    } else if (number % 3 == 0) {
	        // Check divisibility by 3
	        output.append("FIZZ");
	    } else if (number % 5 == 0) {
	        // Check divisibility by 5
	        output.append("BUZZ");
	    } else if (isPrimeNumber(number)) {
	        // Check if the number is prime
	        output.append("FIZZBUZZ++");
	    }

	    // Convert the StringBuilder to a String and return
	    return output.toString();
	}

	// Checks if a given number is prime
	// Returns true if the number is prime, false otherwise
	private static boolean isPrimeNumber(int num) {
		// Check if the number is less than 2
		if (num < 2) {
			// Numbers less than 2 are not prime
			return false;
		}

		// Loop to search for divisors of num
		// The loop starts at i = 2 and ends at the square root of num to optimize the
		// search
		for (int i = 2; i <= Math.sqrt(num); i++) {
			// Check if num is divisible by i
			if (num % i == 0) {
				// If num has a divisor other than 1 and itself, then it is not prime
				return false;
			}
		}

		// If the loop completes without finding a divisor, the number is prime
		return true;
	}

}