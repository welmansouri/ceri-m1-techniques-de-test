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
        assertNull(iPokedex);
    }

    @Test
    public void testCreatePokedexWithZeroSize() {
        when(this.pokedexFactory.createPokedex(this.metadataProvider, this.pokemonFactory)).
                thenReturn(mock(IPokedex.class));
        IPokedex iPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotEquals(null, iPokedex);
        when(iPokedex.size()).thenReturn(0);
        assertEquals(0, iPokedex.size());
    }
}
