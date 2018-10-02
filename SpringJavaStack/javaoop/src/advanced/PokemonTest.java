package advanced;

public class PokemonTest {
	
	public static void main(String[] args) {		
		Pokedex test = new Pokedex();
		
		Pokemon pika = test.createPokemon("pika",50, "electric");
		Pokemon rika = test.createPokemon("rika",50, "stone");
		System.out.println(test.pokemonInfo(pika));
		pika.attackPokemon(rika);
		System.out.println(test.pokemonInfo(rika));
		test.listPokemon();
	}
	
}
