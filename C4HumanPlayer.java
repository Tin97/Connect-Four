import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	
	C4HumanPlayer(char piece)
	{
		this.piece = piece;
	}

	@Override
	public void makeMove(Connect4Grid2DArray grid) {
		
		Scanner input = new Scanner(System.in);
		
		boolean isFinished = false;
		
		while ( !isFinished )
		{
			int column = input.nextInt();
			
			if ( grid.isValidColumn(column) && !grid.isColumnFull(column))
			{
				grid.dropPiece(this, column);
				isFinished = true;
			}
			
			else if (grid.isColumnFull(column))
			{
				System.out.println("Column is full. Choose another column.");
			}
			
			else
			{
				System.out.println("Invalid column");
			}
		}
	}

}
