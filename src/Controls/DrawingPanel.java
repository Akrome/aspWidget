package Controls;

import main.Config;
import processing.core.PApplet;

public class DrawingPanel extends BasicControl{
	
	public DrawingPanel(float x, float y, float width, float height, PApplet p) {
		super(x, y, width, height, p);
		initMatrix();
	}


	private Matrix matrix;
	private void initMatrix() {
		final float matrixX = Config.infoPanelWidth + Config.drawingPanelWidth / (Config.matrixCells+2);
		final float matrixWidth = Config.matrixCells* Config.drawingPanelWidth / (Config.matrixCells+2);
		final float matrixY = Config.topAreaHeight / (Config.matrixCells+2);
		final float matrixHeight = Config.matrixCells * Config.topAreaHeight / (Config.matrixCells+2);
		matrix = new Matrix(matrixX, matrixY, matrixWidth, matrixHeight, p);		
	}
	
	@Override
	public void draw() {
		if (!valid) {
			p.pushMatrix();
			clearBackground();
			matrix.draw();
			p.popMatrix();
			valid=true;
		}		
	}

}
