package io.github.wotjd243.dddpokemon.pokemon.ui;


import io.github.wotjd243.dddpokemon.pokemon.application.PokemonService;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonRestController {
  private final PokemonService pokemonService;

  public PokemonRestController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  /**
   * localhost:8080/pokemon/1
   */
  @GetMapping("/pokemon/{number}")
  public Pokemon getPokemon(@PathVariable(name = "number") int number) {
    return pokemonService.getPokemon(number);
  }
}
