import java.awt.Rectangle;
import java.util.LinkedList;

import com.jogamp.opengl.GL2;

public class ObjectHandler {
	private LinkedList<GameObject> enemies;
	Player player1;
	Player player2;
	
	public ObjectHandler(Player player1, Player player2) {
		enemies = new LinkedList<GameObject>();
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void add(GameObject newObject) {
		enemies.add(newObject);
	}
	
	public void draw(GL2 gl) {
		player1.draw(gl);
		player2.draw(gl);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(gl);
		}
	}
	
	public void update() {
		player1.update();
		player2.update();
		
		GameObject curr;
		for (int i = 0; i < enemies.size(); i++) {
			curr = enemies.get(i);
			
			// hit detection for player1
			if(curr.hitbox.intersects(player1.hitbox)) {
				System.out.println("you are dead!");
			}
			
			// hit detection for player2
			if(curr.hitbox.intersects(player2.hitbox)) {
				System.out.println("you are dead!");
			}
			
			curr.update();
		}
	}
}