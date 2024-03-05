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
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Définir le comportement attendu pour le mock
        when(this.metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,
                "Bulbizarre", 126, 126, 90));
        // Appeler la méthode à tester
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        // Vérifier si les résultats sont conformes aux attentes
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(1, metadata.getIndex());
        assertEquals(45, metadata.getAttack());
        assertEquals(49, metadata.getAttack());
        assertEquals(49, metadata.getAttack());
    }


}