package seaviver.main.graphics;

import java.awt.Color;

import seaviver.main.Entity;
import seaviver.main.Scene;

public abstract class LightSource extends Entity {
	
	/*
	 * Setting the default brightness.
	 */
	protected float brightness = 200f;
	
	/*
	 * Setting the default color.
	 */
	protected Color color = Color.red;
	
	/*
	 * Should the light be stable?
	 */
	protected boolean stable = true;
	
	/*
	 * Noise for the light.
	 */
	protected float noise = 1f;

	public LightSource(float x, float y, Scene scene) {
		super(x, y, scene);
		// TODO Auto-generated constructor stub
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
	
	/**
	 * This function is used to set noise to the light.
	 * 
	 * @param noise a float value
	 */
	public void setNoise(float noise){
		this.noise = noise;
	}
	
	/**
	 * This function is used to get the noise of the light.
	 * 
	 * @return a float value.
	 */
	public float getNoise(){
		return this.noise;
	}
	
	/**
	 * This function is used to check if the light is stable.
	 * 
	 * @return the current stable boolean
	 */
	public boolean isStable(){
		return this.stable;
	}
	
	/**
	 * This function is used to set the light to either stable or unstable.
	 * 
	 * @param stable a boolean value
	 */
	public void setStable(boolean stable){
		this.stable = stable;
	}
}
