package Controls;

public abstract class BasicControl {
	public float width;
	public float height;
	public float x;
	public float y;
	boolean valid;
	
	public BasicControl (float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.valid = false;
	}
	
	public abstract void draw();
	
	public void invalidate() {this.valid=false;}
	
	public String toString() {
		return "X: "+x+" Y:"+y+" WIDTH:"+width+" HEIGHT:"+height;
	}
	
	public void mouseDown(float mx, float my) {
		
	}
	
	public void mouseOver(float mx, float my) {
		
	}
	
}
