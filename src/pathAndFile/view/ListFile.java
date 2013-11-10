package pathAndFile.view;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pathAndFile.control.LoadPath;
import pathAndFile.model.AppliPaths;

import common.view.MainFrame;

public class ListFile extends JPanel {
	
	private JList<File> view;
	private File path;
	private AppliPaths knowPath;
	private JScrollPane scroll;
	
	public ListFile(File path){
		this.path=path;
		this.knowPath=LoadPath.getPaths();
		view=new JList<File>();
		scroll=new JScrollPane(view);
		this.setSize(600,900);
		this.add(scroll);
		refresh();
	}
	
	public void setSize(int width,int heigth){
		scroll.setPreferredSize(new Dimension(width,heigth));
	}
	
	public void refresh(){
		ArrayList<File> list=new ArrayList<File>();
		listFile(list,path);
		Vector<File> v=new Vector<File>(list);
		view.setListData(v);
		
	}
	
	
	private void listFile(ArrayList<File> list,File root){
		
		for(File file:root.listFiles()){
			System.out.println(file);
			if(!knowPath.containsValue(file)){
				if(file.isDirectory()){
					listFile(list,file);
				}
				else{
					list.add(file);
				}
			}
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame test=new MainFrame();
		test.setSize(700, 1000);
		test.add(new ListFile(LoadPath.getPaths().get(AppliPaths.DOWNLOAD)));
	}

}
