import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ItemListIO {
    static List<String> allFoodItems = new ArrayList<>();



    public ItemListIO() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Food.ReadFile();
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Menu:
                1.) Get food list
                2.) Add to food list
                3.) Remove from food list
                4.) Calculate price
                5.) View all food sold
                6.) Exit
                """);
        String menuChoice = input.nextLine();

        while (!menuChoice.equals("6")) {
            switch (menuChoice) {
                case ("1"):
                    getFoodList();
                    break;
                case ("2"):
                    addToFoodList();
                    break;
                case ("3"):
                    removeFromFoodList();
                    break;
                case ("4"):
                    calculateTotalPrice();
                    break;
                case ("5"):
                    listAllFoodSold();
                    break;
            }

            System.out.println("""
                Menu:
                1.) Get food list
                2.) Add to food list
                3.) Remove from food list
                4.) Calculate price
                5.) View all food sold
                6.) Exit
                """);
            menuChoice = input.nextLine();
        }
    }

    public static void getFoodList() {
        System.out.println(allFoodItems);
    }

    public static void addToFoodList() {
        Scanner input = new Scanner(System.in);
        System.out.println("What food item do you want to add?");
        String givenItem = input.nextLine();

        if (Food.foodDict.containsKey(givenItem)) {
            allFoodItems.add(givenItem);
        }
        else {
            System.out.println("What food item do you want to add?");
            givenItem = input.nextLine();
        }

    }

    public static void removeFromFoodList() {
        Scanner input = new Scanner(System.in);
        System.out.println("What food item do you want to remove?");
        String givenItem = input.nextLine();

        if (allFoodItems.contains(givenItem)) {
            allFoodItems.remove(givenItem);
        }
        else {
            System.out.println("What food item do you want to remove?");
            givenItem = input.nextLine();
        }
    }

    public static void calculateTotalPrice() {
        double overallPrice = 0.0;
        for (String i: allFoodItems) {
            overallPrice += Food.foodDict.get(i);
        }
        System.out.println("Total price is: " + overallPrice);
    }

    public static void listAllFoodSold() {
        for (Map.Entry<String,Double> i: Food.foodDict.entrySet()) {
            System.out.println("Item: " + i.getKey() + "  " + "Price: " + i.getValue());
        }
    }


}
