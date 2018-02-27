import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class control extends JPanel implements ActionListener{

	/**
	 * @author Jack Hammond
	 * 26/03/17
	 * Brunel University
	 */

	//this id is generated automatically when extending JPanel
	private static final long serialVersionUID = 1L;
	//static keyword allows the variable or method to be called without creating an an object instance for said variable or method
	private JButton start,stop,resetbutton,random,next,glider,exploder;
	//Label for the iterations of the GRID
	private JLabel cellGenerationValue,cellGenerationCaption;
	//Variable for the grid iterations
	private Timer iterations;

	//object instances as global they can be used thorughout the class
	private static shapes shape = new shapes();
	private static count count = new count();
	
	//Global variables
	//this is the number of generations default value
	private static long generationCount = 0;
	//this is a final variable that defines the grid size 
	protected static final int Cells = 20;

	//2 dimensional int array that stores the grid size throughout the program. 
	protected static final int[][] tiles = new int [Cells][Cells]; 

	public control(){

		//constructor for the three buttons

		//Glider shape
		glider = new JButton("Glider Grid");
		//Centre the text vertically
		glider.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text vertically
		glider.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'glider' when clicked
		glider.setActionCommand("glider");

		//Glider gun shape
		exploder = new JButton("Exploder Grid");
		//Centre the text vertically
		exploder.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text vertically
		exploder.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'exploder' when clicked
		exploder.setActionCommand("exploder");

		//Random button
		random = new JButton("Random Grid");
		//Centre the text vertically
		random.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text vertically
		random.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'random' when clicked
		random.setActionCommand("random");

		//start
		start = new JButton("Start");
		//Centre the text vertically
		start.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text horizontally
		start.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'Start' when clicked
		start.setActionCommand("start");

		start.setEnabled(false);

		//Caption for second button(the user will see this) // new JButton object
		stop = new JButton("Stop");
		//Centre the text vertically
		stop.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text horizontally
		stop.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'stop' when clicked
		stop.setActionCommand("stop");
		//setting the initial of the stop button to disabled(nothing to stop)
		stop.setEnabled(false);

		//Caption for second button(the user will see this) // new JButton object
		next = new JButton("Next Generation");
		//Centre the text vertically
		next.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text horizontally
		next.setHorizontalTextPosition(AbstractButton.CENTER);
		//Create the event/action 'next' when clicked
		next.setActionCommand("next");
		//setting the initial of the stop button to disabled(nothing to stop)
		next.setEnabled(false);

		//caption for third button(the user will see this) // new JButton object
		resetbutton = new JButton("Reset Grid");
		//Centre the text horizontally
		resetbutton.setVerticalTextPosition(AbstractButton.CENTER);
		//Centre the text horizontally
		resetbutton.setHorizontalTextPosition(AbstractButton.CENTER);
		//create the event/action when clicked
		resetbutton.setActionCommand("reset");
		//setting the initial of the reset button to disabled(nothing to reset)
		resetbutton.setEnabled(false);

		//Create the event/action 'iterations' every half second
		iterations = new Timer(500, this);
		//each second this action command is set
		iterations.setActionCommand("iterations");
		//start automatically when called
		iterations.setInitialDelay(0);
		//this is used when the size of the grid is < or = to 19 (because my preset shapes are too big to look nice within the frame.)
		if(Cells <= 19){
			exploder.setEnabled(false);
			exploder.setToolTipText("make the grid size greater than 20 to use");
		}

		//this adds a JSeperator to the frame 
		JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
		//this sets the size of the line as 500 pixels long and 10 wide
		x.setPreferredSize(new Dimension(500,10));


		//Listen for actions from all buttons
		//The current instance of 'this' class will process the actions for the buttons 
		//'this' keyword works as a reference to the current object whose method or constructor is being invoked (this will refer to each button object individually)
		start.addActionListener(this);
		stop.addActionListener(this);
		resetbutton.addActionListener(this);
		random.addActionListener(this);
		next.addActionListener(this);
		glider.addActionListener(this);
		exploder.addActionListener(this);


		//This is the text that is displayed when we hover over the buttons
		start.setToolTipText("Click this button to start the simulation ");
		stop.setToolTipText("Click this button to stop the simulation");
		resetbutton.setToolTipText("Click this button to clear the board");


		//Create the labels
		//surrounding the generation value with a border and setting the font to serif with bold text and 20 size 
		cellGenerationCaption = new JLabel("Current Generation:");
		cellGenerationCaption.setFont(new Font("serif", Font.BOLD, 20));
		cellGenerationValue = new JLabel("0");
		cellGenerationValue.setFont(new Font("serif", Font.BOLD, 20));
		cellGenerationValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		//Add the Components to the Form
		//If they are not added then they will not appear!
		add(start);
		add(stop);
		add(resetbutton);
		add(next);
		add(cellGenerationCaption);
		add(cellGenerationValue);
		add(x);
		add(glider);
		add(exploder);
		add(random);
		
	}

	public void actionPerformed(ActionEvent event) {
		//this switch statements is the equivalent of using if statements however switches requires less conditional statements 
		switch(event.getActionCommand()){
		case "glider":{

			System.out.println("Glider used");
			resetbutton.setEnabled(true);
			next.setEnabled(true);
			glider.setEnabled(true);
			start.setEnabled(true);
			random.setEnabled(true);
			//calling the glider method for the button then repaint the frame.
			shape.glider();
			repaint();
			break;
		}
		case "exploder":{
			
			System.out.println("exploder used");
			//setting the following buttons visible when this button is pressed
			resetbutton.setEnabled(true);
			next.setEnabled(true);
			exploder.setEnabled(true);
			start.setEnabled(true);
			random.setEnabled(true);
			//calling the exploder method for the button then repaint the frame
			shape.exploder();
			repaint();
			break;
		}
		case "next":{

			System.out.println("next");
			//set next button the visible
			next.setEnabled(true);
			//call the logic method then repaint the frame
			logic();
			repaint();
			//this acts as the generation count, each iteration will plus 1 to generationCount
			generationCount++;
			//set the text within cellGenerationValue to generationCount by converting the long to a string
			cellGenerationValue.setText(Long.toString(generationCount));
			break;
		}
		case "random":{

			System.out.println("random");
			//set buttons visible true or false 
			stop.setEnabled(false);
			resetbutton.setEnabled(true);
			start.setEnabled(true);
			next.setEnabled(true);
			random.setEnabled(true);
			//call random method and repaint
			shape.random();
			repaint();
			break;
		}
		case"stop":{

			System.out.println("Stop pressed");
			//set buttons visible true or false
			stop.setEnabled(false);
			resetbutton.setEnabled(true);
			start.setEnabled(true);
			next.setEnabled(true);
			exploder.setEnabled(false);
			//stop the iteration timer which halts the grid from changing as iterations holds the logic method
			iterations.stop();
			break;
		}
		case "iterations":{
			//this is the iteration method that will run every time the timer has met a pre-defined time set in the constructor
			//call logic method and repaint the frame
			logic();
			repaint();
			//iterate generationCount varaible and convert to string within the set text method 
			generationCount++;
			cellGenerationValue.setText(Long.toString(generationCount));
			break;
		}
		case"start":{
			System.out.println("Simulation Started");
			//change buttons state for start button
			start.setEnabled(false);
			stop.setEnabled(true);
			resetbutton.setEnabled(false);
			random.setEnabled(false);
			glider.setEnabled(false);
			exploder.setEnabled(false);
			next.setEnabled(false);
			//start iterations timer
			iterations.start();
			break;
		}
		case "reset":{

			System.out.println("Board Reset");
			//change button state for the reset button
			next.setEnabled(false);
			random.setEnabled(true);
			glider.setEnabled(true);
			stop.setEnabled(false);
			start.setEnabled(false);
			resetbutton.setEnabled(false);
			//this checks if the value of cellsis below 20 and sets exploder visible based on this
			if(Cells <= 19){
				exploder.setEnabled(false);
				exploder.setToolTipText("make the grid size greater than 20 to use");
			}
			else{
				exploder.setEnabled(true);
			}
			//call reset method and repaint frame
			reset();
			repaint();
			//reset iteration value to 0 for reset and set as label value 
			generationCount = 0;
			cellGenerationValue.setText(Long.toString(generationCount));
			//stop iterations timer
			iterations.stop();
			break;
		}
		}
	}

	private void logic() {
		//creating new array called copy
		int[][] copy = new int[Cells][Cells];

		//setting copy[x][y] array to the values of tiles[x][y] array so they can be modified without affecting the grid.
		for (int x = 0; x < Cells; x++) {
			for (int y = 0; y < Cells; y++) {

				copy[x][y] = tiles[x][y]; //give the values of tiles to copy
			}
		}

		for (int x = 0; x < Cells; x++) {
			for (int y = 0; y < Cells; y++) {

				//this is passing in x and y values to countNeighbours(x,y) and setting the returned value to finalNeighbours
				//calling the countNeighbours method from count class;
				int finalNeighbours = count.countNeighbours(x, y);

				//this counts the neighbours
				//if the element in array x y is alive and neighbours == to 2 or 3 then it survives else it dies 
				if(tiles[x][y] > 0){
					if (finalNeighbours == 2 || finalNeighbours == 3){ 

						copy[x][y] = copy[x][y]+1; // alive

					}
					else {
						copy[x][y] = 0; // dead

					}

				}
				//if the element in array x y is dead and neighbours == to 3 then it becomes alive else it dies 
				else if (tiles[x][y] < 1){
					if(finalNeighbours == 3){

						copy[x][y]=1;
					}
					else{
						copy[x][y] = copy[x][y]-1;
					}
				}
			}
		}
		//copying the modified value of copy[x][y] to tiles[x][y]
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {

				tiles[x][y] = copy[x][y];

			}
		}
	}

	//this nested loop just iterates thorugh each element within the array and sets the value of each element to 0(dead)
	private void reset(){
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = 0;
			}
		}
	}
	//setting the colour values for an alive cell
	private Color yellow(int i, int j){

		int colourChange = 150-(tiles[i][j]*50);
		if(colourChange<0){
			colourChange=0;
		}
		return new Color(255,255,colourChange);

	}
	//setting the colour values for an alive cell
	private Color black(int i, int j){

		int colourChange = 160-(tiles[i][j]*-32);
		if(colourChange<32){
			colourChange=32;
		}
		return new Color(colourChange,colourChange,colourChange);

	}
	public void paint(Graphics g){

		super.paint(g);
		//width1 is a variable that acts as the width from the left of the frame for the grid
		int width1 = 50;
		//height1 is a variable that acts as the height from the top of the frame for the grid
		int height1;
		//this sets the size of the grid to 500 and divides this into the grid size and -2 the distance between each row/column
		int size = (500/Cells)-1;

		for(int i = 0; i < Cells; i++){
			height1 = 90; //within the first for loop, change the value of height to the value wanted from the top of the frame
			for(int j = 0; j <Cells; j++){
				//if the current element in the array is greater than 0 set it to newyellow
				if(tiles[i][j] > 0){
					//using the Color class allows us to use the rgb colour chart for the cell colours
					Color newyellow =yellow(i,j); // create variable to hold the returned value of the yellow method 
					g.setColor(newyellow);
				}
				else{
					//using the Color class allows us to use the rgb colour chart for the cell colours
					Color newblack = black(i,j);
					g.setColor(newblack); // create variable to hold the returned value of the yellow method 

				}
				//this wil pait the grid into the frame, the width and height will increase by 1 pixel each time its printed allowing for a gap between cells
				g.fillRect(width1, height1, size, size); //size variable  is the size of the grid wanted then divided by the number of rows and columns wanted
				height1 = height1+size+1; //changing the size of height by adding the size variable and 1 each time it iterates through the loop, this will make the grid visually
			}
			width1 = width1+size+1;  //changing the size of height by adding the size variable and 1 each time it iterates through the loop, this will make the grid visually
		}
	}
}