package vendingMachine;

public enum Drink {
	COKE("Coke", 25), PEPSI("Pepsi", 35), SODA("Soda", 45);
	
	
	
	private String name;
	private int price;
	
	private Drink(String name , int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() { return name;}
	public int getPrice() { return price;}
}
