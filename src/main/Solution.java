package main;

import java.util.HashMap;

import processing.core.PImage;

public class Solution {
	public final String category;
	public final String type;
	public final String name;
	
	public HashMap<String, Integer> data;
	
	public final PImage buttonOff;
	public final PImage buttonOn;
	public final PImage image;
	
	public final int index;
	
	public boolean status;
	
	public Solution(String c, String t, String n, PImage bOn, PImage bOff, PImage ip, int index) {
		this.category = c;
		this.type = t;
		this.name = n;
		this.buttonOff=bOff;
		this.buttonOn=bOn;
		this.image=ip;
		this.index=index;
		this.data = new HashMap<String, Integer>();
	}
}
