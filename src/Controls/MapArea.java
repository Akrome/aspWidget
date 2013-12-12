package Controls;

import java.util.HashMap;

import main.Assets;
import main.Colors;
import main.Config;
import processing.core.PApplet;
import processing.core.PImage;

public class MapArea extends BasicControl {

	public HashMap<String, PImage> images;
	PImage background;
	
	@SuppressWarnings("unchecked")
	public MapArea(float x, float y, float width, float height) {
		super(x, y, width, height);
		background = (PImage) ((HashMap<String, Object>)(Assets.assets.get("map"))).get("background");
		images = new HashMap<String, PImage>();
	}
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.image(background, x, y);
		for (PImage im: images.values()) {
			Config.p.image(im, x, y);
		}
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}

}
