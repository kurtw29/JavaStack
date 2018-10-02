package advanced;
import java.util.ArrayList;

public class Pokedex extends AbstractPokemon{
	ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon mon = super.createPokemon(name, health, type);
		myPokemons.add(mon);
		return mon;
	}

	public void listPokemon() {
		for(int i = 0; i < Pokemon.getCount(); i++) {
			System.out.println(this.pokemonInfo(myPokemons.get(i)));
		}		
	}
}
