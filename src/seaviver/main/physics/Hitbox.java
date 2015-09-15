package seaviver.main.physics;

import java.awt.Dimension;

public class Hitbox {
	/*
	 * Setting the position of the HitBox.
	 */
	public float x, y = 0f;
	
	/*
	 * Setting & defaulting the width and height to 16px.
	 */
	public int width, height = 16;
	
	/*
	 * Creating the dimension with width and height.
	 */
	protected Dimension dimension = new Dimension(height, height);
	
	/**
	 * This function is used to get the dimension of the HitBox.
	 * 
	 * @return the dimension of the HitBox. (width, height)
	 */
	public Dimension getDimension(){
		return this.dimension;
	}
	
	/**
	 * This function is used to set the width and height of the HitBox. %
	 * 
	 * @param width the width of the HitBox.
	 * @param height the height of the HitBox.
	 */
	public void setDimension(int width, int height){
		this.getDimension().setSize(width, height);
	}
}
