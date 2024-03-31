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
        PokemonFactory p = new PokemonFactory();
        // Appelez directement la méthode createPokemon() de votre classe
        Pokemon pokemon = p.createPokemon(133, 2729, 202, 5000, 4);

        // Effectuez vos assertions sur le résultat
        assertEquals(133, pokemon.getIndex());


    }

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

    @Test
    public void testCreatePokemonSecond() {
        PokemonFactory factory = new PokemonFactory();

        // Création d'un Pokémon avec des valeurs spécifiques
        Pokemon pokemon = factory.createPokemon(4, 100, 50, 100, 10);

        // Vérification des valeurs du Pokémon créé
        assertEquals(4, pokemon.getIndex());
        assertEquals("", pokemon.getName()); // Le nom est vide dans l'implémentation actuelle
        assertEquals(0, pokemon.getAttack()); // Valeur incorrecte pour l'attaque
        assertEquals(0, pokemon.getDefense());
        assertEquals(0, pokemon.getStamina());
        assertEquals(100, pokemon.getCp());
        assertEquals(50, pokemon.getHp());
        assertEquals(100, pokemon.getDust());
        assertEquals(10, pokemon.getCandy());
        assertEquals(0, pokemon.getIv(), 0);
    }


}



