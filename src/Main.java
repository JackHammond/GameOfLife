public class Main {
	
		
		public static void main(String[] args) {
			//this is my main class that creates an object of the GUI class
		GUI gui = new GUI();
		//invoke later allows  calls the do runnable object gui which is an instance of GUI.
		javax.swing.SwingUtilities.invokeLater(gui);
		}
}

