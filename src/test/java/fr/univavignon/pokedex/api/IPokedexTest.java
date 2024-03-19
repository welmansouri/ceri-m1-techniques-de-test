package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokedexTest {
    private IPokedex iPokedex;
    List<Pokemon> pokemons;
    @BeforeAll
    public void setUp() {
        //création d'un mock pour l'interface IPokedex
        this.iPokedex = mock(IPokedex.class);
        //créer une liste de pokemons pour tester les méthodes sur la liste des pokemons
        pokemons = Arrays.asList(
                new Pokemon(0,
                        "Bulbizarre", 130, 130,
                        100, 613, 64,
                        4000, 4, 0.91),
                new Pokemon(1,
                        "test", 140, 150,
                        110, 654, 54,
                        4000, 5, 0.90),

                new Pokemon(133, "Aquali", 186,
                        168, 260, 2729, 202
                        , 5000, 4, 0.91)
        );
    }


    @Test
    public void testSize() {
        when(this.iPokedex.size()).thenReturn(151);
        assertEquals(151, this.iPokedex.size());
    }

    @Test
    void testAddPokemon() throws PokedexException {
        //tester ajouter un pokemon
        Pokemon pokemon = new Pokemon(3,
                "Poke", 129, 109,
                79, 614, 64,
                4001, 4, 0.94);

        when(this.iPokedex.addPokemon(pokemon)).thenReturn(3);
        int index = this.iPokedex.addPokemon(pokemon);
        //recuperer le pokemon ajouté
        when(this.iPokedex.getPokemon(index)).thenReturn(pokemon);
        Pokemon pokemonNew = this.iPokedex.getPokemon(index);
        //verification que le pokemon a bien été ajouté

        assertEquals("Poke", pokemonNew.getName());

    }

    @Test
    void testPokemonClass() throws PokedexException {
        //Find pokemon By index
        when(this.iPokedex.getPokemon(133)).thenReturn(new Pokemon(133, "Aquali", 186,
                168, 260, 2729, 202
                , 5000, 4, 0.91));
        Pokemon pokemon = this.iPokedex.getPokemon(133);
        //tester que le nom de Pokemon égale à Aquali

        assertEquals("Aquali", pokemon.getName());
        //tester que c'est bien un type Pokemon
        assertEquals(Pokemon.class, pokemon.getClass());
    }


    @Test
    void getPokemons() {
        when(this.iPokedex.getPokemons()).thenReturn(pokemons);
        List<Pokemon> pokemons = this.iPokedex.getPokemons();
        //Vérifier que la liste n'est pas null!!!
        assertNotNull(pokemons);
        //Vérifier que la taille de la liste!!!

        assertEquals(3, pokemons.size());
        try{
            pokemons.add(new Pokemon(4,
                    "Wafae", 128, 108,
                    78, 613, 64,
                    4000, 4, 0.91));
            fail("On peut pas modifier la liste ");
        } catch (UnsupportedOperationException e) {
        }
        //Vérifié que l'élément n'a pas été ajouté à la liste
        assertEquals(3, pokemons.size());
    }



    @Test
    public void testPokemonsSortedByName() {
        // Créer une liste de Pokemons non triée
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 0.91),
                new Pokemon(0, "Bulbizarre", 130, 130, 100, 613, 64, 4000, 4, 0.91),
                new Pokemon(1,
                        "test", 140, 150,
                        110, 654, 54,
                        4000, 5, 0.90),
                new Pokemon(3,
                        "Poke", 129, 109,
                        79, 614, 64,
                        4001, 4, 0.94)
        );

        // Définir le comportement attendu de iPokedex.getPokemons(PokemonComparators.NAME)
        when(iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);

        // Appeler iPokedex.getPokemons(PokemonComparators.NAME) dans votre code
        List<Pokemon> sortedPokemons = iPokedex.getPokemons(PokemonComparators.NAME);

        // Vérifier que la liste ne peut pas être modifiée
        assertThrows(UnsupportedOperationException.class, () -> {
            sortedPokemons.add(new Pokemon(8, "TestTest", 128, 108, 78, 613, 64, 4000, 4, 0.91));
        });

        // Vérifier que la liste est triée par nom
        assertEquals("Aquali", sortedPokemons.get(0).getName());
        assertEquals("Bulbizarre", sortedPokemons.get(1).getName());
        assertEquals("test", sortedPokemons.get(2).getName());
        assertEquals("Poke", sortedPokemons.get(3).getName());
    }


    @Test
    void testGetPokemonsNonModifiable() {
        IPokedex pokedex = new PokedexImplement();

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertThrows(UnsupportedOperationException.class, () -> {
            pokemons.add(new Pokemon(2, "wafae", 199, 201, 140, 610, 60, 4000, 4, 0.91));
        });
    }

    @Test
    void createPokemonTest() throws PokedexException {

        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "wafae", 136, 122, 80, 612, 64, 4000, 5, 0.91));

        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "wafae", 136, 122, 80));

        IPokedex pokedex = new PokedexImplement(pokemonFactory, pokemonMetadataProvider);

        Pokemon createdPokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);

        assertEquals("wafae", createdPokemon.getName());

    }


    @Test
    void getTestPokemonMetadata() throws PokedexException {

        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "wafae", 127, 127, 100));


        IPokedex pokedex = new PokedexImplement(pokemonFactory, pokemonMetadataProvider);


        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(0);


        assertEquals("wafae", pokemonMetadata.getName());
        assertEquals(127, pokemonMetadata.getAttack());

    }



    @Test
    public void getPokemonThrowsPokedexExceptionTest() throws PokedexException {
        when(this.iPokedex.getPokemon(0)).thenThrow(new PokedexException("Erreur : Pokemon non trouvé "));

        assertThrows(PokedexException.class, () -> {
            this.iPokedex.getPokemon(0);
        });
    }

    @Test
    public void testGetPokemonThrowsPokedexException() throws PokedexException {
        when(this.iPokedex.getPokemon(151)).thenThrow(new PokedexException("Error : Pokemon non trouvé !"));
        assertThrows(PokedexException.class, () -> {
            this.iPokedex.getPokemon(151);
        });
    }


}
