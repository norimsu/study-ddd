package io.github.wotjd243.dddpokemon.item.application;

import io.github.wotjd243.dddpokemon.item.domain.PokeBall;
import io.github.wotjd243.dddpokemon.item.domain.PokeBallRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
  private final PokeBallRepository pokeBallRepository;

  public ItemService(PokeBallRepository pokeBallRepository) {
    this.pokeBallRepository = pokeBallRepository;
  }

  public PokeBall getPokeBall(final long id) {
    return pokeBallRepository.findById(id).orElseThrow(IllegalArgumentException::new);
  }
}
