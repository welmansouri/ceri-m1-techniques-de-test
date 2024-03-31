package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.RocketPokemonFactory;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class IRocketPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        RocketPokemonFactory factory = new RocketPokemonFactory();

        // Testing creation of Bulbasaur
        Pokemon bulbasaur = factory.createPokemon(1, 100, 50, 100, 10);
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertNotEquals(1000, bulbasaur.getAttack()); // Attack should not be default
        assertNotEquals(1000, bulbasaur.getDefense()); // Defense should not be default
        assertNotEquals(1000, bulbasaur.getStamina()); // Stamina should not be default
        assertEquals(1, bulbasaur.getIv(), 0); // IV should be 1

        // Testing creation of Ash's Pikachu
        Pokemon pikachu = factory.createPokemon(-1, 200, 60, 150, 20);
        assertEquals("Ash's Pikachu", pikachu.getName());
        assertEquals(1000, pikachu.getAttack()); // Attack should be default
        assertEquals(1000, pikachu.getDefense()); // Defense should be default
        assertEquals(1000, pikachu.getStamina()); // Stamina should be default
        assertEquals(0, pikachu.getIv(), 0); // IV should be 0

        // Testing creation of MISSINGNO
        Pokemon missingno = factory.createPokemon(0, 150, 40, 120, 15);
        assertEquals("MISSINGNO", missingno.getName());
        assertNotEquals(1000, missingno.getAttack()); // Attack should not be default
        assertNotEquals(1000, missingno.getDefense()); // Defense should not be default
        assertNotEquals(1000, missingno.getStamina()); // Stamina should not be default
        assertEquals(1, missingno.getIv(), 0); // IV should be 1

        // Testing creation with invalid index
        Pokemon invalidIndexPokemon = factory.createPokemon(10, 200, 60, 150, 20);
        assertEquals("MISSINGNO", invalidIndexPokemon.getName());
        assertNotEquals(1000, invalidIndexPokemon.getAttack()); // Attack should not be default
        assertNotEquals(1000, invalidIndexPokemon.getDefense()); // Defense should not be default
        assertNotEquals(1000, invalidIndexPokemon.getStamina()); // Stamina should not be default
        assertEquals(1, invalidIndexPokemon.getIv(), 0); // IV should be 1
    }

    @Test
    public void testGenerateRandomStat() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Method method = RocketPokemonFactory.class.getDeclaredMethod("generateRandomStat");
        method.setAccessible(true);
        int stat = (int) method.invoke(factory);
        assertNotNull(stat); // Ensure a value is generated
        assertNotEquals(0, stat); // Stat should not be 0
    }
}
