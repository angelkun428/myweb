package com.kun.ranch.service;

import com.kun.ranch.model.GameScore;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 小游戏分数服务（内存存储，可替换为 MySQL）
 */
@Service
public class GameService {

    private final ConcurrentHashMap<String, GameScore> scores = new ConcurrentHashMap<>();

    public GameService() {
        scores.put("snake", new GameScore("snake", "贪吃蛇"));
        scores.put("dino", new GameScore("dino", "跳障碍"));
    }

    public Collection<GameScore> getAllScores() {
        return scores.values();
    }

    public GameScore getScore(String gameId) {
        return scores.get(gameId);
    }

    /**
     * 提交分数，返回是否刷新了最高分
     */
    public GameScore submitScore(String gameId, int score) {
        GameScore gs = scores.computeIfAbsent(gameId, k -> new GameScore(k, k));
        gs.setLastScore(score);
        if (score > gs.getHighScore()) {
            gs.setHighScore(score);
        }
        return gs;
    }
}
