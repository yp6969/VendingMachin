package vendingMachine;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		VendingMachine vMachin = new VendingMachine();
		vMachin.initialize();
		MyPair<Drink, List<Coin>> myDrink = null;
		int option;
		option = input.nextInt();
		
		while(true) {
			System.out.println("Please chose a drink");
			System.out.println("1: Coke 2: Pepsi 3: Soda");
			try {
				switch(option) {
				case 1:
					vMachin.selectDrink(Drink.COKE);
				case 2:
					vMachin.selectDrink(Drink.PEPSI);
				case 3:
					vMachin.selectDrink(Drink.SODA);
				}
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			
			System.out.println("Please insert money");
			int amount = input.nextInt();
				
			System.out.println("chose your option");
			System.out.println("1: get the drink 2: take a refund  3: reset system (only for menegeer)");
			switch(option) {
			case 1:
				try {
					myDrink = vMachin.collectCanWithChange(); // chek if there enoth mony
				} catch (NotEnoughMonyExeption e) {
					System.out.println(e.toString());
				} catch (NoCoinsExeption e) {
					System.out.println(e.toString());
					/* go to refund */
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			case 2:
				vMachin.refund();
			case 3:
				
			}
		}
	}
	
	

}
