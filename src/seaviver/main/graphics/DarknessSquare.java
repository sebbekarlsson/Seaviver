package seaviver.main.graphics;

import java.awt.Color;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import seaviver.main.Actor;
import seaviver.main.Scene;
import seaviver.main.utils.GMath;

public class DarknessSquare extends Actor {
	
	/*
	 * This variable is for initialization.
	 */
	protected boolean initialized = false;

	/*
	 * Setting the default color.
	 */
	protected Color color = Color.black;
	protected Color original_color = color;

	/*
	 * Setting the default strength.
	 */
	protected float strength = 0.5f;
	protected float original_strength = 0.5f;

	/*
	 * Setting the default intensity.
	 */
	protected float intensity = 100f;
	
	/*
	 * We will need random for light flickering.
	 */
	protected Random random = new Random();
	
	/*
	 * Should the light flicker?
	 */
	protected boolean flicker = false;

	/*
	 * Setting the parent engine
	 */
	protected LightEngine lightengine;

	public DarknessSquare(float x, float y, Scene scene, LightEngine lightengine) {
		super(x, y, scene);
		this.lightengine = lightengine;
	}

	@Override
	protected void init(float delta) {
		depth = 0f;

	}

	@Override
	protected void draw(float delta) {
		int width = getHitbox().getDimension().width;
		int height = getHitbox().getDimension().width;

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(getColor().getRed()/255f, getColor().getGreen()/255f, getColor().getBlue()/255f, strength);

		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, depth);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0, 0);

		GL11.glVertex2f(width, 0);

		GL11.glVertex2f(width, height);

		GL11.glVertex2f(0, height);
		GL11.glEnd();


		GL11.glPopMatrix();
		GL11.glColor4f(1f, 1f, 1f, 1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);


	}

	@Override
	protected void tick(float delta) {
		/*
		 * Resetting the strength and color.
		 */
		this.strength = this.original_strength;
		this.color = this.original_color;
		
		/*
		 * Iterating through lightsources.
		 */
		for(int i = 0; i < lightengine.getLights().size(); i++){
			/*
			 * Collecting the light.
			 */
			LightSource light = lightengine.getLights().get(i);
			
			/*
			 * Caĺculating the distance.
			 */
			float distance = GMath.getDistance(x+scene.getCamera().getX(), y+scene.getCamera().getY(), light.getX(), light.getY());
			
			/*
			 * Setting the strength of the darkness to the light's brightness.
			 * We're also setting the default percentage value to 0.
			 */
			float strength = light.getBrightness();
			double percentage = 0;
			
			/*
			 * Implementing flickering.
			 */
			if(isFlickering()){
				strength = strength*random.nextFloat();
			}
			
			if(distance < strength){
				/*
				 * Calculating the percentage of change.
				 */
				percentage = distance / strength;
				percentage = Math.abs(percentage-1);
				

				/*
				 * Collecting RGB values.
				 */
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				
				
				/*
				 * Changing the darkness color relative to the light's color.
				 */
				this.color = new Color(Math.min(255, red + light.getColor().getRed()), Math.min(255, green + light.getColor().getGreen()), Math.min(255, blue + light.getColor().getBlue()));
				
				red = this.color.getRed();
				green = this.color.getGreen();
				blue = this.color.getBlue();
				
				/*
				 * Calculating new RGB values.
				 * This will blend colors.
				 */
				red = (int) Math.min(255, ((red - distance) + (red)) - distance);
				green = (int) Math.min(255, ((green - distance) + (green))  - distance);
				blue = (int) Math.min(255, ((blue - distance) + (blue))  - distance);

				/*
				 * Changing the old RGB values to the new RGB values.
				 */
				this.color = new Color(Math.max(0, red), Math.max(0, green), Math.max(0, blue));
			}

			/*
			 * Decreasing the darkness strength with the calculated percentage.
			 */
			this.strength -= percentage;

		}

	}

	/**
	 * This function is used to get the color of the darkness-square
	 * 
	 * @return the current color of the square
	 */
	public Color getColor(){
		return this.color;
	}

	/**
	 * This function is used to set the color of the darkness-square.
	 * 
	 * @param color the chosen color
	 */
	public void setColor(Color color){
		this.color = color;
		this.original_color = color;
	}

	/**
	 * This function is used to get the strength.
	 * 
	 * @return the current strength.
	 */
	public float getStrength(){
		return this.strength;
	}

	/**
	 * This function is used to set the strength of the darkness-square.
	 * 
	 * @param strength the chosen strength
	 */
	public void setStrength(float strength){
		this.strength = strength;
		this.original_strength = strength;
	}

	/**
	 * This function is used to get the intensity.
	 * 
	 * @return the current intensity.
	 */
	public float getIntensity(){
		return this.intensity;
	}

	/**
	 * This function is used to set the intensity of the darkness-square.
	 * 
	 * @param intensity the chosen intensity
	 */
	public void setIntensity(float intensity){
		this.intensity = intensity;
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
	
	/**
	 * This function is used to make the light fĺicker.
	 * 
	 * @param flicker a boolean value
	 */
	public void setFlickering(boolean flicker){
		this.flicker = flicker;
	}
	
	/**
	 * This function is used to check if the light is flickering.
	 * 
	 * @return a boolean value.
	 */
	public boolean isFlickering(){
		return this.flicker;
	}
}
