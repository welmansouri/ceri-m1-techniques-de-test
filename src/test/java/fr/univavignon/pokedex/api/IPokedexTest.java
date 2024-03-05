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

    @Test
    void testAddPokemon() throws PokedexException {
        //tester ajouter un pokemon
        Pokemon pokemon = new Pokemon(3,
                "Poke", 129, 109,
                79, 614, 64,
                4001, 4, 0.94);
        when(this.iPokedex.addPokemon(pokemon)).thenReturn(3);
        int index = this.iPokedex.addPokemon(pokemon);
        //recuperer le pokemon ajouté
        when(this.iPokedex.getPokemon(index)).thenReturn(pokemon);
        Pokemon pokemonNew = this.iPokedex.getPokemon(index);
        //verification que le pokemon a bien été ajouté

        assertEquals("Poke", pokemonNew.getName());

    }

    @Test
    void testPokemonClass() throws PokedexException {
        //Find pokemon By index
        when(this.iPokedex.getPokemon(133)).thenReturn(new Pokemon(133, "Aquali", 186,
                168, 260, 2729, 202
                , 5000, 4, 0.91));
        Pokemon pokemon = this.iPokedex.getPokemon(133);
        //tester que le nom de Pokemon égale à Aquali

        assertEquals("Aquali", pokemon.getName());
        //tester que c'est bien un type Pokemon
        assertEquals(Pokemon.class, pokemon.getClass());
    }




}
