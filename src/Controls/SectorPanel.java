package Controls;

import java.io.File;
import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PImage;

public class SectorPanel extends BasicControl{

	private PImage icon;
	public String iconPath=null;
	private int numberOfElements;
	public SectorButton[] secButtons;
	private int currentlyOn;
	public HashMap<String, SectorPanel> secPanels;
	
	public SectorPanel(float x, float y, float width, float height, PApplet p) {
		super(x, y, width, height, p);
	}
	
	public void init(String name, int numberOfElements) {
		this.iconPath="assets"+File.separator+name+".png";
		this.numberOfElements=numberOfElements;
		icon = p.loadImage(iconPath);		
	}

	@Override
	public void draw() {
		if (!valid) {
			p.pushMatrix();
			clearBackground();
			p.image(icon, x, y, width / (numberOfElements+1), height);
			if (secButtons!=null) {
				for (int i=0; i<secButtons.length;i++) {
					secButtons[i].draw();
				}
			}
			p.popMatrix();
			valid=true;
		}		
	}
	
	public class SectorButton extends BasicControl {

		public SelectorPanel selPan;
		public boolean isOn;
		public String iconPath;
		public PImage icon;
		
		public SectorButton(float x, float y, float width, float height, PApplet p) {
			super(x, y, width, height, p);
		}

		@Override
		public void draw() {
			if (!valid) {
				p.pushMatrix();
				clearBackground();
				p.image(icon, x, y, width, height);
				if (isOn) {
					selPan.draw();
				}
				p.popMatrix();
				valid=true;
			}		
		}

		@Override
		public void manageClick(float x, float y) {			
		}
	}
	
	public void manageClick(float x, float y) {
		float hsize = width / (numberOfElements+1);
		float offsetX = x - this.x - hsize;
		if (offsetX > 0) {
			int pos = (int) (offsetX / hsize);
			if (pos<secButtons.length)  {
				for (SectorPanel spp: secPanels.values()) {
					for (SectorButton sbb: spp.secButtons) {
						sbb.isOn=false;
					}
				}
				secButtons[pos].manageClick(x, y);
				secButtons[pos].isOn=true;
				secButtons[pos].selPan.draw();
			}
		}
	}

	public void initSecButtons(String[] names) {
		secButtons=new SectorButton[names.length];
		float hsize = width / (numberOfElements+1);
		for (int i=0; i<secButtons.length;i++) {
			secButtons[i]=new SectorButton(x+hsize*(i+1), y, hsize, height, p);
			secButtons[i].iconPath="assets"+File.separator+names[i]+".png";
			secButtons[i].icon=p.loadImage(secButtons[i].iconPath);
		}
		
	}

}
