package Controls;

import processing.core.PImage;
import main.Config;

public class FirstLevelOption extends BasicControl {
	
	PImage on;
	PImage off;
	PImage over;

	boolean isOn;
	
	public FirstLevelOption(float x, float y, float width, float height, PImage on, PImage off, PImage over) {
		super(x, y, width, height);
		this.on=on;
		this.off=off;
		this.over=over;
	}

	@Override
	public void draw() {
		if (!valid) {
			Config.p.pushMatrix();
			Config.p.image(on, x, y, width, height);
			Config.p.popMatrix();
			valid = true;
		}

	}

}
