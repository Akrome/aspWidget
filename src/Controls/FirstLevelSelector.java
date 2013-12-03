package Controls;

import main.Assets;
import main.Config;
import processing.core.PApplet;

public class FirstLevelSelector extends BasicControl {

	public FirstLevelSelector(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw() {
		if (!valid) {
			Config.p.pushMatrix();
			Config.p.popMatrix();
			valid = true;
		}
	}
}
