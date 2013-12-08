package Controls;

import processing.core.PImage;
import main.Config;
import main.Scores;
import main.Solution;

public class ThirdLevelOption extends BasicControl {
	
	PImage on;
	PImage off;
	PImage over;
	public String name;
	public boolean isOn;
	public Solution solution;
	
	public ThirdLevelOption(float x, float y, float width, float height, PImage on, PImage off, PImage over, String name, Solution s) {
		super(x, y, width, height);
		this.on=on;
		this.off=off;
		this.over=over;
		this.name=name;
		this.solution=s;
	}

	public void draw(boolean isOn) {
		Config.p.pushMatrix();
		if (contains(Config.p.mouseX, Config.p.mouseY)) 
			Config.p.image(over,x,y,width, height);
		else if (isOn)
			Config.p.image(on, x, y,width, height);
		else
			Config.p.image(off, x, y,width, height);
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		toggle();		
	}
	
	public void toggle() {
		if (isOn) {
			isOn=false;
			Scores.currentAir-=solution.data.get("air");
			Scores.currentBudget+=solution.data.get("cost");
			Scores.currentEffort+=solution.data.get("effort");
			Scores.currentVisenv-=solution.data.get("visenv");
			Scores.currentWaste-=solution.data.get("waste");
			Scores.currentWater-=solution.data.get("water");
		}
		else {
			int c = solution.data.get("cost");
			int e = solution.data.get("effort");
			if (Scores.currentBudget >= c && Scores.currentEffort >= e) {
				isOn=true;
				Scores.currentAir+=solution.data.get("air");
				Scores.currentBudget-=solution.data.get("cost");
				Scores.currentEffort-=solution.data.get("effort");
				Scores.currentVisenv+=solution.data.get("visenv");
				Scores.currentWaste+=solution.data.get("waste");
				Scores.currentWater+=solution.data.get("water");
			}			
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		draw(false);
		
	}

}