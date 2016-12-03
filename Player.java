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
}
