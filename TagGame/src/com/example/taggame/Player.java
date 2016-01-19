package com.example.taggame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Rectangle{
	
	private Texture texture;
	
	public Player(String fileString, int width, int height){
		texture= new Texture(Gdx.files.internal(fileString));
		this.width = width;
		this.height = height;
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(texture, this.x, this.y);
	}
	
	public void dispose(){
		texture.dispose();
	}

}
