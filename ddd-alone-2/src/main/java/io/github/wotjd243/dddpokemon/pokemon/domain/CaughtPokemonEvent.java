package io.github.wotjd243.dddpokemon.pokemon.domain;

public class CaughtPokemonEvent {
  private final String trainerId;
  private final int pokedexNumber;
  private final String nickname;
  private final boolean caught;

  public CaughtPokemonEvent(String trainerId, int pokedexNumber, String nickname, boolean caught) {
    this.trainerId = trainerId;
    this.pokedexNumber = pokedexNumber;
    this.nickname = nickname;
    this.caught = caught;
  }

  public String getTrainerId() {
    return trainerId;
  }

  public int getPokedexNumber() {
    return pokedexNumber;
  }

  public String getNickname() {
    return nickname;
  }

  public boolean isCaught() {
    return caught;
  }
}
