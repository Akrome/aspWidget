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
		Config.p.image(background,  x,  y);
		float xBase = 25;
		float yBase = 129;
		float w = 22;
		float xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));

		for (int i=0; i<Scores.currentBudget;i++) {
			Config.p.image(budget, xBase + (w+xStep)*i, yBase);
		}
		
		yBase = 195;
		w = 15;
		xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));
		for (int i=0; i<Scores.currentEffort;i++) {
			Config.p.image(effort, xBase + (w+xStep)*i, yBase);
		}
		
		yBase = 273;
		w = 21;
		xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));
		int ca = Math.max(Scores.currentAir, Config.min);
		ca = Math.min(ca, Config.max);
		for (int i=0; i<ca;i++) {
			Config.p.image(air, xBase + (w+xStep)*i, yBase);
		}

		yBase = 336;
		w = 16;
		xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));
		int cwat = Math.max(Scores.currentWater, Config.min);
		cwat = Math.min(cwat, Config.max);
		for (int i=0; i<cwat; i++) {
			Config.p.image(water, xBase + (w+xStep)*i, yBase);
		}
		
		yBase = 409;
		w = 20;
		xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));
		int cwas = Math.max(Scores.currentWaste, Config.min);
		cwas = Math.min(cwas, Config.max);
		for (int i=0; i<cwas;i++) {
			Config.p.image(waste, xBase + (w+xStep)*i, yBase);
		}
		
		yBase = 479;
		w = 22;
		xStep = (float)((327 - xBase - Config.max*w)/(Config.max-1));
		int cv = Math.max(Scores.currentVisenv, Config.min);
		cv = Math.min(cv, Config.max);
		for (int i=0; i<cv;i++) {
			Config.p.image(visenv, xBase + (w+xStep)*i, yBase);
		}
		
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}


}
