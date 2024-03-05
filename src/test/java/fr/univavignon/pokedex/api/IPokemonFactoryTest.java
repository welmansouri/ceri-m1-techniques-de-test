package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        this.pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {

        // Définissez le comportement attendu pour la méthode createPokemon() du mock
        when(this.pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(new Pokemon(133, "Aquali", 186, 168, 260,2729, 202, 5000, 4,100));

        // Appelez la méthode createPokemon() avec les arguments donnés
        Pokemon pokemon = this.pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);


        // Les assertions ici échoueront puisque les valeurs renvoyées par le mock ne correspondent pas à celles attendues
        assertEquals(133, pokemon.getIndex());
        assertEquals("Flareon", pokemon.getName()); // Nom attendu "Flareon", mais le mock renvoie "Aquali"
        assertEquals(186, pokemon.getAttack());
        assertEquals(168, pokemon.getDefense());
        assertEquals(260, pokemon.getStamina());
        assertEquals(2729, pokemon.getCp());
        assertEquals(202, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(100.0, pokemon.getIv(), 0.001);

    }
}
