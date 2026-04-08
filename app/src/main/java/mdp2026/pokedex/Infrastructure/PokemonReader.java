package mdp2026.pokedex.Infrastructure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mdp2026.pokedex.Core.Pokemon;
import mdp2026.pokedex.utility.ResourceReader;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class PokemonReader extends ResourceReader {
    public ArrayList<Pokemon> leggiPokemon() {

        String json = leggiFile("data.json");

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Pokemon>>() {}.getType();

        return gson.fromJson(json, type);
    }
}
