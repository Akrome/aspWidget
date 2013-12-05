package Controls;

import java.util.HashMap;

import main.Assets;
import main.Colors;
import main.Config;
import main.Scores;
import processing.core.PApplet;
import processing.core.PImage;

public class Scoreboard extends BasicControl {
	PImage effortOn;
	PImage effortOff;
	PImage budgetOn;
	PImage budgetOff;
	PImage water;
	PImage air;
	PImage waste;
	
	

	@SuppressWarnings("unchecked")
	public Scoreboard(float x, float y, float width, float height) {
		super(x, y, width, height);
		effortOn = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("efforton");
		effortOff = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("effortoff");
		budgetOn = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("budgeton");
		budgetOff = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("budgetoff");
		water = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("water");
		waste = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("waste");
		air = (PImage) ((HashMap<String, Object>) (Assets.assets.get("scoreboard"))).get("air");
		
	}

	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.rectMode(PApplet.CORNER);
		Config.p.fill(Colors.green);
		Config.p.rect(x, y, width, height);
		float yStep = height/12;
		float xStep = width/(Math.max(Config.maxBudget, Config.maxEffort)*2+1);
		
		Config.p.fill(Colors.black);
		Config.p.text("Budget Available:", xStep, yStep);
		for (int i=0; i<Config.maxBudget;i++) {
			if (i<Scores.currentBudget) {
				Config.p.image(budgetOn, xStep*(1+2*i), yStep*2, xStep, yStep);
			}
			else {
				Config.p.image(budgetOff, xStep*(1+2*i), yStep*2, xStep, yStep);
			}
		}
		
		Config.p.text("Effort Available:", xStep, yStep*3);
		for (int i=0; i<Config.maxBudget;i++) {
			if (i<Scores.currentBudget) {
				Config.p.image(effortOn, xStep*(1+2*i), yStep*4, xStep, yStep);
			}
			else {
				Config.p.image(effortOff, xStep*(1+2*i), yStep*4, xStep, yStep);
			}
		}
		
		Config.p.text("Air quality:", xStep, yStep*5);
		for (int i=0; i<Scores.currentAir;i++) {
			Config.p.image(budgetOn, xStep*(1+2*i), yStep*6, xStep, yStep);
		}

		Config.p.text("Water quality:", xStep, yStep*7);
		for (int i=0; i<Scores.currentAir;i++) {
			Config.p.image(budgetOn, xStep*(1+2*i), yStep*8, xStep, yStep);
		}
		
		Config.p.text("Waste quality:", xStep, yStep*9);
		for (int i=0; i<Scores.currentAir;i++) {
			Config.p.image(budgetOn, xStep*(1+2*i), yStep*10, xStep, yStep);
		}
		
		
		Config.p.popMatrix();
	}

	@Override
	public void click(float mx, float my) {
		// TODO Auto-generated method stub
		
	}


}
