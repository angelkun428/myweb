package com.kun.ranch.model;

/**
 * 页面宠物
 */
public class Pet {
    private String id;
    private String name;
    private String emoji;
    private String image;

    public Pet() {}

    public Pet(String id, String name, String emoji, String image) {
        this.id = id;
        this.name = name;
        this.emoji = emoji;
        this.image = image;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
