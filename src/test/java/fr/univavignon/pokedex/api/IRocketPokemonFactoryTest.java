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

    }


}
