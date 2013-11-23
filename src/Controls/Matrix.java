package Controls;

import java.io.File;

import main.Config;
import processing.core.PApplet;
import processing.core.PImage;

public class Matrix extends BasicControl{

	public Matrix(float x, float y, float width, float height, PApplet p) {
		super(x, y, width, height, p);
		initMatrix();
		
	}

	public class MatrixCell extends BasicControl {

		public String imagePath="assets"+File.separator+"test.jpg";
		private PImage icon;
		public boolean isOn = true;
		
		public MatrixCell(float x, float y, float width, float height, PApplet p) {
			super(x, y, width, height, p);
			this.icon = p.loadImage(imagePath);
		}

		@Override
		public void draw() {
			p.pushMatrix();
			p.rectMode(PApplet.CORNER);
			clearBackground();
			if (isOn) {
				p.image(icon, x,  y, width, height);
			}
			p.popMatrix();
			valid=true;
		}

		@Override
		public void manageClick(float x, float y) {}
		
	}
	
	private MatrixCell[][] matrix;
	private void initMatrix() {
		matrix = new MatrixCell[Config.matrixCells][Config.matrixCells];
		float cellWidth = width / Config.matrixCells;
		float cellHeight = height / Config.matrixCells;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				matrix[i][j] = new MatrixCell(x+j*cellWidth, y+i*cellHeight, cellWidth, cellHeight, p);
			}
		}
	}
	
	@Override
	public void draw() {
		if (!valid) {
			p.pushMatrix();
			clearBackground();
			for (int i=0; i<matrix.length; i++) {
				for (int j=0; j<matrix.length; j++) {
					matrix[i][j].draw();
				}
			}
			p.popMatrix();
			valid=true;
		}		
	}

	@Override
	public void manageClick(float x, float y) {
		// TODO Auto-generated method stub
		
	}

}
