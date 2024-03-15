package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    List<PokemonMetadata> pokemonsMetadata;



    public PokemonMetadataProvider() {
        pokemonsMetadata = new ArrayList<>();
        pokemonsMetadata.add(new PokemonMetadata(0, "Bulbasaur",
                126, 126,
                90));
        pokemonsMetadata.add(new PokemonMetadata(25, "Pikachu",
                112, 101,
                70));

    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index >= 151)
        {
            throw new PokedexException("Index n'est pas valide");
        }
        else
        {for (PokemonMetadata pokemonMetadata : pokemonsMetadata) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        throw new PokedexException("PokemonMetaData n'est pas trouvé");
    }
}