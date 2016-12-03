import java.awt.Rectangle;
import java.util.LinkedList;

import com.jogamp.opengl.GL2;

public class ObjectHandler {
	private LinkedList<GameObject> enemies;
	Player player1;
	
	public ObjectHandler(Player player1) {
		enemies = new LinkedList<GameObject>();
		this.player1 = player1;
	}
	
	public void add(GameObject newObject) {
		enemies.add(newObject);
	}
	
	public void draw(GL2 gl) {
		player1.draw(gl);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(gl);
		}
	}
	
	public void update() {
		player1.update();
		
		GameObject curr;
		for (int i = 0; i < enemies.size(); i++) {
			curr = enemies.get(i);
			
			if(curr.hitbox.intersects(player1.hitbox)) {
				System.out.println("you are dead!");
			}
			
			curr.update();
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