package main;

import java.util.LinkedList;
import Controls.*;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Program extends PApplet {

	LinkedList<BasicControl> controls;
	
	public void setup(){
		Config.p = this;
		this.size((int)Config.width, (int)Config.height);
		initControls();
		Assets.loadAssets(this);
		System.out.println(Assets.assets);
	}
	
	public void draw(){
		for (BasicControl bc:controls) {
			bc.draw();
		}
	}
	
	void initControls() {
		this.controls=new LinkedList<BasicControl>();
		controls.add(new Scoreboard(0, 0, Config.width0, Config.height0));
		controls.add(new FirstLevelSelector(Config.x2, Config.y2, Config.width2, Config.height2));
		System.out.println(Config.width0+" "+Config.height0);
	}
}
