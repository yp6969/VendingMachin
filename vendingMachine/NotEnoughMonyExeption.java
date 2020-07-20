package vendingMachine;

public class NotEnoughMonyExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messsege;
	
	NotEnoughMonyExeption(String messege){
		this.messsege = messege;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return messsege;
	}
}
