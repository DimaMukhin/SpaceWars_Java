import java.awt.Frame;
import java.awt.event.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class Bullet extends GameObject{
	private Player player;
	private Player enemy;
	private final static float height = 15;
	private final static float width = 3;
	private float angle;

	//....
	//..
	public Bullet(Player player, Player enemy) {
		super(player.wx,player.wy,width,height);
		this.player = player;
		this.enemy = enemy;
		this.angle = player.angle;
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
		
		// hit test
		if (hitbox.intersects(enemy.hitbox)) {
			System.out.println("daed!");
		}
	}
}
