import java.util.Scanner;

/**
 * Write a description of class TempConverterMain here.
 *  
 * @author Merrill Hall
 * @version 2.0
 */
public class TempConverterMain {
    /**
     * main method reads a Fahrenheit temperature and 
     * displays it in Celsius and Kelvin scales.
     */
    public static void main(String[] args) {
        String inputType = "";
        double inputTemp = 0.0;
        Scanner keyInput = new  Scanner(System.in);
        TempConverter tc = new TempConverter();
        boolean anotherTemp = true; // another temperature?
        boolean goodType = false; // good temperature type?
        boolean goodTemperature = false;
        
        while (anotherTemp) {
            //read the temp

            System.out.print("Enter a  temperature type (C for Celsius, F for Fahrenheit, K for Kelvin, Q=Quit): ");
            inputType = keyInput.nextLine();
            // check type
            goodType = false;
            while ( ! goodType) {
                if (inputType.equalsIgnoreCase("C") || 
                        inputType.equalsIgnoreCase("F") ||
                        inputType.equalsIgnoreCase("K") ||
                        inputType.equalsIgnoreCase("Q")) {
                    goodType = true;
                }
                else {
                    System.out.println("Invalid temperature type!");
                    System.out.println("The type must be C, F, K, or Q.");
                    System.out.print("Please enter the temperature type again: ");
                    inputType = keyInput.nextLine();
                }
            }
            if (inputType.equalsIgnoreCase("Q")) {
                // quit
                anotherTemp = false;
                System.out.println("\nProgram ended.");
            }
            else {
                goodTemperature = false;
                   do {
                    System.out.print("Enter a temperature: ");
                    if (keyInput.hasNextDouble()) {
                        inputTemp = keyInput.nextDouble();
                        if (inputType.equalsIgnoreCase("C") && tc.setTempC(inputTemp)) {
                            System.out.println("You entered " + inputTemp + " degrees Celsius");
                            System.out.println("which is " + tc.getTempF() + " degrees Fahrenheit");
                            System.out.println("and " + tc.getTempK() + " degrees Kelvin.");
                            goodTemperature = true;
                        }
                        else if (inputType.equalsIgnoreCase("F") && tc.setTempF(inputTemp)) {
                            System.out.println("You entered " + inputTemp + " degrees Fahrenheit");
                            System.out.println("which is " + tc.getTempC() + " degrees Celsius");
                            System.out.println("and " + tc.getTempK() + " degrees Kelvin.");
                            goodTemperature = true;
                        }
                        else if (inputType.equalsIgnoreCase("K") && tc.setTempK(inputTemp)) {
                            System.out.println("You entered " + inputTemp + " degrees Kelvin");
                            System.out.println("which is " + tc.getTempC() + " degrees Celsius");
                            System.out.println("and " + tc.getTempF() + " degrees Fahrenheit.");
                            goodTemperature = true;
                        }
                        else {
                            System.out.println("You entered an invalid temperature!");
                            System.out.println("It must be greater than absolute 0 "
                                + "(0K, -273.15C, -459.67F).");
                            System.out.println("Try again.");
                        }
                    }
                    else {
                        System.out.println("You entered an invalid temperature!");
                        System.out.println("It must be a numeric value.");
                        System.out.println("Try again.");
                    }
                    keyInput.nextLine();
                } while ( ! goodTemperature);
            }
        }
    }
}
