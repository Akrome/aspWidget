package Controls;

import java.io.File;

import processing.core.PApplet;
import processing.core.PImage;

public class SelectorPanel extends BasicControl{

	String[] iconPaths;
	PImage[] icons;
	
	public SelectorPanel(float x, float y, float width, float height, PApplet p) {
		super(x, y, width, height, p);
	}

	public void init(String name, int numberOfElements, String[] names) {
		iconPaths = new String[numberOfElements];
		icons = new PImage[numberOfElements];
		for (int i=0;i<iconPaths.length;i++) {
			iconPaths[i] = "assets"+File.separator+name+File.separator+names[i]+".png";
			icons[i]=p.loadImage(iconPaths[i]);
		}
	}
	
	@Override
	public void draw() {
		p.pushMatrix();
		clearBackground();
		float firstX, itemWidth = width / 5;
		switch (icons.length) {
		case 1:
			firstX = (width - itemWidth) /2;
			break;
		case 2: 
			firstX = (width - 3*itemWidth) /2;
			break;
		default: 
			firstX = (width - 5*itemWidth) /2;
			break;
		}
		for (int i=0; i<icons.length;i++) {
			p.image(icons[i], firstX+itemWidth*2*i, y, itemWidth, height);
		}
		p.popMatrix();
	}

	@Override
	public void manageClick(float x, float y) {}

}
