package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @BeforeAll
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory(); // Utilisez votre implémentation réelle de l'usine de dresseurs Pokémon
    }

    @Test
    public void testCreatePokemonTrainer() {
        Team team = Team.INSTINCT;
        String trainerName = "Ash";

        // Utilisez vos implémentations réelles des dépendances
        IPokedexFactory pokedexFactory = new PokedexFactory(); // Utilisez votre implémentation réelle de l'usine de Pokédex
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(); // Utilisez votre implémentation réelle du fournisseur de métadonnées Pokémon
        IPokemonFactory pokemonFactory = new PokemonFactory(); // Utilisez votre implémentation réelle de l'usine de Pokémon

        // Créez le Pokédex réel en utilisant les dépendances réelles
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        // Créez le dresseur de Pokémon en utilisant les dépendances réelles
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Assertions
        assertNotNull(pokemonTrainer);
        assertEquals(trainerName, pokemonTrainer.getName());
        assertEquals(team, pokemonTrainer.getTeam());
    }


}
