package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexImplement implements IPokedex {

    private List<Pokemon> pokemonsList;
    
    private IPokemonFactory pokemonFactory;

    private PokemonMetadata pokemonMetadata;
    private IPokemonMetadataProvider pokemonMetadataProvider;

    public static int CAPACITY = 151;

    public PokedexImplement() {
        this.pokemonsList = new ArrayList<>(CAPACITY);
    }

    public PokedexImplement(IPokemonFactory pokemonFactory, IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonsList = new ArrayList<>(CAPACITY);

        this.pokemonMetadataProvider = pokemonMetadataProvider;

    }

    @Override
    public int size() {
        return this.pokemonsList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        for (Pokemon pokemon1 : pokemonsList) {
            if (pokemon1.getIndex() == pokemon.getIndex()) {
                
                throw new IllegalArgumentException("Pokemon existe déja");
            }
        }
        this.pokemonsList.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 ) {
            throw new PokedexException("Index non valide");
        } else {
            
            for (Pokemon pokemon : pokemonsList) {
                if (pokemon.getIndex() == id) {
                    return pokemon;
                }
            }
            
            throw new PokedexException("Pokemon n'et pas trouvé");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemonsList);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        this.pokemonsList.sort(order);
        return Collections.unmodifiableList(this.pokemonsList);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemonsNotComplet = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        try {
            this.pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(index);
            Pokemon PokemonComplet = new Pokemon(index, this.pokemonMetadata.getName(),
                    this.pokemonMetadata.getAttack(),
                    this.pokemonMetadata.getDefense(), this.pokemonMetadata.getStamina(),
                    
                    
                    pokemonsNotComplet.getCp(), pokemonsNotComplet.getHp(), pokemonsNotComplet.getDust(),
                    pokemonsNotComplet.getCandy(),
                    
                    
                    pokemonsNotComplet.getIv());
            
            
            this.pokemonsList.add(PokemonComplet);
            return PokemonComplet;
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {


        return this.pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
