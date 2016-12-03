import com.jogamp.opengl.GL2;

public abstract class GameObject {
	protected float wx, wy; // world position x and y
	protected float vx, vy; // velocity x and velocity y
	protected float width, height; // width and height of the object
	
	public GameObject(float wx, float wy, float width, float height) {
		this.wx = wx;
		this.wy = wy;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw(GL2 gl);
	
	public abstract void update();
}