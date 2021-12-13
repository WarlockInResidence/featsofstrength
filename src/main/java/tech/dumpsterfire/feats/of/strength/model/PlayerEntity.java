package tech.dumpsterfire.feats.of.strength.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;
    private String playerUrl;
    private int game1Score;
    private int game2Score;

    public PlayerEntity(Long id, String playerName, String playerUrl, int game1Score, int game2Score) {
        this.id = id;
        this.playerName = playerName;
        this.playerUrl = playerUrl;
        this.game1Score = game1Score;
        this.game2Score = game2Score;
    }

    public PlayerEntity() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public void setPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
    }

    public int getGame1Score() {
        return game1Score;
    }

    public void setGame1Score(int game1Score) {
        this.game1Score = game1Score;
    }

    public int getGame2Score() {
        return game2Score;
    }

    public void setGame2Score(int game2Score) {
        this.game2Score = game2Score;
    }
}
