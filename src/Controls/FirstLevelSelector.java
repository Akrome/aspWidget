package Controls;

import java.util.HashMap;
import java.util.LinkedList;

import main.Assets;
import main.Colors;
import main.Config;
import main.Utilities;
import processing.core.PApplet;
import processing.core.PImage;

public class FirstLevelSelector extends BasicControl {

	LinkedList<FirstLevelOption> options;
	
	@SuppressWarnings("unchecked")
	public FirstLevelSelector(float x, float y, float width, float height) {
		super(x, y, width, height);
		options=new LinkedList<FirstLevelOption>();
		try {
			HashMap<String, Object> areasHM = (HashMap<String, Object>)(Assets.assets.get("firstlevelselector"));
			int i=0;
			float basicWidth = width * 1 / 15;
			float basicHeight = height * 1 / 5;
			for (String area: Utilities.asSortedList(areasHM.keySet())) {
				HashMap<String, Object> areaHM = (HashMap<String, Object>)areasHM.get(area);
				PImage on = (PImage) areaHM.get("on");
				PImage off = (PImage) areaHM.get("off");
				PImage over = (PImage) areaHM.get("over");
				options.add(new FirstLevelOption(x+(2+i*4)*basicWidth, y+2*basicHeight, 3*basicWidth, 3*basicHeight, on, off, over));
				i++;
			}
		}
		catch (Exception e){
			System.out.println("Error in loading the First Level Selector");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void draw() {
		if (hasMouseOver) {
			for (FirstLevelOption fo:options) {
				fo.hasMouseOver=fo.contains(Config.p.mouseX, Config.p.mouseY);
			}
			valid=false;
		}
		
		if (!valid) {
			Config.p.pushMatrix();
			Config.p.fill(Colors.red);
			Config.p.rectMode(PApplet.CORNER);
			Config.p.rect(x,y,width,height);
			for (FirstLevelOption fo: options) {
				fo.draw();
			}
			Config.p.popMatrix();
			valid = true;
		}
	}

	@Override
	public void click(float mx, float my) {
		for (FirstLevelOption fo:options) {
			if (fo.contains(mx, my)) {
				fo.click(mx,  my);
				if (fo.isOn) {
					for (FirstLevelOption foo: options) {
						if (foo!=fo) {
							foo.isOn=false;
						}
					}
				}
			}
		}
	}
}
