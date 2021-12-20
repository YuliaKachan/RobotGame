package game.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int health;
    private String name;
    private List<Character> damageKeys = new ArrayList<>();

    public Robot() {
        initDamageList();
        health = 100;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    public List<Character> getDamageKeys() {
        return damageKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    private void initDamageList() {
        DamageKey damageKey = new DamageKey();

        for (int i = 0; i < 5; i++) {
            char randomKey = damageKey.getRandomKey();
            damageKeys.add(randomKey);
        }
    }


}
