package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @BeforeAll
    public void setUp(){
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    }


    @Test
    public void testCreatePokemonTrainer() {
        Team team = Team.INSTINCT;
        String trainerName = "Ash";

        // Mock des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Définition du comportement attendu pour la création du Pokédex
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Définition du comportement attendu pour la création du dresseur
        when(pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory))
                .thenReturn(new PokemonTrainer(trainerName, team, pokedex));

        // Appel de la méthode de création du dresseur
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Assertions
        assertNotNull(pokemonTrainer);
        assertEquals(trainerName, pokemonTrainer.getName());
        assertEquals(team, pokemonTrainer.getTeam());
    }


    @Test
    public void testCreateWithNullParams() {
        Team team = Team.INSTINCT;
        String trainerName = "Ash";


        // Mock des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Définition du comportement attendu pour la création du Pokédex
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Définition du comportement attendu pour la création du dresseur avec des paramètres null
        when(pokemonTrainerFactory.createTrainer(null, team, pokedexFactory)).thenThrow(new IllegalArgumentException());
        when(pokemonTrainerFactory.createTrainer(trainerName, null, pokedexFactory)).thenThrow(new IllegalArgumentException());
        when(pokemonTrainerFactory.createTrainer(trainerName, team, null)).thenThrow(new IllegalArgumentException());

        // Assertions pour chaque cas où un paramètre est null
        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer(null, team, pokedexFactory));
        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer(trainerName, null, pokedexFactory));
        assertThrows(IllegalArgumentException.class, () -> pokemonTrainerFactory.createTrainer(trainerName, team, null));
    }
    @Test
    public void testCreateTrainer() {
        // Création d'un faux IPokedexFactory
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Création de la PokemonTrainerFactory
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        // Création de l'entraîneur Pokémon avec la factory
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Vérification des valeurs de l'entraîneur créé
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
    }


}
