package game;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Framework.GameFrame;
import Framework.GamePanel;

public class CFrame extends GameFrame 
{

	public CFrame(int width, int height, String title, GamePanel panel)
	{
		super(width, height, title, panel);
		this.setResizable(false); 
		//ImageIcon image = new ImageIcon("C:/Users/kboss/eclipse-workspace/NewChess/src/game/PLV1.png"); 
		//this.setIconImage(image.getImage()); 
		
		
	}

}
