
import java.util.ArrayList;

public class FightMoves {

	RandomGen random = new RandomGen();
	ArrayList<MoveEffects> moves = new ArrayList<MoveEffects>();
	ArrayList<String> exceptions = new ArrayList<String>();
	public void populateMoves()
	{
		//absorb - 20 strength, 100% accuracy, 20pp, 50% of damage done health restored	
		moves.add(new MoveEffects("ABSORB", "Grass", 20, 100, 20, 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));
		//acid - 40 strength, 100% accuracy, 30pp, 10% chance of lowering enemies defence by 1
		moves.add(new MoveEffects("ACID", "Poison", 40, 100, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 10));
		moves.add(new MoveEffects("ACID", "Poison", 40, 100, 30, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 10));
		//acid armour - 0 strength, 100% accuracy, 40pp, raises attack Pokemon's attack by 2 points
		moves.add(new MoveEffects("ACID ARMOUR", "Poison", 0, 100, 40, 0.0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));
		//aeroblast - 100 strength, 95% accuracy, 5pp, Pokemon performs a critical hit more easily - 20% chance of it
		moves.add(new MoveEffects("AEROBLAST", "Flying", 100, 95, 5, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));
		//agility - 0 strength, 100% accuracy, 30pp, Pokemons speed doubles
		moves.add(new MoveEffects("AGILITY", "Psychic", 0, 100, 30, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 0));
		//amnesia - 0 strength, 100% accuracy, 20pp, Pokemon's SP defense raises 2
		moves.add(new MoveEffects("AMNESIA", "Psychic",0, 100, 20, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));
		//ancient power - 60 strength, 100% accuracy, 5pp, 10% chance of raises all Pokemon's stats by 1
		moves.add(new MoveEffects("ANCIENT POWER", "Rock", 60, 100, 5, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 10));
		moves.add(new MoveEffects("ANCIENT POWER", "Rock", 60, 100, 5, 0.0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));

		//needs work!!
		//attract - 0 strength, 100% accuracy, 15pp, 50% chance pokemon of opposite sex cannot attack
		//moves.add(new MoveEffects("Attract", "Normal", 0, 100, 15, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 50));


		//aurora beam - 65 strength, 100% accuracy, 20pp, 10% chance of lowering enemy attack by 1
		moves.add(new MoveEffects("AURORA BEAM", "Ice", 65, 100, 20, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 10));
		moves.add(new MoveEffects("AURORA BEAM", "Ice", 65, 100, 20, 0.0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 10));

	}

	public int getStrength(String move)
	{
		int positionStrength  = getIndex(move);
		int strength = moves.get(positionStrength).getStrength();
		return strength;
	}

	public int getAccuracy(String move)
	{
		int positionAccuracy = getIndex(move);
		int accuracy = moves.get(positionAccuracy).getAccuracy();
		return accuracy;
	}

	public int getIndex(String moveName)
	{
		boolean found = false;
		int index = 0;
		while(found == false)
		{
			for(MoveEffects a: moves)
			{
				//				System.out.println(a.getName());
				//				System.out.println(moveName);
				String b = a.getName();
				if(b.equals(moveName))
				{
					int odds = a.getExceptionsOdds();
					if(odds > 0)
					{
						if(random.GenerateNumber(100) > odds)
						{
							return index;
						}
						else
						{
							index++;
							return index;
						}
					}
					return index;
				}
				else
				{
					index++;
				}
			}
		}
		return 0;	
	}
	
	public double getHealthRegeneration(String move)
	{
		int healthRegeneration = getIndex(move);
		double regeneration = moves.get(healthRegeneration).getHealthRegeneration();
		return regeneration;
	}
	public int getMovePP(String move)
	{
		int moveLimit = getIndex(move);
		int pp = moves.get(moveLimit).getPP();
		return pp;
	}
}