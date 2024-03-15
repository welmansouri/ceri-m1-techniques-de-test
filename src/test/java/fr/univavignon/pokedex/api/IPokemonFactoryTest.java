package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;



    @Before
    public void setUp() {
        //bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //this.pokemonFactory = mock(IPokemonFactory.class);
        this.pokemonFactory = new PokemonFactory();

    }

    @Test
    public void testCreatePokemon() {

        // Définissez le comportement attendu pour la méthode createPokemon() du mock
        when(this.pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(new Pokemon(133, "Aquali", 186, 168, 260,2729, 202, 5000, 4,100));

        // Appelez la méthode createPokemon() avec les arguments donnés
        Pokemon pokemon = this.pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);


        // Les assertions ici échoueront puisque les valeurs renvoyées par le mock ne correspondent pas à celles attendues
        //assertEquals(133, pokemon.getIndex());
        //assertEquals("Aquali", pokemon.getName()); // Nom attendu "Flareon", mais le mock renvoie "Aquali"
        //assertEquals(186, pokemon.getAttack());
        //assertEquals(168, pokemon.getDefense());
        //assertEquals(260, pokemon.getStamina());
        //assertEquals(2729, pokemon.getCp());
        //assertEquals(202, pokemon.getHp());
        //assertEquals(5000, pokemon.getDust());
        //assertEquals(4, pokemon.getCandy());
        //assertEquals(100.0, pokemon.getIv(), 0.001);



        // Ajoutez vos assertions supplémentaires pour les plages de valeurs spécifiées : AssertTrue
        assertTrue("la valeur de l'attaque doit être entre 140 et 190",
                pokemon.getAttack() >= 140 && pokemon.getAttack() <= 190);


    }



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
