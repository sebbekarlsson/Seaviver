package seaviver.main;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * 
 * @author Sebastian Robert Karlsson
 */
public class Seaviver {
	
	/*
	 * Setting the default WIDTH value for the display.
	 */
	private static int WIDTH = 640;
	
	/*
	 * Setting the default HEIGHT value for the display.
	 */
	private static int HEIGHT = WIDTH / 16 * 9;
	
	/*
	 * Setting the default SCALE value for the display.
	 */
	public static int SCALE = 2;
	
	/*
	 * Setting a public dimension for the display.
	 */
	public static Dimension DISPLAY_SIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
	/*
	 * Setting the default title for the display.
	 */
	public static String TITLE = "SEAVIVER";
	
	/*
	 * Creating the scene-list that will hold all of the game's scenes.
	 */
	public static ArrayList<Scene> SCENES = new ArrayList<Scene>();
	
	/*
	 * This is basically a pointer for the scene-list. (Which scene is currently relevant?)
	 */
	public static int SCENE_INDEX = 0;
	
	/**
	 * Let's start the game by creating an instance of it.
	 * 
	 * @param args program arguments
	 * @throws LWJGLException 
	 */
	public static void main(String[] args) throws LWJGLException{
		new Seaviver();
	}
	
	/**
	 * This is the Seaviver object constructor.
	 * 
	 * @throws LWJGLException because.
	 */
	public Seaviver() throws LWJGLException{
		
		/*
		 * Exiting the program if there are no scenes added to the buffer.
		 */
		if(SCENES.size() == 0){
			System.err.println("There are no scenes in buffer.");
			System.exit(0);
		}
		
		/*
		 * Creating our display with a title.
		 */
		createDisplay(TITLE);
		
		/*
		 * Starting the GameLoop.
		 */
		loop();
		
		/*
		 * Exiting our program if the GameLoop ends for some reason.
		 */
		System.exit(0);
	}
	
	/**
	 * This is the GameLoop
	 */
	private void loop(){
		
		/*
		 * Starting the actual loop
		 */
		while(!Display.isCloseRequested()){
			
			/*
			 * Fetching the current scene, because we will need it.
			 */
			Scene scene = getCurrentScene();
			
			/*
			 * Clearing the display with the current scene's background-color.
			 */
			clearDisplay(scene.getBackgroundColor(), 1f);
			
			/*
			 * Updating the current state of the game.
			 */
			GL11.glPushMatrix();
			update(0);
			GL11.glPopMatrix();
			
			/*
			 * Syncing the display.
			 */
			Display.sync(60);
			
			/*
			 * Updating the display.
			 */
			Display.update();
		}
	}
	
	/**
	 * This function is used to update the current state of the game. (Probably only used in the GameLoop)
	 * 
	 * @param delta the current delta-time.
	 */
	private void update(int delta){
		
	}
	
	/**
	 * This function is used to create our display.
	 * 
	 * @param title a title for the Display.
	 * @throws LWJGLException this is thrown if we cannot create the display.
	 */
	private void createDisplay(String title) throws LWJGLException{
		Display.setTitle(title);
		Display.setDisplayMode(new DisplayMode(DISPLAY_SIZE.width, DISPLAY_SIZE.height));
		Display.create();
	}
	
	/**
	 * This function is used to clear the display. (It is probably only used in the GameLoop)
	 * 
	 * @param color the choosen background-color for the display.
	 * @param alpha the alpha of the background-color for the display.
	 */
	private void clearDisplay(Color color, float alpha){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(color.getRed()/255f, color.getGreen()/255f, color.getBlue()/255f, alpha);
	}
	
	/**
	 * This function is used to get the current scene that is currently viewed and updated.
	 * 
	 * @return current scene.
	 */
	public static Scene getCurrentScene(){
		return SCENES.get(SCENE_INDEX);
	}
}
