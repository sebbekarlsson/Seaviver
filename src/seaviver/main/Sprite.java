package seaviver.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	/*
	 * Creating a list of textures (for animations)
	 */
	public ArrayList<Texture> textures = new ArrayList<Texture>();
	
	/*
	 * Creating a texture index so that we know which texture that should be drawn.
	 */
	public int texture_index = 0;
	
	/**
	 * This function is used to draw the texture.
	 * 
	 * @param delta the current delta-time.
	 */
	public void draw(int delta){
		GL11.glPushMatrix();
		Texture texture = getTexture();
		
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		
		GL11.glTexCoord2f(texture.getImageWidth(), 0);
		GL11.glVertex2f(texture.getWidth(), 0);
		
		GL11.glTexCoord2f(texture.getImageWidth(), texture.getImageHeight());
		GL11.glVertex2f(texture.getWidth(), texture.getHeight());
		
		GL11.glTexCoord2f(0, texture.getImageHeight());
		GL11.glVertex2f(0, texture.getHeight());
		
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/**
	 * This function is used to set a collection of textures to the sprite.
	 * 
	 * @param textures an array of textures.
	 */
	public void setTextures(Texture...textures){
		this.textures = new ArrayList<Texture>(Arrays.asList(textures));
	}
	
	/**
	 * This function is used to get the current texture in the texture list.
	 * 
	 * @return the current texture based on the texture_index.
	 */
	public Texture getTexture(){
		return textures.get(texture_index);
	}
}
