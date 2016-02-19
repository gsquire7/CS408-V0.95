
public class PokemonState {

	private int id;
	private String pokemon;
	private String name;
	private int level;
	private String type;
	private int xp;
	private int xpMax;
	private int hp;
	private int hpMax;
	private int attack;
	private int defence;
	private int speed;
	private int specialAttack;
	private int specialDefense;
	public String move1;
	public String move2;
	public String move3;
	public String move4;
	private int move1PPMax;
	private int move2PPMax;
	private int move3PPMax;
	private int move4PPMax;
	private int move1PP;
	private int move2PP;
	private int move3PP;
	private int move4PP;
	
	
	private boolean poison;
	private boolean frozen;
	private boolean paralysed;
	private boolean confused;
	private boolean burned;
	private boolean sleeping;
	
	private String frontPic;
	private String backPic;
	//getting and setting the data towards a pokemon.
	//this will be used for every party pokemon
	//in particular this should help control how moves affect the pokemon
	
	public PokemonState(int id, String pokemon, String name, int level, String type, 
			int xp, int xpMax, int hp, int hpMax, int attack, int defense, int speed,
			int specialAttack, int specialDefense, String move1, String move2, String move3, 
			String move4, int move1PPMax, int move2PPMax, int move3PPMax,
			int move4PPMax, int move1PP, int move2PP, int move3PP, int move4PP, 
			boolean poison, boolean frozen, boolean paralysed, boolean confused, boolean burned,
			boolean sleeping, String frontPic, String backPic)
	{
		this.id = id;
		this.pokemon = pokemon;
		this.name = name;
		this.level = level;
		this.type = type;
		this.xp = xp;
		this.xpMax = xpMax;
		this.hp = hp;
		this.hpMax = hpMax;
		this.attack = attack;
		this.defence = defense;
		this.speed = speed;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
		this.move1PPMax = move1PPMax;
		this.move2PPMax = move2PPMax;
		this.move3PPMax = move3PPMax;
		this.move4PPMax = move4PPMax;
		this.move1PP = move1PP;
		this.move2PP = move2PP;
		this.move3PP = move3PP;
		this.move4PP = move4PP;
		this.poison = poison;
		this.frozen = frozen;
		this.paralysed = paralysed;
		this.confused = confused;
		this.burned = sleeping;
		this.sleeping = sleeping;
		this.frontPic = frontPic;
		this.backPic = backPic;
		
	}
	public int getId()
	{
		return id;
	}
	public String getPokemon()
	{
		return pokemon;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String x)
	{
		name = x;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int newLevel)
	{
		level = newLevel;
	}
	public int getXP()
	{
		return xp;
	}
	public void addXP(int experience)
	{
		xp = xp + experience;
	}
	public String getType()
	{
		return type;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int x)
	{
		hp = x;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int x)
	{
		attack = x;
	}
	
	public int getDefence()
	{
		return defence;
	}
	
	public void setDefence(int x)
	{
		defence = x;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int x)
	{
		speed = x;
	}
	
	public int getSpecialAttack()
	{
		return specialAttack;
	}
	
	public void setSpecialAttack(int x)
	{
		specialAttack = x;
	}
	
	public int getSpecialDefense()
	{
		return specialDefense;
	}
	
	public void setSpecialDefense(int x)
	{
		specialDefense = x;
	}
	public String getMove1()
	{
		return move1;
	}
	public void setMove1(String x)
	{
		move1 = x;
	}
	public int getMove1PP()
	{
		return move1PP;
	}
	
	public void decrementMove1PP()
	{
		move1PP--;
	}
	
	public void setMove1PP(int x)
	{
		move1PP = x;
	}
	
	public int getMove1PPMax()
	{
		return move1PPMax;
	}
	
	public void setMove1PPMax(int x)
	{
		move1PPMax = x;
	}
	public String getMove2()
	{
		return move2;
	}
	
	public void decrementMove2PP()
	{
		move2PP--;
	}
	public void decrementMove3PP()
	{
		move3PP--;
	}
	
	public void decrementMove4PP()
	{
		move4PP--;
	}
	
	public void setMove2(String x)
	{
		move2 = x;
	}
	public int getMove2PP()
	{
		return move2PP;
	}
	
	public void setMove2PP(int x)
	{
		move2PP = x;
	}
	
	public int getMove2PPMax()
	{
		return move2PPMax;
	}
	
	public void setMove2PPMax(int x)
	{
		move2PPMax = x;
	}
	public String getMove3()
	{
		return move3;
	}
	public void setMove3(String x)
	{
		move3 = x;
	}
	public int getMove3PP()
	{
		return move3PP;
	}
	
	public void setMove3PP(int x)
	{
		move3PP = x;
	}
	
	public int getMove3PPMax()
	{
		return move3PPMax;
	}
	
	public void setMove3PPMax(int x)
	{
		move3PPMax = x;
	}
	public String getMove4()
	{
		return move4;
	}
	public void setMove4(String x)
	{
		move4 = x;
	}
	public int getMove4PP()
	{
		return move4PP;
	}
	
	public void setMove4PP(int x)
	{
		move4PP = x;
	}
	
	public int getMove4PPMax()
	{
		return move4PPMax;
	}
	
	public void setMove4PPMax(int x)
	{
		move4PPMax = x;
	}
	
	public boolean getPoison()
	{
		return poison;
	}
	
	public void setPoison(boolean x)
	{
		poison = x;
	}
	public boolean getFrozen()
	{
		return frozen;
	}
	
	public void setFrozen(boolean x)
	{
		frozen = x;
	}
	public boolean getParalysed()
	{
		return paralysed;
	}
	
	public void setParalysed(boolean x)
	{
		paralysed = x;
	}
	public boolean getConfused()
	{
		return confused;
	}
	
	public void setConfused(boolean x)
	{
		confused = x;
	}
	public boolean getBurned()
	{
		return burned;
	}
	
	public void setBurned(boolean x)
	{
		burned = x;
	}
	public boolean getSleeping()
	{
		return sleeping;
	}
	
	public void setSleeping(boolean x)
	{
		sleeping = x;
	}
	public int getHPTotal() {
		return hpMax;
	}
	public void setHPTotal(int x) {
		hpMax = x;
	}
	public int getXPTotal() {
		return xpMax;
	}
	public void setXPTotal(int x) {
		xpMax = x;
	}
	
	public String getFrontPic()
	{
		return frontPic;
	}
	public String getBackPic()
	{
		return backPic;
	}
	
}
