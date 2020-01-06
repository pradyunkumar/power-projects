package pradyunjava;

import java.util.InputMismatchException;

//object denotes an item at a grocery store
class StockItem implements Comparable<StockItem> {
    private final String name;          //name of product
    private double price;               //price of product
    private int quantityInStock = 0;    //number of items in stock
    private int reserved = 0;           //number of reserved items

    //constructor initializes the name and price
    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;  // or here (but you wouldn't normally do both).
    }
    //constructor initializes the name and price, as well as quanitity of item in stock
    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }


    public String getName() {
        return name;
    }   //getter for name

    public double getPrice() {
        return price;
    }   //getter for price

    public int availableQuantity() {
        return quantityInStock - reserved;
    }   //getter for product availability

    public void setPrice(double price) {    //setter for the price
        try{
            if (price > 0.0) {
                this.price = price;
            }
        } catch(IncompatibleClassChangeError e) {
            System.out.println("worn");
        }
            System.out.println("Please enter a valid price.");

    }

    public void adjustStock(int quantity) {    //adds quantity to existing
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity >=0) {
            this.quantityInStock = newQuantity;
        } else {
            System.out.println("Too much stock removed.");
        }
    }

    public int reserveStock(int quantity) {     //allows reservation of stock
        if (quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        } else {
            System.out.println("Not enough stock.");
            return 0;
        }
    }

    public int unreserveStock(int quantity) {   //removes reservation of stovk
        if(quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {    //finalizes stock
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {     //checks to see if objects are the same
        if(obj == this) {
            return true;
        }
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }


    @Override
    public int compareTo(StockItem o) {
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved: " + this.reserved;
    }
}
