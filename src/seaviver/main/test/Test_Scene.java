package seaviver.main.test;

import java.awt.Color;

import seaviver.main.Scene;

public class Test_Scene extends Scene{

	@Override
	protected void tick(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init(float delta) {
		setBackgroundColor(Color.white);
		instantiateActor(new Test_Actor(64, 64));
	}

}
