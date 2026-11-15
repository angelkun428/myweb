package com.kun.ranch.model;

import java.util.List;

/**
 * 牧场整体状态：猪列表 + 小麦数量
 */
public class RanchState {
    private List<Pig> pigs;
    private int wheatCount;
    private int wheatBites;
    private int maxPigs;
    private int maxWheat;

    public RanchState() {}

    public RanchState(List<Pig> pigs, int wheatCount, int wheatBites, int maxPigs, int maxWheat) {
        this.pigs = pigs;
        this.wheatCount = wheatCount;
        this.wheatBites = wheatBites;
        this.maxPigs = maxPigs;
        this.maxWheat = maxWheat;
    }

    public List<Pig> getPigs() { return pigs; }
    public void setPigs(List<Pig> pigs) { this.pigs = pigs; }

    public int getWheatCount() { return wheatCount; }
    public void setWheatCount(int wheatCount) { this.wheatCount = wheatCount; }

    public int getWheatBites() { return wheatBites; }
    public void setWheatBites(int wheatBites) { this.wheatBites = wheatBites; }

    public int getMaxPigs() { return maxPigs; }
    public void setMaxPigs(int maxPigs) { this.maxPigs = maxPigs; }

    public int getMaxWheat() { return maxWheat; }
    public void setMaxWheat(int maxWheat) { this.maxWheat = maxWheat; }
}
