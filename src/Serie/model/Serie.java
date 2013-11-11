package Serie.model;

import java.util.List;

public class Serie {
	
	private List<Season> seasons;
	private String name;
	
	public Serie(String name,List<Season> l){
		this.name=name;
		seasons=l;
	}
	
	public String getName(){
		return name;
	}
	
	public Episode get(int season,int episode){
		return seasons.get(season).get(episode);
	}
	
	public Season get(int season){
		return seasons.get(season);
	}
	
	public List<Season> get(){
		return seasons;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
