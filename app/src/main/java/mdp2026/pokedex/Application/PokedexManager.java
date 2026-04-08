package mdp2026.pokedex.Application;

import mdp2026.pokedex.Infrastructure.PokemonReader;
import mdp2026.pokedex.Core.Pokedex;
import mdp2026.pokedex.Core.Pokemon;

import java.util.ArrayList;

public class PokedexManager {
    private Pokedex pokedex;
    private PokemonReader pokemonReader;

    public PokedexManager() {
        pokedex = new Pokedex();
        pokemonReader = new PokemonReader();
    }

    public void loadPokemon(){
        ArrayList<Pokemon> pokemonDalFile = pokemonReader.leggiPokemon();
        for(Pokemon pokemon : pokemonDalFile){
            pokemon.setFind(false);
        }
        pokedex.aggiungiTutti(pokemonDalFile);
    }


    public ArrayList<Pokemon> getPokedex() {
        return pokedex.getPokedex();
    }
}
