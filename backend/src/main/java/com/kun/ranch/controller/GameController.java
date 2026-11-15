package com.kun.ranch.controller;

import com.kun.ranch.model.GameScore;
import com.kun.ranch.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 小游戏 REST API
 *
 * GET  /api/games/scores           获取所有游戏最高分
 * GET  /api/games/scores/{gameId}  获取某个游戏的分数
 * POST /api/games/scores/{gameId}  提交分数（body: { "score": 100 }）
 */
@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/scores")
    public Collection<GameScore> getAllScores() {
        return gameService.getAllScores();
    }

    @GetMapping("/scores/{gameId}")
    public ResponseEntity<?> getScore(@PathVariable String gameId) {
        GameScore gs = gameService.getScore(gameId);
        if (gs == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "没有这个游戏: " + gameId));
        }
        return ResponseEntity.ok(gs);
    }

    @PostMapping("/scores/{gameId}")
    public ResponseEntity<?> submitScore(@PathVariable String gameId, @RequestBody Map<String, Integer> body) {
        Integer score = body.get("score");
        if (score == null || score < 0) {
            return ResponseEntity.badRequest().body(Map.of("message", "分数无效"));
        }
        GameScore gs = gameService.submitScore(gameId, score);
        return ResponseEntity.ok(gs);
    }
}
