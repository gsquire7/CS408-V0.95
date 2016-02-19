

public class MoveEffects {
	private String name; 
	private String type; 
	private int strength; 
	private int accuracy; 
	private int pp;
	private double healthRegeneration;
	private int attackerAttack;
	private int defenderAttack;
	private int attackerDefense;
	private int defenderDefense;
	private int attackerSpeed;
	private int defenderSpeed;
	private int attackerSPAttack;
	private int defenderSPAttack;
	private int attackerSPDefense;
	private int defenderSPDefense;
	private double criticalMultiplier;
	private double poison;
	private double frozen;
	private double paralysed;
	private double confusion;
	private double burned;
	private double attackerSleep; 
	private double defenderSleep;
	private double attackerSpeedRatio;
	private int exceptionsOdds;
	
	public MoveEffects(String name, String type, int strength, int accuracy, int pp,
			double healthRegeneration, int attackerAttack, int defenderAttack,
			int attackerDefense, int defenderDefense,
			int attackerSpeed, int defenderSpeed,
			int attackerSPAttack, int defenderSPAttack,
			int attackerSPDefense, int defenderSPDefense,
			double criticalMultiplier, double poison, double frozen,
			double paralysed, double confusion, double burned,
			double attackerSleep, double defenderSleep,
			double attackerSpeedRatio, int exceptionsOdds)
	{
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.accuracy = accuracy;
		this.pp = pp;
		this.healthRegeneration = healthRegeneration;
		this.attackerAttack = attackerAttack;
		this.defenderAttack = defenderAttack;
		this.attackerDefense = attackerDefense;
		this.defenderDefense = defenderDefense;
		this.attackerSpeed = attackerSpeed;
		this.defenderSpeed = defenderSpeed;
		this.attackerSPAttack = attackerSPAttack;
		this.defenderSPAttack = defenderSPAttack;
		this.attackerSPDefense= attackerSPDefense;
		this.defenderSPDefense = attackerSPDefense;
		this.criticalMultiplier = criticalMultiplier;
		this.poison = poison;
		this.frozen = frozen;
		this.paralysed = paralysed;
		this.confusion = confusion;
		this.burned = burned;
		this.attackerSleep = attackerSleep; 
		this.defenderSleep = defenderSleep;
		this.attackerSpeedRatio = attackerSpeedRatio;
		this.exceptionsOdds = exceptionsOdds;
	}
	
	public String getName()
	{ 
		return name;
	}
	
	public String getType()
	{ 
		return type;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	
	public int getExceptionsOdds()
	{
		return exceptionsOdds;
	}
	public double getHealthRegeneration()
	{
		return healthRegeneration;
	}
	public int getPP()
	{
		return pp;
	}
	
}
