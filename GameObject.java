import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public abstract class GameObject {
	public float wx, wy; // world position x and y
	public float vx, vy; // velocity x and velocity y
	public float width, height; // width and height of the object
	public Rectangle hitbox;
	
	public GameObject(float wx, float wy, float width, float height) {
		this.wx = wx;
		this.wy = wy;
		this.width = width;
		this.height = height;
		
		hitbox = new Rectangle((int) (wx - (width / 2.0f)),
				(int) (wy - (height / 2.0f)),
				(int) width, (int) height);
	}
	
	public abstract void draw(GL2 gl);
	
	public void update() {
		hitbox = new Rectangle((int) (wx - (width / 2.0f)),
				(int) (wy - (height / 2.0f)),
				(int) width, (int) height);
	}
}