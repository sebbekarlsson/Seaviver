package seaviver.main;

import org.lwjgl.opengl.GL11;

import seaviver.main.physics.Hitbox;

/**
 * 
 * @author Sebastian Robert Karlsson
 */
public abstract class Actor {
	
	/*
	 * Setting our position variables.
	 * Depth will be used to determine if an object should be drawn over another for example.
	 */
	protected float x, y, depth = 0f;
	
	/*
	 * Creating a sprite for the actor.
	 */
	public Sprite sprite = new Sprite();
	
	/*
	 * Creating a hitbox for the actor.
	 */
	protected Hitbox hitbox = new Hitbox();
	
	/**
	 * 
	 * @return the x position of the actor.
	 */
	public float getX(){
		return this.x;
	}
	
	/**
	 * 
	 * @return the y position of the actor.
	 */
	public float getY(){
		return this.y;
	}
	
	/**
	 * 
	 * @return the depth of the actor.
	 */
	public float getDepth(){
		return this.depth;
	}
	
	/**
	 * This function is the root update function for every Actor. This one isually calls for the tick & draw methods.
	 * 
	 * @param delta the current delta-time.
	 */
	public void update(int delta){
		
		/*
		 * Updating the current state of the actor.
		 */
		tick(delta);
		
		/*
		 * Updating the current state of the graphics for this actor.
		 */
		draw(delta);
	}
	
	/**
	 * This function is used to update the current state of the graphics that this actor is drawing.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void draw(int delta);
	
	/**
	 * This function is used to update the current state of the actor.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void tick(int delta);
	
	/**
	 * This is the default draw method.
	 * 
	 * @param delta the current delta-time.
	 */
	public void drawDefault(int delta){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, depth);
		
		sprite.draw(delta);
		
		GL11.glPopMatrix();
	}
	
	/**
	 * This function is used to get the HitBox of the actor.
	 * 
	 * @return the HitBox of the actor.
	 */
	public Hitbox getHitbox(){
		return this.hitbox;
	}
}
