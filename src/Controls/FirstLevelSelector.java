package Controls;

import java.util.HashMap;
import java.util.LinkedList;

import main.Assets;
import main.Config;
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
			for (String area: areasHM.keySet()) {
				System.out.println(area.toString());
				HashMap<String, Object> areaHM = (HashMap<String, Object>)areasHM.get(area);
				PImage on = (PImage) areaHM.get("on");
				PImage off = (PImage) areaHM.get("off");
				PImage over = (PImage) areaHM.get("over");			
				options.add(new FirstLevelOption(x, y, width, height, on, off, over));
			}
		}
		catch (Exception e){
			System.out.println("Error in loading the First Level Selector");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void draw() {
		if (!valid) {
			Config.p.pushMatrix();
			for (FirstLevelOption fo: options) {
				fo.draw();
			}
			Config.p.popMatrix();
			valid = true;
		}
	}
}
