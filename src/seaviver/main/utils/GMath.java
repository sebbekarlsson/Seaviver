package seaviver.main.utils;

public class GMath {

	public static float getDistance(float x1, float y1, float x2, float y2){
		return (float) Math.sqrt(
				(x1-x2) * (x1-x2)
				+
				(y1-y2) * (y1-y2)
				);
	}

}
