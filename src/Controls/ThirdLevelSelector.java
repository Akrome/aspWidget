package Controls;

import java.util.HashMap;
import java.util.LinkedList;

import main.Assets;
import main.Colors;
import main.Config;
import main.Solution;
import main.Utilities;
import processing.core.PApplet;
import processing.core.PImage;

public class ThirdLevelSelector extends BasicControl {

	public LinkedList<ThirdLevelOption> options;
	public ThirdLevelOption activeOption;
	public String name;
	
	@SuppressWarnings("unchecked")
	public ThirdLevelSelector(float x, float y, float width, float height, String secondName, String name) {
		super(x, y, width, height);
		this.name=name;
		options=new LinkedList<ThirdLevelOption>();
		try {
			HashMap<String, Object> areasHM = ((HashMap<String, Object>)((HashMap<String, Object>)(Assets.assets.get("thirdlevelselector"))).get(secondName));
			HashMap<String, Object> areasHM2 = (HashMap<String, Object>) areasHM.get(name);
			int i=0;
			float basicWidth = width * 1 / 15;
			float basicHeight = height * 1 / 5;
			for (String area: Utilities.asSortedList(areasHM2.keySet())) {
				HashMap<String, Object> areaHM = (HashMap<String, Object>)areasHM2.get(area);
				PImage on = (PImage) areaHM.get("on");
				PImage off = (PImage) areaHM.get("off");
				PImage over = (PImage) areaHM.get("over");
				PImage text  = (PImage) areaHM.get("text");
				ThirdLevelOption tlo = new ThirdLevelOption(x+(1+i*5)*basicWidth, y+1*basicHeight, 4*basicWidth, 4*basicHeight, on, off, over, text, area, Assets.data.get(area));
				options.add(tlo);
					
				i++;
			}
		}
		catch (Exception e){
			System.out.println("Error in loading the Third Level Selector");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.fill(Colors.red);
		Config.p.rectMode(PApplet.CORNER);
		Config.p.rect(x,y,width,height);
		for (ThirdLevelOption to: options) {
			to.draw(to==activeOption);
		}
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		for (ThirdLevelOption to:options) {
			if (to.contains(mx, my)) {
				to.click(mx,  my);
				if (to.isOn) {
					activeOption=to;
					for (ThirdLevelOption too: options) {
						if (activeOption!=too) {
							if (too.isOn) {
								too.off();
							}
						}
						
					}
				}
				else {
					activeOption = null;
				}
				break;
			}
		}
	}
}
