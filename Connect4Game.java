import java.util.Scanner;

public class Connect4Game {

	public static void main(String[] args) {
		
		boolean isFinished = false;
		int player;
		ConnectPlayer player1, player2;
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type in 1 if the player1 is going to be a user"
				+ "\n or type in 2 if the player1 is going to be an AI;");
		
		player = input.nextInt();
		
		if ( player == 1 )
		{
			player1 = new C4HumanPlayer('O');
		}
		
		else 
		{
			player1 = new C4RandomAIPlayer('O');
		}
		
		System.out.println("Type in 1 if the player2 is going to be a user"
				+ "\n or type in 2 if the player2 is going to be an AI;");
		
		player = input.nextInt();
		
		if ( player == 1 )
		{
			player2 = new C4HumanPlayer('X');
		}
		
		else 
		{
			player2 = new C4RandomAIPlayer('X');
		}
		
		boolean isPlayer1 = true;
		
		grid.emptyGrid();
		
		while ( !isFinished )
		{
			if ( !grid.isGridFull())
			{
				if (isPlayer1)
				{
					if ( player1 instanceof C4HumanPlayer )
					{
						System.out.println("Enter a column where player1 should drop 'O':");
					}
					player1.makeMove(grid);
					isPlayer1 = false;
				}
				
				else
				{
					if ( player2 instanceof C4HumanPlayer )
					{
						System.out.println("Enter a column where player2 should drop 'X':");
					}
					player2.makeMove(grid);
					isPlayer1 = true;
				}
				
				grid.printGrid();
				
				if ( grid.didLastPieceConnect4() )
				{
					if ( isPlayer1 )
					{
						System.out.println("Player2 won!");
					}
					
					else
					{
						System.out.println("Player1 won!");
					}
					
					isFinished = true;
				}
			}
			
			else
			{
				System.out.println("There was no winner.");
				isFinished = true;
			}
		}
		

	}

}
