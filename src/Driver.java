
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<PokemonState> currentPokemon = new ArrayList<PokemonState>();
		OwnedPokemon OP = new OwnedPokemon();
		OP.pokemon();
		for(int a = 0; a < (OP.returnParty().size()); a++)
		{
			currentPokemon.add(OP.returnParty().get(a));
			
		}
		ArrayList<PokemonState> enemyPokemon = new ArrayList<PokemonState>();
		MapPrototype MP = new MapPrototype();
		MP.pokemon();
		enemyPokemon = MP.returnEnemy();
		
//		
//		while(true)
//		{
			FightController FC = new FightController();
			currentPokemon = FC.runBattle(currentPokemon, enemyPokemon);
			MP.pokemon();
//		}
	}	
	
}
