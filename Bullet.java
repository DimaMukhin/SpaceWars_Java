import java.awt.Frame;
import java.awt.event.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Bullet extends GameObject{
	public float va;
	
	
	public Bullet(float wx, float wy) {
		super(wx,wy,10,30);
	}
	
	public void draw(GL2 gl)
	{
		gl.glPushMatrix();
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(1, 1, 1);
		gl.glVertex2f(wx-width/2, wy-height/2);
		gl.glVertex2f(wx+width/2, wy-height/2);
		gl.glVertex2f(wx+width/2, wy+height/2);
		gl.glVertex2f(wx-width/2, wy+height/2);
		gl.glEnd();
		
	}

	@Override
	public void update() {
		
		wx += vx;
		wy += vy;
	}
}
