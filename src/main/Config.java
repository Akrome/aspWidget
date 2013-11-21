package main;

public class Config {
	public static float width = 1200;
	public static float height = 800;

	public static float infoPanelWidth = width *1/4;
	
	public static float drawingPanelWidth = width - infoPanelWidth;
	
	public static float topAreaHeight = height *3/5;
	
	public static float sectorScaffoldHeight = (height - topAreaHeight) *1/2;
	
	public static float selectorPanelHeight = height - topAreaHeight - sectorScaffoldHeight;
	
	public static int matrixCells = 5;

}
