package main;
import java.util.*;

/**
 * Student class (the user's avatar)
 * @author Tony Hill
 * CIT 130
 */
public class Student {
    private static final String PLAINTEXT = "\033[0;0m";
    private static final String BOLDTEXT = "\033[0;1m";
    
    final int INVENTORYSIZE = 100;
    final int BASE_HITPOINTS = 30;
    final int BASE_STRENGTH = 1;
    // Item stats (strength)
    final int PENCIL = 2;
    final int MECHANICAL_PENCIL = 2;
    final int CANVAS_ARMOR = 1;
    final int STRENGTH_TONIC = 1;
    final int OVERACHIEVER_TONIC = -1;
    final int SPANDEX = -1;
    final int POCKET_PROTECTOR = 1;
    final int GOLDEN_HELMET = 3;
 
    private String name;
    private int hitpoints;
    private String[][] inventory = new String[INVENTORYSIZE][INVENTORYSIZE];
    private String[] abilities;
    private int strength;
    
    Student() {
        name = "PLAYER1";
        inventory[0][0] = "Broken Pencil"; // +0 strength
        abilities = new String[]{ "Attack", "Dropout (run)" };
        hitpoints = BASE_HITPOINTS;
        strength = BASE_STRENGTH;
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
    public String[][] getInventory() {
        return this.inventory;
    }
    /**
     * Adds an item to the next available inventory slot
     * @param item item to add
     */
    public void addToInventory(String item) {
        outerloop:
        for(int i = 0; i < inventory.length; i++) {
            for(int k = 0; k < inventory[0].length; k++) {
                if(inventory[i][k] == null) {
                    inventory[i][k] = item;
                    break outerloop;
                }
            }
        }
    }
    /**
     * Equips an item
     * @param item item to equip
     */
    public void equipItem(String item) {
        if(checkIfPlayerHasItem(item)) {
            // Set strength to base strength so stacking overpowered items isn't possible
            setStrength(BASE_STRENGTH);
            switch(item) {
                case "Pencil": setStrength(BASE_STRENGTH + PENCIL);
                    break;
                case "Mechanical Pencil": setStrength(BASE_STRENGTH + 
                        MECHANICAL_PENCIL);
                    break;
                case "Canvas Armor": setStrength(BASE_STRENGTH + 
                        CANVAS_ARMOR);
                    break;
                case "Strength Tonic" : 
                    setStrength(BASE_STRENGTH + STRENGTH_TONIC);
                    break;
                case "The Overachiever Tonic" : 
                    setStrength(BASE_STRENGTH + OVERACHIEVER_TONIC);
                    break;
                case "Broken Pencil" : setStrength(BASE_STRENGTH);
                    break;
                case "Sweaty Jockstrap" : setStrength(BASE_STRENGTH 
                        + SPANDEX);
                    break;
                case "Pocket Protector" : setStrength(BASE_STRENGTH 
                        + POCKET_PROTECTOR);
                    break;
                case "Golden Helmet" : setStrength(BASE_STRENGTH 
                        + GOLDEN_HELMET);
                    break;
                default : setStrength(BASE_STRENGTH);
                    break;
            }
            removePotionsFromInventory(item);
        } else {
            System.out.println("You do not have posses this item");
        }
    }
    /**
     * Shows player inventory
     */
    public void showPlayerInventory() {
        Scanner input = new Scanner(System.in);
        System.out.println("INVENTORY:");
        for(int i = 0; i < inventory.length; i++) {
            for(int k = 0; k < inventory[0].length; k++) {
                if(inventory[i][k] != null) {
                    System.out.println(inventory[i][k]);
                }
            }
        }
        System.out.print(BOLDTEXT + "Enter an item name to equip> " + PLAINTEXT);
        String item = input.nextLine();
        equipItem(item);
    }
    /**
     * Checks if player has an item
     * null check on inventory requirement (else an exception throws)
     * 
     * @return true if player has item
     */
    public boolean checkIfPlayerHasItem(String item) {
        boolean has_item = false;
        for(int i = 0; i < inventory.length; i++) {
            for(int k = 0; k < inventory[0].length; k++) {
                if(inventory[i][k] != null && 
                        inventory[i][k].equals(item)) {
                    has_item = true;
                    return has_item;
                }
            }
        }
        return has_item;
    }
    /**
     * Use a potion
     */
    public void usePotion() {
        this.hitpoints = BASE_HITPOINTS; // Fully heal player
    }
    /**
     * Removes potions and tonics when used
     * Breaks loop early if an item is found (in case of multiples)
     * @param item 
     */
    public void removePotionsFromInventory(String item) {
        if(item.equals("Potion") || item.equals("The Overachiever Tonic") ||
                item.equals("Strength Tonic")) {
            for(int i = 0; i < inventory.length; i++) {
                for(int k = 0; k < inventory[0].length; k++) {
                    if(inventory[i][k] != null && inventory[i][k].equals(item)) {
                        inventory[i][k] = null;
                        break;
                    }
                }
            }
        }
    }
}
