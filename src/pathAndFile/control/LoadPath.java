package pathAndFile.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import pathAndFile.model.AppliPaths;

public class LoadPath {
	
	
	public static AppliPaths getPaths(){
		AppliPaths toReturn=new AppliPaths();
		try {
			BufferedReader r=new BufferedReader(new FileReader("ressource/paths.txt"));
			String path="";
			while(path!=null){
				if(path.contains("=")){
					String[] tab=path.split("=");
					toReturn.put(tab[0],Paths.get(tab[1],"" ).toFile());
				}
				path=r.readLine();
			}
			r.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPaths());
	}

}
