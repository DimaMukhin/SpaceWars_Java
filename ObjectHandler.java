import java.util.LinkedList;

import com.jogamp.opengl.GL2;

public class ObjectHandler {
	private LinkedList<GameObject> list;
	
	public ObjectHandler() {
		list = new LinkedList<GameObject>();
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
			
			curr.update();
		}
	}
}