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
	PImage visenvup;
	PImage visenvdown;
	
	
	
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
		
		visenvup = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("visenvup");
		visenvdown = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("visenvdown");
		
		images = new HashMap<String, PImage>();
	}
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.imageMode(PApplet.CORNER);
		Config.p.image(background, x, y);
		for (PImage im: images.values()) {
			Config.p.image(im, x, y, width, height);
		}
		if (Scores.currentAir>=7) {
			Config.p.image(airup, x, y);
		}
		if (Scores.currentAir<=2) {
			Config.p.image(airdown, x, y);
		}
		if (Scores.currentWater>=5) {
			Config.p.image(waterup, x, y);
		}
		if (Scores.currentWater<=2) {
			Config.p.image(waterdown, x, y);
		}
		if (Scores.currentWaste>=7) {
			Config.p.image(wasteup, x, y);
			System.out.println(wasteup);
		}
		if (Scores.currentWaste<=3) {
			Config.p.image(wastedown, x, y);
		}
		if (Scores.currentVisenv>=7) {
			Config.p.image(visenvup, x, y);
		}
		if (Scores.currentVisenv<=3) {
			Config.p.image(visenvdown, x, y);
		}
		
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}

}
