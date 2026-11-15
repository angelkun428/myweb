package com.kun.ranch.model;

/**
 * 小游戏分数记录
 */
public class GameScore {
    private String gameId;      // 游戏标识：snake / dino
    private String gameName;    // 游戏名称
    private int highScore;      // 最高分
    private int lastScore;      // 最近一次得分

    public GameScore() {}

    public GameScore(String gameId, String gameName) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.highScore = 0;
        this.lastScore = 0;
    }

    public String getGameId() { return gameId; }
    public void setGameId(String gameId) { this.gameId = gameId; }

    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }

    public int getHighScore() { return highScore; }
    public void setHighScore(int highScore) { this.highScore = highScore; }

    public int getLastScore() { return lastScore; }
    public void setLastScore(int lastScore) { this.lastScore = lastScore; }
}
