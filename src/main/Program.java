package main;


import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

import Controls.*;
import Controls.SectorPanel.SectorButton;

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
		
		initSectorPanels();
	}
	
	private void initSectorPanels() {
		sectorPanels = new HashMap<String, SectorPanel>();
		
		SectorPanel spEn = new SectorPanel(0, Config.topAreaHeight, Config.width*4/10, Config.sectorScaffoldHeight, this);
		spEn.backgroundColor=Colors.energy;
		spEn.init("energy",3);
		String[] parEn = {"cogeneration", "solar", "wind"};
		spEn.initSecButtons(parEn);
		String[] coPar = {"fuelcells", "internalcombustionengine", "microgasturbine"};
		initSelectorPanel("cogeneration", spEn.secButtons[0], 3, coPar);
		String[] soPar = {"cristalline", "innovative", "thinfilm"};
		initSelectorPanel("solar", spEn.secButtons[1], 3, soPar);
		String[] wiPar = {"eolicenergy"};
		initSelectorPanel("wind", spEn.secButtons[2], 1, wiPar);
		sectorPanels.put("energy", spEn);
		
		SectorPanel spWas = new SectorPanel(Config.width*4/10, Config.topAreaHeight, Config.width*3/10, Config.sectorScaffoldHeight, this);
		spWas.backgroundColor=Colors.waste;
		spWas.init("waste",2);
		String[] parWas = {"wastelogistics", "biomass"};
		spWas.initSecButtons(parWas);
		String[] logPar = {"dehydratation", "torrefaction", "waterfall"};
		initSelectorPanel("wastelogistics", spWas.secButtons[0], 3, logPar);
		String[] bioPar = {"anaerobicdigestion", "composting"};
		initSelectorPanel("biomass", spWas.secButtons[1], 2, bioPar);
		sectorPanels.put("waste", spWas);
		
		SectorPanel spWat = new SectorPanel(Config.width*7/10, Config.topAreaHeight, Config.width*3/10, Config.sectorScaffoldHeight, this);
		spWat.backgroundColor=Colors.water;
		spWat.init("water",2);
		String[] parWat = {"toilets", "fuelcells"};
		spWat.initSecButtons(parWat);
		String[] wcPar = {"ct", "nmv"};
		initSelectorPanel("toilets", spWat.secButtons[0], 2, wcPar);
		String[] fuelPar = {"dfc", "mrc", "pemfc"};
		initSelectorPanel("fuelcells", spWat.secButtons[1], 3, fuelPar);
		sectorPanels.put("water", spWat);
		for (SectorPanel sp: sectorPanels.values()) {
			controls.add(sp);
			sp.secPanels=sectorPanels;
		}
		
		
		
		
	}
	
	private void initSelectorPanel(String name, SectorButton sb, int numberOfElements, String[] names) {
		sb.selPan = new SelectorPanel(0, Config.topAreaHeight+Config.sectorScaffoldHeight, Config.width, Config.height - (Config.topAreaHeight+Config.sectorScaffoldHeight), this);
		sb.selPan.init(name, numberOfElements, names);
	}
	
	public void draw(){
		for (BasicControl bc: controls) {
			bc.draw();
		}
	}
	
	public void mouseReleased() {
		for (BasicControl bc: controls) {
			if (bc.x<=mouseX && mouseX<=bc.x+bc.width && bc.y<=mouseY && mouseY<=bc.y+bc.height) {
				bc.manageClick(mouseX, mouseY);
			}
		}
	}
	
	
}
