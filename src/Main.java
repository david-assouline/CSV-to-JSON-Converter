//---------------------------------------------------------------
// Assignment 3
// COMP 249 Winter 2021
// Section WW
// Written by: David-Raphael Assouline 40082595
//---------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, CSVFileInvalidException {


//       Scanner object to ask the user which file they would like to convert to JSON format
        Scanner userInput = new Scanner(System.in);
        System.out.print("Hello. Please enter the name of file #1 that you would like to convert to JSON: ");
        String userFile = userInput.nextLine();

//      Conversion to JSON of input file #1
        Scanner fileScanner1 = null;
        try {
            fileScanner1 = new Scanner(new File(userFile + ".csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file " + userFile + " for reading.");
            System.out.println("Please check if the file exists! Program will terminate after closing all open files.");
            System.exit(-1);
        }

//      Program will write a log.txt file in the event that an error occurs during conversion
        PrintWriter errorLogger = new PrintWriter("log.txt");
        CSV2JSON file1 = new CSV2JSON(userFile + ".json");

//      Program will split the first line of the csv document into an array of values
        String[] attributesArray = fileScanner1.nextLine().split(",");

//      This while loop uses CSV2JSON methods to convert from csv to JSON
        while (fileScanner1.hasNextLine()) {
            String[] valuesArray = fileScanner1.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0; i < valuesArray.length; i += 1) {
                try {
                    Integer.parseInt(valuesArray[i]);
                } catch (NumberFormatException e) {
                    try {
                        if (valuesArray[i].charAt(0) != '"') {
                            valuesArray[i] = "\"" + valuesArray[i] + "\"";
                        }
                    } catch (StringIndexOutOfBoundsException f) {
                        System.out.println("File " + userFile + ".csv is invalid: field is missing.\nFile is not converted to JSON");
                        errorLogger.println("File " + ".CSV is invalid");
                        errorLogger.println("Missing field: " + (valuesArray.length - 1) + " detected, 1 missing");
                        errorLogger.println(Arrays.toString(attributesArray));
                        errorLogger.close();
                    }
                }
            }
            if (fileScanner1.hasNextLine()) {
                try {
                    file1.createJsonObject(attributesArray, valuesArray);

                } catch (ArrayIndexOutOfBoundsException g) {
                    errorLogger.println("In file " + userFile + ".CSV line 2");
                    errorLogger.println(Arrays.toString(valuesArray));
                    errorLogger.println("Missing: " + attributesArray[2]);
                    errorLogger.close();

                    try {
                        throw new CSVFileInvalidException();
                    } catch (CSVFileInvalidException ignored) {
                        System.out.println("In file " + userFile + ".CSV line 2 not converted to JSON: missing data");
                    }

                }
            } else if (!fileScanner1.hasNextLine()) {
                file1.lastJsonObject(attributesArray, valuesArray);
            }
        }

//      Scanner object to ask the user which file they would like to convert to JSON format
        System.out.print("Please enter the name of file #2 that you would like to convert to json: ");
        String userFile2 = userInput.nextLine();

//      Conversion to JSON of input file #2
        Scanner fileScanner2 = null;
        try {
            fileScanner2 = new Scanner(new File(userFile2 + ".csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file " + userFile2 + " for reading.");
            System.out.println("Please check if the file exists! Program will terminate after closing all open files.");
            System.exit(-1);
        }

        CSV2JSON file2 = new CSV2JSON(userFile2 + ".json");

//      Program will split the first line of the csv document into an array of values
        attributesArray = fileScanner2.nextLine().split(",");

//      This while loop uses CSV2JSON methods to convert from csv to JSON
        while (fileScanner2.hasNextLine()) {
            String[] valuesArray = fileScanner2.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0; i < valuesArray.length; i += 1) {
                try {
                    Integer.parseInt(valuesArray[i]);
                } catch (NumberFormatException e) {
                    try {
                        if (valuesArray[i].charAt(0) != '"') {
                            valuesArray[i] = "\"" + valuesArray[i] + "\"";
                        }
                    } catch (StringIndexOutOfBoundsException f) {
                        System.out.println("File " + userFile2 + ".csv is invalid: field is missing.\nFile is not converted to JSON");
                        errorLogger.println("File " + ".CSV is invalid");
                        errorLogger.println("Missing field: " + (valuesArray.length - 1) + " detected, 1 missing");
                        errorLogger.println(Arrays.toString(attributesArray));
                        errorLogger.close();
                    }
                }
            }
            if (fileScanner2.hasNextLine()) {
                try {
                    file2.createJsonObject(attributesArray, valuesArray);

                } catch (ArrayIndexOutOfBoundsException g) {
                    errorLogger.println("In file " + userFile2 + ".CSV line 2");
                    errorLogger.println(Arrays.toString(valuesArray));
                    errorLogger.println("Missing: " + attributesArray[2]);
                    errorLogger.close();

                    try {
                        throw new CSVFileInvalidException();
                    } catch (CSVFileInvalidException ignored) {
                        System.out.println("In file " + userFile2 + ".CSV line 2 not converted to JSON: missing data");
                    }

                }
            } else if (!fileScanner2.hasNextLine()) {
                file2.lastJsonObject(attributesArray, valuesArray);
            }
        }

        System.out.print("Conversion to JSON has been completed. Please select a file that you would like to open for reading: ");
        String userFile3 = userInput.nextLine();

//      User can select a JSON file be read using bufferedwriter class, however user only has 2 attempts to input correct
//      file name
        try {
            String line;
            BufferedReader reader1 = new BufferedReader(new FileReader(userFile3 + ".json"));
            while ((line = reader1.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\nFile Succesfully read! Program will now terminate. Thank you for using CSV2JSON conversion software");
        } catch (FileNotFoundException j) {
            System.out.print("That was an invalid name. You are allowed 1 more attempt. Please enter a file name: ");
            userFile3 = userInput.nextLine();
            try {
                BufferedReader reader1 = new BufferedReader(new FileReader(userFile3 + ".json"));
            } catch (FileNotFoundException k) {
                System.out.println("That was another invalid name. Program will now terminate.");
                System.exit(-3);

            }
        }


    }


}
