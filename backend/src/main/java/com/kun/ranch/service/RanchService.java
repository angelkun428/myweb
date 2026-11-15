package com.kun.ranch.service;

import com.kun.ranch.model.Pig;
import com.kun.ranch.model.RanchState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 牧场服务：管理猪和小麦的状态（内存存储，可替换为 MySQL）
 */
@Service
public class RanchService {

    @Value("${ranch.max-pigs}")
    private int maxPigs;

    @Value("${ranch.max-wheat}")
    private int maxWheat;

    @Value("${ranch.wheat-bites-per-unit}")
    private int wheatBitesPerUnit;

    private final ConcurrentHashMap<Long, Pig> pigs = new ConcurrentHashMap<>();
    private final AtomicLong pigIdSeq = new AtomicLong(0);

    private volatile int wheatCount = 0;
    private volatile int wheatBites = 0;

    private static final String[] PIG_NAMES = {"小花", "大黑", "白白", "胖墩", "二师兄", "哼哼", "嘟嘟", "团团", "圆圆", "豆豆"};

    public RanchState getState() {
        return new RanchState(new ArrayList<>(pigs.values()), wheatCount, wheatBites, maxPigs, maxWheat);
    }

    public Pig addPig() {
        if (pigs.size() >= maxPigs) {
            throw new IllegalStateException("猪的数量已达上限 " + maxPigs);
        }
        long id = pigIdSeq.incrementAndGet();
        String name = PIG_NAMES[(int) (id % PIG_NAMES.length)] + (id > PIG_NAMES.length ? id : "");
        Pig pig = new Pig(id, name);
        pigs.put(id, pig);
        return pig;
    }

    public Pig removePig() {
        if (pigs.isEmpty()) {
            throw new IllegalStateException("牧场里已经没有猪了");
        }
        List<Long> ids = new ArrayList<>(pigs.keySet());
        Long randomId = ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
        Pig removed = pigs.remove(randomId);
        if (removed != null) {
            removed.setDying(true);
        }
        return removed;
    }

    public int addWheat() {
        if (wheatCount >= maxWheat) {
            throw new IllegalStateException("饲料槽已满，最多放 " + maxWheat + " 份小麦");
        }
        wheatCount++;
        wheatBites += wheatBitesPerUnit;
        return wheatCount;
    }

    public int consumeWheat() {
        if (wheatBites <= 0) {
            return 0;
        }
        wheatBites--;
        // 每消耗 bitesPerUnit 口，小麦视觉数量减 1
        int consumedUnits = (int) Math.floor((double) wheatBites / wheatBitesPerUnit);
        if (consumedUnits < wheatCount) {
            wheatCount = consumedUnits;
        }
        return wheatBites;
    }

    public void clearWheat() {
        wheatCount = 0;
        wheatBites = 0;
    }

    /**
     * 重置牧场：清空所有猪和小麦（打开弹窗时调用，保持前后端一致）
     */
    public void reset() {
        pigs.clear();
        wheatCount = 0;
        wheatBites = 0;
        pigIdSeq.set(0);
    }
}
