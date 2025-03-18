import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * This is the package for FileIO.java
 *
 * The fileio program reads a sample input file with integers on each line
 * For each line of integers:
 * Convert them from string to int.
 * Calculate the sum of all the integers.
 * Write the sum to the output file.
 * and displays the error message in “output.txt”.
 *
 * <p>
 * This class satisfies style checkers.
 * </p>
 *
 * @version 1.0
 * @since 2025-02-28
 */
public final class FileIO {

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This is the main method to run the program.
     * @param filepath
     */
    public static void readFile(final String filepath) throws Exception {
        // Read the input file
        File file = new File(filepath);
        FileWriter outputFile = new FileWriter("output.txt");
        Scanner fileScan = new Scanner(file);

        // While there are still lines to read from the file
        while (fileScan.hasNextLine()) {
            // Read the next line from the file
            String line = fileScan.nextLine();
            try {
                // Split the line into an array of strings
                String[] arrayOfStrings = line.split(" ");
                // If values are empty
                if (arrayOfStrings.length <= 0) {
                    // Display message
                    outputFile.write("Nothing on this line\n");
                } else {
                    int sum = 0;
                    // For each string in the array
                    for (String numString : arrayOfStrings) {
                        // Convert the string to an integer
                        int numInt = Integer.parseInt(numString);
                        // Add the integer to the sum
                        sum += numInt;
                    }
                    // Return Sum to the output file
                    outputFile.write(String.valueOf(sum) + "\n");
                }
            } catch (NumberFormatException error) {
                // Catches the exception string cannot be parsed to an integer
                outputFile.write("You entered string instead of an integer. "
                        + error.getMessage() + "\n");
            }
        }
        outputFile.close();
        fileScan.close();
    }
    /**
     * This is the main method to run the program.
     *
     * @param args
    */
    public static void main(final String[] args) throws Exception {
        readFile("Unit2-02-input.txt");
    }
}
