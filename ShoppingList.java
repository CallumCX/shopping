import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    List<Shopping> shoppingList=new ArrayList<>();

    public ShoppingList(List<Shopping> shoppingList) {
        this.shoppingList=shoppingList;
    }

    public List<Shopping> getShoppingList() {
        return this.shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList=shoppingList;
    }

    public void addShoppingItems(Shopping givenItem) {
        shoppingList.add(givenItem);
    }

    public void removeShoppingItem(Shopping givenItem) {
        shoppingList.remove(givenItem);
    }

    public void calculatePrice() {
        double totalPrice = 0.0;
        for (Shopping i: shoppingList) {
            totalPrice += i.getPrice();
        }
        totalPrice = totalPrice * 0.85;
    }
}
