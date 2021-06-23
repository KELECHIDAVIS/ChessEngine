package game.pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Tile;

public abstract class Piece extends ImageIcon
{
	public boolean isWhite; 
	public boolean starting = true; 
	public Piece(boolean isWhite,String path)
	{
		super(path); 
		this.isWhite = isWhite; 
	}
	
	
	public abstract ArrayList<Tile> legalMoves(int currRow,int currCol, Tile[][] grid); // returns the valid tiles 


	public boolean isWhite()
	{
		return isWhite;
	}


	public void setWhite(boolean isWhite)
	{
		this.isWhite = isWhite;
	}
	

}
