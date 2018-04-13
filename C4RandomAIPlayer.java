import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{
	
	C4RandomAIPlayer(char piece)
	{
		this.piece = piece;
	}

	@Override
	public void makeMove(Connect4Grid2DArray grid) {
		
		Random generator = new Random();
		
		boolean isFinished = false;
		
		while ( !isFinished )
		{
			int column = generator.nextInt(7);
			column++;
			
			if ( grid.isValidColumn(column) && !grid.isColumnFull(column) )
			{
				grid.dropPiece(this, column);
				isFinished = true;
			}
		}
	}


}
