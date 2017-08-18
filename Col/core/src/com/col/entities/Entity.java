package com.col.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected ShapeRenderer renderer;
	
	protected float x, y, width, height, angle;
	protected float poly[];
	
	public Entity(float x, float y, float width, float height, ShapeRenderer renderer) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.renderer = renderer;
		this.poly = createEntity();
	}
	
	public abstract void update(float delta);
	public abstract void render();
	
	protected abstract float[] createEntity();
	
	public Vector2 getSize() { return new Vector2(width, height); }
	public Vector2 getPosition() { return new Vector2(x, y); }
}
