package observers;

import models.Game;
import models.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Scoreboard implements GameObserver {
    public ConcurrentMap<Player, Integer> scores;

    public Scoreboard() {
        this.scores = new ConcurrentHashMap<>();
    }

    public void display() {
        for (Map.Entry<Player, Integer> playerInfo: scores.entrySet()) {
            System.out.printf(
                    "Player: %s, Score: %s%n",
                    playerInfo.getKey().name(),
                    playerInfo.getValue()
            );
        }
    }

    public void addScore(Player player, Integer scoreToAdd) {
        scores.compute(player, (playerToCompute, score) -> {
            if (score != null) {
                return score + scoreToAdd;
            }
            return scoreToAdd;
        });
    }

    @Override
    public void update(Game game) {
        Player player = game.getWinner();
        if (player != null) {
            addScore(player, 1);
        }
    }
}
