package tech.dumpsterfire.feats.of.strength.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.dumpsterfire.feats.of.strength.model.PlayerEntity;

@Repository
public interface PlayersRepository extends JpaRepository<PlayerEntity, Long> {
}
