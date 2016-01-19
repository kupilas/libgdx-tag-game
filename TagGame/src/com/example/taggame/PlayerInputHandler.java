package com.example.taggame;

import com.badlogic.gdx.Gdx;

public class PlayerInputHandler {
	
	private Player player;
	private int keyLeft, keyRight, keyUp, keyDown;
	private final int SPEED = 200;
	
	public PlayerInputHandler(Player player, int keyLeft, int keyRight, int keyUp, int keyDown){
		this.player = player;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
		this.keyUp = keyUp;
		this.keyDown = keyDown;
	}
	
	public void handleInput(float deltaTime){
		if (Gdx.input.isKeyPressed(keyLeft))
			player.x -= SPEED * deltaTime;
		if (Gdx.input.isKeyPressed(keyRight))
			player.x += SPEED * deltaTime;
		if (Gdx.input.isKeyPressed(keyUp))
			player.y += SPEED * deltaTime;
		if (Gdx.input.isKeyPressed(keyDown))
			player.y -= SPEED * deltaTime;
		
		if (player.x < 0)
			player.x = 0;
		if (player.x > Game.WIDTH - player.getWidth())
			player.x = Game.WIDTH - player.getWidth();
		if (player.y < 0)
			player.y = 0;
		if (player.y > Game.HEIGHT - player.getHeight())
			player.y = Game.HEIGHT - player.getHeight();
	}

}
