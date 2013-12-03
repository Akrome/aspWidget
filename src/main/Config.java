package main;

import processing.core.PApplet;

public class Config {
	public static final float width = 1100f;
	public static final float height = 900f;
	
	public static final float x0 = 0f;
	public static final float y0 = 0f;
	public static final float width0 = width* 1/4 ;
	public static final float height0 = height* 2/3; 
	
	public static final float x1 = width0;
	public static final float y1 = y0;
	public static final float width1 = width - width0;
	public static final float height1 = height0;
	
	public static final float x2 = x0;
	public static final float y2 = height0;
	public static final float width2 = width0;
	public static final float height2 = height - height0;
	
	public static final float x3 = x1;
	public static final float y3 = y2;
	public static final float width3 = width*1/4;
	public static final float height3 = height2;
	
	public static final float x4 = x3 + width3;
	public static final float y4 = y3;
	public static final float width4 = width - (width2+width3);
	public static final float height4 = height3;
	
	//***************************************
	
	public static final int maxBudget = 10;
	public static final int maxEffort = 10;
	
	//***************************************
	
	public static final String[] controlAreas = {"scoreboard", "map", "firstlevelselector", "secondlevelselector", "thirdlevelselector"};
			
	//**************************************
			
	public static PApplet p;
	
}
