package tech.dumpsterfire.feats.of.strength.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tech.dumpsterfire.feats.of.strength.model.PlayerEntity;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    PlayersRepository playersRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (playersRepository.count() == 0) {
            PlayerEntity playerEntity1 = new PlayerEntity(1L,"Jim Bo", "url", 0, 0);
            PlayerEntity playerEntity2 = new PlayerEntity(2L,"Nana", "", 0, 0);
            PlayerEntity playerEntity3 = new PlayerEntity(3L, "Scooter", "", 0, 0);
            PlayerEntity playerEntity4 = new PlayerEntity(4L,"Joe", "", 0, 0);
            playersRepository.save(playerEntity1);
            playersRepository.save(playerEntity2);
            playersRepository.save(playerEntity3);
            playersRepository.save(playerEntity4);
        }

    }
}
