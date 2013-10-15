package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class Program extends PApplet {

	public void setup(){
		size((int)Config.width, (int)Config.height);
		loadSolutions();
	}
	
	public void draw(){
		fill(255,255,255);
		rectMode(PApplet.CORNERS);
		rect(0, 0, Config.sidebarX, Config.footerY);
		rect(0, Config.footerY, Config.width, Config.height);
		drawGridBackground();
		drawGridImages();
		drawButtons();
		
	}
	
	void drawGridBackground() {
		beginShape();
		vertex(Config.topX, Config.topY);
		vertex(Config.rxX, Config.rxY);
		vertex(Config.botX, Config.botY);
		vertex(Config.lxX, Config.lxY);
		endShape();
		float spanX = (Config.rxX - Config.lxX)/(2*Config.sideSquares);
		float spanY = (Config.botY - Config.topY)/(2*Config.sideSquares);
		
		for (int i=0; i<= Config.sideSquares; i++) {
			line(Config.lxX + i*spanX, Config.lxY - i*spanY, Config.botX + i*spanX, Config.botY - i*spanY);
			line(Config.lxX + i*spanX, Config.lxY + i*spanY, Config.topX + i*spanX, Config.topY + i*spanY);
		}
	}

	void drawGridImages() {
		pushMatrix();
		imageMode(PApplet.CORNERS);
		fill(255,0,0);
		float spanX = (Config.rxX - Config.lxX)/(2*Config.sideSquares);
		float spanY = (Config.botY - Config.topY)/(2*Config.sideSquares);
		for (int i=0;i<solutions.size();i++) {
			if (solutions.get(i).status) {
				int row = i / Config.sideSquares;
				int column = i % Config.sideSquares;
				float lxX = Config.lxX+(row+column)*spanX;
				float topX = lxX + spanX;
				float rxX = topX + spanX;
				
				float topY, lxY, botY;
				
				if (row > column) {
					topY = Config.lxY + (row - column - 1)*spanY;	
					lxY = topY + spanY;
					botY = lxY + spanY;
				}
				else if (row < column) {
					botY = Config.lxY - (column - row - 1)*spanY;	
					lxY = botY - spanY;
					topY = lxY - spanY;					
				}
				else {
					lxY = Config.lxY;
					topY = lxY - spanY;
					botY = lxY + spanY;
				}			
				image(solutions.get(i).image,lxX, topY, rxX, botY);
//				beginShape();
//				vertex(lxX, lxY);
//				vertex(topX, topY);
//				vertex(rxX, lxY);
//				vertex(topX, botY);
//				endShape();				
			}
		}
		popMatrix();
	}
	
	void drawButtons() {
		float spanX = Config.width/solutions.size();
		imageMode(PApplet.CORNERS);
		
		for (int i=0; i<solutions.size();i++) {
			Solution s = solutions.get(i);
			if (s.status)
				image(s.buttonOn,i*spanX, Config.footerY, (i+1)*spanX, Config.height);
			else
				image(s.buttonOff,i*spanX, Config.footerY, (i+1)*spanX, Config.height);
		}
	}

	float mouseDownX;
	float mouseDownY;
	
	public void mousePressed(){
		mouseDownX = mouseX;
		mouseDownY = mouseY;
	}
	public void mouseReleased(){
		if (mouseY > Config.footerY && mouseDownY > Config.footerY) {			
			float spanX = Config.width / solutions.size();
			int buttonX = (int) (mouseX / spanX);
			int buttonXX = (int) (mouseDownX / spanX);
			if (buttonX == buttonXX)
				solutions.get(buttonX).status = !solutions.get(buttonX).status;
		}
	}
	
	HashMap<Integer, Solution> solutions;
	void loadSolutions() {
		solutions = new HashMap<Integer, Solution>();
		
		File assetsDir =  new File("./assets/");
		File[] categories = assetsDir.listFiles();
		int index = 0;
		//f are the categories (energy, waste, etc)
		for (File f: categories) {
			if (f.isDirectory()) {
				File[] types = f.listFiles();
				//g are the types (solar, wind, etc)
				for (File g: types) {
					if (g.isDirectory()) {
						File[] dsolutions = g.listFiles();
						//h are the solutions (thin film, cells, etc)
						for (File h: dsolutions) {
							if (h.isDirectory()) {
								Solution s = extractData(h.getPath()+File.separator, f.getName(), g.getName(), h.getName(), index);
								if (s!=null)
									this.solutions.put(index, s);
								index++;
							}
						}
					}
				}
			}
		}
	}
	
	Solution extractData(String filePath, String cat, String typ, String name, int index) {
		Solution s = null;
		try {
			PImage bOn = loadImage(filePath+File.separator+"buttonOn.png");
			PImage bOff = loadImage(filePath+File.separator+"buttonOff.png");
			PImage ip = loadImage(filePath+File.separator+"image.png");
			s = new Solution(cat, typ, name, bOn, bOff, ip, index);
			BufferedReader br = new BufferedReader(new FileReader(filePath+"data.txt"));
			String line = br.readLine();
			while (line != null) {
				String[] splitted = line.split(":");
				s.data.put(splitted[0].toLowerCase(), new Integer(splitted[1]));	
				line=br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FAILED TO READ "+filePath+" DURING LOADING OF SOLUTION DATA");
			e.printStackTrace();
		}
		return s;
	}
}
