
import java.util.ArrayList;

public class MapPrototype {

	ArrayList<PokemonState> enemy = new ArrayList<PokemonState>();

	public void pokemon()
	{
		FightMoves FM = new FightMoves();
		FM.populateMoves();
		enemy.clear();

		//id, pokemon, name, level, type, xp, hp
		//attack, defence, speed, specialAttack, specialDefence
		//move1, move2, move3, move4
		//move1PPmax, move2ppmax, move3ppmax, move4ppmax
		//move1pp, move2pp, move3pp, move4pp
		//poisoned, frozen, paralysed, confused, burned, sleeping
		String move1 = "ABSORB";
		String move2 = "ACID";
		String move3 = "ACID ARMOUR";
		String move4 = "AEROBLAST";
		enemy.add(new PokemonState(017, "LUGIA", "LUGIA", 40, "Dark", 95, 200, 200, 200, 
				90, 60, 45, 55, 55,
				move1, move2, move3, move4,
				FM.getMovePP(move1),FM.getMovePP(move2), FM.getMovePP(move3), FM.getMovePP(move4),
				1, 1, 1, 1,
				false, false, false, false, false, false,
				"Front Pics/249.png", "Back Pics/249.png"));
		enemy.add(new PokemonState(0127, "OMASTAR", "OMASTAR", 30, "Electric", 45655, 70000, 100, 200, 
				50, 60, 45, 55, 55,
				move1, move2, move3, move4,
				FM.getMovePP(move1),FM.getMovePP(move2), FM.getMovePP(move3), FM.getMovePP(move4),
				10, 10, 10, 10,
				false, false, false, false, false, false,
				"Front Pics/139.png", "Back Pics/139.png"));
		
//		System.out.println(owned.toString());
//		System.out.println(party.toString());
		
	}
	
	public ArrayList<PokemonState> returnEnemy()
	{
		return enemy;
	}
	
}