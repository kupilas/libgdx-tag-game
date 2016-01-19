package com.example.taggame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager {
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	
	private Player player1, player2;
	private PlayerInputHandler inputHandler1, inputHandler2;
	private Sound sound;
	
	// constructor
	public GameManager(){
		init();
	}
	
	/////////////////////////////////////
	// public methods
	/////////////////////////////////////
	
	public void update(float deltaTime){
		handleInput(deltaTime);
		checkForCollisions();
		
		// update camera every frame
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);
	}
	
	public void draw(){
		batch.begin();
		font.draw(batch, "Tag Game Tutorial", 0, Game.HEIGHT);
		player1.draw(batch);
		player2.draw(batch);
		batch.end();
	}
	
	public void dispose(){
		batch.dispose();
		font.dispose();
		sound.dispose();
		player1.dispose();
		player2.dispose();
	}
	
	/////////////////////////////////////
	// private methods
	/////////////////////////////////////
	
	private void init(){
		// batch
		batch = new SpriteBatch();
		
		// camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
		
		// font
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		
		// assets
		player1 = new Player("player1.png", 64, 64);
		player2 = new Player("player2.png", 64, 64);
		sound = Gdx.audio.newSound(Gdx.files.internal("sound.wav"));
		
		// input handlers
		inputHandler1 = new PlayerInputHandler(player1, Keys.A, Keys.D, Keys.W, Keys.S);
		inputHandler2 = new PlayerInputHandler(player2, Keys.LEFT, Keys.RIGHT, Keys.UP, Keys.DOWN);
		
		setGameToStartingState();
	}
	
	private void setGameToStartingState() {
		player1.x = 0;
		player1.y = 100;
		
		player2.x = Game.WIDTH - player2.width;
		player2.y = 100;
	}
	
	private void handleInput(float deltaTime){
		inputHandler1.handleInput(deltaTime);
		inputHandler2.handleInput(deltaTime);
	}
	
	private void checkForCollisions() {
		
		if(player1.overlaps(player2)){
			setGameToStartingState();
			sound.play();
		}
		
	}

}
