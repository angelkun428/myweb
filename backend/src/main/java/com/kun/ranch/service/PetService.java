package com.kun.ranch.service;

import com.kun.ranch.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 页面宠物服务：宠物列表、当前选中、随机对话气泡
 */
@Service
public class PetService {

    private final List<Pet> pets = Arrays.asList(
            new Pet("villager", "村民", "🧑", "assets/villager.webp"),
            new Pet("creeper", "苦力怕", "💥", "assets/creeper.webp"),
            new Pet("pig", "小猪", "🐷", "assets/pig.webp"),
            new Pet("piglet", "猪仔", "🐽", "assets/piglet.webp")
    );

    private volatile String currentPetId = "villager";

    private static final String[] BUBBLES = {
            "今天天气真不错呢~", "要不要一起出去玩？", "我饿了，有吃的吗？",
            "嘿嘿，你好呀！", "牧场里的猪真可爱", "听说你会写代码？好厉害！",
            "我要去散步啦~", "记得多休息哦", "今天也要加油鸭！",
            "你点我干嘛呀~", "哼哼，我才不怕你！", "要不要来玩小游戏？"
    };

    public List<Pet> getPets() {
        return pets;
    }

    public Pet getCurrentPet() {
        return pets.stream()
                .filter(p -> p.getId().equals(currentPetId))
                .findFirst()
                .orElse(pets.get(0));
    }

    public Pet selectPet(String petId) {
        Pet pet = pets.stream()
                .filter(p -> p.getId().equals(petId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("没有这个宠物: " + petId));
        currentPetId = petId;
        return pet;
    }

    public String getRandomBubble() {
        return BUBBLES[ThreadLocalRandom.current().nextInt(BUBBLES.length)];
    }
}
