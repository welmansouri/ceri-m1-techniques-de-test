package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    PokemonTrainer pokemonTrainer;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        pokemonTrainer = new PokemonTrainer("Trainer", Team.INSTINCT, pokedex);
    }

    @Test
    public void shouldGetTrainer() {
        PokemonTrainer testTrainer = pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory);

        assertEquals(pokemonTrainer.getName(), testTrainer.getName());
        assertEquals(pokemonTrainer.getTeam(), testTrainer.getTeam());
        assertEquals(pokemonTrainer.getPokedex().size(), testTrainer.getPokedex().size());
        assertEquals(pokemonTrainer.getPokedex().getPokemons(), testTrainer.getPokedex().getPokemons());
    }


}