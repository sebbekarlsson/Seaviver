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
	 * Creating the array of squares
	 */
	public DarknessSquare[][] squares;
	
	public ArrayList<LightSource> lights = new ArrayList<LightSource>();
	
	public LightEngine(int width, int height, int square_size, Scene scene){
		this.width = width;
		this.height = height;
		this.square_size = square_size;
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
				scene.instantiateActor(squares[xx][yy]);
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
	
}
