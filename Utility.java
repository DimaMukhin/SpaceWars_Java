
public class Utility {
	public static boolean objectOutOfBounds(GameObject curr) {
		boolean out = false;
		
		if (curr.wx + (curr.width / 2.0f) > SpaceWars.INITIAL_WIDTH) {
			out = true;
		} else if (curr.wx - (curr.width / 2.0f) < 0) {
			out = true;
		} else if (curr.wy + (curr.height / 2.0f) > SpaceWars.INITIAL_HEIGHT) {
			out = true;
		} else if (curr.wy - (curr.height / 2.0f) < 0) {
			out = true;
		}
			
		return out;
	}
}
