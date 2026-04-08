package mdp2026.pokedex.core;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> pokemons;

    public Pokedex() {
        this.pokemons = new ArrayList<>();
    }

    public ArrayList<Pokemon> getFindPokemons() {
        ArrayList<Pokemon> foundPokemons = new ArrayList<>();
        for(Pokemon p : pokemons) {
            if(p.getFind())
                foundPokemons.add(p);
        }
        return foundPokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon.getId(), pokemon);
        pokemons.get(pokemon.getId()).setFind(true);
    }

    public String getPokemonNameById(int id) {
        if(id < 1 || id > 155) throw new IndexOutOfBoundsException("Pokemon id out of bounds");
        return pokemons.get(id).dettaglio();
    }

    public void aggiungiTutti(ArrayList<Pokemon> pokemon) {
        for(Pokemon p : pokemon) {
            pokemons.add(p.getId(), p);
        }
    }

    public ArrayList<Pokemon> getPokedex() {
        return pokemons;
    }
}
