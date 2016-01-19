package com.example.taggame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	
	public static void main(String[] args) {
		
		LwjglApplicationConfiguration cfg =
			new LwjglApplicationConfiguration();
		cfg.title = "TagGame";
		cfg.width = 640;
		cfg.height = 480;
		cfg.useGL20 = false;
		cfg.resizable = false;
		
		new LwjglApplication(new Game(), cfg);
		
	}

}
