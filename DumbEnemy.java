import java.util.Random;

import com.jogamp.opengl.GL2;

public class DumbEnemy extends GameObject{
	
	private final static float width = 50, height = 50;
	private float r, g, b;
	private final int min = -3, max = 3;
	
	public DumbEnemy(float wx, float wy) {
		
		super(wx, wy, width, height);
		r = (float) Math.random();
		g = (float) Math.random();
		b = (float) Math.random();

	    vx = (float)Math.random()*(max - min) + min;
	    vy = (float)Math.random()*(max - min) + min;
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