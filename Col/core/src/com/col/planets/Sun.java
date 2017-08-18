package com.col.planets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Sun extends Planet {

	private float angle;
	private float angleMove;

	public Sun(String name, float x, float y, float radius, int resolution, Color color, ShapeRenderer renderer) {
		super(name, x, y, radius, resolution, color, renderer);
		// TODO Auto-generated constructor stub
		angleMove = 360 / resolution;
		points = createPlanet();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		points = createPlanet();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		renderer.setColor(Color.YELLOW);
		renderer.circle(x, y, radius, (int) resolution);
	}

	@Override
	protected float[] createPlanet() {
		float[] points = new float[(int) resolution * 2];
		
		return points;
	}

}
