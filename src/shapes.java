
public class shapes extends control {

	private static final long serialVersionUID = 1L;
	//shapes
	public void glider(){
		//tiles as position x and y to be made alive
		tiles[3][2]=1;
		tiles[4][3]=1;
		tiles[4][4]=1;
		tiles[3][4]=1;
		tiles[2][4]=1;
	}
	public void exploder(){
		//tiles as position x and y to be made alive
		//tiles[(cells/2)+0][]
		tiles[7][7] = 1;
		tiles[7][8] = 1;
		tiles[7][9] = 1;
		tiles[7][10] = 1;
		tiles[7][11] = 1;

		tiles[9][7] = 1;
		tiles[9][11] = 1;

		tiles[11][7] = 1;
		tiles[11][8] = 1;
		tiles[11][9] = 1;
		tiles[11][10] = 1;
		tiles[11][11] = 1;

	}
	public void random(){

		for (int x = 0; x < Cells; x++) {
			for (int y = 0; y < Cells; y++) {
				//using math.random build in function i create a random value for rand variable between 0 and 1 
				long rand = Math.round(Math.random()*1);
				///using an if else statement i check if the value of rand is mod == 0 , if it is then that cell current element becomes alive else it becomes dead
				if(rand % 2 == 0){
					tiles[x][y] = 1;
				}
				else if(rand % 2 != 0){
					tiles[x][y] = 0;
				}	
			}
		}
	}
}
