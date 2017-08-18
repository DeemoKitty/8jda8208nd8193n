package com.col.main;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.col.entities.Entity;
import com.col.planets.Planet;

public class Universe{

	private ArrayList<Entity> entities;
	private ArrayList<Planet> planets;
	
	private ShapeRenderer renderer;
	
	/*
	 * TODO - Fix the update and render methods. Feels a bit redundant/too much.
	 */
	
	public Universe(ShapeRenderer renderer) {
		this.renderer = renderer;
		
		entities = new ArrayList<Entity>();
		planets = new ArrayList<Planet>();
	}
	
	public void update(float delta) {
		if(entities != null && !entities.isEmpty()) {
			for(int i = 0; i < entities.size(); i++) {
				Entity e = entities.get(i);
				e.update(delta);
			}
		}
		if(planets != null && !planets.isEmpty()) {
			for(int i = 0; i < planets.size(); i++) {
				Planet p = planets.get(i);
				p.update(delta);
			}
		}
	}
	
	public void render() {
		renderer.begin(ShapeType.Line);
		if(entities != null && !entities.isEmpty()) {
			for(int i = 0; i < entities.size(); i++) {
				Entity e = entities.get(i);
				e.render();
				renderer.setColor(Color.WHITE);
			}
		}
		if(planets != null && !planets.isEmpty()) {
			for(int i = 0; i < planets.size(); i++) {
				Planet p = planets.get(i);
				p.render();
				renderer.setColor(Color.WHITE);
			}
		}
		renderer.end();
	}
	
	public void AddPlanet(Planet p) {
		this.planets.add(p);
	}
	
	public void RemovePlanet(Planet p) {
		this.planets.remove(p);
	}
	
	public void AddEntity(Entity e) {
		this.entities.add(e);
	}
	
	public void RemoveEntity(Entity e) {
		this.entities.remove(e);
	}
	
	public void dispose() {
		entities = null;
	}
}
