package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class IPokedexFactoryTest {


    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    @BeforeAll
    public void setUp() {
        this.pokedexFactory = new PokedexFactory();
        this.metadataProvider = new PokemonMetadataProvider();
        this.pokemonFactory = new PokemonFactory();
    }
    @Test
    public void testCreatePokedex() {
        IPokedex iPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(iPokedex);
    }

    @Test
    public void throwExceptionIfParamsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(null, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(null, pokemonFactory);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(metadataProvider, null);
        });
    }

    @Test
    public void testVerifPokedex() {
        IPokedex iPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(0, iPokedex.size());
    }




}
