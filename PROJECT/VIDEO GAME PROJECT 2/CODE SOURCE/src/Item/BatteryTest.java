package Item;

import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;
import Unity.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest extends Unit {

    private Battery battery1;
    private Identity id;

    @BeforeEach
    public void setUp() {
        battery1 = new Battery(id);
    }

    @Test
    public void testIsEmpty() {
        while (battery1.getLevel() > 0) {
            assertFalse(battery1.isEmpty());
            battery1.use();
        }
        assertTrue(battery1.isEmpty());
        assertEquals(battery1.getLevel(), 0);
        battery1.use();
        assertEquals(battery1.getLevel(), 0);
    }

    @Test
    public void testUse() {
        int level = Battery.DEFAULT_LEVEL;
        while (battery1.getLevel() > 0) {
            assertEquals(battery1.getLevel(), level);
            battery1.use();
            level--;
        }
    }

    @Test
    public void testUse2() {
        while (battery1.getLevel() > 0) {
            battery1.use();
        }
        assertEquals(battery1.getLevel(), 0);
        assertTrue(battery1.isEmpty());
    }

    @Override
    public <T extends Enemy> void attackEnemy(T e, Weapon w) {

    }

    @Override
    public void aleaAttak(Player p) {

    }

    @Override
    public void print() {

    }
}