package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.item.domain.PokeBall;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.utils.RandomUtils;

/**
 * 포획률 = (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
 */
public class CatchingService {
  private static final double POKE_BALL = 1.0;
  private static final int TRAINER_BONUS = 1;

  private final Pokemon pokemon;
  private final Trainer trainer;
  private final PokeBall pokeBall;

  public CatchingService(final Pokemon pokemon, final Trainer trainer, final PokeBall pokeBall) {
    this.pokemon = pokemon;
    this.trainer = trainer;
    this.pokeBall = pokeBall;
  }

  public boolean isCaught() {
    return pokemon.getCaptureRate() <= calculate();
  }

  private double calculate() {
    return pokemon.getCaptureRate() * pokeBall.getMultiplier() * trainer.getBonus() * 100 / 255;
  }
}
