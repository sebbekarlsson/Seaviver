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
	protected float x = 0f, y = 0f, depth = 0f, rotation = 0f;
	
	/*
	 * Creating a sprite for the actor.
	 */
	public Sprite sprite = new Sprite();
	
	/*
	 * Creating a hitbox for the actor.
	 */
	protected Hitbox hitbox = new Hitbox();
	
	/*
	 * This variable is for initialization.
	 */
	protected boolean initialized = false;
	
	public Actor(float x, float y){
		this.x = x;
		this.y = y;
	}
	
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
	 * This function is used to set the x position of the actor.
	 * 
	 * @param x the chosen x value
	 */
	public void setX(float x){
		this.x = x;
	}
	
	/**
	 * This function is used to set the y position of the actor.
	 * 
	 * @param y the chosen y value
	 */
	public void setY(float y){
		this.y = y;
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
	public void update(float delta){
		
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
	 * This function is used to initialize the actor.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void init(float delta);
	
	/**
	 * This function is used to update the current state of the graphics that this actor is drawing.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void draw(float delta);
	
	/**
	 * This function is used to update the current state of the actor.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void tick(float delta);
	
	/**
	 * This is the default draw method.
	 * 
	 * @param delta the current delta-time.
	 */
	public void drawDefault(float delta){
		
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef(x, y, 1f);
		GL11.glRotatef(rotation, 0, 0f, 1f);
		
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
	
	/**
	 * This function is used to get the rotation of the actor.
	 * 
	 * @return actor rotation
	 */
	public float getRotation(){
		return this.rotation;
	}
	
	/**
	 * This function is used to set the rotation of the actor.
	 * 
	 * @param rotation the chosen rotation to apply to the actor.
	 */
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	
	/**
	 * This function is used to check if the actor has been initialized.
	 * 
	 * @return boolean value, initialized or not.
	 */
	public boolean isInitialized(){
		return this.initialized;
	}
	
	/**
	 * This function is used to set the actor to initialized or not.
	 * 
	 * @param initialized boolean value
	 */
	public void setInitialized(boolean initialized){
		this.initialized = initialized;
	}
}
