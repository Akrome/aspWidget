package Controls;

import processing.core.PApplet;

public class SectorPanel extends BasicControl{

	public SectorPanel(float x, float y, float width, float height, PApplet p) {
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
