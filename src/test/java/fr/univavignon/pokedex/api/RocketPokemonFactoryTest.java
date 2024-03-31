package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RocketPokemonFactoryTest {
    IPokemonFactory pokemonFactory = new RocketPokemonFactory();
    @BeforeEach
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testPokemonNullWhenCombatLvlNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, -1, 0, 0, 0));
    }

    @Test
    public void testPokemonNullWhenDustNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, -1, 0));
    }

    @Test
    public void testPokemonNullWhenHealthPointsNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, -1, 0, 0));
    }

    @Test
    public void testPokemonNullWhenCandiesAmountNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, 0, -1));
    }

    @Test
    public void testPokemonNullWhenIndexNegative() {
        assertNull(this.pokemonFactory.createPokemon(-1, 0, 0, 0, 0));
    }

    @Test
    public void testPokemonNullWhenIndexGreaterThan150() {
        assertNull(this.pokemonFactory.createPokemon(151, 0, 0, 0, 0));
    }

    @Test
    public void testPokemonCorrectlyCreated() {
        int index = 0;
        int cp = 50;
        int hp = 50;
        int dust = 80;
        int candy = 3;
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(0, pokemon.getIv());
    }
}