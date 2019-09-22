package io.github.wotjd243.dddpokemon.pokemon;

public class Pokemon {
  private final NationalPokedexNumber number;
  private final String name;
  private CaptureRate captureRate;

  public Pokemon(final int number, final String name, final int captureRate) {
    this.number = NationalPokedexNumber.from(number);
    this.name = name;
    this.captureRate = new CaptureRate(captureRate);
  }

  public boolean isCaught(final int number) {
    return this.captureRate.isCaught(number);
  }

  public void changeCaptureRate(final int number) {
    // 1
    this.captureRate = new CaptureRate(number);
    // 2
    this.captureRate = this.captureRate.change(number);
    // this.captureRate.change(number);
  }

  public int getNumber() {
    return number.get();
  }
}
