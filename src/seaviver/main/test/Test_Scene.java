package seaviver.main.test;

import java.awt.Color;
import java.util.Random;

import org.lwjgl.opengl.Display;

import seaviver.main.Scene;
import seaviver.main.graphics.LightEngine;

public class Test_Scene extends Scene{
	
	public LightEngine lightengine;
	Random random = new Random();

	@Override
	protected void tick(float delta) {
		getCamera().setX(getCamera().getX()+1f);
		
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
		
		createLightEngine(new LightEngine(Display.getWidth(), Display.getHeight(), 16, this));
		getLightEngine().setEnabled(true);
		
		
		
	}

	@Override
	protected void gui(float delta) {
		getLightEngine().update(delta);
	}

}
