import java.awt.Color;

public class Apple {
	//Same as snake class: attributes private with methods to access
	public int posX, posY, width, height;
	public Color color;
	public Apple(int posX, int posY, int width, int height, Color c) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.color = c;
	}
}
