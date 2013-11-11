package Serie.control;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Serie.model.Episode;
import Serie.model.Season;
import Serie.model.Serie;

public class EpListParser {
	
	public static Serie process(String name,String text){
		List<Season> seasons=new ArrayList<Season>();
		List<Episode> episodes=new ArrayList<Episode>();
		String[] lines=text.split("\\r\\n");
		Pattern numero=Pattern.compile("\\d+-\\d+");
		Pattern datePattern=Pattern.compile("\\d{2}/\\D[3]/\\d{2}");
		
		int i=0;
		int season=1;
		while(i<lines.length){
			if(lines[i].matches("[0-9]+.*")){
				String[] tab=lines[i].split("\\s");
				Matcher m=numero.matcher(lines[i]);
				m.find();
				String nameNumero=lines[i].substring(m.start(),m.end());
				if(!nameNumero.startsWith(""+season)){
					seasons.add(new Season(episodes));
					episodes=new ArrayList<Episode>();
					season++;
				}
				
			}
			i++;
		}
		
		return new Serie(name,seasons);
	}
	
	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		String url="http://epguides.com/GoodWife/";
		String test=SerieFactory.getSerie(url);
		process("The Good Wife",test);
//		String t=" choe 1-10 pinva";
//		Pattern numero=Pattern.compile("\\d+-\\d+");
//		Matcher m=numero.matcher(t);
//		System.out.println(m.find());
//		System.out.println(m.start());
//		System.out.println(m.end());

	}

}
