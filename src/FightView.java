
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class FightView extends JPanel implements ActionListener, KeyListener {
	
	
	
	Timer tm = new Timer(5, this);
	
	public FightView(){
		
			tm.start();
			addKeyListener(this);
			//enable key listener
			setFocusable(true);
			//not using shift or tab etc
			setFocusTraversalKeysEnabled(false);
		}

	public void Pause(int x){
		
		repaint();
		try {
			TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 100 * FightController.L, 100 * FightController.L + 100);
			//get percentages
			FightController.playerHpPercent();
			FightController.enemyHpPercent();
			FightController.expPercentage();
//			System.out.println(FightController.change);

			if(FightController.change == false)
			{
//				System.out.println("Here Graphics");
				g.setColor(Color.BLACK);
				g.fillRect(0,  ((100 * FightController.L/10) * 7),  100 * FightController.L,  ((100 * FightController.L / 10) * 3));
				//*** TOP HALF ***
				//hp top
				g.fillRect(10 * FightController.L, 12 * FightController.L, 5 * FightController.L, 4 * FightController.L);
				//sidebar top
				g.fillRect(6 * FightController.L ,12 * FightController.L, (int)(1.5 * FightController.L), (int)(8.5 * FightController.L));
				//basebar top
				g.fillRect(6 * FightController.L, 20 * FightController.L, 33 * FightController.L, (int)(0.5 * FightController.L));
				//under HP top
				g.fillRect(15 * FightController.L, (int)(15.5 * FightController.L), 21 * FightController.L, (int)(0.5 * FightController.L));
				//right hand bar top
				g.fillRect(35* FightController.L, 12 * FightController.L, 2 * FightController.L, 4 * FightController.L);
				//end triangle top
				g.fillRect(35 * FightController.L, (int)(18.5 * FightController.L), 1 * FightController.L, 2 * FightController.L);
				g.fillRect(36 * FightController.L, 19 * FightController.L, 1 * FightController.L, 1 * FightController.L);
				g.fillRect(37 * FightController.L, (int)(19.5 * FightController.L), 1 * FightController.L, 1 * FightController.L);
				//*** BOTTOM HALF ***
				//hp bottom
				g.fillRect(65  * FightController.L, 52 * FightController.L, 5 * FightController.L, 4 * FightController.L);
				//sidebar bot
				g.fillRect(94 * FightController.L, 52 * FightController.L, (int)(1.5 * FightController.L), (int)(13.5 * FightController.L));
				//basebar bot
				g.fillRect(61 * FightController.L, 65 * FightController.L, 33 * FightController.L, (int)(0.5 * FightController.L));
				//under HP bot
				g.fillRect(70 * FightController.L, (int)(55.5 * FightController.L), 21 * FightController.L, (int)(0.5 * FightController.L));
				//right hand bar bot
				g.fillRect(90 * FightController.L, 52 * FightController.L, 2 * FightController.L, 4 * FightController.L);
				//end triangle bot
				g.fillRect(64 * FightController.L, (int)(63.5 * FightController.L), 1 * FightController.L, 2 * FightController.L);
				g.fillRect(63 * FightController.L, 64 * FightController.L, 1 * FightController.L, 1 * FightController.L);
				g.fillRect(62 * FightController.L, (int)(64.5 * FightController.L), 1 * FightController.L, 1 * FightController.L);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(3 * FightController.L, 73 * FightController.L, 94 * FightController.L, 20 * FightController.L);

				Image opponentImage = new ImageIcon(FightController.enemyParty.get(FightController.enemyCurrent).getFrontPic()).getImage();
				g.drawImage(opponentImage, 95 * FightController.L - 300, 0, this);
				Image playerpic = new ImageIcon(FightController.playerParty.get(FightController.playerCurrent).getBackPic()).getImage();
				g.drawImage(playerpic, 5 * FightController.L, 70 * FightController.L - 300, this);
				g.setColor(Color.black);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 4 * FightController.L));
				g.drawString(FightController.enemyParty.get(FightController.enemyCurrent).getPokemon(), 6 * FightController.L, 5 * FightController.L);
				g.drawString(FightController.playerParty.get(FightController.playerCurrent).getPokemon(), 65 * FightController.L, 45 * FightController.L);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 3 * FightController.L));
				
				g.setColor(Color.black);
				if(FightController.mainScreen == true)
				{
					g.fillOval(FightController.xPos, FightController.yPos, (int)(1.5 * FightController.L), (int)(1.5 * FightController.L));
					g.drawString("FIGHT", FightController.writingLeft, FightController.upperWriting);
					g.drawString("POKEMON", FightController.writingRight, FightController.upperWriting);
					g.drawString("PACK", FightController.writingLeft, FightController.lowerWriting);
					g.drawString("RUN", FightController.writingRight, FightController.lowerWriting);
				}
				else if(FightController.moves == true)
				{
					g.fillOval(FightController.xPos, FightController.yPos, (int)(1.5 * FightController.L), (int)(1.5 * FightController.L));
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).move1, FightController.writingLeft, FightController.upperWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).move2, FightController.writingRight, FightController.upperWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).move3, FightController.writingLeft, FightController.lowerWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).move4, FightController.writingRight, FightController.lowerWriting);
					g.setFont(new Font("Comic Sans MS", Font.BOLD, 2 * FightController.L));

					g.drawString(FightController.playerParty.get(FightController.playerCurrent).getMove1PP() + " / " + FightController.playerParty.get(FightController.playerCurrent).getMove1PPMax(), FightController.writingLeft + FightController.ppWidth, FightController.upperWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).getMove2PP() + " / " + FightController.playerParty.get(FightController.playerCurrent).getMove2PPMax(), FightController.writingRight + FightController.ppWidth, FightController.upperWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).getMove3PP() + " / " + FightController.playerParty.get(FightController.playerCurrent).getMove3PPMax(), FightController.writingLeft + FightController.ppWidth, FightController.lowerWriting);
					g.drawString(FightController.playerParty.get(FightController.playerCurrent).getMove4PP() + " / " + FightController.playerParty.get(FightController.playerCurrent).getMove4PPMax(), FightController.writingRight + FightController.ppWidth, FightController.lowerWriting);

				}
				else //if(FightController.speech == true)
				{
					g.drawString(FightController.spoken, FightController.writingLeft, FightController.upperWriting);
				}
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 3 * FightController.L));

				g.drawString("L "+ FightController.enemyParty.get(FightController.enemyCurrent).getLevel(), 20 * FightController.L, 10 * FightController.L);

				g.setColor(Color.blue);
				g.fillRect(65 * FightController.L, (int)(63.5 * FightController.L), (int)(FightController.expPercent * (29 / 10)), (int)(1.5 * FightController.L));

				if(FightController.EnemyHPPercent > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(15 * FightController.L, (int)(12.5 * FightController.L), (int)(FightController.EnemyHPPercent * (0.2 * FightController.L)), 2 * FightController.L);

				g.setColor(Color.BLACK);
				g.drawString("L " + FightController.playerParty.get(FightController.playerCurrent).getLevel(), (int)(77.5 * FightController.L), 50 * FightController.L);
				g.drawString(FightController.playerParty.get(FightController.playerCurrent).getHP() + "  /  " + FightController.playerParty.get(FightController.playerCurrent).getHPTotal(), 73 * FightController.L, 60 * FightController.L);
				g.setColor(Color.yellow);
				g.drawString("HP:", 10 * FightController.L, 15 * FightController.L);
				g.drawString("HP:", 65 * FightController.L, 55 * FightController.L);
				if(FightController.PlayerHPPercent > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(70 * FightController.L, 53 * FightController.L, (int)(FightController.PlayerHPPercent * (0.2 * FightController.L)) , 2 * FightController.L);
			}else{
				
				
			//CHANGE POKEMON
			g.setColor(Color.BLACK);
			g.fillOval(3 * FightController.L, FightController.yPos, (int)(1.5 * FightController.L), (int)(1.5 * FightController.L));
			int y = 18 * FightController.L;
			for(int x = 0; x < FightController.playerParty.size(); x++)
			{
				g.setColor(Color.BLACK);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 4 * FightController.L));
				g.drawString("CLOSE", 10 * FightController.L, 78 * FightController.L);
				g.drawString(FightController.playerParty.get(x).getName(), 10 * FightController.L, y);
				g.fillRect(65 * FightController.L, y - 3 * FightController.L, 5 * FightController.L, 3 * FightController.L);
				g.fillRect(90 * FightController.L, y - 3 * FightController.L, 2 * FightController.L, 3 * FightController.L);
				g.fillRect(65 * FightController.L, y , 27 * FightController.L, (int)(0.5 * FightController.L));
				g.drawString("L " + FightController.playerParty.get(x).getLevel(), 47 * FightController.L,y);
				g.drawString(FightController.playerParty.get(x).getHP() + " / " + FightController.playerParty.get(x).getHPTotal(),  75 * FightController.L, y - 4 * FightController.L);
				g.setFont(new Font("Comic Sans MS", Font.PLAIN, 2 * FightController.L));
				g.setColor(Color.YELLOW);
				g.drawString("HP:", 66 * FightController.L, y - (int)(0.5 * FightController.L));
				if(FightController.playerParty.get(x).getHP() > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(70 * FightController.L, y - 2 * FightController.L, (int)(FightController.HpPercent(x) * 0.2 * FightController.L), 2 * FightController.L);
				y = y + 10 * FightController.L;

			}
			
			}
			

		}
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}

		public void keyPressed(KeyEvent e)
		{
			int c = e.getKeyCode();
			System.out.println("KEYEVENT");


			if(c ==KeyEvent.VK_LEFT || c == KeyEvent.VK_A)
			{
				System.out.println("LEFT");
				FightController.xPos = 7 * FightController.L;
			}
			
			if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D)
			{
				System.out.println("RIGHT");
				FightController.xPos = 52 * FightController.L;
			}
			
			if(c == KeyEvent.VK_UP || c == KeyEvent.VK_W)
			{
				System.out.println("UP");
				if(FightController.change == false && FightController.pack == false)
				{
					FightController.yPos = 76 * FightController.L;
				}
				else if(FightController.change == true)
				{
					if(FightController.yPos == (int)(75.5 * FightController.L) && FightController.playerParty.size() == 5)
					{
						FightController.yPos = (int)(55.5 * FightController.L);
					}
					else if(FightController.yPos == (int)(75.5 * FightController.L) && FightController.playerParty.size() == 4)
					{
						FightController.yPos = (int)(45.5 * FightController.L);
					}
					else if(FightController.yPos == (int)(75.5 * FightController.L) && FightController.playerParty.size() == 3)
					{
						FightController.yPos = (int)(35.5 * FightController.L);
					}
					else if(FightController.yPos == (int)(75.5 * FightController.L) && FightController.playerParty.size() == 2)
					{
						FightController.yPos = (int)(25.5 * FightController.L);
					}
					else if(FightController.yPos == (int)(75.5 * FightController.L) && FightController.playerParty.size() == 1)
					{
						FightController.yPos = (int)(15.5 * FightController.L);
					}
					else if(FightController.yPos == (int)(75.5 * FightController.L))
					{
						FightController.yPos = FightController.yPos - 10 * FightController.L;
					}
					else if(FightController.yPos != (int)(15.5 * FightController.L))
					{
						FightController.yPos = FightController.yPos - 10 * FightController.L;
					}
				}
			}
			
			if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S)
			{
				System.out.println("DOWN");
				if(FightController.change == false && FightController.pack == false)
				{
					FightController.yPos = 86 * FightController.L;
				}
				else if(FightController.change == true)
				{
					if(FightController.yPos == (int)(15.5 * FightController.L) && FightController.playerParty.size() > 1)
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else if(FightController.yPos == (int)(25.5 * FightController.L)&& FightController.playerParty.size() > 2)
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else if(FightController.yPos == (int)(35.5 * FightController.L)&& FightController.playerParty.size() > 3)
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else if(FightController.yPos == (int)(45.5 * FightController.L)&& FightController.playerParty.size() > 4)
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else if(FightController.yPos == (int)(55.5 * FightController.L) && FightController.playerParty.size() > 5)
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else if(FightController.yPos == (int)(65.5 * FightController.L))
					{
						FightController.yPos = FightController.yPos + 10 * FightController.L;
					}
					else
					{
						FightController.yPos = (int)(75.5 * FightController.L);
					}
				}
			}
			//A BUTTON
			if (c == KeyEvent.VK_L)
			{
				System.out.println("A");
				//on main screen
				if(FightController.mainScreen == true)
				{
					//selecting moves
					if(FightController.xPos == 7 * FightController.L && FightController.yPos == 76 * FightController.L)
					{
						FightController.mainScreen = false;
						FightController.moves = true;
					}
					if(FightController.xPos == 52 * FightController.L && FightController.yPos == 76 * FightController.L)
					{
						FightController.mainScreen = false;
						FightController.change = true;
						FightController.yPos = (int)(15.5 * FightController.L);
					}
					if(FightController.xPos == 52 * FightController.L && FightController.yPos == 86 * FightController.L)
					{
						System.exit(0);
					}
				}
				//on move screen
				else if(FightController.moves == true)
				{
					FightController.moves = false;
					FightController.speech = true;

				}
				//on pokemon screen
				else if(FightController.change == true)
				{
					if(FightController.yPos == (int)(15.5 * FightController.L) && FightController.playerCurrent !=0 && FightController.playerParty.size() > 0 && FightController.playerParty.get(0).getHP() > 0)
					{
						FightController.playerCurrent = 0;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					if(FightController.yPos == (int)(25.5 * FightController.L) && FightController.playerCurrent !=1 && FightController.playerParty.size() > 1 && FightController.playerParty.get(1).getHP() > 0)
					{
						FightController.playerCurrent = 1;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					if(FightController.yPos == (int)(35.5 * FightController.L) && FightController.playerCurrent !=2 && FightController.playerParty.size() > 2 && FightController.playerParty.get(2).getHP() > 0)
					{
						FightController.playerCurrent = 2;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					if(FightController.yPos == (int)(45.5 * FightController.L) && FightController.playerCurrent !=3 && FightController.playerParty.size() > 3 && FightController.playerParty.get(3).getHP() > 0)
					{
						FightController.playerCurrent = 3;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					if(FightController.yPos == (int)(55.5 * FightController.L) && FightController.playerCurrent !=4 && FightController.playerParty.size() > 4 && FightController.playerParty.get(4).getHP() > 0)
					{
						FightController.playerCurrent = 4;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					if(FightController.yPos == (int)(65.5 * FightController.L) && FightController.playerCurrent !=5 && FightController.playerParty.size() > 5 && FightController.playerParty.get(5).getHP() > 0)
					{
						FightController.playerCurrent = 5;
						FightController.playerTurn = false;
						FightController.speech = true;
						FightController.spoken = FightController.playerParty.get(FightController.playerCurrent).getName() + " I CHOOSE YOU!";
						FightController.change = false;
						FightController.xPos = 7 * FightController.L;
						FightController.yPos = 76 * FightController.L;
					}
					
				}
				

			}
			//B BUTTON
			if (c == KeyEvent.VK_K)
			{
				System.out.println("B");
				if(FightController.moves == true || FightController.change == true)
				{

					FightController.mainScreen = true;
					FightController.change = false;
					FightController.moves = false;
					FightController.xPos = 7 * FightController.L;
					FightController.yPos = 76 * FightController.L;

				}
			}
		}

		public void keyTyped(KeyEvent e)
		{

		}
		public void keyReleased(KeyEvent e)
		{

		}

}
