package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.RocketPokemonFactory;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class IRocketPokemonFactoryTest {
    private IPokemonFactory factory;
    @Before
    public void setUp() throws PokedexException {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        RocketPokemonFactory factory = new RocketPokemonFactory();

        // Testing creation of Bulbasaur
        Pokemon bulbasaur = factory.createPokemon(1, 100, 50, 100, 10);
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertNotEquals(1000, bulbasaur.getAttack());
        assertNotEquals(1000, bulbasaur.getDefense());
        assertNotEquals(1000, bulbasaur.getStamina());
        assertEquals(1, bulbasaur.getIv(), 0);

        // Testing creation of Ash's Pikachu
        Pokemon pikachu = factory.createPokemon(-1, 200, 60, 150, 20);
        assertEquals("Ash's Pikachu", pikachu.getName());
        assertEquals(1000, pikachu.getAttack());
        assertEquals(1000, pikachu.getDefense());
        assertEquals(1000, pikachu.getStamina()); // Stamina should be default
        assertEquals(0, pikachu.getIv(), 0); // IV should be 0

        // Testing creation of MISSINGNO
        Pokemon missingno = factory.createPokemon(0, 150, 40, 120, 15);
        assertEquals("MISSINGNO", missingno.getName());
        assertNotEquals(1000, missingno.getAttack());
        assertNotEquals(1000, missingno.getDefense());
        assertNotEquals(1000, missingno.getStamina()); // Stamina should not be default
        assertEquals(1, missingno.getIv(), 0);

        // Testing creation with invalid index
        Pokemon invalidIndexPokemon = factory.createPokemon(10, 200, 60, 150, 20);
        assertEquals("MISSINGNO", invalidIndexPokemon.getName());
        assertNotEquals(1000, invalidIndexPokemon.getAttack());
        assertNotEquals(1000, invalidIndexPokemon.getDefense());
        assertNotEquals(1000, invalidIndexPokemon.getStamina());
        assertEquals(1, invalidIndexPokemon.getIv(), 0);
    }

    @Test
    public void testGenerateRandomStat() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = RocketPokemonFactory.class.getDeclaredMethod("generateRandomStat");
        method.setAccessible(true);
        int stat = (int) method.invoke(factory);
        assertNotNull(stat);
        assertNotEquals(0, stat);
    }
}
