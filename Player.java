import java.awt.Frame;
import java.awt.event.*;
import java.util.LinkedList;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Player extends GameObject{
	private float red;
	private float green;
	private float blue;
	public float va;
	public float angle;
	public float speed;
	public LinkedList<GameObject> bullets;
	
	public Player(float wx, float wy) {
		super(wx,wy,30,50);
		
		speed = 0;
		bullets = new LinkedList<GameObject>();
		
		do
		{
			red = (float)Math.random();
			green = (float)Math.random();
			blue = (float)Math.random();
		}while(red <= 0.3f && green <= 0.3f && blue <=0.3f);
	}
	
	public void draw(GL2 gl)
	{
		gl.glPushMatrix();
		
		gl.glTranslatef(wx,wy,0);
		gl.glRotated(angle, 0, 0, 1f);
		gl.glTranslatef(-wx,-wy,0);
		
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3f(red, green, blue);
		gl.glVertex2f(wx-width/2,wy-height/2);
		gl.glVertex2f(wx+width/2,wy-height/2);
		gl.glVertex2f(wx,wy+height/2);
		gl.glEnd();
		
		gl.glPopMatrix();
		
		// drawing the bullets
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(gl);
		}
	}

	@Override
	public void update() {
		super.update();
		vy = (float) Math.cos(Math.toRadians(-angle)) * speed;
		vx = (float) Math.sin(Math.toRadians(-angle)) * speed;
		wx += vx;
		wy += vy;
		angle += va;
		
		// updating the bullets
		for (int i = 0; i < bullets.size(); i++) {
			GameObject curr = bullets.get(i);
			curr.update();
			
			// if bullet is out of bounds, delete it
			if (Utility.objectOutOfBounds(curr)) {
				bullets.remove(curr);
			}
		}
	}
}
