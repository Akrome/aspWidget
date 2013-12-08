package main;

import java.io.*;

import processing.core.*;
import java.util.HashMap;;

public class Assets {
	public static HashMap<String, Object> assets;
	public static HashMap<String, Solution> data;
	
	public static void loadAssets(PApplet p) {
		data = new HashMap<String, Solution>();
		assets = expandDirectory(new File("assets"));
	}
	
	static HashMap<String, Object> expandDirectory(File folder) {
		HashMap<String, Object> innerMap = new HashMap<String, Object>();

		for (File f: folder.listFiles()) {
			if (!f.isDirectory()) {
				if (f.getName().compareTo("data.txt")!=0) {
					innerMap.put(f.getName().substring(0, f.getName().lastIndexOf('.')), Config.p.loadImage(f.getPath()));
				}
				else {
					Solution s = new Solution();
				    try {

						BufferedReader br = new BufferedReader(new FileReader(f));
				        String line = br.readLine();

				        while (line != null) {
				        	s.data.put(line.split("=")[0], new Integer(line.split("=")[1]));
				            line = br.readLine();
				        }

				        br.close();
				    } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{}				        
					data.put(folder.getName(), s);
				}
			}
			else {
				innerMap.put(f.getName(), expandDirectory(f));
			}
		}
		return innerMap;
	}
}
