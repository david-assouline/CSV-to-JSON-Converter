import java.io.*;
import java.util.Scanner;

public class CSV2JSON {

    String nameOfFile;

    /**
     * Parameterized constructor for CSV2JSON Class
     * @param nameOfFile name of file to be converted to JSON
     * @throws IOException IOException
     */
    public CSV2JSON(String nameOfFile) throws IOException {

        this.nameOfFile = nameOfFile;

        try {
            File newJson = new File(nameOfFile);
            if (newJson.createNewFile()) {
                System.out.println("File created: " + newJson.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(nameOfFile);
            myWriter.write("[");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    /**
     * This method takes an array of attributes and an array of values from the text file and converts them to a JSON
     * object
     * @param attributesArray an array of attributes (E.g. the first line of a csv file)
     * @param valuesArray an array of values (E.g. all subsequent lines of a csv file)
     */
    public void createJsonObject(String[] attributesArray, String[] valuesArray) {
        try {
            FileWriter myWriter = new FileWriter(nameOfFile, true);
            myWriter.append("\n  {");
            for (int i = 0; i < attributesArray.length; i += 1) {
                myWriter.append("\n    \"" + attributesArray[i] + '"' + ": " + valuesArray[i]);
                if (i != (attributesArray.length - 1)) {
                    myWriter.append(",");
                }
            }
            myWriter.append("\n  },");

            myWriter.close();
            System.out.println("Successfully wrote 1 JSON object to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Same effect as the previous createJsonObject method however this method uses slightly different characters to
     * mark the end of the JSON file
     * @param attributesArray an array of attributes (E.g. the first line of a csv file)
     * @param valuesArray an array of values (E.g. all subsequent lines of a csv file)
     */
    public void lastJsonObject(String[] attributesArray, String[] valuesArray) {
        try {
            FileWriter myWriter = new FileWriter(nameOfFile, true);
            myWriter.append("\n  {");
            for (int i = 0; i < attributesArray.length; i += 1) {
                myWriter.append("\n    \"" + attributesArray[i] + '"' + ": " + valuesArray[i]);
                if (i != (attributesArray.length - 1)) {
                    myWriter.append(",");
                }
            }
            myWriter.append("\n  }\n]");

            myWriter.close();
            System.out.println("Successfully wrote last JSON object to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}