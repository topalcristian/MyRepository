public class MineSweeper {

	public static void main(String[] args) {
		
		final int HEIGHT = 10;
		final int WIDTH = 10;
		MineSweeperWindow window = new MineSweeperWindow(HEIGHT,WIDTH);
		
		int[][] board = makeBoard(HEIGHT,WIDTH);
		boolean[][] open = new boolean[HEIGHT][WIDTH];

		
		computeHints(board);
		
		boolean alive = true;
		while (alive) {
			window.printBoard(board,open);
			int[] move = window.getMove();
			alive = clicked(move[0],move[1],board,open);
		}
		 

		window.printBoard(board,open);
	}
	public static int[][] makeBoard(int height, int width) {

	    int[][] board = new int[height][width];

		
		for(int i=0; i<10; i++) {
			// we want to do the following for ten bombs

			
			int randnumberRow = (int) (Math.random()*10);
			int randnumberCol = (int) (Math.random()*10);
			//randomly picked location in the matrix - one stands for the coloum and one for the row 
			


			while(board[randnumberRow][randnumberCol]==9) {     
				i--;
				continue;	
				//if a location has already a bomb, we continue until a empty location is found		
			}
			


     			board[randnumberRow][randnumberCol]=9;
     			//we put both random numbers in the index and say that on that location a 9 is 
		}
	    
	    
	    return (board); 
	}
	
	 
	
	public static void computeHints(int[][] array) {
		// computing hints inside the board - array=board	
	    
	    for (int x=0; x<array.length; x++){
	    	//for loop for row
	    	for (int y=0; y<array[0].length; y++){
				 // for loop for cols
				 int counter=0;
				 // starting bombcounter at 0
				if(array[x][y] != 9){
					// if  no bomb
					for (int p = x-1; p<=x+1; p++){
						// checking every side
						for(int q = y-1; q<=y+1; q++){
							
							if(p>=0 && q>=0 && p<=9 && q<=9){
								
								if(array[p][q]==9){counter+=1;}
							    // if bomb
							}
						
						}
					
					}
					array[x][y] = counter;
				
				}
			
			}
		
		}
	}


	public static boolean clicked(int x, int y, int[][] board, boolean[][] open) {
	   	    // method that opens boxes
	   	    if(board[x][y] ==9){ 
	   	    	// if bomb
	   	    	for(int rowboard = 0; rowboard<board.length; rowboard++)
	   	 		   
	   	 		   for(int columnboard = 0 ; columnboard < board[0].length; columnboard++)
	   	 				
	   	 				{open [rowboard][columnboard]=true;}
	   		}

	   		else if(board[x][y] !=9){open[x][y]=true ;}
	   				//if no bomb
	   				 
                    if(board[x][y]==0 && x<9)  {open[x+1][y]=true;}
	   			 
					if(board[x][y]==0 && x>0)  {open[x-1][y]=true;}
	   			 	
	   			 	if(board[x][y]==0 && y>0)  {open[x][y-1]=true;}
	   			 		
					if(board[x][y]==0 && y<9)  {open[x][y+1]=true;}
	   				
	   				return true;
	}


}