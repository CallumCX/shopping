public class Shopping {
    String item;
    double price;
    int quantity;

    public Shopping(String item, double price, int quantity) {
            this.item=item;
            this.price=price;
            this.quantity=quantity;
    }

    public String getItem() {
        return this.item;
    }

    public double getPrice() {
        return this.price;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setItem(String item) {
        this.item=item;
    }

    public void setPrice(double price) {
        this.price=price;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
}