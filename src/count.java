//this class is counting the neighbours from the logic method within the control class and returns an integer containing the neighbour count for each element within tiles array
public class count extends control {

	private static final long serialVersionUID = 1L;
	//these two methods allow the grid to wrap around (if x is greater than 0 set x to 0 to be the other side of the grid)
	private int XValue(int x){
		//if the current location of x exceeds or is equal to the total set amount of cells within the grid, set x to 0(the opposite side of the grid)
		if(x >= Cells){
			x = 0;
		}
		//if x is less than 0 set y value to the Cells -1 which will make it at the opposite end of the grid visually
		if(x < 0){
			x = Cells -1;
		}
		return x;
	}
	private int YValue(int y){
		if(y >= Cells){
			y = 0;
		}

		if(y < 0){
			//if y is less than 0 set y value to the Cells -1 which will make it at the opposite end of the grid visually
			y = Cells -1;
		}
		return y;
	}

	//set x and y to specified value to target that specified location.
	//BOTTOM
	private int bottomMiddle(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		y = y+1;
		//set the current value of y to the value that is returned from the YValue method hen called
		y = YValue(y);
		if (tiles[x][y]> 0){ return 1;}//bottom middle
		else return 0;
	}

	private int bottomRight(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		x=x+1;
		y=y+1;
		x = XValue(x);
		y = YValue(y);
		if (tiles[x][y]> 0){return 1;} //bottom right
		else return 0;
	}

	private int bottomLeft(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		x=x-1;
		y=y+1;
		x = XValue(x);
		y = YValue(y);
		if (tiles[x][y]> 0){return 1;} //bottom left
		else return 0;
	}

	//MIDDLE
	private int middleLeft(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		x=x-1;
		x = XValue(x);
		if (tiles[x][y]> 0) {return 1;} //middle left
		else return 0;
	}

	private int middleRight(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		x=x+1;
		x = XValue(x);
		if (tiles[x][y]> 0){ return 1;} //middle right
		else return 0;
	}

	//Top
	private int topRight(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		x=x+1;
		y=y-1;
		x = XValue(x);
		y = YValue(y);
		if (tiles[x][y]> 0){ return 1;} //top right
		else return 0;
	}

	private int topMiddle(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		y=y-1;
		y = YValue(y);
		if (tiles[x][y]> 0){ return 1;} //top middle
		else return 0;
	}

	private int topLeft(int x ,int y){
		//changing the value of x and or y depending on what neighbour method we are in
		y=y-1;
		x=x-1;
		x = XValue(x);
		y = YValue(y);
		if (tiles[x][y]> 0){ return 1;} //top left
		else return 0;
	}
	//this is public as we are calling it in the control class
	public int countNeighbours(int x , int y){
		//these 8 integers store either 0 or 1 depending if the specified location in the array is > than 0 (alive being 1 and dead as 0)
		int topLeft = topLeft(x,y);
		int topRight = topRight(x,y);
		int topMiddle = topMiddle(x,y);
		int bottomRight = bottomRight(x,y);
		int bottomMiddle = bottomMiddle(x,y);
		int bottomLeft = bottomLeft(x,y);
		int middleLeft = middleLeft(x,y);
		int middleRight = middleRight(x,y);

		return topLeft+topRight+topMiddle+bottomRight+bottomMiddle+bottomLeft+middleLeft+middleRight;
	}
}
