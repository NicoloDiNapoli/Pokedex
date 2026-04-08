package mdp2026.pokedex.Core;

import javax.annotation.Nullable;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    @Nullable
    private String type2;
    private float height;
    private float weight;
    private boolean find = false;

    public Pokemon(Pokemon pokemon) {
        this.id = pokemon.id;
        this.name = pokemon.name;
        this.type = pokemon.type;
        this.type2 = pokemon.type2;
        this.height = pokemon.height;
        this.weight = pokemon.weight;
        this.find = true;
    }

    public Pokemon(int id, String name, String type, String type2, float height, float weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.type2 = type2;
        this.height = height;
        this.weight = weight;
        this.find = false;
    }

    public String dettaglio(){
        if(!find){find = true;}
        String dettaglio = "";
        dettaglio = "Il pokemon " + this.name + " , è un pokemon di tipo " + this.type;
        if (type2 != null) {
            dettaglio = dettaglio + " e di tipo " + type2;
        }
        dettaglio = dettaglio + " , ha un altezza di " + this.height + " e un peso di " + this.weight;
        return dettaglio;
    }

    public boolean getFind() {return find;}

    public int getId() {return id;}

    public void setFind(boolean b) {this.find = b;}

    public String getNome() {
        return name;
    }
}
