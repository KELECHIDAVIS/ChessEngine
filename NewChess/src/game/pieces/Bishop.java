package game.pieces;

import java.util.ArrayList;

import game.CPanel;
import game.Tile;

public class Bishop extends Piece 
{

	public Bishop(boolean isWhite, String path)
	{
		super(isWhite, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tile> legalMoves(int currRow, int currCol, Tile[][] grid)
	{
		ArrayList<Tile> moves = new ArrayList<Tile>(); 
		int vert =1 , horr=1; 
		
		while(currRow-vert>=0&&currCol+horr<CPanel.cols)// up and right
		{
			if(grid[currRow-vert][currCol+horr].currentPiece==null)
			{
				moves.add(grid[currRow-vert][currCol+horr]);
			}
			else if(grid[currRow-vert][currCol+horr].currentPiece.isWhite!=this.isWhite)
			{
				moves.add(grid[currRow-vert][currCol+horr]); 
				break; 
			}
			else if(grid[currRow-vert][currCol+horr].currentPiece.isWhite==this.isWhite)
			{
				break; 
			}
			vert++; 
			horr++; 
		}
	 vert =1 ;horr=1; // resets the value 
		while(currRow+vert<CPanel.rows&&currCol+horr<CPanel.cols)//down and right
		{
			if(grid[currRow+vert][currCol+horr].currentPiece==null)
			{
				moves.add(grid[currRow+vert][currCol+horr]);
			}
			else if(grid[currRow+vert][currCol+horr].currentPiece.isWhite!=this.isWhite)
			{
				moves.add(grid[currRow+vert][currCol+horr]); 
				break; 
			}
			else if(grid[currRow+vert][currCol+horr].currentPiece.isWhite==this.isWhite)
			{
				break; 
			}
			vert++; 
			horr++; 
		}
		 vert =1 ;horr=1; // resets the value 
			while(currRow+vert<CPanel.rows&&currCol-horr>=0)//down and right
			{
				if(grid[currRow+vert][currCol-horr].currentPiece==null)
				{
					moves.add(grid[currRow+vert][currCol-horr]);
				}
				else if(grid[currRow+vert][currCol-horr].currentPiece.isWhite!=this.isWhite)
				{
					moves.add(grid[currRow+vert][currCol-horr]); 
					break; 
				}
				else if(grid[currRow+vert][currCol-horr].currentPiece.isWhite==this.isWhite)
				{
					break; 
				}
				vert++; 
				horr++; 
			}
			vert =1 ;horr=1; // resets the value 
			while(currRow-vert>=0&&currCol-horr>=0)//down and right
			{
				if(grid[currRow-vert][currCol-horr].currentPiece==null)
				{
					moves.add(grid[currRow-vert][currCol-horr]);
				}
				else if(grid[currRow-vert][currCol-horr].currentPiece.isWhite!=this.isWhite)
				{
					moves.add(grid[currRow-vert][currCol-horr]); 
					break; 
					
				}
				else if(grid[currRow-vert][currCol-horr].currentPiece.isWhite==this.isWhite)
				{
					break; 
				}
				vert++; 
				horr++; 
			}
		
		
		return moves;
	}

}
