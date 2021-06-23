package game;

import java.awt.Color;
import java.awt.Graphics;

import game.pieces.Piece;

public class Tile
{
	public Color color, selectedColor = new Color(255,255,0);  //yellow 
	public Piece currentPiece; //make sure to make null  if switched or destroyed or you will get duplication 
	protected int x , y; 
	protected CPanel panel; 
	
	protected boolean selected = false; 
	
	Tile(int x,int y,Piece piece,Color tilecolor,CPanel panel)
	{
		this.currentPiece = piece ; 
		this.color =tilecolor ;
		this.x = x ; 
		this.y = y ; 
		this.panel = panel ; 
	}
	
	Tile(int x,int y, Color tilecolor ,CPanel panel)
	{
		this.color = tilecolor; 
		this.x = x ; 
		this.y = y ; 
		this.panel = panel ; 
	}
	
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		if(selected)
		{
			g.setColor(selectedColor);
		}
		g.fillRect(this.x*CPanel.tileSize, this.y*CPanel.tileSize, CPanel.tileSize, CPanel.tileSize);
		if(currentPiece!=null)
		{
			
			currentPiece.paintIcon(panel, g, this.x*CPanel.tileSize+(CPanel.tileSize/2)-(currentPiece.getIconWidth()/2), this.y*CPanel.tileSize+(CPanel.tileSize/2)-(currentPiece.getIconHeight()/2));
			
		}
	}
}
