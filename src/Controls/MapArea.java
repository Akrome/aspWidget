package Controls;

import java.util.HashMap;

import main.Assets;
import main.Colors;
import main.Config;
import main.Scores;
import processing.core.PApplet;
import processing.core.PImage;

public class MapArea extends BasicControl {

	public HashMap<String, PImage> images;
	PImage background;
	PImage airup;
	PImage airdown;
	PImage waterup;
	PImage waterdown;
	PImage wasteup;
	PImage wastedown;
	
	
	
	@SuppressWarnings("unchecked")
	public MapArea(float x, float y, float width, float height) {
		super(x, y, width, height);
		background = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("background");
		airup = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("airup");
		airdown = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("airdown");
		waterup = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("waterup");
		waterdown = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("waterdown");
		wasteup = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("wasteup");
		wastedown = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("wastedown");
		images = new HashMap<String, PImage>();
	}
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.image(background, x, y);
		for (PImage im: images.values()) {
			Config.p.image(im, x, y);
		}
		if (Scores.currentAir>=8) {
			Config.p.image(airup, x, y);
		}
		if (Scores.currentAir<=2) {
			Config.p.image(airup, x, y);
		}
		if (Scores.currentWater>=8) {
			Config.p.image(waterdown, x, y);
		}
		if (Scores.currentWater<=2) {
			Config.p.image(waterup, x, y);
		}
		if (Scores.currentWaste>=8) {
			Config.p.image(wasteup, x, y);
		}
		if (Scores.currentWaste<=2) {
			Config.p.image(wastedown, x, y);
		}
		
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}

}
