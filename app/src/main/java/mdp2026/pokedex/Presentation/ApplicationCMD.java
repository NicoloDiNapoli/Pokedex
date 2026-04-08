package mdp2026.pokedex.Presentation;

import mdp2026.pokedex.Application.PokedexManager;
import mdp2026.pokedex.Core.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationCMD {

    private PokedexManager gestore = new PokedexManager();
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Pokemon> pokedex;
    private boolean[] scoperti = new boolean[156]; // 1-155

    private int stato = 0; // 0 = menu, 1 = dettaglio
    private int pokemonCorrente = -1;

    public void avvia() {


    }

    // ================= MENU GENERALE =================

    private void menuGenerale() {

        System.out.println("\n--- MENU GENERALE ---");
        System.out.println("Comandi:");
        System.out.println("1-155 -> apri Pokémon");
        System.out.println("search <nome>");
        System.out.println("exit");

        System.out.print("> ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Uscita...");
            System.exit(0);
        }

        if (input.startsWith("search")) {
            cercaPokemon(input);
            return;
        }

        try {
            int id = Integer.parseInt(input);

            if (id < 1 || id > 155) {
                System.out.println("ID non valido (1-155)");
                return;
            }

            apriPokemon(id);

        } catch (NumberFormatException e) {
            System.out.println("Comando non valido");
        }
    }

    // ================= DETTAGLIO =================

    private void dettaglioPokemon() {

        Pokemon p = getPokemonById(pokemonCorrente);

        if (p == null) {
            stato = 0;
            return;
        }

        scoperti[pokemonCorrente] = true;

        System.out.println("\n=== DETTAGLIO POKEMON ===");
        p.dettaglio();
        System.out.println("\nComandi:");
        System.out.println("next | prev | back | exit");

        System.out.print("> ");
        String input = scanner.nextLine();

        switch (input.toLowerCase()) {

            case "back":
                stato = 0;
                break;

            case "next":
                pokemonCorrente = getSuccessivoScoperto(pokemonCorrente);
                break;

            case "prev":
                pokemonCorrente = getPrecedenteScoperto(pokemonCorrente);
                break;

            case "exit":
                System.exit(0);
                break;

            default:
                System.out.println("Comando non valido");
        }
    }

    // ================= LOGICA =================

    private void apriPokemon(int id) {
        pokemonCorrente = id;
        scoperti[id] = true;
        stato = 1;
    }

    private Pokemon getPokemonById(int id) {
        for (Pokemon p : pokedex) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private void cercaPokemon(String input) {

        String nome = input.substring(6).trim();

        boolean trovato = false;

        for (Pokemon p : pokedex) {
            if (scoperti[p.getId()] &&
                    p.getNome().equalsIgnoreCase(nome)) {

                System.out.println("TROVATO:");
                p.dettaglio();
                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Nessun Pokémon trovato tra quelli scoperti");
        }
    }

    private int getSuccessivoScoperto(int attuale) {

        for (int i = attuale + 1; i <= 155; i++) {
            if (scoperti[i]) return i;
        }

        for (int i = 1; i <= attuale; i++) {
            if (scoperti[i]) return i;
        }

        return attuale;
    }

    private int getPrecedenteScoperto(int attuale) {

        for (int i = attuale - 1; i >= 1; i--) {
            if (scoperti[i]) return i;
        }

        for (int i = 155; i >= attuale; i--) {
            if (scoperti[i]) return i;
        }

        return attuale;
    }
}