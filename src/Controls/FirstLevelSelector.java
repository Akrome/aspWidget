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

	public LinkedList<FirstLevelOption> options;
	public FirstLevelOption activeOption;
	
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
				FirstLevelOption flo = new FirstLevelOption(x+(1+i*5)*basicWidth, y+1*basicHeight, 4*basicWidth, 4*basicHeight, on, off, over,area);
				options.add(flo);
				if (activeOption==null) {
					activeOption = flo;
					activeOption.isOn=true;
				}
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
		Config.p.pushMatrix();
		Config.p.fill(Colors.red);
		Config.p.rectMode(PApplet.CORNER);
		Config.p.rect(x,y,width,height);
		for (FirstLevelOption fo: options) {
			fo.draw(fo==activeOption);
		}
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		for (FirstLevelOption fo:options) {
			if (fo.contains(mx, my)) {
				fo.click(mx,  my);
				if (fo.isOn) {
					activeOption=fo;
					for (FirstLevelOption foo: options) {
						if (fo!=foo)
							foo.isOn=false;
					}
				}
				break;
			}
		}
	}
}
