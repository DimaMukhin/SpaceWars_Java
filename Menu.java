import com.jogamp.opengl.GL2;

public class Menu {
	public static void draw(GL2 gl) {
		gl.glColor3f(1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2f(10, 10);
		gl.glVertex2f(10, 200);
		gl.glVertex2f(200, 200);
		gl.glVertex2f(200, 10);
		
		gl.glEnd();
	}
	
	public static void update() {
		
	}
}
