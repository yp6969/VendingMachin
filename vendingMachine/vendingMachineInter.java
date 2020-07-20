package vendingMachine;

import java.util.List;

public interface vendingMachineInter {
	
	public void initialize();
	public int selectDrink(Drink drink) throws NoDrinkExeption;
	public void insertCoin(Coin c);
	public MyPair<Drink , List<Coin> > collectCanWithChange() throws Exception;
	public List<Coin> refund();
	public void reset();
	
	
	//private Drink collectCanFromMachin() throws Exception;
	//private List<Coin> collectChange() throws NoCoinsExeption;
	//private void reduceChangeFromStock(List<Coin> change);
    //private List<Coin> createChange(int amount) throws NoCoinsExeption;
	

}
