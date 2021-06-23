package game.pieces;

import java.util.ArrayList;

import game.CPanel;
import game.Tile;

public class Knight extends Piece
{

	public Knight(boolean isWhite, String path)
	{
		super(isWhite, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tile> legalMoves(int currRow, int currCol, Tile[][] grid)
	{
		ArrayList<Tile> moves = new ArrayList<Tile>(); 
		if(currRow>=2)// top l
		{
			if(currCol>0)  //left
			{
				if(grid[currRow-2][currCol-1].currentPiece == null)
				{
					moves.add(grid[currRow-2][currCol-1]); 
				}else if(grid[currRow-2][currCol-1].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow-2][currCol-1]); 
				}
				
			} 
			if(currCol<CPanel.cols-1)//rigbht
			{
				if(grid[currRow-2][currCol+1].currentPiece == null)
				{
					moves.add(grid[currRow-2][currCol+1]); 
				}else if(grid[currRow-2][currCol+1].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow-2][currCol+1]); 
				}
				
			}
			
		}
		if(currRow>=1)// top mid l
		{
			if(currCol>1)  //left
			{
				if(grid[currRow-1][currCol-2].currentPiece == null)
				{
					moves.add(grid[currRow-1][currCol-2]); 
				}else if(grid[currRow-1][currCol-2].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow-1][currCol-2]); 
				}
				
			} 
			if(currCol<CPanel.cols-2)//rigbht
			{
				if(grid[currRow-1][currCol+2].currentPiece == null)
				{
					moves.add(grid[currRow-1][currCol+2]); 
				}else if(grid[currRow-1][currCol+2].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow-1][currCol+2]); 
				}
				
			}
			
		}
		
		
		if(currRow<CPanel.rows-1)// top mid l
		{
			if(currCol>1)  //left
			{
				if(grid[currRow+1][currCol-2].currentPiece == null)
				{
					moves.add(grid[currRow+1][currCol-2]); 
				}else if(grid[currRow+1][currCol-2].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow+1][currCol-2]); 
				}
				
			} 
			if(currCol<CPanel.cols-2)//rigbht
			{
				if(grid[currRow+1][currCol+2].currentPiece == null)
				{
					moves.add(grid[currRow+1][currCol+2]); 
				}else if(grid[currRow+1][currCol+2].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow+1][currCol+2]); 
				}
				
			}
			
		}
		
		
		if(currRow<CPanel.rows-2)// bot l
		{
			if(currCol>0)  //left
			{
				if(grid[currRow+2][currCol-1].currentPiece == null)
				{
					moves.add(grid[currRow+2][currCol-1]); 
				}else if(grid[currRow+2][currCol-1].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow+2][currCol-1]); 
				}
				
			} 
			if(currCol<CPanel.cols-1)//rigbht
			{
				if(grid[currRow+2][currCol+1].currentPiece == null)
				{
					moves.add(grid[currRow+2][currCol+1]); 
				}else if(grid[currRow+2][currCol+1].currentPiece.isWhite!= this.isWhite)
				{
					moves.add(grid[currRow+2][currCol+1]); 
				}
				
			}
			
		}
		return moves;
	}

}
