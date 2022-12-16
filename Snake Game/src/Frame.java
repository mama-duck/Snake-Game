import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame implements KeyListener{
	private Random r = new Random();
	public Apple a = new Apple(r.nextInt(10)*50, r.nextInt(10)*50, 25, 25, Color.BLUE);
	public Snake s = new Snake(r.nextInt(10)*50, r.nextInt(10)*50, 25, 25, Color.GREEN);
	public boolean f = false;
	public Point dir = new Point(0,0);
	public Frame() {
		this.setSize(750,750);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(this);
		
		//not taking any points off for the timer not running the logic is fine
		Timer t = new Timer(100, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(s.eat(a)) {
					a.posX = r.nextInt(10)*50;
					a.posY = r.nextInt(10)*50;
					s.updateBody();
					}
				s.MoveHead(dir);
				repaint();
				}
			}
		);
		t.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		//updating the direction should change both x and y in each key.
		//we don't wan the snake moving on a diagonal line
		if(e.getKeyCode() == KeyEvent.VK_W) {
			dir.x = -1;
			//dir.y = 0;
		};
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			dir.y = -1;
		};
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			dir.x = 1;
		};
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			dir.y = 1;
		};
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			f = true;
		};
		repaint();
	}
		// TODO Auto-generated method stub
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
public void paint(Graphics g) {
	super.paint(g);
	//redundant if statement: if(f) if(f) are asking the same thing
	//makes code easier to read and more efficient if this is under one statement
	if(f) {	g.setColor(Color.MAGENTA);
		g.drawOval(a.posX+50, a.posY+50, a.width, a.height);
	//remove if and put draw rect with the oval
	if(f) {g.setColor(s.color);
		g.drawRect(s.xd+50, s.yd+50, 25, 25);
			}
		}
	for(Point p : s.body) {
		g.drawRect(p.x+50, p.y+50, s.height, s.length);
	}
	}
}
