import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	public int posx, posy, length, height, xd, yd;
	public Color color;
	ArrayList<Point>body = new ArrayList();//this adds a square to the snake
	public Snake(int posx, int posy, int length, int height, Color color) {
		this.posx = posx;
		this.posy = posy;
		this.length = length;
		this.height = height;
		this.color = color;
	}
	public boolean eat(Apple a) {
		if(posx == a.posX && posy == a.posY) {
			return(true);
		}
		return(false);
	}
	public void Move() {
		int nextposx = posx;
		int nextposy = posy;
		int tailposx = 0;
		int tailposy = 0;
		for(Point p: body) {
			tailposx = p.x;
			tailposy = p.y;
			p.x = nextposx;
			p.y = nextposy;
			nextposx = tailposx;
			nextposy = tailposy;
			}
		}
	public void updateBody() {
		body.add(new Point(-150, -150));
	}
	public void MoveHead(Point p) {
		Move();
		posx = posx+(50*p.x);
		posy = posy+(50*p.y);
	}
}
