import java.awt.Frame;
import java.awt.event.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Player extends GameObject{
	private float red;
	private float green;
	private float blue;
	
	public Player(float wx, float wy) {
		super(wx,wy,15,15);
		red = (float)Math.random();
		green = (float)Math.random();
		blue = (float)Math.random();
		do
		{
			red = (float)Math.random();
			green = (float)Math.random();
			blue = (float)Math.random();
		}while(red <= 0.3f && green <= 0.3f && blue <=0.3f);
	}
	
	public void draw(GL2 gl)
	{
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3f(red, green, blue);
		gl.glVertex2f(wx-height/2,wy-height/2);
		gl.glVertex2f(wx+height/2,wy-height/2);
		gl.glVertex2f(wx,wy+height/2);
		gl.glEnd();
		
	}

	@Override
	public void update() {
		wx += vx;
		wy += vy;	
	}
}
