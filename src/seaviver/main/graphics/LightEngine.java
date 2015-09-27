package seaviver.main.graphics;

import java.util.ArrayList;

import seaviver.main.Scene;

public class LightEngine {

	/*
	 * Setting some default values.
	 */
	protected int width = 0, height = 0;
	protected int square_size = 16;
	protected float strength = 1f;
	protected Scene scene;

	/*
	 * Defaulting enabled to false
	 */
	protected boolean enabled = false;

	/*
	 * Creating the array of squares
	 */
	public DarknessSquare[][] squares;

	public ArrayList<LightSource> lights = new ArrayList<LightSource>();

	public LightEngine(int width, int height, int square_size, float strength, Scene scene){
		this.width = width;
		this.height = height;
		this.square_size = square_size;
		this.strength = strength;
		this.scene = scene;

		this.squares = new DarknessSquare[(width+square_size) / square_size][(height+square_size) / square_size];
	}

	/*
	 * Initializing the darkness-network. Creating all the squares.
	 */
	public void init(){
		for(int xx = 0; xx < squares.length; xx++){
			for(int yy = 0; yy < squares[xx].length; yy++){
				squares[xx][yy] = new DarknessSquare(xx * square_size, yy * square_size, scene, this);
				squares[xx][yy].getHitbox().setDimension(square_size, square_size);
				squares[xx][yy].setStrength(strength);
			}
		}
	}

	public void update(float delta){
		if(isEnabled()){
			for(int i = 0; i < lights.size(); i++){
				lights.get(i).update(delta);
			}
			
			for(int xx = 0; xx < squares.length; xx++){
				for(int yy = 0; yy < squares[xx].length; yy++){
					squares[xx][yy].update(delta);
					if(!squares[xx][yy].isInitialized()){
						squares[xx][yy].init(delta);
						squares[xx][yy].setInitialized(true);
					}
				}
			}
		}
	}

	/**
	 * This function will return all of the lights.
	 * 
	 * @return an arraylist of lights
	 */
	public ArrayList<LightSource> getLights(){
		return this.lights;
	}

	/**
	 * This function is used to add lightsources to the light-engine.
	 * 
	 * @param light a lightsource object
	 */
	public void addLight(LightSource light){
		lights.add(light);
	}

	/**
	 * This function is used to check if the lightengine is enabled.
	 * 
	 * @return enabled
	 */
	public boolean isEnabled(){
		return this.enabled;
	}

	/**
	 * This function is used to set the lightengine to either enabled or disabled.
	 * 
	 * @param enabled the choosen enabled value
	 */
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
	
	/**
	 * This function is used to get the strength value of the darkness.
	 * 
	 * @return the strength of the darkness
	 */
	public float getStrength(){
		return this.strength;
	}
	
	/**
	 * This function is used to set the strength of the darkness.
	 * 
	 * @param strength the chosen strength
	 */
	public void setStrength(float strength){
		this.strength = strength;
	}
	
	/**
	 * This function is used to get the roughness of the darkness.
	 * 
	 * @return the size of the darkness square. (roughness)
	 */
	public int getSquareSize(){
		return this.square_size;
	}
	
	/**
	 * This function is used to set the roughness of the darkness.
	 * 
	 * @param square_size the chosen square_size
	 */
	public void setSquareSize(int square_size){
		this.square_size = square_size;
	}
}
