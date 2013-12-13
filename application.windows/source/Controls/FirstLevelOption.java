package Controls;

import processing.core.PImage;
import main.Config;

public class FirstLevelOption extends BasicControl {
	
	PImage big;
	PImage small;
	PImage smallover;
	PImage bigover;
	public String name;
	public boolean isOn;
	
	public FirstLevelOption(float x, float y, float width, float height, PImage big, PImage small, PImage smallover, PImage bigover, String name) {
		super(x, y, width, height);
		this.big=big;
		this.small=small;
		this.smallover=smallover;
		this.bigover=bigover;
		this.name=name;
	}

	public void draw(boolean isOn) {
		Config.p.pushMatrix();
		if (contains(Config.p.mouseX, Config.p.mouseY)) {
			if (isOn) {
				Config.p.image(bigover,x,y,width, height);
			}
			else {
				Config.p.image(smallover,x,y,width, height);
			}
		}
		else if (isOn)
			Config.p.image(big, x, y,width, height);
		else
			Config.p.image(small, x, y,width, height);
		
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
