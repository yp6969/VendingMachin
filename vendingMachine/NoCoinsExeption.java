package vendingMachine;

public class NoCoinsExeption extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messsege;
	
	NoCoinsExeption(String messege){
		this.messsege = messege;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return messsege;
	}
}
