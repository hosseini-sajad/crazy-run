package crazyrun;

import java.awt.Dimension;
import java.io.FileInputStream;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;
import sun.audio.*;
import java.io.*;


public class GameFrame extends JFrame {
	
	private Game game;
	
	public GameFrame() {
		
		game = new Game();
		game.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		add(game);
		
		pack();
		
		setTitle("Crazy Run");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                
	}

	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new GameFrame();
                                music();
			}
		});
	}
        
         public static void music() 
        {       
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;

            ContinuousAudioDataStream loop = null;

            try
            {
                InputStream test = new FileInputStream("C:\\Users\\Amir\\Downloads\\Music\\music2.wav");
                BGM = new AudioStream(test);
                AudioPlayer.player.start(BGM);
                //MD = BGM.getData();
                //loop = new ContinuousAudioDataStream(MD);
            }
            catch(FileNotFoundException e){
                System.out.print(e.toString());
            }
            catch(IOException error)
            {
                System.out.print(error.toString());
            }
            MGP.start(loop);
        }
        
}
