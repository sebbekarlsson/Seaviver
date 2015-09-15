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
	private Color backgroundColor = Color.black;
	
	/*
	 * Creating a list that will hold actors. (Objects that will be updated & drawn)
	 */
	public ArrayList<Actor> actors = new ArrayList<Actor>();
	
	/*
	 * This variable is for initialization.
	 */
	protected boolean initialized = false;
	
	/**
	 * This function is primarily used to call two other methods. Tick() and Draw(). It can also be used to specify standard
	 * updates for a scene.
	 * 
	 * @param delta the current delta-time.
	 */
	public void update(float delta){
		updateActors(delta);
		tick(delta);
		draw(delta);
	}
	
	/**
	 * This function is used to initialize the scene.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void init(float delta);
	
	/**
	 * This function is used to update the current state of this scene.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void tick(float delta);
	
	/**
	 * This function is used to update the current state of the graphics for this scene.
	 * 
	 * @param delta the current delta-time.
	 */
	protected abstract void draw(float delta);
	
	/**
	 * This is a private method that updates all of the actors in this scene.
	 * 
	 * @param delta the current delta-time
	 */
	private void updateActors(float delta){
		for(int i = 0; i < actors.size(); i++){
			if(!actors.get(i).isInitialized()){
				actors.get(i).init(delta);
				actors.get(i).setInitialized(true);
			}
			actors.get(i).update(delta);
		}
	}
	
	/**
	 * This function is used to check if the scene has been initialized.
	 * 
	 * @return boolean value, initialized or not.
	 */
	public boolean isInitialized(){
		return this.initialized;
	}
	
	/**
	 * This function is used to set the scene to initialized or not.
	 * 
	 * @param initialized boolean value
	 */
	public void setInitialized(boolean initialized){
		this.initialized = initialized;
	}
	
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
