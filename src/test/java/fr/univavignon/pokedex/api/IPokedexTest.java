package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokedexTest {
    private IPokedex iPokedex;
    List<Pokemon> pokemons;
    @BeforeAll
    public void setUp() {
        //création d'un mock pour l'interface IPokedex
        this.iPokedex = mock(IPokedex.class);
        //créer une liste de pokemons pour tester les méthodes sur la liste des pokemons
        pokemons = Arrays.asList(
                new Pokemon(0,
                        "Bulbizarre", 130, 130,
                        100, 613, 64,
                        4000, 4, 0.91),
                new Pokemon(1,
                        "test", 140, 150,
                        110, 654, 54,
                        4000, 5, 0.90),

                new Pokemon(133, "Aquali", 186,
                        168, 260, 2729, 202
                        , 5000, 4, 0.91)
        );
    }


    @Test
    public void testSize() {
        when(this.iPokedex.size()).thenReturn(151);
        assertEquals(151, this.iPokedex.size());
    }




}
