import com.jogamp.opengl.GL2;

public class DumbEnemy extends GameObject{
	
	private final static float width = 70, height = 70;
	private float r, g, b;
	public DumbEnemy(float wx, float wy) {
		super(wx, wy, width, height);
		r = (float) Math.random();
		g = (float) Math.random();
		b = (float) Math.random();
	}

	
	public void draw(GL2 gl) {
		gl.glColor3f(r, g, b);
		gl.glBegin(GL2.GL_QUAD_STRIP);
		gl.glVertex2f(wx-width/2,wy-height/2);
		gl.glVertex2f(wx+width/2,wy-height/2);
		gl.glVertex2f(wx-width/2,wy+height/2);
		gl.glVertex2f(wx+width/2,wy+height/2);
		gl.glEnd();
	}

	
	public void update() {
		wx += vx;
		wy += vy;
	}

	
	
}