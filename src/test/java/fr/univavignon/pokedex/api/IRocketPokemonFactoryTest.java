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
        pokemon1 = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon rocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 5);
        assertEquals(pokemon1.getIndex(), rocket.getIndex());
        assertEquals(pokemon1.getCp(), rocket.getCp());
        assertEquals(pokemon1.getHp(), rocket.getHp());
        assertEquals(pokemon1.getDust(), rocket.getDust());
        assertEquals(pokemon1.getCandy(), rocket.getCandy());

        // On vériie avec un nombre négative
        Pokemon rocket1 = rocketPokemonFactory.createPokemon(-1, 0, 0, 0, 0);
        assertEquals(rocket1.getIndex(), -1);
        assertEquals(rocket1.getName(), "Ash's Pikachu");
        assertEquals(rocket1.getAttack(), 1000);

        assertEquals(rocket1.getDefense(), 1000);
        assertEquals(rocket1.getStamina(), 1000);
        assertEquals(rocket1.getCp(), 0);
        assertEquals(rocket1.getHp(), 0);
        assertEquals(rocket1.getDust(), 0);
        assertEquals(rocket1.getCandy(), 0);
        assertEquals(rocket1.getIv(), 0, 0);
        // Create MISSINGNO

        Pokemon rocketmissingno = rocketPokemonFactory.createPokemon(0, 0, 0, 0, 0);
        assertEquals(rocketmissingno.getName(), "MISSINGNO");

        rocketmissingno = rocketPokemonFactory.createPokemon(1000, 0, 0, 0, 0);
        assertEquals(rocketmissingno.getName(), "MISSINGNO");

        // Create Bulbasaur

        Pokemon Bulbasaur= rocketPokemonFactory.createPokemon(1, 0, 0, 0, 0);
        assertEquals(Bulbasaur.getName(), "Bulbasaur");




    }


}