package seaviver.main;

/**
 * 
 * @author Sebastian Robert Karlsson
 */
public abstract class Entity extends Actor {
	
	/*
	 * Setting the delta position variables for the Entity.
	 */
	protected float dx, dy = 0f;
	
	/*
	 * Setting the default friction value for the Entity.
	 */
	protected float friction = 0.5f;
	
	@Override
	public void update(int delta){
		updatePhysics(delta);
		tick(delta);
		draw(delta);
	}
	
	/**
	 * This function is used to decrease the Entity's velocity with the friction value.
	 * This function is also used to check for collisions etc.
	 * 
	 * @param delta the current delta-time.
	 */
	private void updatePhysics(int delta){
		
		/*
		 * Velocity decreasement on the x-axis
		 */
		if(dx > 0){
			if(dx - friction < 0){
				dx = 0;
			}else{
				dx -= friction;
			}
		}
		if(dx < 0){
			if(dx + friction > 0){
				dx = 0;
			}else{
				dx += friction;
			}
		}
		
		/*
		 * Velocity decreasement on the y-axis
		 */
		if(dy > 0){
			if(dy - friction < 0){
				dy = 0;
			}else{
				dy -= friction;
			}
		}
		if(dy < 0){
			if(dy + friction > 0){
				dy = 0;
			}else{
				dy += friction;
			}
		}
	}

}
