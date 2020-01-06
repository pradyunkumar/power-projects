package pradyunjava;
/*
    Purpose: This program simulates the in-store maintenance of stock.

    Functions:
    For customers:
    1. It allows buying and return products.
    2. It allows query through the stock.
    3. Allows request for more stock.
    For suppliers:
    1. Allows addition/removal of stock.
    2. Provides list of all stock.


 */

import java.util.InputMismatchException;
import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
	    try {
            temp.setPrice(7);
        } catch (InputMismatchException ime){
            System.out.println("Please enter a value of coreect data type.");
            ime.getStackTrace();
        }
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new pradyunjava.StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new pradyunjava.StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket pradyunsBasket = new Basket("Tim");

        sellItem(pradyunsBasket, "car", 1);
        System.out.println(pradyunsBasket);

        sellItem(pradyunsBasket, "car", 1);
        System.out.println(pradyunsBasket);

        if(sellItem(pradyunsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(pradyunsBasket, "spanner", 5);
//        System.out.println(pradyunsBasket);

        sellItem(pradyunsBasket, "juice", 4);
        sellItem(pradyunsBasket, "cup", 12);
        sellItem(pradyunsBasket, "bread", 1);
//        System.out.println(pradyunsBasket);

//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(pradyunsBasket, "car", 1);
        removeItem(pradyunsBasket, "cup", 9);
        removeItem(pradyunsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(pradyunsBasket, "car", 1));  // should not remove any

        System.out.println(pradyunsBasket);

        // remove all items from pradyunsBasket
        removeItem(pradyunsBasket, "bread", 1);
        removeItem(pradyunsBasket, "cup", 3);
        removeItem(pradyunsBasket, "juice", 4);
        removeItem(pradyunsBasket, "cup", 3);
        System.out.println(pradyunsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
        StockItem car = stockList.Items().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            stockList.get("car").adjustStock(-1000);
        }

        System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(pradyunsBasket);
        System.out.println(pradyunsBasket);


    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
