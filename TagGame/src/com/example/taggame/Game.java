package com.example.taggame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class Game implements ApplicationListener{
	
	public static int WIDTH;
	public static int HEIGHT;
	
	private GameManager gameManager;
	
	@Override
	public void create() {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		gameManager = new GameManager();
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
				
		gameManager.update(Gdx.graphics.getDeltaTime());
		gameManager.draw();
	}


	@Override
	public void dispose() {
		gameManager.dispose();
	}
	
	@Override
	public void resize(int arg0, int arg1) {}

	@Override
	public void resume() {}

	@Override
	public void pause() {}

}
