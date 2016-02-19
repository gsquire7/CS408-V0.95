
import java.util.ArrayList;

import javax.swing.JFrame;

public class FightController {

	static boolean mainScreen = false;
	static boolean speech = true;
	static boolean moves = false;
	static boolean moveUsed = false;
	static boolean change = false;
	static boolean pack = false;
	static boolean playerControl = true;
	static boolean enemyHit = false;
	boolean run = false;
	static int L = 9;

	static int xPos = 7 * L, yPos = 76 * L, totalWidth = 900, totalHeight = 1000;
	static int ballLeft = 7 * L, ballRight = 52 * L, writingLeft = 10 * L, writingRight = 55 * L, ppWidth = 30 * L, 
			upperWriting = 78 * L, lowerWriting = 88 * L;
	static int expPercent, EnemyHPPercent, PlayerHPPercent;
	static String spoken;//, imagelocation = "Back Pics/009.png", opponentimagelocation = "Front Pics/249.png";

	FightMoves FM = new FightMoves();
	RandomGen RM = new RandomGen();
	OwnedPokemon OP = new OwnedPokemon();
	FightView FV = new FightView();
	static ArrayList<PokemonState> playerParty = new ArrayList<PokemonState>();
	static ArrayList<PokemonState> enemyParty = new ArrayList<PokemonState>();
	static int playerCurrent = 0, enemyCurrent = 0;
	static boolean playerAttackable = true, enemyAttackable = true;

	//temporary attack statistics
	private int accuracy, base, damage, choice;
	static boolean playerTurn = true, playable = true;
	static int temppercent;


	public static void playerHpPercent()
	{
		double x = ((double)playerParty.get(playerCurrent).getHP() / (double)playerParty.get(playerCurrent).getHPTotal()) * 100;

		PlayerHPPercent = (int)x; 
	}

	public static int HpPercent(int z)
	{
		double x = ((double)playerParty.get(z).getHP() / (double)playerParty.get(z).getHPTotal()) * 100;

		temppercent = (int)x;
		return temppercent; 
	}

	public static void enemyHpPercent()
	{
		double x = ((double)enemyParty.get(enemyCurrent).getHP() / (double)enemyParty.get(enemyCurrent).getHPTotal()) * 100;
		EnemyHPPercent = (int)x;
	}

	public static void expPercentage()
	{
		double x = ((double)playerParty.get(playerCurrent).getXP() / (double)playerParty.get(playerCurrent).getXPTotal()) * 100;
		expPercent = (int)x;
	}

	public ArrayList<PokemonState> runBattle(ArrayList<PokemonState> currentPokemon, ArrayList<PokemonState> enemyPokemon){	
		playerCurrent = 0;
		enemyCurrent = 0;
		FM.populateMoves();
		playerParty = new ArrayList<PokemonState>(currentPokemon);
		enemyParty = new ArrayList<PokemonState>(enemyPokemon);
		JFrame jf = new JFrame();
//		totalWidth = totalWidth * L;
//		totalHeight = totalHeight * L;
		jf.setSize(100 * L, 100* L);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(FV);
//		System.out.println("Here");
		spoken = "A wild " + enemyParty.get(enemyCurrent).getName() + " appeared";
		FV.Pause(1000);
		spoken = "Wild " + enemyParty.get(enemyCurrent).getName() + " attacked";
		FV.Pause(1000);
		spoken = playerParty.get(playerCurrent).getName() + " GO!";
		FV.Pause(1000);
		System.out.println("Here");

		while(playable == true){
			mainScreen = true;
			speech = false;
			playerTurn();
			enemyTurn();
		}

		return playerParty;
	}



	public void playerTurn(){
		while(playerTurn == true && playable == true){

//			FV.repaint();
			choice = 0;
			boolean playerHealthUp = false;
			double playerHealthChange = 0.0;
			moveUsed = true;
			if(speech == true)
			{

				if(xPos == 7 * L && yPos == 76 * L)
				{
					choice = 1;
				}
				if(xPos == 52 * L && yPos == 76 * L)
				{
					choice = 2;
				}
				if(xPos == 7 * L && yPos == 86 * L)
				{
					choice = 3;
				}
				if(xPos == 52 * L && yPos == 86 * L)
				{
					choice = 4;
				}
			}

			if (choice == 1)
			{
				System.out.println("MOVE 1 PP = " + playerParty.get(playerCurrent).getMove1PP());
				if(playerParty.get(playerCurrent).getMove1PP() == 0)
				{
					moveUsed = false;
				}
				if (moveUsed == true)
				{
					System.out.println("used " + playerParty.get(playerCurrent).getMove1());
					getStats(playerParty.get(playerCurrent).getName(), playerParty.get(playerCurrent).getMove1(), playerParty.get(playerCurrent).getMove1PP());
					playerParty.get(playerCurrent).decrementMove1PP();
					playerHealthChange = FM.getHealthRegeneration(playerParty.get(playerCurrent).getMove1());
					if( playerHealthChange > 0.0)
					{
						playerHealthUp = true;
					}
				}
				else
				{
					speech = true;
					mainScreen = false;
					spoken= "NO PP LEFT";
					System.out.println("NO PP LEFT");
					FV.Pause(1000);
					mainScreen = true;
					speech = false;
					choice = 0;
				}
			}
			else if (choice == 2)
			{
				if(playerParty.get(playerCurrent).getMove2PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					System.out.println("used " + playerParty.get(playerCurrent).getMove2());
					getStats(playerParty.get(playerCurrent).getName(), playerParty.get(playerCurrent).getMove2(), playerParty.get(playerCurrent).getMove2PP());
					playerParty.get(playerCurrent).decrementMove2PP();
					playerHealthChange = FM.getHealthRegeneration(playerParty.get(playerCurrent).getMove2());
					if( playerHealthChange > 0.0)
					{
						playerHealthUp = true;
					}
				}
				else
				{
					speech = true;
					mainScreen = false;
					spoken= "NO PP LEFT";
					System.out.println("NO PP LEFT");
					FV.Pause(1000);
					mainScreen = true;
					speech = false;
					choice = 0;
				}
			}
			else if (choice == 3)
			{
				if(playerParty.get(playerCurrent).getMove3PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					System.out.println("used " + playerParty.get(playerCurrent).getMove3());
					getStats(playerParty.get(playerCurrent).getName(), playerParty.get(playerCurrent).getMove3(), playerParty.get(playerCurrent).getMove3PP());
					playerParty.get(playerCurrent).decrementMove3PP();
					playerHealthChange = FM.getHealthRegeneration(playerParty.get(playerCurrent).getMove3());
					if( playerHealthChange > 0.0)
					{
						playerHealthUp = true;
					}
				}
				else
				{
					speech = true;
					mainScreen = false;
					spoken= "NO PP LEFT";
					System.out.println("NO PP LEFT");
					FV.Pause(1000);
					mainScreen = true;
					speech = false;
					choice = 0;
				}
			}
			else if (choice == 4)
			{
				if(playerParty.get(playerCurrent).getMove4PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					System.out.println("used " + playerParty.get(playerCurrent).getMove4());
					getStats(playerParty.get(playerCurrent).getName(), playerParty.get(playerCurrent).getMove4(), playerParty.get(playerCurrent).getMove4PP());
					playerParty.get(playerCurrent).decrementMove4PP();
					playerHealthChange = FM.getHealthRegeneration(playerParty.get(playerCurrent).getMove4());
					if( playerHealthChange > 0.0)
					{
						playerHealthUp = true;
					}
				}
				else
				{
					speech = true;
					mainScreen = false;
					spoken= "NO PP LEFT";
					System.out.println("NO PP LEFT");
					FV.Pause(1000);mainScreen = true;
					speech = false;
					choice = 0;
				}
			}

			if (choice < 5 && choice > 0)
			{
				//does the move hit due to accuracy
				if(accuracy < 100)
				{
					playerAttackable = accuracy(accuracy);				
				}
				//if the pokemon can attack then calculate damage
				if (playerAttackable != false)
				{
					if(base != 0)
					{
						calcDamage(playerParty.get(playerCurrent).getLevel(), playerParty.get(playerCurrent).getAttack(), enemyParty.get(enemyCurrent).getDefence(), base);
						enemyParty.get(enemyCurrent).setHP(attackStrength(enemyParty.get(enemyCurrent).getHP(), damage));
						System.out.println("Enemy " + enemyParty.get(enemyCurrent).getName() + " hit.");
						//if move regenerates player hp, regenerate it
						if(playerHealthUp == true)
						{
							playerParty.get(playerCurrent).setHP((int) (playerParty.get(playerCurrent).getHP() + (playerHealthChange * damage)));
							System.out.println("Player regerates health");
						}
					}
					spoken = playerParty.get(playerCurrent).getName() + " hit!";
					xPos = 7 * L;
					yPos = 76 * L;
					FV.Pause(1000);
					System.out.println(enemyParty.get(enemyCurrent).getName() + " health Points remaining " + enemyParty.get(enemyCurrent).getHP());
					System.out.println(playerParty.get(playerCurrent).getName() + " health Points remaining " + playerParty.get(playerCurrent).getHP());
					playerAttackable = true;
					playerTurn = false;
				}
				else
				{
					spoken = playerParty.get(playerCurrent).getName() + " missed!";
					FV.Pause(1000);
					playerAttackable = true;
					//					playerTurn = false;
				}

				//Did the enemy faint
				if(enemyParty.get(enemyCurrent).getHP() <= 0)
				{
					spoken = "Enemy " + enemyParty.get(enemyCurrent).getName() + " fainted!";
					FV.Pause(1000);
					System.out.println("Enemy " + enemyParty.get(enemyCurrent).getName() + " fainted.");
					//if so check to see if there are any other pokemon in the party
					//if not then fight won
					boolean out = true;
					ArrayList<Integer> left = new ArrayList<Integer>();

					for(int z = 0; z < enemyParty.size(); z++)
					{
						if(enemyParty.get(z).getHP() > 0)
						{

							left.add(z);
							out = false;
						}
					}

					if(out == true)
					{
						spoken = playerParty.get(playerCurrent).getName() + " has won the fight";
						FV.Pause(1000);
						System.out.println(playerParty.get(playerCurrent).getName() + " has won the fight");
						playable = false;
					}
					//else determine which pokemon is selected
					else
					{

						enemyCurrent = left.get(0);

					}

				}
			}
		}
	}

	public int attackStrength(int healthpoints, int strength) {

		healthpoints = healthpoints - strength;
		if(healthpoints < 0)
		{
			healthpoints = 0;
		}
		return healthpoints;
	}

	public boolean accuracy(int x)
	{
		boolean hit;
		int accurate = RM.GenerateNumber(100);
		//		System.out.println("Accuracy Number" + accurate);
		if(accurate <= x)
		{
			hit = true;
		}
		else
		{
			hit = false;

		}
		return hit;

	}


	public void calcDamage(int level, int attack, int defense, int base)
	{
		double x = Math.floor((((2 * (double)level + 10) / 250) * ((double)attack / 
				(double)defense) * (double)base) + 2);

		damage = (int)x;
		//		System.out.println("Damage = " + damage);

	}
	public void getStats(String name, String move, int pp)
	{
		pp--;
		if(pp >= 0)
		{
			spoken = name + " used " + move;
			FV.Pause(1000);
			System.out.println(name + " used " + move);
			base = FM.getStrength(move);
			accuracy = FM.getAccuracy(move);
		}
	}



	public void enemyTurn(){
		while(playerTurn != true && playable == true)
		{
			/*
			 * Code to stop trying to change pokemon when only one is useable
			 * prevents infinite looping later
			 */
			int a = 0;
			for(int b = 0; b < enemyParty.size(); b++)
			{
				if(enemyParty.get(b).getHP() > 0)
				{
					a++;
				}
			}
			int c = 0;
			if(a == 1)
			{
				c = 80;
			}
			else
			{
				c = 100;
			}
			/*
			 * Creates a random choice for the move or change
			 * This is the RANDOM part of the AI
			 */
			choice = RM.GenerateNumber(80);
			if(choice < 20)
			{
				choice = 1;
			}
			else if(choice >= 20 && choice < 40)
			{
				choice = 2;

			}
			else if(choice >= 40 && choice < 60)
			{
				choice = 3;
			}
			else if(choice >= 60 && choice < 80)
			{
				choice = 4;
			}
			else if(choice >=80)
			{
				choice = 5;
			}

			moveUsed = true;
			System.out.println(choice);
			boolean enemyHealthUp = false;
			double enemyHealthChange = 0.0;
			if(choice == 1)
			{

				if(enemyParty.get(enemyCurrent).getMove1PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					getStats(enemyParty.get(enemyCurrent).getName(), enemyParty.get(enemyCurrent).getMove1(), enemyParty.get(enemyCurrent).getMove1PP());
					enemyParty.get(enemyCurrent).decrementMove1PP();
					enemyHealthChange = FM.getHealthRegeneration(enemyParty.get(enemyCurrent).getMove1());
					if( enemyHealthChange > 0.0)
					{
						enemyHealthUp = true;
					}
				}
				else
				{
					System.out.println("NO PP LEFT");
					choice = 0;
				}
			}
			else if (choice == 2)
			{
				if(enemyParty.get(enemyCurrent).getMove2PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					getStats(enemyParty.get(enemyCurrent).getName(), enemyParty.get(enemyCurrent).getMove2(), enemyParty.get(enemyCurrent).getMove2PP());
					enemyParty.get(enemyCurrent).decrementMove2PP();
					enemyHealthChange = FM.getHealthRegeneration(enemyParty.get(enemyCurrent).getMove2());
					if( enemyHealthChange > 0.0)
					{
						enemyHealthUp = true;
					}
				}
				else
				{
					System.out.println("NO PP LEFT");
					choice = 0;
				}
			}
			else if (choice == 3)
			{
				if(enemyParty.get(enemyCurrent).getMove3PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					getStats(enemyParty.get(enemyCurrent).getName(), enemyParty.get(enemyCurrent).getMove3(), enemyParty.get(enemyCurrent).getMove3PP());
					enemyParty.get(enemyCurrent).decrementMove3PP();
					enemyHealthChange = FM.getHealthRegeneration(enemyParty.get(enemyCurrent).getMove3());
					if( enemyHealthChange > 0.0)
					{
						enemyHealthUp = true;
					}
				}
				else
				{
					System.out.println("NO PP LEFT");
					choice = 0;
				}
			}
			else if (choice == 4)
			{
				if(enemyParty.get(enemyCurrent).getMove4PP() == 0)
				{
					moveUsed = false;
				}
				if(moveUsed == true)
				{
					getStats(enemyParty.get(enemyCurrent).getName(), enemyParty.get(enemyCurrent).getMove4(), enemyParty.get(enemyCurrent).getMove4PP());
					enemyParty.get(enemyCurrent).decrementMove4PP();
					enemyHealthChange = FM.getHealthRegeneration(enemyParty.get(enemyCurrent).getMove4());
					if( enemyHealthChange > 0.0)
					{
						enemyHealthUp = true;
					}
				}
				else
				{
					System.out.println("NO PP LEFT");
					choice = 0;
				}
			}
			if(choice < 5 && choice > 0)
			{
				//does the move hit due to accuracy
				if(accuracy < 100)
				{
					enemyAttackable = accuracy(accuracy);
				}
				//if the pokemon can attack then calculate damage
				if (enemyAttackable != false)
				{
					if(base != 0)
					{
						calcDamage(enemyParty.get(enemyCurrent).getLevel(), enemyParty.get(enemyCurrent).getAttack(), playerParty.get(playerCurrent).getDefence(), base);
						playerParty.get(playerCurrent).setHP(attackStrength(playerParty.get(playerCurrent).getHP(), damage));
						//add health gained if move gains health
						if(enemyHealthUp == true)
						{
							enemyParty.get(enemyCurrent).setHP((int) (enemyParty.get(enemyCurrent).getHP() + (enemyHealthChange * damage)));
							System.out.println("Enemy regerates health");
						}
					}
					spoken = "Enemy " + enemyParty.get(enemyCurrent).getName() + " hit!";
					FV.Pause(1000);
					System.out.println(playerParty.get(playerCurrent).getName() + " hit. Health Points remaining " + playerParty.get(playerCurrent).getHP());
					System.out.println(enemyParty.get(enemyCurrent).getName() + " Health Points remaining " + enemyParty.get(enemyCurrent).getHP());

				}
				else
				{
					spoken = "Enemy " + enemyParty.get(enemyCurrent).getName() + " missed!";
					FV.Pause(1000);
					System.out.println("Enemy " + enemyParty.get(enemyCurrent).getName() + " missed!");
				}
				enemyAttackable = true;

				//did player pokemon faint
				if(playerParty.get(playerCurrent).getHP() <= 0)
				{
					spoken = playerParty.get(playerCurrent).getName() + " fainted.";
					FV.Pause(1000);
					System.out.println(playerParty.get(playerCurrent).getName() + " fainted.");
					//if so then are there any other pokemon left in the party
					boolean out = true;
					ArrayList<Integer> left = new ArrayList<Integer>();

					for(int z = 0; z < playerParty.size(); z++)
					{
						if(playerParty.get(z).getHP() > 0)
						{

							left.add(z);
							out = false;
						}
					}

					if(out == true)
					{
						spoken = "player fainted. Enemy " + enemyParty.get(enemyCurrent).getName() + " has won the fight";
						FV.Pause(1000);
						System.out.println("player fainted. Enemy " + enemyParty.get(enemyCurrent).getName() + " has won the fight");
						playable = false;
					}
					//else determine which pokemon is selected
					else
					{

						playerCurrent = left.get(0);

					}
				}
				playerTurn = true;
			}
			else if (choice == 5)
			{
				
				/*
				 * This will not work if there are no other pokemon, need to rethink this section
				 */
				boolean allowed = false;
				
				while(allowed == false)
				{
					System.out.println("IN THE LOOP");
					int use = RM.GenerateNumber(enemyParty.size());
					if(use == enemyCurrent)
					{
						allowed = false;
					}
					else if(enemyParty.get(use).getHP() < 1)
					{
						allowed = false;
					}
					else
					{
						spoken = ("ENEMY: " + enemyParty.get(enemyCurrent).getName() + " THATS ENOUGH!");
						FV.Pause(1000);
						System.out.println("Enemy: " + enemyParty.get(use).getName() + " I CHOOSE YOU!");
						spoken = "Enemy: " + enemyParty.get(use).getName() + " I CHOOSE YOU!";
						FV.Pause(1000);
						enemyCurrent = use;
						allowed = true;
					}
				}
				playerTurn = true;
			}
		}
	}
}