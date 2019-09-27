package io.github.wotjd243.dddpokemon.trainer.application;

import io.github.wotjd243.dddpokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.trainer.domain.TrainerRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TrainerService {
  private final TrainerRepository trainerRepository;

  public TrainerService(TrainerRepository trainerRepository) {
    this.trainerRepository = trainerRepository;
  }

  @Transactional
  public void join(final String id) {
    final Trainer trainer = new Trainer(id);
    trainerRepository.save(trainer);
  }

  @EventListener(condition = "#event.caught")
  @Transactional
  public void registerNewPokemon(final CaughtPokemonEvent event) {
    final Trainer trainer = getTrainer(event.getTrainerId());
    trainer.registerNewPokemon(event.getPokedexNumber(), event.getNickname());
  }

  public Trainer getTrainer(String id) {
    return trainerRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new)
            ;
  }
}
