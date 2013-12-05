package Controls;

import processing.core.PImage;
import main.Config;

public class SecondLevelOption extends BasicControl {
	
	PImage on;
	PImage off;
	PImage over;
	public String name;
	public boolean isOn;
	
	public SecondLevelOption(float x, float y, float width, float height, PImage on, PImage off, PImage over, String name) {
		super(x, y, width, height);
		this.on=on;
		this.off=off;
		this.over=over;
		this.name=name;
	}

	public void draw(boolean isOn) {
		Config.p.pushMatrix();
		if (contains(Config.p.mouseX, Config.p.mouseY)) 
			Config.p.image(over,x,y,width, height);
		else if (isOn)
			Config.p.image(on, x, y,width, height);
		else
			Config.p.image(off, x, y,width, height);
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		this.isOn=!this.isOn;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		draw(false);
		
	}

}
