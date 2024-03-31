package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IRocketPokemonFactoryTest {
    private IPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() throws PokedexException {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon rocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, rocket.getIndex());
        assertEquals(613, rocket.getCp());
        assertEquals(64, rocket.getHp());
        assertEquals(4000, rocket.getDust());
        assertEquals(4, rocket.getCandy());

        // Verifier avec un index inferieur à 0
        Pokemon rocket2 = rocketPokemonFactory.createPokemon(-1, 0, 0, 0, 0);

        assertEquals(rocket2.getIndex(), -1);
        assertEquals(rocket2.getName(), "Ash's Pikachu");
        assertEquals(rocket2.getAttack(), 1000);
        assertEquals(rocket2.getDefense(), 1000);
        assertEquals(rocket2.getStamina(), 1000);
        assertEquals(rocket2.getCp(), 0);
        assertEquals(rocket2.getHp(), 0);
        assertEquals(rocket2.getDust(), 0);
        assertEquals(rocket2.getCandy(), 0);
        assertEquals(rocket2.getIv(), 0, 0);


        Pokemon missingno = rocketPokemonFactory.createPokemon(0, 0, 0, 0, 0);
        assertEquals(missingno.getName(), "MISSINGNO");

        missingno = rocketPokemonFactory.createPokemon(1000, 0, 0, 0, 0);
        assertEquals(missingno.getName(), "MISSINGNO");

        Pokemon Bulbasaur= rocketPokemonFactory.createPokemon(1, 0, 0, 0, 0);
        assertEquals(Bulbasaur.getName(), "Bulbasaur");

    }


}