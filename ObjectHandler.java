import java.util.LinkedList;

import com.jogamp.opengl.GL2;

public class ObjectHandler {
	private LinkedList<GameObject> list;
	
	public ObjectHandler() {
		list = new LinkedList<GameObject>();
	}
	
	public void add(GameObject newObject) {
		list.add(newObject);
	}
	
	public void draw(GL2 gl) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(gl);
		}
	}
	
	public void update() {
		GameObject curr;
		for (int i = 0; i < list.size(); i++) {
			curr = list.get(i);
			
			if (objectOutOfBounds(curr)) {
				list.remove(curr);
			} else {
				curr.update();
			}
		}
	}
	
	private boolean objectOutOfBounds(GameObject curr) {
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