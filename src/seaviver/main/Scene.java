package seaviver.main;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author Sebastian Robert Karlsson
 */
public abstract class Scene {
	
	/*
	 * Setting the default background-color.
	 */
	private Color backgroundColor = Color.white;
	
	/*
	 * Creating a list that will hold actors. (Objects that will be updated & drawn)
	 */
	public ArrayList<Actor> actors = new ArrayList<Actor>();
	
	/**
	 * This function is primarly used to call two other methods. Tick() and Draw(). It can also be used to specify standard
	 * updates for a scene.
	 * 
	 * @param delta the current delta-time.
	 */
	public void update(int delta){
		tick(delta);
		draw(delta);
	}
	
	/**
	 * This functon is used to update the current state of this scene.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void tick(int delta);
	
	/**
	 * This function is used to update the current state of the graphics for this scene.
	 * 
	 * @param delta the current delta time.
	 */
	protected abstract void draw(int delta);
	
	/**
	 * 
	 * @return the current background-color.
	 */
	public Color getBackgroundColor(){
		return this.backgroundColor;
	}
	
	/**
	 * This function is used to specify the background-color.
	 * 
	 * @param color choosen color for the background.
	 */
	public void setBackgroundColor(Color color){
		this.backgroundColor = color;
	}
	
	/**
	 * 
	 * @return the list of all the current actors.
	 */
	public ArrayList<Actor> getActors(){
		return this.actors;
	}
	
	/**
	 * This function is used to specificly choose what actors this scene should hold.
	 * 
	 * @param actors a list of actors.
	 */
	public void setActors(ArrayList<Actor> actors){
		this.actors = actors;
	}
	
	/**
	 * This function is used to add an actor to the actor-list.
	 * 
	 * @param actor an actor object.
	 */
	public void instantiateActor(Actor actor){
		actors.add(actor);
	}
	
	/**
	 * This function is used to remove an actor from the actor-list.
	 * 
	 * @param actor anb actor object.
	 */
	public void destroyActor(Actor actor){
		actors.remove(actor);
	}
	
	/**
	 * This function is used to remove an actor from the actor-list.
	 * 
	 * @param index an integer that points somewhere in the actor-list.
	 */
	public void destroyActor(int index){
		actors.remove(index);
	}
}
