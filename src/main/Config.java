package main;

public class Config {
	
	public static float width = 1200;
	public static float height = 800;
	
	public static float epsilonX = width / 50;
	public static float epsilonY = height / 20;
	
	
	public static float sidebarX = width/5;
	public static float footerY = height*4/5;
	
	public static float topX = width*3/5;
	public static float topY = 0 + epsilonY;
	
	public static float lxX = sidebarX + epsilonX;
	public static float lxY = height*2/5;
	
	public static float botX = topX;
	public static float botY = footerY - epsilonY;
	
	public static float rxX = width - epsilonX;
	public static float rxY = lxY;
	
	public static int sideSquares = 3;
	

}
