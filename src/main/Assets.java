package main;

import java.io.*;
import processing.core.*;
import java.util.HashMap;;

public class Assets {
	public static HashMap<String, Object> assets;
	
	public static void loadAssets(PApplet p) {
		assets = expandDirectory(new File("assets"));
	}
	
	static HashMap<String, Object> expandDirectory(File folder) {
		HashMap<String, Object> innerMap = new HashMap<String, Object>();
		for (File f: folder.listFiles()) {
			if (!f.isDirectory()) {
				innerMap.put(f.getName().substring(0, f.getName().lastIndexOf('.')), Config.p.loadImage(f.getPath()));
			}
			else {
				innerMap.put(f.getName(), expandDirectory(f));
			}
		}
		return innerMap;
	}
}
