import java.util.Scanner;

public class PeterBarnes_TicTacToe {
	
	// Method to print out the table initially and after each move
	public void printTable(String[][] table){
		
		for(int i = 0; i < 3; i++){
			
			for(int j = 0; j < 3; j++){
				
				System.out.print(table[i][j] + " ");
				
			}
			System.out.println();	
		}	
	}
	
	// Method that places either an X or and O at whatever coordinate the player chooses
	public void place(String[][] table, int row, int col, String player){
		
		row -= 1;
		col -= 1;
		if(table[row][col].equals("X") || table[row][col].equals("O")){
			
			System.out.println("That space is already occupied");
			
		} else {
			table[row][col] = player;
		}
		printTable(table);	
	}
	
	// This method switches the player after each move
	public String switchPlayer(String player){
		if(player.equals("X")){
			player = "O";
		} else if(player.equals("O")){
			player = "X";
		}
		return player;
	}
	
	/*
	 * This method is the longest
	 * It checks whether the board is full
	 * Or if a player has won horizontally
	 * Or if a player has won vertically
	 * Or if a player has won diagonally
	 * It then sets a boolean called done equal to true
	 * To stop the loop*/
	public boolean done(boolean done, String[][] table, String player){
		int counter = 0;
		done = false;
		for(int i = 0; i < 3; i++){
			
			for(int j = 0; j < 3; j++){
				
				if(table[i][j].equals("X") || table[i][j].equals("O")){
					counter++;
				}
			}
			
			if((table[i][0].equals("X") && table[i][1].equals("X") && table[i][2].equals("X")) || 
			   (table[i][0].equals("O") && table[i][1].equals("O") && table[i][2].equals("O"))){
						
				System.out.println("The winner is " + player);
				done = true;
				
			} else if((table[0][i].equals("X") && table[1][i].equals("X") && table[2][i].equals("X")) || 
					  (table[0][i].equals("O") && table[1][i].equals("O") && table[2][i].equals("O"))){
				
				System.out.println("The winner is " + player);
				done = true;
				
			}  
			
			if((table[0][0].equals("X") && table[1][1].equals("X") && table[2][2].equals("X")) || 
			   (table[0][0].equals("O") && table[1][1].equals("O") && table[2][2].equals("O")) || 
			   (table[0][2].equals("X") && table[1][1].equals("X") && table[2][0].equals("X")) || 
			   (table[0][2].equals("O") && table[1][1].equals("O") && table[2][0].equals("O"))){
				
				System.out.println("The winner is " + player);
				done = true;
				break;
				
			}	
		}
		if(counter == 9){
			
			System.out.println("The board is full!  Cat!");
			done = true;	
		}
			
		return done;
	}
	
	public static void main(String[] args) {
		boolean done = false;
		int option = 1;
		PeterBarnes_TicTacToe game = new PeterBarnes_TicTacToe();
		Scanner sc = new Scanner(System.in);
		// Creating the 2d array for the board
		String[][] table = new String[3][3];
		// Filling the arrays with values
		for(int i = 0; i < 3; i++){
			
			for(int j = 0; j < 3; j++){
				
				table[i][j] = Integer.toString(j+1);
				
			}	
		}
		
		// This loop allows the user to play multiple times 
		while(option == 1){
			
			System.out.println("Welcome to tic-tac-toe! \n");
			game.printTable(table);
			String player = "X";
			// This is the game running
			do {
				
				System.out.println("It is currently " + player + "'s turn");
				System.out.println("Enter the row (1-3)");
				int row = sc.nextInt();
				System.out.println("Enter the column (1-3)");
				int col = sc.nextInt();
				game.place(table, row, col, player);
				done = game.done(done, table, player);
				player = game.switchPlayer(player);
				
			}while(done == false);
			// Prompts the user if they want to go again
			System.out.println("Would you like to go again?");
			System.out.println("[1] YES");
			System.out.println("[2] NO");
			option = sc.nextInt();
			
		}
	}
}

