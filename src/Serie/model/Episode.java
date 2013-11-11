package Serie.model;

import java.util.Date;

public class Episode {
	
	private String name;
	private Date date;
	
	
	public Episode(String s){
		this.name=s;
	}
	
	public String getName(){
		return name;
	}
	
	public Date getDate(){
		return date;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
