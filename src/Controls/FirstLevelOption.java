package Controls;

import processing.core.PImage;
import main.Config;

public class FirstLevelOption extends BasicControl {
	
	PImage on;
	PImage off;
	PImage over;

	public boolean isOn;
	
	public FirstLevelOption(float x, float y, float width, float height, PImage on, PImage off, PImage over) {
		super(x, y, width, height);
		this.on=on;
		this.off=off;
		this.over=over;
	}

	@Override
	public void draw() {
		Config.p.pushMatrix();
		if (hasMouseOver) 
			Config.p.image(over,x,y);
		else if (isOn)
			Config.p.image(on, x, y);
		else
			Config.p.image(off, x, y);
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		this.isOn=!this.isOn;
		
	}

}
