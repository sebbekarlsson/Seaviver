package seaviver.main.test;

import java.awt.Color;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import seaviver.main.Scene;
import seaviver.main.graphics.LightEngine;
import seaviver.main.graphics.LightSource;

public class Test_Scene extends Scene{
	
	public LightEngine lightengine;
	public LightSource mouse_light = new LightSource(0, 0, this);

	@Override
	protected void tick(float delta) {
		mouse_light.setX(Mouse.getX());
		mouse_light.setY(Display.getHeight() - Mouse.getY());
		
	}

	@Override
	protected void draw(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init(float delta) {
		setBackgroundColor(Color.white);
		
		instantiateActor(new Test_Actor(64, 64, this));
		instantiateActor(new Test_Actor(32, 32, this));
		
		lightengine = new LightEngine(Display.getWidth(), Display.getHeight(), 16, this);
		lightengine.init();
		
		lightengine.addLight(new LightSource(86, 86, this));
		lightengine.addLight(new LightSource(256, 256, this));
		
		LightSource lightsource = new LightSource(356, 356, this);
		lightsource.setColor(Color.blue);
		
		lightengine.addLight(lightsource);
		
		lightengine.addLight(mouse_light);
		
		
	}

}
