package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        this.pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        // Appelez directement la méthode createPokemon() de votre classe
        Pokemon pokemon = this.pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        // Effectuez vos assertions sur le résultat
        assertEquals(133, pokemon.getIndex());


        // Ajoutez d'autres assertions si nécessaire
    }

    // Testez d'autres méthodes de votre PokemonFactory si nécessaire



    // Test la création d'un pokemon avec les bonnes valeurs
    @Test
    public void testcreatePokemonShouldReturnCorrectPokemon() throws PokedexException {
        Pokemon pokemon = this.pokemonFactory.createPokemon(0, 614, 70,
                4000, 5);

        assertEquals(614, pokemon.getCp());
        assertEquals(70, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(0, pokemon.getIndex());

        assertEquals(5, pokemon.getCandy());

    }


}



