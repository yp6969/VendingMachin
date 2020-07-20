package vendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine implements vendingMachineInter{
	
	private static int MAX_EACH = 10;
	private Map<Drink,Integer> stock = new HashMap<Drink, Integer>();
	private Map<Coin,Integer> coins = new HashMap<Coin,Integer>();
	private Drink currentDrink;
	private int currentBalance;
	private long totalBalance;
	
	public VendingMachine() {
		initialize();
	}
	
	
	public void initialize() {
		for(Drink can : Drink.values())
			stock.put(can , MAX_EACH );
		for(Coin c : Coin.values())
			coins.put(c, MAX_EACH);
	}
	
	@SuppressWarnings("deprecation")
	/**
	 * get the price for the wanted drink
	 * @param drink 
	 * @return
	 * @throws NoDrinkExeption
	 */
	public int selectDrink(Drink drink) throws NoDrinkExeption {
		if(stock.get(drink) == null || stock.get(drink) == 0) {
			throw new NoDrinkExeption("This item has been sold out please try to buy other");
		}
		currentDrink = drink;
		return drink.getPrice();
	}
	
	/**
	 * update the map with new coin
	 * @param c
	 */
	public void insertCoin(Coin c) {
		currentBalance += c.getValue();
		int coinAmount = coins.get(c);
		coins.replace(c , coinAmount+1);
	}
	
	/**
	 * collect the drink and change
	 * @return
	 * @throws Exception
	 */
	public MyPair<Drink , List<Coin> > collectCanWithChange() throws Exception  {
		
		Drink newCan = collectCanFromMachin();
		totalBalance += newCan.getPrice();
		List<Coin> change = collectChange();
		return new MyPair<Drink, List<Coin>>(currentDrink, change);
	}
	
	
	/**
	 * collect the can from the machine
	 * @return
	 * @throws Exception
	 */
	private Drink collectCanFromMachin() throws Exception {
		if(isFullPaid()) {
			if(hasCorrectChange()) {
				int amount = stock.get(currentDrink);
				stock.replace(currentDrink, amount - 1 );
				return currentDrink;
			}
			else throw new NoCoinsExeption("There is not enoth coins change in the stock");
		}
		throw new NotEnoughMonyExeption("There is not enoth mony to but the product");
	}
	
	/**
	 * check if the costomer is fully paid
	 * @return
	 */
	private boolean isFullPaid() {
		return currentBalance >= currentDrink.getPrice();
	}
	
	
	/**
	 * 
	 * @return
	 * @throws NoCoinsExeption
	 */
	private List<Coin> collectChange() throws NoCoinsExeption {
        int change = currentBalance - currentDrink.getPrice();
        List<Coin> changeList = createChange(change);
        reduceChangeFromStock(changeList);
        currentBalance = 0;
        currentDrink = null;
        return changeList;
    }
	
	/**
	 * 
	 * @param change
	 */
	private void reduceChangeFromStock(List<Coin> change) {
		for(Coin c : change) {
			int amount = coins.get(c);
			coins.replace(c , amount - 1);
		}
	}
	
	
	/**
	 * create a change coin list 
	 * @param amount
	 * @return
	 * @throws NoCoinsExeption
	 */
	public List<Coin> createChange(int amount) throws NoCoinsExeption  {
		List<Coin> change = null;
		int cnt = amount;
		
		if(cnt > 0) {
			change = new ArrayList<Coin>();
			while(cnt > 0) {
				if(cnt >= Coin.QUARTER.getValue() && coins.get(Coin.QUARTER) > 0) {
					change.add(Coin.QUARTER);
					cnt -= Coin.QUARTER.getValue();
					continue;
				}
				else if(cnt >= Coin.PENNY.getValue() && coins.get(Coin.PENNY) > 0) {
					change.add(Coin.PENNY);
					cnt -= Coin.PENNY.getValue();
					continue;
				}
				else if(cnt >= Coin.NICKLE.getValue() && coins.get(Coin.NICKLE) > 0) {
					change.add(Coin.NICKLE);
					cnt -= Coin.NICKLE.getValue();
					continue;
				}
				else if(cnt >= Coin.DIME.getValue() && coins.get(Coin.DIME) > 0) {
					change.add(Coin.DIME);
					cnt -= Coin.DIME.getValue();
					continue;
				}
				else throw new NoCoinsExeption("There is not enoth coins change in the stock");
			}
		}
		return change;
	}
	
	/**
	 * check the correct of change
	 * @return
	 */
	private boolean hasCorrectChange() {
		try {
			createChange(currentBalance);
		}
		catch (NoCoinsExeption e) {
			return false;
		}
		return true;
	}


	@Override
	public List<Coin> refund() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
