package com.col.planets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Planet {
	
	protected ShapeRenderer renderer;
	
	protected float x, y, radius;
	protected int resolution;
	
	protected String name;
	
	protected Color color;
	
	protected float[] points;
	
	public Planet(String name, float x, float y, float radius, int resolution, Color color, ShapeRenderer renderer) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.renderer = renderer;
		this.resolution = resolution;
		this.color = color;
	}
	
	public abstract void update(float delta);
	
	public abstract void render();
	
	protected abstract float[] createPlanet();
	
	/*
	 * TODO - Add an algorithm for random planet spike/hill generation (LATER)
	 *        -- Math for finding coordinates ( x = center_x + radius * cos(angle); y = center_y + radius * sin(angle); )
	 */
}
