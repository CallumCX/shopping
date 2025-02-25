import java.io.*;
import java.util.*;

public class Food {
    static Map<String, Double> foodDict = new HashMap<String, Double>();

    public static Map<String, Double> ReadFile() throws FileNotFoundException {
        File fileName = new File("Dictionary.txt");
        Scanner fileData = new Scanner(fileName);

        while (fileData.hasNextLine()) {
            String[] foodData = (fileData.nextLine()).split(":", 2);
            String nameDate = foodData[0];
            double priceData = Double.parseDouble(foodData[1].replace(";", ""));
            foodDict.put(nameDate, priceData);
        }

        return foodDict;
    }
}

