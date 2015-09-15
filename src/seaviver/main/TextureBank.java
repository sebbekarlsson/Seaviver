package seaviver.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {
	
	/*
	 * Creating a hashmap that will be used as a dictionary for all our textures.
	 */
	private static HashMap<String, Texture> textures = new HashMap<String, Texture>();
	
	/**
	 * This function is used to load in a bunch of textures that are in a directory.
	 * 
	 * @param path path to directory where textures are.
	 */
	public static void loadTextures(String path){
		
		/*
		 * Iterating through all of the files in the specified dir.
		 */
		File dir = new File(path);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File image : directoryListing) {
		    	System.out.println("loading texture: " + image.getName());
		    	textures.put(image.getName(), loadTexture(image.getAbsolutePath(), "png"));
		    }
		  } else {
			  System.err.println("The path is not a directory (TextureBank -> loadTextures(path)");
			  System.exit(1);
		  }
	}
	
	/**
	 * This function is used to load in a texture.
	 * 
	 * @param path path to image file.
	 * @param format for example; png.
	 * @return
	 */
	private static Texture loadTexture(String path, String format){
		Texture texture = null;
		
		try {
			texture = TextureLoader.getTexture(format, new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return texture;
	}
	
	/**
	 * This function is used to collect a desired texture from the loaded textures.
	 * 
	 * @param name the name of the texture. for example "horse.png"
	 * @return desired texture.
	 */
	public static Texture getTexture(String name){
		return textures.get(name);
	}
}
