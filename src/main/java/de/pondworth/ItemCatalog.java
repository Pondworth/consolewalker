package de.mhengstmann;

import java.util.HashMap;
import java.util.Random;

/**
 * J = Juwels
 * K = Kiste
 * F = Fels
 */
public class ItemCatalog extends HashMap<Integer, Character> {
    private final Random random = new Random();

    ItemCatalog() {
        for (int i = 0; i < 100; i++) {
            put(i,' ');
        }
        put(10,'J');
        put(25,'K');
        put(50,'F');
        put(75,'A');
    }



    public char getRandomItem() {
        int number = random.nextInt(0,99);
        return get(number);
    }
}
