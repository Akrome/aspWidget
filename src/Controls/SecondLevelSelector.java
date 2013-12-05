package Controls;

import java.util.HashMap;
import java.util.LinkedList;

import main.Assets;
import main.Colors;
import main.Config;
import main.Utilities;
import processing.core.PApplet;
import processing.core.PImage;

public class SecondLevelSelector extends BasicControl {

	public LinkedList<SecondLevelOption> options;
	public SecondLevelOption activeOption;
	public String name;
	
	@SuppressWarnings("unchecked")
	public SecondLevelSelector(float x, float y, float width, float height, String name) {
		super(x, y, width, height);
		this.name=name;
		options=new LinkedList<SecondLevelOption>();
		try {
			HashMap<String, Object> areasHM = ((HashMap<String, Object>)((HashMap<String, Object>)(Assets.assets.get("secondlevelselector"))).get(name));
			int i=0;
			float basicWidth = width * 1 / 15;
			float basicHeight = height * 1 / 5;
			for (String area: Utilities.asSortedList(areasHM.keySet())) {
				HashMap<String, Object> areaHM = (HashMap<String, Object>)areasHM.get(area);
				PImage on = (PImage) areaHM.get("on");
				PImage off = (PImage) areaHM.get("off");
				PImage over = (PImage) areaHM.get("over");
				SecondLevelOption slo = new SecondLevelOption(x+(1+i*5)*basicWidth, y+1*basicHeight, 4*basicWidth, 4*basicHeight, on, off, over,area.substring(2));
				options.add(slo);
				if (activeOption==null) {
					activeOption = slo;
					activeOption.isOn=true;
				}
					
				i++;
			}
		}
		catch (Exception e){
			System.out.println("Error in loading the Second Level Selector");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.fill(Colors.red);
		Config.p.rectMode(PApplet.CORNER);
		Config.p.rect(x,y,width,height);
		for (SecondLevelOption so: options) {
			so.draw(so==activeOption);
		}
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		for (SecondLevelOption so:options) {
			if (so.contains(mx, my)) {
				so.click(mx,  my);
				if (so.isOn) {
					activeOption=so;
					for (SecondLevelOption soo: options) {
						if (so!=soo)
							soo.isOn=false;
					}
				}
				break;
			}
		}
	}
}
