package seaviver.main.graphics;

import java.awt.Color;

import seaviver.main.Entity;
import seaviver.main.Scene;

public class LightSource extends Entity {
	
	/*
	 * Setting the default brightness.
	 */
	protected float brightness = 200f;
	
	/*
	 * Setting the default color.
	 */
	protected Color color = Color.red;

	public LightSource(float x, float y, Scene scene) {
		super(x, y, scene);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void tick(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This function is used to get the current brightness of the light.
	 * 
	 * @return the current brightness of the light
	 */
	public float getBrightness(){
		return this.brightness;
	}
	
	/**
	 * This function is used to set the brightness of the light.
	 * 
	 * @param brightness the chosen brightness
	 */
	public void setBrightness(float brightness){
		this.brightness = brightness;
	}
	
	/**
	 * This function is used to get the current color of the light.
	 * 
	 * @return the current color of the light
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * This function is used to set the color of the light.
	 * 
	 * @param brightness the chosen color
	 */
	public void setColor(Color color){
		this.color = color;
	}
}
