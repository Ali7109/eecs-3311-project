package frontend;
import backend.*;
import java.util.List;
import java.util.ArrayList;

public class OrderUIController {
	
	private static SandwichCreator setSandwichCreator(String name) {
		if(name.equals("Chicken")) {
			return new ChickenSandwichCreator();
		}
		else if(name.equals("Beef")) {
			return new BeefSandwichCreator();
		}
		else {
			return new MeatballSandwichCreator();
		}
	}
	
	public static List<Double> getSandwichOrder(List<CartItem> cartList) {
		List<Sandwich> orderBag = new ArrayList<>();
		for(CartItem item : cartList) {
			SandwichCreator sandwichCreator = setSandwichCreator(item.getName());
			Sandwich sandwich = sandwichCreator.createSandwich();
			// check if factory actually made a sandwich, and don't add the null return value
			if(sandwich != null) {
				orderBag.add(sandwich);
			}
		}
		
		List<Double> costs = new ArrayList<>();
		
		for(Sandwich sandwich : orderBag) {
			costs.add(sandwich.getCost());
		}

		
		return costs;
	}
	

}
