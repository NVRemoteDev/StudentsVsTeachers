package main;
import java.util.*;
/**
 * Teacher class contains teacher mob information
 * @author Tony Hill
 */
public class Teacher {
    final int INVENTORYSIZE = 3;
    final int HITPOINTS = 10;
    final int STRENGTH = 2;
    
    private String name;
    private int hitpoints;
    private String[][] inventory = new String[INVENTORYSIZE][INVENTORYSIZE];
    private String[] abilities;
    private int strength;
    
    Teacher() {
        name = "Ms. S";
        // +1 strength assumes default broken pencil, with strength of 1
        // A "Pencil" dropped below would therefore bring player strength to 2
        inventory[0][0] = "Potion"; // Heal player to full
        inventory[0][1] = "Pencil"; // +1 strength
        inventory[0][2] = "Mechanical Pencil"; // +2 strength
        inventory[1][0] = "Canvas Armor"; // +1 strength
        inventory[1][1] = "Strength tonic"; // +1 strength
        inventory[1][2] = "The Overachiever Tonic"; // -1 strength
        inventory[2][0] = "Sweaty Jockstrap"; // -1 strength
        inventory[2][1] = "Pocket Protector"; // +1 strength
        inventory[2][2] = "Golden Helmet"; // +3 strength
        abilities = new String[]{ "Homework", "Pop Quiz", "Powerpoint Lecture",
            "Final" };
        hitpoints = HITPOINTS;
        strength = STRENGTH;
    }
    
    // Get/Set methods
    public String getName() {
        return this.name;
    }
    public void setName(String a_name) {
        this.name = a_name;
    }
    public int getHP() {
        return this.hitpoints;
    }
    public void setHP(int hp) {
        this.hitpoints = hp;
    }
    public int getStrength() {
        return this.strength;
    }
    public void setStrength(int str) {
        this.strength = str;
    }
    public String[] getAbilities() {
        return abilities;
    }
    public String getRandomAbility() {
        Random generator = new Random();
        int x = generator.nextInt(abilities.length);
        return abilities[x];
    }
    public String getRandomInventoryItem() {
        Random generator = new Random();
        int x = generator.nextInt(INVENTORYSIZE);
        int y = generator.nextInt(INVENTORYSIZE);
        return inventory[x][y];
    }
}
