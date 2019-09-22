package io.github.wotjd243.dddpokemon.pokemon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {
  @DisplayName("포켓몬 생성")
  @Test
  void create() {
    // given
    // when
    // then
    new Pokemon(1, "이상해씨", 45);
  }

  @DisplayName("계산된 포확률이 포켓몬의 포획률 보다 높을 때")
  @ParameterizedTest
  @ValueSource(ints = {100, 75, 50})
  void isCaught_Should_be_true(final int number) {
    // given
    final Pokemon pokemon = new Pokemon(1, "이상해씨", 45);
    // when1
    final boolean caught = pokemon.isCaught(number);
    // then
    assertThat(caught).isTrue();
  }
}