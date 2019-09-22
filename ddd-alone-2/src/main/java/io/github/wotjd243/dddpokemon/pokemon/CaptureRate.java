package io.github.wotjd243.dddpokemon.pokemon;

import org.hibernate.boot.archive.scan.spi.ScanParameters;

public class CaptureRate {
  private int captureRate;

  public CaptureRate(int captureRate) {
    this.captureRate = captureRate;
  }

  int get() {
    return captureRate;
  }

  boolean isCaught(final int number) {
    return captureRate <= number;
  }

  CaptureRate change(int number) {
    this.captureRate = number;
    return this;
  }
}
