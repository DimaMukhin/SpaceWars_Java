import com.jogamp.opengl.GL2;

public class DumbEnemy extends GameObject{
	
	final static float width = 10, height = 10;
	
	public DumbEnemy(float wx, float wy) {
		super(wx, wy, width, height);
	}

	
	public void draw(GL2 gl) {
		gl.glColor3f(0, 1, 0);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex2f(width/2, height/2);
		gl.glVertex2f(width/2, height/2);
		gl.glVertex2f(width/2, height/2);
		gl.glVertex2f(width/2, height/2);
		gl.glEnd();
	}

	
	public void update() {
		
	}

	
	
}