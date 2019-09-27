package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.Name;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PokemonTranslator {
  private static final int LANGUAGE_KOREAN_ID = 3;

  public Optional<Pokemon> translate(final PokemonSpecies pokemonSpecies) {
    return Optional.of(new Pokemon(pokemonSpecies.getId(), getName(pokemonSpecies.getNames()), pokemonSpecies.getCaptureRate()));
  }
  private String getName(final List<Name> names) {
    return names.stream()
            .filter(name -> name.getLanguage().getId() == LANGUAGE_KOREAN_ID)
            .findAny()
            .map(Name::getName)
            .orElse("no name")
            ;
  }
}
