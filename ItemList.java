import java.util.ArrayList;
import java.util.List;

public class ItemList {
    List<String> itemList = new ArrayList<>();

    public ItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public void addToList(String givenItem) {
        if (Food.foodDict.containsKey(givenItem)) {
            itemList.add(givenItem);
        }
        else {
            throw new IllegalArgumentException("ERROR: Does not exist!");
        }
    }

    public void removeFromList(String givenType) {
        if (itemList.contains(givenType)) {
            itemList.remove(givenType);
        }
        else {
            throw new IllegalArgumentException("ERROR: Does not exist!");
        }
    }

    public double calculatePrice() {
        double totalPrice = 0;
        for (String i: itemList) {
            totalPrice += Food.foodDict.get(i);
        }
        return totalPrice;
    }
}
