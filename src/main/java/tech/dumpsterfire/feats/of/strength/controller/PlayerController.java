package tech.dumpsterfire.feats.of.strength.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.dumpsterfire.feats.of.strength.dao.PlayersRepository;
import tech.dumpsterfire.feats.of.strength.model.PlayerEntity;

import java.util.Optional;

@RestController
public class PlayerController {
    @Autowired
    private PlayersRepository playersRepository;


    // Create Items - Post
    @PostMapping("/players")
    public PlayerEntity createPlayers(@RequestBody PlayerEntity player) {
        return this.playersRepository.save(player);
    }

    // Read - Get id
    @GetMapping("/players/{id}")
    public Optional<PlayerEntity> itemById(@PathVariable Long id) {
        return this.playersRepository.findById(id);
    }

    // Update - Patch
    @PatchMapping("/players/{id}")
    public Object updateItemWithPatchById(@PathVariable Long id,
                                          @RequestBody PlayerEntity updatePlayEntity) {
        if (!playersRepository.existsById(id)) return playersRepository.save(updatePlayEntity);

        PlayerEntity patchPlayer = playersRepository.findById(id).orElse(null);

        if (updatePlayEntity.getId() != null) patchPlayer.setId(updatePlayEntity.getId());
        if (updatePlayEntity.getPlayerName() != null) patchPlayer.setPlayerName(updatePlayEntity.getPlayerName());
        if (updatePlayEntity.getPlayerUrl() != null) patchPlayer.setPlayerUrl(updatePlayEntity.getPlayerUrl());
        if (updatePlayEntity.getGame1Score() != 0) patchPlayer.setGame1Score(updatePlayEntity.getGame2Score());
        if (updatePlayEntity.getGame2Score() != 0) patchPlayer.setGame2Score(updatePlayEntity.getGame2Score());

        return playersRepository.save(patchPlayer);
    }

    // Delete - Delete
    @DeleteMapping("/players/{id}")
    public String deleteItem(@PathVariable Long id) {
        PlayerEntity deleteItem = this.playersRepository.findById(id).get();
        if (deleteItem != null) {
            this.playersRepository.deleteById(id);
            return this.playersRepository.count() + " users remaining.";
        } else
            return "Item not found, try another user Id.";
    }

    // List - Get all the items
    @GetMapping("/players")
    public Iterable<PlayerEntity> getAllTheItems() {
        return this.playersRepository.findAll();
    }

}
