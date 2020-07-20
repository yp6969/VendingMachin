package vendingMachine;

public class NoDrinkExeption extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messsege;
	
	NoDrinkExeption(String messege){
		this.messsege = messege;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return messsege;
	}
}
