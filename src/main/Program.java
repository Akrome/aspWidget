package main;

import java.util.HashMap;
import java.util.LinkedList;
import Controls.*;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Program extends PApplet {

	LinkedList<BasicControl> controls;
	HashMap<String, SecondLevelSelector> secondLevelSelectors;
	public HashMap<String, ThirdLevelSelector> thirdLevelSelectors;
	
	public MapArea map;
	
	public void setup(){		
		Config.p = this;
		Config.pr = this;
		Assets.loadAssets(this);

		this.size((int)Config.width, (int)Config.height);
		initControls();
	}
	
	public void draw(){
		for (BasicControl bc:controls) {
			bc.draw();
			
			//Second Level
			SecondLevelSelector sls = secondLevelSelectors.get(fls.activeOption.name);
			sls.draw();
			
			//Third Level
			ThirdLevelSelector tls = thirdLevelSelectors.get(sls.activeOption.name);
			tls.draw();
		}
		
	}
	
	public FirstLevelSelector fls;
	
	@SuppressWarnings("unchecked")
	void initControls() {
		this.controls=new LinkedList<BasicControl>();
		controls.add(new Scoreboard(Config.x0, Config.y0, Config.width0, Config.height0));
		controls.add(new MapArea(Config.x1, Config.y1, Config.width1, Config.height1));
		fls=new FirstLevelSelector(Config.x2, Config.y2, Config.width2, Config.height2);
		controls.add(fls);
		
		secondLevelSelectors = new HashMap<String, SecondLevelSelector>();
		for (String name : ((HashMap<String, Object>) (Assets.assets.get("secondlevelselector"))).keySet()) {
			secondLevelSelectors.put(name, new SecondLevelSelector(Config.x3, Config.y3, Config.width3, Config.height3, name));	
		}
		
		thirdLevelSelectors = new HashMap<String, ThirdLevelSelector>();
		for (String secondName : secondLevelSelectors.keySet()) {
			HashMap<String, Object> hm = (HashMap<String, Object>) ((HashMap<String, Object>) (Assets.assets.get("secondlevelselector"))).get(secondName);
		
			for (String name : hm.keySet()) {
				thirdLevelSelectors.put(name, new ThirdLevelSelector(Config.x4, Config.y4, Config.width4, Config.height4, secondName, name));	
			}
		}
		
		map = new MapArea(Config.x1, Config.y1, Config.width1, Config.height1);
		controls.add(map);
	}


	public void mouseClicked() {
		for (BasicControl bc: controls) {
			if (bc.contains(mouseX, mouseY)) {
				bc.click(mouseX, mouseY);
			}
		}
			
		SecondLevelSelector sls = secondLevelSelectors.get(fls.activeOption.name);
		if (sls.contains(mouseX, mouseY))
			sls.click(mouseX, mouseY);

		ThirdLevelSelector tls = thirdLevelSelectors.get(sls.activeOption.name);
		if (tls.contains(mouseX, mouseY)) {
			tls.click(mouseX, mouseY);
		}
	}
}
