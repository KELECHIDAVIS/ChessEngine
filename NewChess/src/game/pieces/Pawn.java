package game.pieces;

import java.util.ArrayList;

import game.CPanel;
import game.Tile;

public class Pawn extends Piece 
{
	
	public Pawn(boolean isWhite, String path)
	{
		super(isWhite, path); 
	}

	@Override
	public ArrayList<Tile> legalMoves(int currRow, int currCol, Tile[][] grid)
	{
		ArrayList<Tile> moves = new ArrayList<Tile>(); 
		if(this.isWhite) // for white pawns 
		{
			if(currRow>0)//for right infront of the pawn
			{
				if(grid[currRow-1][currCol].currentPiece==null) // if the tile is empty
				{
					moves.add(grid[currRow-1][currCol]); 
				}

				//diagoanl
				if(currCol>0)//left diag
				{
					if(grid[currRow-1][currCol-1].currentPiece!=null&&!grid[currRow-1][currCol-1].currentPiece.isWhite) // the space have to have a piece in it and it cannot be white 
					{
						moves.add(grid[currRow-1][currCol-1]);
					}
				}
				if(currCol<CPanel.cols-1)//right diag
				{
					if(grid[currRow-1][currCol+1].currentPiece!=null&&!grid[currRow-1][currCol+1].currentPiece.isWhite) // the space have to have a piece in it and it cannot be white 
					{
						moves.add(grid[currRow-1][currCol+1]);
					}
				}
			}
			if(starting)//for starting pawns 
			{
				if(grid[currRow-2][currCol].currentPiece==null&&grid[currRow-1][currCol].currentPiece==null) // if the tile is empty
				{
					moves.add(grid[currRow-2][currCol]); 
				} 
			}
			
			
		}else// black pawns 
		{
			if(currRow<CPanel.rows-1)//for right infront of the pawn
			{
				if(grid[currRow+1][currCol].currentPiece==null) // if the tile is empty
				{
					moves.add(grid[currRow+1][currCol]); 
				}

				//diagoanl
				if(currRow<CPanel.rows-1&&currCol<CPanel.cols-1)//right diag
				{
					if(grid[currRow+1][currCol+1].currentPiece!=null&&grid[currRow+1][currCol+1].currentPiece.isWhite) // the space have to have a piece in it and it cannot be white 
					{
						moves.add(grid[currRow+1][currCol+1]);
					}
				}
				if(currCol>0)//left diag
				{
					if(grid[currRow+1][currCol-1].currentPiece!=null&&grid[currRow+1][currCol-1].currentPiece.isWhite) // the space have to have a piece in it and it cannot be white 
					{
						moves.add(grid[currRow+1][currCol-1]);
					}
				}
			}
			if(starting)//for starting pawns 
			{
				if(grid[currRow+2][currCol].currentPiece==null&&grid[currRow+1][currCol].currentPiece==null) // if the tile is empty
				{
					moves.add(grid[currRow+2][currCol]); 
				} 
			}
			
			
		}
		
		return moves;
	}
}
