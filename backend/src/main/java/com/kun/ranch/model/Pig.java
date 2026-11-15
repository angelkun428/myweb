package com.kun.ranch.model;

/**
 * 牧场里的一只猪
 */
public class Pig {
    private Long id;
    private String name;
    private boolean fat;
    private boolean dying;
    private int bites;

    public Pig() {}

    public Pig(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isFat() { return fat; }
    public void setFat(boolean fat) { this.fat = fat; }

    public boolean isDying() { return dying; }
    public void setDying(boolean dying) { this.dying = dying; }

    public int getBites() { return bites; }
    public void setBites(int bites) { this.bites = bites; }
}
