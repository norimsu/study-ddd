package io.github.wotjd243.dddpokemon.item.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PokeBall {
    @Id
    private Long id;
    private String name;
    private double multiplier;

    protected PokeBall() {
    }

    public PokeBall(Long id, String name, double multiplier) {
        this.id = id;
        this.name = name;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
