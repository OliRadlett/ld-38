package com.oli.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Parts {
	
	Array<Texture> parts;
	Texture LED;
	
	public Parts() {
		
		parts = new Array<Texture>();
		LED = new Texture("LED.png");
		parts.add(LED);
		
	}

}