package com.col.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.col.entities.Player;
import com.col.planets.Sun;

public class Index extends ApplicationAdapter {
	
	// Library related classes
	private OrthographicCamera ortho;
	private ShapeRenderer renderer;
	//--------------------------
	
	// Custom classes
	private Universe universe;
	private Player player;
	private Sun sun;
	//----------------------
	
	@Override
	public void create () {
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		// Instantiating classes
		ortho = new OrthographicCamera();
		renderer = new ShapeRenderer();
		universe = new Universe(renderer);
		player = new Player(w / 2, h / 2, 10, 16, renderer);
		sun = new Sun("Sun", 20, 20, 500, 10, Color.RED, renderer);
		//---------------------
		
		// Needed parameters for classes
		ortho.setToOrtho(false, w, h); /* Camera set up */
		universe.AddEntity(player);
		universe.AddPlanet(sun);
		// -----------------------------
		
	}

	public void update(float delta) {
		
		updateCamera(delta);
		
		universe.update(delta);
	}
	
	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		
		// Render
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.setProjectionMatrix(ortho.combined);
		universe.render();
	}
	
	private void updateCamera(float delta) {
		Vector3 pos = ortho.position;
		pos.x = player.getPosition().x;
		pos.y = player.getPosition().y;
		ortho.position.set(pos);
		
		if(Gdx.input.isKeyJustPressed(Keys.UP))
			ortho.zoom += 0.1f;
		else if(Gdx.input.isKeyJustPressed(Keys.DOWN))
			ortho.zoom -= 0.1f;
		
		ortho.update();
	}
	
	@Override
	public void resize(int width, int height) {
		ortho.setToOrtho(false, width, height);
	}
	
	@Override
	public void dispose () {
		universe.dispose();
		renderer.dispose();
		ortho = null;
	}
}
