package crazyrun;

import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {
	
	private Game game;
	
	public GameFrame() {
		
		game = new Game();
		game.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		add(game);
		
		pack();
		
		setTitle("Bouncing Ball Game...");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new GameFrame();
			}
		});

	}

}
