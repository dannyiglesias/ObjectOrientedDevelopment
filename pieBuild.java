//Dannys Custom Pie Shop - Decorator Pattern Assignment
//Week 1 Assignment - Spring 2020
//Author: Daniel Iglesias

//Abstract Pie class
//All classes extend from this
abstract class Pie {
	String description = "Unknown Pie";
	public String getDescription() {
		return description;
	}
	public abstract double cost();
}

//Decorator Class
abstract class PieDecorator extends Pie {
	public abstract String getDescription();	
}

//Pie classes
class Pumpkin extends Pie {
	public Pumpkin() {
		description = "Pumpkin Pie";	
	}
	public double cost() {
		return 8.99;	
	}
}

class Pecan extends Pie {
	public Pecan() {
		description = "Pecan Pie";	
	}
	public double cost() {
		return 7.99;	
	}
}

class Apple extends Pie {
	public Apple() {
		description = "Apple Pie";
	}	
	public double cost() {
		return 9.99;
	}
}

class Cherry extends Pie {
	public Cherry() {
		description = "Cherry Pie";
	}
	public double cost() {
		return 8.59;
	}
}

class Lemon extends Pie {
	public Lemon() {
		description = "Lemon Merengue";
	}
	public double cost() {
		return 11.99;
	}
}

//Toppings classes
class Chocolate extends PieDecorator {
	Pie pie;
	
	public Chocolate(Pie pie) {
		this.pie = pie;	
	}
	public String getDescription() {
		return pie.getDescription() + ", Chocolate";
	}
	public double cost() {
		return pie.cost() + 1.00;
	}	
}

class Almonds extends PieDecorator {
	Pie pie;
	
	public Almonds(Pie pie) {
		this.pie = pie;	
	}
	public String getDescription() {
		return pie.getDescription() + ", Almonds";
	}
	public double cost() {
		return pie.cost() + 2.00;
	}	
}

class Toffee extends PieDecorator {
	Pie pie;
	
	public Toffee(Pie pie) {
		this.pie = pie;	
	}
	public String getDescription() {
		return pie.getDescription() + ", Toffee";
	}
	public double cost() {
		return pie.cost() + .59;
	}	
}

//Driver class and method
class PieOrder {
	public static void main(String args[]) {
		
		System.out.println("Thank you for your custom pie order at Dannys Pies! Your order included:");
		Pie pie = new Apple();
		System.out.println(pie.getDescription()
				+ " $" + pie.cost());
		
		Pie pie2 = new Pecan();
		pie2 = new Chocolate(pie2);
		pie2 = new Toffee(pie2);
		pie2 = new Almonds(pie2);
		System.out.println(pie2.getDescription()
				+ " $" + pie2.cost());
		
		Pie pie3 = new Cherry();
		pie3 = new Chocolate(pie3);
		pie3 = new Almonds(pie3);
		System.out.println(pie3.getDescription()
				+ "  $" + pie3.cost());
		
		double pieTotal = pie.cost() + pie2.cost() + pie3.cost();
		System.out.println("The total for this order comes out to $" + pieTotal); 
	}
}
