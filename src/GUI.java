import java.awt.BorderLayout;
import javax.swing.JFrame;
//because this class inherits runnable im setting this to run initially 
public class GUI implements Runnable {
	
		
		public void run(){
			
			//creating a control object from class control
			control control = new control();
			
			///creating a new JFrame object 
			JFrame frame = new JFrame("Conway's Game of Life");
			//frame size
			frame.setSize(600, 650);
			frame.setPreferredSize(frame.getSize());
			//sets frame to centre of the window
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//can't resize the window 
			frame.setResizable(false);
			//change to border layout if things do not work.
			frame.setLayout(new BorderLayout());
			//the frame needs to be set opaque to true 
			control.setOpaque(true);
			
			frame.add(control, BorderLayout.CENTER);
			//this is needed for the frame to show
			frame.setVisible(true);
			
		
		}		
		
}

