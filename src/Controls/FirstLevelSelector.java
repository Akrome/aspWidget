package Controls;

import java.util.HashMap;
import java.util.LinkedList;

import main.Assets;
import main.Colors;
import main.Config;
import main.Utilities;
import processing.core.PApplet;
import processing.core.PImage;

public class FirstLevelSelector extends BasicControl {

	public LinkedList<FirstLevelOption> options;
	public FirstLevelOption activeOption;
	private FirstLevelOption left;
	private FirstLevelOption right;
	
	@SuppressWarnings("unchecked")
	public FirstLevelSelector(float x, float y, float width, float height) {
		super(x, y, width, height);
		options=new LinkedList<FirstLevelOption>();
		try {
			HashMap<String, Object> areasHM = (HashMap<String, Object>)(Assets.assets.get("firstlevelselector"));
			for (String area: Utilities.asSortedList(areasHM.keySet())) {
				HashMap<String, Object> areaHM = (HashMap<String, Object>)areasHM.get(area);
				PImage big = (PImage) areaHM.get("big");
				PImage small = (PImage) areaHM.get("small");
				PImage smallover = (PImage) areaHM.get("smallover");
				PImage bigover = (PImage) areaHM.get("bigover");
				FirstLevelOption flo = new FirstLevelOption(0,0,0,0,big, small, smallover, bigover,area);
				options.add(flo);
				if (activeOption==null) {
					makeActive(flo);
				}
				else if (left==null) {
					makeLeft(flo);
				}
				else if (right == null) {
					makeRight(flo);
				}
			}
		}
		catch (Exception e){
			System.out.println("Error in loading the First Level Selector");
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void draw() {
		Config.p.pushMatrix();
		Config.p.fill(Colors.red);
		Config.p.rectMode(PApplet.CORNER);
		Config.p.rect(x,y,width,height);
		
		for (FirstLevelOption fo: options) {
			fo.draw(fo==activeOption);
		}
		Config.p.popMatrix();
	}
	
	void makeLeft (FirstLevelOption fo) {
		fo.isOn=false;
		fo.x = x;
		fo.width = width/2;
		fo.y = y+height*2/3;
		fo.height = height*1/3;
		left = fo;
	}
	
	void makeRight (FirstLevelOption fo) {
		fo.isOn=false;
		fo.x = x+width/2;
		fo.width = width/2;
		fo.y = y+height*2/3;
		fo.height = height*1/3;
		right=fo;
	}
	
	void makeActive (FirstLevelOption fo) {
		fo.isOn=true;
		fo.x = x;
		fo.width = width;
		fo.y = y;
		fo.height = height * 2/3;
		activeOption = fo;
	}
	
	@Override
	public void click(float mx, float my) {
		for (FirstLevelOption fo: options) {
			if (fo.contains(mx, my)) {
				System.out.println("AA");
				if (fo==left) {
					System.out.println("BB");
					FirstLevelOption foo = activeOption;
					makeLeft(foo);
					makeActive(fo);
					break;
					
				}
				else if (fo==right) {
					System.out.println("CC");
					FirstLevelOption foo = activeOption;
					makeActive(fo);
					makeRight(foo);		
					break;
				}
			}
		}
	}	
}
