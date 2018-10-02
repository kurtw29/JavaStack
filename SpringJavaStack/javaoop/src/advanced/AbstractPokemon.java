package advanced;

public abstract class AbstractPokemon implements PokemonInterface {
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon poke = new Pokemon(name, health, type);
		return poke;
	}
	
	public String pokemonInfo(Pokemon pokemon) {
		return pokemon.getName()+" health: "+pokemon.getHealth()+" type: "+pokemon.getType()+"."; 
	}
}
