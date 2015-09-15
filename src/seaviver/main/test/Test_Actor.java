package seaviver.main.test;

import seaviver.main.Entity;
import seaviver.main.TextureBank;

public class Test_Actor extends Entity {

	public Test_Actor(float x, float y) {
		super(x, y);
		this.sprite.setTextures(TextureBank.getTexture("tile_grass.png"));
	}

	@Override
	protected void draw(float delta) {
		this.drawDefault(delta);
		
	}

	@Override
	protected void tick(float delta) {
		dy += 1f;
	}

}
