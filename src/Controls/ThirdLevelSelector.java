package Controls;

import main.Colors;
import main.Config;
import processing.core.PApplet;

public class ThirdLevelSelector extends BasicControl {
	
	public ThirdLevelSelector(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.rectMode(PApplet.CORNER);
		Config.p.fill(Colors.blue);
		Config.p.rect(x, y, width, height);
		Config.p.popMatrix();

	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}


}
