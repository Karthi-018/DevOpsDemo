package javas.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Grocery{
	String fruit;
    double unitPrice;
    double totalBill;
    
	public Grocery(String fruit, double unitPrice, double totalBill) {
		this.fruit = fruit;
		this.unitPrice = unitPrice;
		this.totalBill = totalBill;
	}
   
}

class Cart{
	String fruit;
    int count;
	public Cart(String fruit, int count) {
		this.fruit = fruit;
		this.count = count;
	}

}

abstract class GroceryReceiptBase {
    private Map<String, Double> prices;
    private Map<String, Integer> discounts;

    public GroceryReceiptBase(Map<String, Double> prices, Map<String, Integer> 
discounts) {
        this.prices = prices;
        this.discounts = discounts;
    }

    public abstract List<Grocery> Calculate(List<Cart> shoppingList);

    public Map<String, Double> getPrices() {
        return prices;
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }
}
class GroceryReceipt extends GroceryReceiptBase{
	
	public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts){ 
		super(prices,discounts);
	}

	@Override
	public List<Grocery> Calculate(List<Cart> shoppingList) {
		  Map<String, Integer> list=new TreeMap<>();
		  for(Cart node: shoppingList)
			  list.merge(node.fruit, node.count, Integer::sum);
		  
		  List<Grocery> finalPrice=new ArrayList<>();
	        for(Map.Entry<String, Integer> groDis: list.entrySet()){
	            String fruit=groDis.getKey();
	            int sum=groDis.getValue();
	            double price=getPrices().get(fruit);
	            double total=sum*price;
	            if(getDiscounts().containsKey(fruit)){
	                total*=(1-getDiscounts().get(fruit)/100.0);
	            }
	            finalPrice.add(new Grocery(fruit, price, total));
	        }
		return finalPrice;
	}
	
}

public class OnlineGroceryMain {
	
	public static void main(String[] args) {
		
	}

}
