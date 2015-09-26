package seaviver.main.test;

import seaviver.main.Entity;
import seaviver.main.Scene;
import seaviver.main.TextureBank;

public class Test_Actor extends Entity {

	public Test_Actor(float x, float y, Scene scene) {
		super(x, y, scene);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void draw(float delta) {
		this.drawDefault(delta);
		
	}

	@Override
	protected void tick(float delta) {

	}

	@Override
	protected void init(float delta) {
		this.sprite.setTextures(TextureBank.getTexture("tile_grass.png"));
		
	}

}
