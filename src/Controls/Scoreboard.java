package Controls;

import java.util.HashMap;

import main.Assets;
import main.Colors;
import main.Config;
import main.Scores;
import processing.core.PApplet;
import processing.core.PImage;

public class Scoreboard extends BasicControl {
	PImage effort;
	PImage budget;
	PImage water;
	PImage air;
	PImage waste;
	PImage background;
	PImage visenv;
	
	

	@SuppressWarnings("unchecked")
	public Scoreboard(float x, float y, float width, float height) {
		super(x, y, width, height);
		background = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("background");
		effort = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("effort");
		budget = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("budget");
		water = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("water");
		waste = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("waste");
		air = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("air");
		visenv = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("visenv");
		
	}

	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.image(background,  x,  y, width, height);
		float xBase = width / 14;
		float yBase = (float) (height / 4.13);
		float yStep = (float) (height/8.18);
		float xStep = (float) (width/11.768);

		for (int i=0; i<Scores.currentBudget;i++) {
			Config.p.image(budget, xBase + xStep*i, yBase + yStep*0);
		}
		
		for (int i=0; i<Scores.currentEffort;i++) {
			Config.p.image(effort, xBase + xStep*i, yBase + yStep*1);
		}
		
		for (int i=0; i<Scores.currentAir;i++) {
			Config.p.image(air, xBase + xStep*i, yBase + yStep*2);
		}

		for (int i=0; i<Scores.currentWater; i++) {
			Config.p.image(water, xBase + xStep*i, yBase + yStep*3);
		}
		
		for (int i=0; i<Scores.currentWaste;i++) {
			Config.p.image(waste, xBase + xStep*i, yBase + yStep*4);
		}
		
		for (int i=0; i<Scores.currentVisenv;i++) {
			Config.p.image(visenv, xBase + xStep*i, yBase + yStep*5);
		}
		
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}


}
