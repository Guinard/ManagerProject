package Serie.control;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Serie.model.Serie;

public class SerieFactory {
	
	
	public static String getSerie(String name) throws MalformedURLException, IOException{
		String content=getContentResult(new URL(name));
		Document page=Jsoup.parse(content);
		//System.out.println(page.select("#eplist").select("pre").html());
		//return new Serie();
		return page.select("#eplist").select("pre").html();
	}
	
	public static String getContentResult(URL url) throws IOException{

	    InputStream in = url.openStream();
	    StringBuffer sb = new StringBuffer();

	    byte [] buffer = new byte[256];

	    while(true){
	        int byteRead = in.read(buffer);
	        if(byteRead == -1)
	            break;
	        for(int i = 0; i < byteRead; i++){
	            sb.append((char)buffer[i]);
	        }
	    }
	    return sb.toString();
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		getSerie("http://epguides.com/GoodWife/");
		
		
		

	}

}
