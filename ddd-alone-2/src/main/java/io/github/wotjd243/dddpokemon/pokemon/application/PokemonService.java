package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.item.application.ItemService;
import io.github.wotjd243.dddpokemon.item.domain.PokeBall;
import io.github.wotjd243.dddpokemon.pokemon.domain.*;
import io.github.wotjd243.dddpokemon.trainer.application.TrainerService;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
  private final PokemonRepository pokemonRepository;
  private final TrainerService trainerService;
  private final ItemService itemService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public PokemonService(final PokemonRepository pokemonRepository, final TrainerService trainerService, final ItemService itemService, final ApplicationEventPublisher applicationEventPublisher) {
    this.pokemonRepository = pokemonRepository;
    this.trainerService = trainerService;
    this.itemService = itemService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public Pokemon getPokemon(final int number) {
    return pokemonRepository.findById(NationalPokedexNumber.valueOf(number))
            .orElseThrow(IllegalArgumentException::new)
            ;
  }

  public void catchPokemon(final int number, final String trainerId, final long itemId) {
    final Pokemon pokemon = getPokemon(number);
    final Trainer trainer = trainerService.getTrainer(trainerId);
    final PokeBall pokeBall = itemService.getPokeBall(itemId);

    final CatchingService catchingService = new CatchingService(pokemon, trainer, pokeBall);
    if (catchingService.isCaught()) {
      applicationEventPublisher.publishEvent(new CaughtPokemonEvent(trainerId, pokemon.getNumber(), pokemon.getName(), true));
    }
  }
}
