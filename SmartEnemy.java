import java.util.Random;

import com.jogamp.opengl.GL2;

public class SmartEnemy extends GameObject{
	
	private final static float width = 50, height = 50;
	private float r, g, b;
	private final int min = -3, max = 3;
	private Player p1; 
	
	public SmartEnemy(float wx, float wy, Player p1) {
		super(wx, wy, width, height);
		this.p1 = p1;
		r = (float) Math.random();
		g = (float) Math.random();
		b = (float) Math.random();

	    vx = (float)Math.random()*(max - min) + min;
	    vy = (float)Math.random()*(max - min) + min;
	}

	
	public void draw(GL2 gl) {
		gl.glColor3f(r, g, b);
		gl.glBegin(GL2.GL_TRIANGLES);
		
		gl.glVertex2f(wx-width/2,wy-height/2);
		gl.glVertex2f(wx+width/2,wy-height/2);
		gl.glVertex2f(wx,wy+height/2);
		
		gl.glVertex2f(wx-width/2,wy+height/2);
		gl.glVertex2f(wx+width/2,wy+height/2);
		gl.glVertex2f(wx,wy-height/2);
		//gl.glVertex2f(wx+width/2,wy+height/2);
		gl.glEnd();
	}

	
	public void update() {
		super.update();
		float dx = p1.wx - wx;
		float dy = p1.wy - wy;
		
		float dist = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
		vx  = 1/dist * dx * 0.5f;
		vy  = 1/dist * dy * 0.5f;
		
		wx += vx;
		wy += vy;
	}

	
	
}