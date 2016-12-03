import java.awt.Frame;
import java.awt.event.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Bullet extends GameObject{
	public float va;
	private Player player1;
	private final static float height = 15;
	private final static float width = 3;
	private float angle;

	//....
	//..
	public Bullet(Player player1) {
		super(player1.wx,player1.wy,width,height);
		this.player1 = player1;
		this.angle = player1.angle;
		vx = (float)Math.sin(Math.toRadians(-angle));
		vy = (float)Math.cos(Math.toRadians(-angle));
		
	}
	
	public void draw(GL2 gl)
	{
		gl.glPushMatrix();
		
		gl.glTranslatef(wx,wy,0);
		gl.glRotated(angle, 0, 0, 1f);
		gl.glTranslatef(-wx,-wy,0);
		
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(1, 0.027f, 0.192f);
		gl.glVertex2f(wx-width/2, wy-height/2);
		gl.glVertex2f(wx+width/2, wy-height/2);
		gl.glVertex2f(wx+width/2, wy+height/2);
		gl.glVertex2f(wx-width/2, wy+height/2);
		gl.glEnd();
		gl.glPopMatrix();
	}

	@Override
	public void update() {
		super.update();
		wx += vx;
		wy += vy;
	}
}
