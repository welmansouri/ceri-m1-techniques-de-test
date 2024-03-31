package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IRocketPokemonFactoryTest {
    private IPokemonFactory rocketPokemonFactory;
    private Pokemon pokemon1;

    @Before
    public void setUp() throws PokedexException {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon rocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 5);
        assertEquals(0, rocket.getIndex());
        assertEquals(613, rocket.getCp());
        assertEquals(64, rocket.getHp());
        assertEquals(4000, rocket.getDust());
        assertEquals(5, rocket.getCandy());

        // On vériie avec un nombre négative
        Pokemon rocket2 = rocketPokemonFactory.createPokemon(-1, 0, 0, 0, 0);
        assertEquals(rocket2.getIndex(), -1);
        assertEquals(rocket2.getName(), "Ash's Pikachu");
        assertEquals(rocket2.getAttack(), 1000);
        assertEquals(rocket2.getDefense(), 1000);
        assertEquals(rocket2.getStamina(), 1000);




    }


}