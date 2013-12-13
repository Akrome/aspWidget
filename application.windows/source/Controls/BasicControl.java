package Controls;

public abstract class BasicControl {
	public float width;
	public float height;
	public float x;
	public float y;	
	
	public BasicControl (float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw();
	
	public String toString() {
		return "X: "+x+" Y:"+y+" WIDTH:"+width+" HEIGHT:"+height;
	}
	
	public abstract void click(float mx, float my);
	
	public boolean contains (float mx, float my) {
		return x <= mx && mx <= x+width && y <= my && my <= y+height;
	}
	
}
