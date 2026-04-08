package mdp2026.pokedex.utility;

public class PokemonReader extends ResourceReader{
    @Override
    protected String leggiFile(String nomeFile) {
        return super.leggiFile("/resource/data.json");
    }
}
