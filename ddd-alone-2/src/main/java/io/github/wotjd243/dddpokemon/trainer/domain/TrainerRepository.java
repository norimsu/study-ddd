package io.github.wotjd243.dddpokemon.trainer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, String> {
}
