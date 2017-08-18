package com.col.planets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TestPlanet extends Planet{

	public TestPlanet(String name, float x, float y, float radius, int resolution, Color color, ShapeRenderer renderer) {
		super(name, x, y, radius, resolution, color, renderer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		if(color != null)
			renderer.setColor(color);
		renderer.circle(x, y, radius);
		renderer.setColor(Color.WHITE);
	}

	@Override
	protected float[] createPlanet() {
		
		return null;
	}
	
	
	
}
