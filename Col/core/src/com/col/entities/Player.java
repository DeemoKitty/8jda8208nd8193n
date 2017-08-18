package com.col.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends Entity {

	public Player(float x, float y, float width, float height, ShapeRenderer renderer) {
		super(x, y, width, height, renderer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float delta) {
		if (Gdx.input.isKeyPressed(Keys.W)) {
			y++;
			angle = 0;
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			y--;
			angle = 180;
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			x--;
			angle = 270;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			x++;
			angle = 90;
		}
		poly = createEntity();
	}

	@Override
	public void render() {
		renderer.polygon(poly);
	}

	private void rotate(float angle) {
		
	}

	@Override
	protected float[] createEntity() {
		float[] points = { x - width, y, x, y + height, x + width, y };
		return points;
	}

}
