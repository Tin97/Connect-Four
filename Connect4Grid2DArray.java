
public class Connect4Grid2DArray implements Connect4Grid{
	
	char[][] grid;
	
	Connect4Grid2DArray()
	{
		grid = new char[ROWS][COLUMNS];
	}
	
	public void emptyGrid() {
		for ( int i = 0 ; i < ROWS ; i++ )
		{
			for ( int j = 0 ; j < COLUMNS ; j++ )
			{
				grid[i][j] = ' ';
			}
		}
	}

	@Override
	public boolean isValidColumn(int column) {
		
		if ( column > 0 || column <= COLUMNS )
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isColumnFull(int column) {
		
		if ( grid[0][column - 1] != ' ' )
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		
		for ( int i = ROWS - 1 ; i > -1 ; i-- )
		{
			if ( grid[i][column - 1] == ' ' )
			{
				grid[i][column - 1] = player.piece;
				break;
			}
		}
	}

	@Override
	public boolean didLastPieceConnect4() {
		
		for ( int i = 0 ; i < ROWS ; i++ )
		{
			for ( int j = 0 ; j < COLUMNS ; j++ )
			{
				if ( grid[i][j] != ' ')
				{
					char piece = grid[i][j];
					
					int counter1 = 0;
					int counter2 = 0;
					int counter3 = 0;
					int counter4 = 0;
					
					for ( int k = 0 ; k < 4 ; k++ )
					{
						if ( j+k < 7 && grid[i][j+k] == piece )
						{
							counter1++;
						}
						
						if ( i+k < 6 && grid[i+k][j] == piece )
						{
							counter2++;
						}
						
						if ( j+k < 7 && i+k < 6 && grid[i+k][j+k] == piece )
						{
							counter3++;
						}
						
						if ( j-k > 0 && i+k < 6 && grid[i+k][j-k] == piece )
						{
							counter4++;
						}
					}
					
					if ( counter1 == 4 || counter2 == 4 || counter3 == 4 || counter4 == 4 )
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean isGridFull() {
		for ( int j = 0 ; j < COLUMNS ; j++ )
		{
			if ( grid[0][j] == ' ' )
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void printGrid() {
		
		for ( int i = 0 ; i < 8 ; i++)
		{
			for ( int j = 0 ; j < 15 ; j++ )
			{
				if ( i < 6 && j % 2 == 1 )
				{
					System.out.print(grid[i][j/2]);
				}
				
				else if ( i < 6 && j % 2 == 0 )
				{
					System.out.print("|");
				}
				
				else if ( i == 6 )
				{
					System.out.print("-");
				}
				
				else if ( i == 7 && j % 2 == 1)
				{
					System.out.print(j/2 + 1);
				}
				
				else
				{
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}

}
