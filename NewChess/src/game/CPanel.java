package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import Framework.GamePanel;
import Framework.audio.Audio;
import game.pieces.Bishop;
import game.pieces.King;
import game.pieces.Knight;
import game.pieces.Pawn;
import game.pieces.Piece;
import game.pieces.Queen;
import game.pieces.Rook;

public class CPanel extends GamePanel 
{
	public final static int width = 975;
	public final int height=1000;
	public int mouseX, mouseY, prevRow, prevCol; 
	public final static int rows = 8;
	public final static int cols = 8; 
	public static int tileSize = 120; 
	public Audio place = new Audio("/game/place.wav"), notLegal;  // the sounds for a correct place and an illegal place 
	public  Color pri= new Color(160,82,45), sec=new Color(230,208,180); //
	public Piece movingPiece ; 
	
	Point pieceCorner, prevPt;  // shoud prolly do this in the prees /i set the corner point to 00 right here instead of the construtor; if theres a problem its probably here
	public Tile[][] grid = new Tile[rows][cols]; 
	
	
	CPanel()
	{
		//this.setBackground(Color.BLACK);  
		// if it is even it is black ;  for chess every other square has an even number when you add the rows and cols
		initTiles(); //draws squares
		initStartPieces(); // draws the pieces in starting position
		this.addMouseMotionListener(new Dragger());
	
		//this.start();
		
	}
	public void initTiles()
	{
		for(int y =0 ; y<rows; y++)
		{
			for(int x = 0; x<cols; x++)
			{
				if((x+y)%2 ==0)// even number 
				{
					grid[y][x] = new Tile(x,y,sec,this); 
					
					
				}else
				{
					grid[y][x] = new Tile(x,y,pri,this);
				}
			}
		}
		
	}
	
	public void initStartPieces()
	{
		for(int y = 0 ; y<rows; y++) 
		{
			for(int x = 0 ; x<cols; x++) 
			{
				if(y==6) // white pawn row
				{
					grid[y][x].currentPiece = new Pawn(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/pawnW.png"); 
				}else if(y==1)//black pawn row 
				{
					grid[y][x].currentPiece = new Pawn(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/pawnB.png") ;
				}else if(y==0)// black first row 
				{
					if(x==0||x==7)//rooks
					{
						grid[y][x].currentPiece= new Rook(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/rookB.png"); 
					}
					else if(x==1||x==6)//knights
					{
						grid[y][x].currentPiece= new Knight(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/knightB.png"); 
					}else if(x==2||x==5)//bishops
					{
						grid[y][x].currentPiece= new Bishop(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/bishopB.png"); 
					}else if(x==3)//queen
					{
						grid[y][x].currentPiece= new Queen(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/queenB.png"); 
					}else //king
					{
						grid[y][x].currentPiece= new King(false,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/kingB.png"); 
					}
					
				}
				else if(y==7)// white first row 
				{
					if(x==0||x==7)//rooks
					{
						grid[y][x].currentPiece= new Rook(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/rookW.png"); 
					}else if(x==1||x==6)//knights
					{
						grid[y][x].currentPiece= new Knight(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/knightW.png"); 
					}else if(x==2||x==5)//bishops
					{
						grid[y][x].currentPiece= new Bishop(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/bishopW.png"); 
					}else if(x==3)//queen
					{
						grid[y][x].currentPiece= new Queen(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/queenW.png"); 
					}else //king
					{
						grid[y][x].currentPiece= new King(true,"C:/Users/kboss/eclipse-workspace/NewChess/src/game/kingW.png"); 
					}
					
				}
					
			}
		}
	}

	@Override
	public void update()
	{
		//logic 
		
	}

	@Override
	public void paint(Graphics g)
	{
		
		super.paintComponents(g);
		 
		
		drawBoard(g); 
		
		//paint the moving piece if it is not null
		if(movingPiece != null)
		{
			movingPiece.paintIcon(this,g,(int)pieceCorner.getX(),(int)pieceCorner.getY()); 
		}
		
		
	}
	public void drawBoard(Graphics g)
	{
		for(int y =0 ; y<rows; y++)
		{
			for(int x = 0; x<cols; x++)
			{
				grid[y][x].draw(g);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{ // this takes the tiles current piece (sets it equal to null) then sets it equal to the moving piece; so set the moving piece in this function ; check if the tile has a piece before to make sure no errors
		int selectedx= e.getX()/tileSize; 
		int selectedy= e.getY()/tileSize; 
		if(selectedx>=0&&selectedx<cols)
		{
			if(selectedy>=0&&selectedy<rows) // if first try doesn't work make your own mouse tracking 
			{
				if(grid[selectedy][selectedx].currentPiece!=null)
				{
					//set moving piece 
					movingPiece = grid[selectedy][selectedx].currentPiece; 
					System.out.println(selectedx+"| "+selectedy);
					ArrayList<Tile> moves = movingPiece.legalMoves(selectedy, selectedx, grid);  //****VERY IMPORTANT**** Make sure to put this in row,col (y,x)
					for(Tile tile:moves)
					{
						tile.selected =true;  
					}
					int piecew = movingPiece.getIconWidth(); 
					int pieceh = movingPiece.getIconHeight(); 
					//set s prev point 
					prevPt = e.getPoint(); 
					
					// the long below code is just to find that specific image corner 
					pieceCorner = new Point(grid[selectedy][selectedx].x*tileSize+(tileSize/2)-(grid[selectedy][selectedx].currentPiece.getIconWidth()/2),
							grid[selectedy][selectedx].y*tileSize+(tileSize/2)-(grid[selectedy][selectedx].currentPiece.getIconHeight()/2)) ; // so smart wow 
					
					
					mouseX = grid[selectedy][selectedx].x; 
					mouseY=grid[selectedy][selectedx].y; 
					
					
					//set the tile current piece to null
					grid[selectedy][selectedx].currentPiece = null; 
					//sets prev row and col  just to make sure that the  if the move was not legal you move back to that spot
					prevCol = selectedx;//
					prevRow = selectedy; 
					//System.out.println(mouseX+"  ," +mouseY);
					//System.out.println(e.getX()+"  ," +e.getY()); // maybe want to use the actual x and y values 
					
					
					
					
					
					repaint(); // updates the board 
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{//** Reset the prev point when released 
		int selectedx= e.getX()/tileSize; 
		int selectedy= e.getY()/tileSize; 
		if(selectedx>=0&&selectedx<cols)
		{//*** VERY IMPORTANT MAKE SURE IT IS A VALID MOVE BEFORE THEY ARE ABLE TO PLACE **** IF NOT SEND IT BACK TO THE PREV TILE 
			if(selectedy>=0&&selectedy<rows) // this is going to place the piece  // if any placing errors maybe because you didn't check if moving piece was null here or not. just copy the mousepressed code and change it 
			{//RIGHT HERE SHOULD BE if(movingPiece.legalMove()): 
				if(movingPiece!=null)
				{
					if( movingPiece.legalMoves(prevRow, prevCol, grid).contains(grid[selectedy][selectedx]))
					{
						mouseX = grid[selectedy][selectedx].x; 
						mouseY=grid[selectedy][selectedx].y; 
						//set moving piece 
						 grid[selectedy][selectedx].currentPiece=movingPiece ; 
						 grid[selectedy][selectedx].currentPiece.starting = false; // it is not starting anymore
						//set the tile moving piece to null
						 movingPiece= null; 
						 //if everything is valid then set prevrow and col to null
						 prevCol = 0;//
						prevRow = 0; 
						place.play();
						System.out.println(mouseX+"  ," +mouseY);
						//System.out.println(e.getX()+"  ," +e.getY()); // maybe want to use the actual x and y values 
						
					}else
					{
						 grid[prevRow][prevCol].currentPiece = movingPiece;
						 movingPiece= null;
						 prevCol = 0;
						 prevRow = 0;
					}
				}
				
				
				
				//reset the color for selected tiles
				reset(); 
				
				
				repaint(); // updates the board 
				
				
				
			}
		}
		
	}
	public void reset()
	{
		for(int y =0 ; y<rows; y++)
		{
			for(int x = 0; x<cols; x++)
			{
				grid[y][x].selected = false;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	private class Dragger extends MouseMotionAdapter
	{
		
		public void mouseDragged(MouseEvent e) // maybe right here make sure the tile is not empty 
		{
			if(prevPt!= null) // could also be prevpt
			{
				Point currentPt = e.getPoint(); 
				pieceCorner.translate((int)(currentPt.getX() - prevPt.getX()), 
						(int)(currentPt.getY() - prevPt.getY()));
				prevPt = currentPt; 
				repaint(); 
			} 
		}
		
	}
	

}
