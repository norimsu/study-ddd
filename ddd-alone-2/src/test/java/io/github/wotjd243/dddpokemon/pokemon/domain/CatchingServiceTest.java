package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.item.domain.PokeBall;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CatchingServiceTest {
  private static final Pokemon TEST_POKEMON_EASY_TO_CATCH = new Pokemon(10, "캐터피", 255);
  private static final Pokemon TEST_POKEMON_HARD_TO_CATCH = new Pokemon(150, "뮤츠", 3);
  private static final Trainer TEST_TRAINER = new Trainer("jason");
  private static final PokeBall TEST_POKEBALL_MASTERBALL = new PokeBall(1L, "마스터볼", 255);
  private static final PokeBall TEST_POKEBALL_HYPERBALL = new PokeBall(2L, "하이퍼볼", 2.0);
  private static final PokeBall TEST_POKEBALL_SUPERRBALL = new PokeBall(3L, "슈퍼볼", 1.5);
  private static final PokeBall TEST_POKEBALL_MONSTERRBALL = new PokeBall(4L, "몬스터볼", 1.0);

  @DisplayName("마스터볼을 던지만 무조건 잡힌다.")
  @Test
  void isCaught_True() {
    // given
    final CatchingService catchingService = new CatchingService(TEST_POKEMON_HARD_TO_CATCH, TEST_TRAINER, TEST_POKEBALL_MASTERBALL);

    // when
    final boolean caught = catchingService.isCaught();

    // then
    assertThat(caught).isTrue();
  }

  @DisplayName("무조건 잡히지 않는 경우")
  @Test
  void isCaught_False() {
    // given
    final CatchingService catchingService = new CatchingService(TEST_POKEMON_HARD_TO_CATCH, TEST_TRAINER, TEST_POKEBALL_MONSTERRBALL);

    // when
    final boolean caught = catchingService.isCaught();

    // then
    assertThat(caught).isFalse();
  }

}