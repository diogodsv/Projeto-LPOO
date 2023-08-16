package jogador;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class PecaGUI extends JComponent {
	
	private Color color;
	
	public PecaGUI(Color color) {
		this.color = color;
	}

	public void paintComponent(Graphics g) {
		
		g.setColor(color);
		g.fillOval(18, 13, 50, 50);
		
	}

}
