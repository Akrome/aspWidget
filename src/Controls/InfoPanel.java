package Controls;

import processing.core.PApplet;

public class InfoPanel extends BasicControl{

	public InfoPanel(float x, float y, float width, float height, PApplet p) {
		super(x, y, width, height, p);
	}

	@Override
	public void draw() {
		if (!valid) {
			p.pushMatrix();
			clearBackground();
			p.popMatrix();
			valid=true;
		}		
	}

}
