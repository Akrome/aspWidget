package main;


import java.util.HashMap;
import java.util.LinkedList;

import Controls.*;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Program extends PApplet {
	
	LinkedList<BasicControl> controls;
	DrawingPanel dp;
	InfoPanel ip;
	HashMap<String, SectorPanel> sectorPanels;
	SelectorPanel selectorPanel;

	public void setup(){
		size((int)Config.width, (int)Config.height);
		initPanels();
	}
	
	void initPanels() {
		controls = new LinkedList<BasicControl>();
		ip = new InfoPanel(0, 0, Config.infoPanelWidth, Config.topAreaHeight, this);
		ip.backgroundColor=0xFFFF0000;
		controls.add(ip);
		
		dp = new DrawingPanel(Config.infoPanelWidth, 0, Config.drawingPanelWidth, Config.topAreaHeight, this);
		dp.backgroundColor=0xFF00FF00;
		controls.add(dp);
		
		sectorPanels = new HashMap<String, SectorPanel>();
		SectorPanel spEn = new SectorPanel(0, Config.topAreaHeight, Config.width/3, Config.sectorScaffoldHeight, this);
		spEn.backgroundColor=Colors.energy;
		sectorPanels.put("ENERGY", spEn);
		SectorPanel spWas = new SectorPanel(Config.width/3, Config.topAreaHeight, Config.width/3, Config.sectorScaffoldHeight, this);
		spWas.backgroundColor=Colors.waste;
		sectorPanels.put("WASTE", spWas);
		SectorPanel spWat = new SectorPanel(Config.width*2/3, Config.topAreaHeight, Config.width/3, Config.sectorScaffoldHeight, this);
		spWat.backgroundColor=Colors.water;
		sectorPanels.put("WATER", spWat);
		for (SectorPanel sp: sectorPanels.values()) {
			controls.add(sp);
		}
		
		selectorPanel = new SelectorPanel(0, Config.topAreaHeight+Config.sectorScaffoldHeight, Config.width, Config.selectorPanelHeight, this);
		selectorPanel.backgroundColor=0xFFFFFFFF;
		controls.add(selectorPanel);
	}
	
	public void draw(){
		for (BasicControl bc: controls) {
			bc.draw();
		}
	}
	
	
}
