package Controls;

import processing.core.PApplet;

public abstract class BasicControl {
	
	protected boolean valid = false;
	
	protected final PApplet p;
	public float x;
	public float y;
	public float width;
	public float height;
	
	public int backgroundColor = 0xFFFFFFFF;
	public int borderColor = 0xFF000000;
	
	
	public BasicControl(float x, float y, float width, float height, PApplet p) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;		
	}
	
	public abstract void draw();

	//TO BE CALLED ONLY WITHIN A PUSH/POP MATRIX PAIR
	protected void clearBackground() {
		p.fill(backgroundColor);
		p.rectMode(PApplet.CORNER);
		p.rect(x, y, width, height);
	}
	
	public void invalidate() {valid=false;}
}
