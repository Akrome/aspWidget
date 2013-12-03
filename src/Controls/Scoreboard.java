package Controls;

import main.Assets;
import main.Colors;
import main.Config;
import processing.core.PApplet;

public class Scoreboard extends BasicControl {

	public Scoreboard(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if (!valid) {
			Config.p.pushMatrix();
			Config.p.rectMode(PApplet.CORNER);
			Config.p.fill(Colors.red);
			//p.rect(x, y, width, height);
			Config.p.popMatrix();
			valid = true;
		}
	}

}
