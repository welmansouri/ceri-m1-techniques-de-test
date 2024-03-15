package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;


    @BeforeAll
    public void setUp() {
        metadataProvider =new PokemonMetadataProvider();
    }



    @Test
    public void testMetaDataShouldBeCorrectlyRetrievedBulbizarre() throws PokedexException {
        // Vérification des informations récupérées pour Bulbizarre
        PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
    }

    @Test
    public void testMetaDataShouldBeCorrectlyRetrievedPikachu() throws PokedexException {
        PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(25);
        assertEquals("Pikachu", pokemonMetadata.getName());
        assertEquals(112, pokemonMetadata.getAttack());
        assertEquals(101, pokemonMetadata.getDefense());
        assertEquals(70, pokemonMetadata.getStamina());
    }

    @Test
    public void testMetaDataShouldThrowPokemonException() {
        // Vérification du lancement de l'exception pour un index invalide (151)
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(151);
        });
    }

    @Test
    public void testMetaDataShouldThrowPokemonExceptionNegativeIndex() {
        // Vérification du lancement de l'exception pour un index négatif (-1)
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(-1);
        });
    }

    @Test
    public void testMetaDataShouldThrowPokemonExceptionWhenPokemonNotFound() {
        // Vérifie le lancement de l'exception pour un Pokémon non présent dans la liste
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(10); // Un index qui n'existe pas dans la liste
        });
    }

    @Test
    public void testMetaDataShouldThrowPokemonExceptionWhenInvalidIndex() {
        // Vérifie le lancement de l'exception pour un index inconnu (par exemple 1000)
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(1000);
        });
    }

}