import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.*;
import java.util.Scanner;

class ThirdGLEventListener implements GLEventListener {
    private GLU glu;
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.9f, 0.1f, 0.4f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        Scanner sc = new Scanner(System.in);
        System.out.println("Height");
        int height = sc.nextInt();
        System.out.println("Width");
        int width = sc.nextInt();

        gl.glLineWidth(1.0f);
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(width,0);

        gl.glVertex2d(0,height);
        gl.glVertex2d(width,height);

        gl.glVertex2d(0, 0);
        gl.glVertex2d(0,height);

        gl.glVertex2d(width,0);
        gl.glVertex2d(width,height);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
    }
    public void displayChanged(GLAutoDrawable drawable,
                               boolean modeChanged, boolean deviceChanged) {
    }
    public void dispose(GLAutoDrawable arg0) {

    }
}
public class J16301127 {
    public static void main(String args[]) {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        ThirdGLEventListener b = new ThirdGLEventListener();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);

        final JFrame frame = new JFrame("Viewing the rectangle");
        frame.add(glcanvas);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}