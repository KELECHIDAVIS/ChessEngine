package game.pieces;

import java.util.ArrayList;

import game.CPanel;
import game.Tile;

public class King extends Piece
{

	public King(boolean isWhite, String path)
	{
		super(isWhite, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tile> legalMoves(int currRow, int currCol, Tile[][] grid)
	{
		ArrayList<Tile> moves = new ArrayList<Tile>(); 
		if(currRow >0)
		{
			if(grid[currRow-1][currCol].currentPiece==null||grid[currRow-1][currCol].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow-1][currCol]); 
			}
		}
		if(currRow >0&&currCol>0) //top left 
		{
			if(grid[currRow-1][currCol-1].currentPiece==null||grid[currRow-1][currCol-1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow-1][currCol-1]); 
			}
		}
		if(currRow >0&&currCol <CPanel.cols-1) //top right 
		{
			if(grid[currRow-1][currCol+1].currentPiece==null||grid[currRow-1][currCol+1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow-1][currCol+1]); 
			}
		}
		if(currRow <CPanel.rows-1&&currCol>0) //bot left 
		{
			if(grid[currRow+1][currCol-1].currentPiece==null||grid[currRow+1][currCol-1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow+1][currCol-1]); 
			}
		}
		if(currRow <CPanel.rows-1&&currCol <CPanel.cols-1) //bot right 
		{
			if(grid[currRow+1][currCol+1].currentPiece==null||grid[currRow+1][currCol+1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow+1][currCol+1]); 
			}
		}
		if(currRow <CPanel.rows-1)
		{
			if(grid[currRow+1][currCol].currentPiece==null||grid[currRow+1][currCol].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow+1][currCol]); 
			}
		}
		if(currCol>0)
		{
			if(grid[currRow][currCol-1].currentPiece==null||grid[currRow][currCol-1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow][currCol-1]); 
			}
		}
		if(currCol <CPanel.cols-1)
		{
			if(grid[currRow][currCol+1].currentPiece==null||grid[currRow][currCol+1].currentPiece.isWhite!=this.isWhite) // if the tile is empty
			{
				moves.add(grid[currRow][currCol+1]); 
			}
		}
		return moves ;
	}

}
