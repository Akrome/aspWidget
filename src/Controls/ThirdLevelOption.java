package Controls;

import processing.core.PImage;
import main.Config;
import main.Scores;
import main.Solution;

public class ThirdLevelOption extends BasicControl {
	
	PImage on;
	PImage off;
	PImage over;
	PImage text;
	public String name;
	public boolean isOn;
	public Solution solution;
	
	public ThirdLevelOption(float x, float y, float width, float height, PImage on, PImage off, PImage over, PImage text, String name, Solution s) {
		super(x, y, width, height);
		this.on=on;
		this.off=off;
		this.over=over;
		this.text=text;
		this.name=name;
		this.solution=s;
	}

	public void draw(boolean isOn) {
		Config.p.pushMatrix();
		if (contains(Config.p.mouseX, Config.p.mouseY)) 
			Config.p.image(over,x,y);
		else if (isOn)
			Config.p.image(on, x, y);
		else
			Config.p.image(off, x, y);
		
		Config.p.image(text, x, y+height/2);
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		toggle();		
	}
	
	public void off() {
		isOn=false;
		Scores.currentAir-=solution.data.get("air");
		Scores.currentBudget+=solution.data.get("cost");
		Scores.currentEffort+=solution.data.get("effort");
		Scores.currentWaste-=solution.data.get("waste");
		Scores.currentWater-=solution.data.get("water");
		Scores.currentVisenv-=solution.data.get("visenv");
	}
	
	public void on() {
		isOn=true;
		Scores.currentAir+=solution.data.get("air");
		Scores.currentBudget-=solution.data.get("cost");
		Scores.currentEffort-=solution.data.get("effort");
		Scores.currentWaste+=solution.data.get("waste");
		Scores.currentWater+=solution.data.get("water");
		Scores.currentVisenv+=solution.data.get("visenv");
	}
	public void toggle() {
		int c = solution.data.get("cost");
		int e = solution.data.get("effort");
		if (isOn) {
			if (Scores.currentBudget+c >= Config.min && Scores.currentEffort+e >= Config.min) {
				off();
			}
		}
		else {
			if (Scores.currentBudget-c >= Config.min && Scores.currentEffort-e >= Config.min) {
				on();
			}			
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		draw(false);
		
	}

}