import javax.swing.*;

import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

public class SpaceWars implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {
	public static final boolean TRACE = false;

	public static final String WINDOW_TITLE = "Space wars";
	public static final int INITIAL_WIDTH = 640;
	public static final int INITIAL_HEIGHT = 480;

	public static void main(String[] args) {
		final JFrame frame = new JFrame(WINDOW_TITLE);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (TRACE)
					System.out.println("closing window '" + ((JFrame)e.getWindow()).getTitle() + "'");
				System.exit(0);
			}
		});

		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		final GLCapabilities capabilities = new GLCapabilities(profile);
		capabilities.setDoubleBuffered(true);
		final GLCanvas canvas = new GLCanvas(capabilities);
		try {
			Object self = self().getConstructor().newInstance();
			self.getClass().getMethod("setup", new Class[] { GLCanvas.class }).invoke(self, canvas);
			canvas.addGLEventListener((GLEventListener)self);
			canvas.addMouseListener((MouseListener)self);
			canvas.addMouseMotionListener((MouseMotionListener)self);
			canvas.addKeyListener((KeyListener)self);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		canvas.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
		canvas.setAutoSwapBufferMode(true);

		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);

		if (TRACE)
			System.out.println("-> end of main().");
	}

	private static Class<?> self() {
		// This ugly hack gives us the containing class of a static method 
		return new Object() { }.getClass().getEnclosingClass();
	}

	/*** Instance variables and methods ***/
	
	int width, height;
	float left, top, right, bottom;
	long time = 0;

	// TODO: add what you need
	ObjectHandler handler;
	Player player1;
	
	public void setup(final GLCanvas canvas) {
		// Called for one-time setup
		if (TRACE)
			System.out.println("-> executing setup()");

		new Timer().scheduleAtFixedRate(new TimerTask() {
			public void run() {
				canvas.repaint();
			}
		}, 1000, 1000/60);

		// TODO: Add code here
		handler = new ObjectHandler();
		player1 = new Player(50, 50);
		
		handler.add(player1);
		handler.add(new DumbEnemy(100, 100));
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// Called when the canvas is (re-)created - use it for initial GL setup
		if (TRACE)
			System.out.println("-> executing init()");

		final GL2 gl = drawable.getGL().getGL2();

		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		long delta = 0;
		long now = System.nanoTime();
		if (time != 0 && now - time < 100000000)
			delta = now - time;
		time = now;

		// Draws the display
		if (TRACE)
			System.out.println("-> executing display()");

		final GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		// TODO: Update the world, and draw it
		gl.glLoadIdentity();
		//test
		handler.draw(gl);
		handler.update();
	}
	
	public float lerp(float t, float a, float b) {
		return (1 - t) * a + t * b;
	}
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
		// Called when the canvas is destroyed (reverse anything from init) 
		if (TRACE)
			System.out.println("-> executing dispose()");
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// Called when the canvas has been resized
		if (TRACE)
			System.out.println("-> executing reshape(" + x + ", " + y + ", " + width + ", " + height + ")");

		final GL2 gl = drawable.getGL().getGL2();

		this.width = width;
		this.height = height;
		// TODO: choose your coordinate system
//		final float ar = (float)width / (height == 0 ? 1 : height);

		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
//		left = ar < 1 ? -1.0f : -ar;
//		right = ar < 1 ? 1.0f : ar;
//		bottom = ar > 1 ? -1.0f : -1/ar;
//		top = ar > 1 ? 1.0f : 1/ar;
//		gl.glOrthof(left, right, bottom, top, -1.0f, 1.0f);
		gl.glOrthof(0, width, 0, height, 0.0f, 1.0f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	// TODO: use this class if you like, or your own
	class Bubble {
		public float x, y, vx, vy;
		public float radius;
		
		public Bubble(float x, float y, float vx, float vy, float radius) {
			this.x = x;
			this.y = y;
			this.vx = vx;
			this.vy = vy;
			this.radius = radius;
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'w') {
			player1.vy = 3;
		} else if (e.getKeyChar() == 'd') {
			player1.angle += 0.5f;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'w') {
			player1.vy = 0;
		} else if (e.getKeyChar() == 'w') {
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
		
	}

}
