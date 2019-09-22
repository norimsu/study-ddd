package io.github.wotjd243.dddpokemon.pokemon;

import java.util.Objects;

public class NationalPokedexNumber {
  public static final int MINIMUM_NUMBER = 1;
  public static final int MAXIMUM_NUMBER = 151;
  final int number;

  private NationalPokedexNumber(final int number) {
    validate(number);
    this.number = number;
  }

  static NationalPokedexNumber from(final int nubmer) {
    return new NationalPokedexNumber(nubmer);
  }

  private void validate(final int number) {
    if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NationalPokedexNumber that = (NationalPokedexNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  public int get() {
    return number;
  }
}
