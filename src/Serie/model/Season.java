package Serie.model;

import java.util.List;

public class Season {
	
	private List<Episode> episodes;
	
	public Season(List<Episode> l){
		this.episodes=l;
	}
	
	public Episode get(int i){
		return episodes.get(i);
	}
	
	public List<Episode> get(){
		return episodes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
