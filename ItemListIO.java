import java.io.FileNotFoundException;
import java.util.*;

public class ItemListIO {
    static List<String> allFoodItems = new ArrayList<>();


    public ItemListIO() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Double> dict = Food.ReadFile();
        System.out.println(Food.foodDict);
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
                    addToFoodList(input);
                    break;
                case ("3"):
                    removeFromFoodList(input);
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

    public static void addToFoodList(Scanner input) {
        List<String> keyList = new ArrayList<>();

        for (Map.Entry<String,Double> i:Food.foodDict.entrySet()) {
            keyList.add(i.getKey());
        }

        System.out.println(keyList);

        System.out.println("What food do you want to add?: ");
        String givenItem = input.nextLine();

       if (keyList.contains(givenItem)) {
        allFoodItems.add(givenItem);
        System.out.println(givenItem + " added to the shopping list!");
       }
        else {
            System.out.println("Item is not available at this shop!");
          return;
        }

    }

    public static void removeFromFoodList(Scanner input) {
        System.out.println("What food do you want to remove?: ");
        String givenItem = input.nextLine();

        if (allFoodItems.contains(givenItem)) {
            allFoodItems.remove(givenItem);
            System.out.println(givenItem + " has been removed from the list!");
        }
        else {
            System.out.println("Item is not available at this shop!");
            return;
        }
    }

    public static void calculateTotalPrice() {
        double totalPrice = 0.0;
        for (String i:allFoodItems) {
            totalPrice += Food.foodDict.get(i);
        }
        System.out.println("The estimated price for the food, including VAT, is: £" + totalPrice);
    }

    public static void listAllFoodSold() {
        for (Map.Entry<String,Double> i: Food.foodDict.entrySet()) {
            System.out.println("Item: " + i.getKey() + " " + "Value: " + i.getValue());
        }
    }
}
