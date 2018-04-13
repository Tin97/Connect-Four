
interface Connect4Grid {
	
	public int ROWS = 6;
	public int COLUMNS = 7;
	
	public void emptyGrid();
	public void printGrid();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();   

}
