package game.pieces;

import java.util.ArrayList;

import game.CPanel;
import game.Tile;

public class Rook extends Piece 
{

	public Rook(boolean isWhite, String path)
	{
		super(isWhite, path);
		
	}

	@Override
	public ArrayList<Tile> legalMoves(int currRow, int currCol, Tile[][] grid)
	{ // if ever stuck remember this function subtracts all the directions
		ArrayList<Tile> moves = new ArrayList<Tile>();
		int up = 1, down=-1,right=-1,left=1;  // it is going to be a while loop that stop adding when it hits a wall / another piece
		while(currRow-up>=0) // while its not hitting the vertical wall 
		{
			if(grid[currRow-up][currCol].currentPiece==null) // this is if there is nothing in the row
			{
				moves.add(grid[currRow-up][currCol]); 
			}
			else if(grid[currRow-up][currCol].currentPiece.isWhite!= this.isWhite) // this is if there is nothing in the row
			{
				moves.add(grid[currRow-up][currCol]); 
				break; 
			}else if(grid[currRow-up][currCol].currentPiece.isWhite== this.isWhite) // this is if there is nothing in the row
			{
				
				break; 
			}
			
			up++; // the up iterator goes up so  that we can check the above tile
		}
		//down
		while(currRow-down<CPanel.rows) // while its not hitting the vertical wall 
		{
			if(grid[currRow-down][currCol].currentPiece==null) // this is if there is nothing in the row
			{
				moves.add(grid[currRow-down][currCol]); 
			}
			else if(grid[currRow-down][currCol].currentPiece.isWhite!= this.isWhite) // this is if there is nothing in the row
			{
				moves.add(grid[currRow-down][currCol]); 
				break; 
			}else if(grid[currRow-down][currCol].currentPiece.isWhite== this.isWhite) // this is if there is nothing in the row
			{
				
				break; 
			}
			
			down--; // the up iterator goes up so  that we can check the above tile // remember that it is negative
		}
		while(currCol-left>=0) // while its not hitting the vertical wall 
		{
			if(grid[currRow][currCol-left].currentPiece==null) // this is if there is nothing in the row
			{
				moves.add(grid[currRow][currCol-left]); 
			}
			else if(grid[currRow][currCol-left].currentPiece.isWhite!= this.isWhite) // this is if there is nothing in the row
			{
				moves.add(grid[currRow][currCol-left]); 
				break; 
			}else if(grid[currRow][currCol-left].currentPiece.isWhite== this.isWhite) // this is if there is nothing in the row
			{
				
				break; 
			}
			
			left++; // the up iterator goes up so  that we can check the above tile // remember that it is negative
		}
		//right
		while(currCol-right<CPanel.cols) // while its not hitting the vertical wall 
		{
			if(grid[currRow][currCol-right].currentPiece==null) // this is if there is nothing in the row
			{
				moves.add(grid[currRow][currCol-right]); 
			}
			else if(grid[currRow][currCol-right].currentPiece.isWhite!= this.isWhite) // this is if there is nothing in the row
			{
				moves.add(grid[currRow][currCol-right]); 
				break; 
			}else if(grid[currRow][currCol-right].currentPiece.isWhite== this.isWhite) // this is if there is nothing in the row
			{
				
				break; 
			}
			
			right--; // the up iterator goes up so  that we can check the above tile // remember that it is negative
		}
	
		return moves;
	}

}
