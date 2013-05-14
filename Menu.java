package main;

/**
 * Menu class holds all of the menus for the game
 * @author Anthony Hill
 */

import java.util.*;

public class Menu {
    private static final String PLAINTEXT = "\033[0;0m";
    private static final String BOLDTEXT = "\033[0;1m";
    /**
     * Display the main menu
     * @return true for start playing, false for exit
     */
    public static boolean MainMenu() {
        Scanner input = new Scanner(System.in);
        boolean choice = true;
        
        System.out.println("Student Vs. Teachers - Main Menu");
        System.out.println("1. Start Playing");
        System.out.println("2. Exit");
        System.out.print(BOLDTEXT + "Enter a choice> " + PLAINTEXT);
        // User entered exit
        if(input.nextInt() == 2) { 
            choice = false;
        }
        
        return choice;
    }
    /**
     * Create a character menu
     * @param player 
     */
    public static void CreateCharacterMenu(Student player) {
        Scanner input = new Scanner(System.in);
        System.out.print(BOLDTEXT + "Enter your name> " + PLAINTEXT);
        String name = input.nextLine();
        player.setName(name);
    }
    
    /**
     * Battle menu is the attack/quit menu in the game
     * @return 
     */
    public static int ShowBattleMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1) Attack");
        System.out.println("2) Dropout");
        System.out.print(BOLDTEXT + "Enter a choice> " + PLAINTEXT);
        return input.nextInt();
    }
    /**
     * The menu shown before battles
     * Switch statement on the input determines which menu action to take
     * 
     * @param player the current player
     */
    public static void ShowPreBattleMenu(Student player) {
        boolean has_potions = player.checkIfPlayerHasItem("Potion");
        boolean show_menu = true;
        while(show_menu) {
            System.out.println("Strength: " + player.getStrength());
            System.out.println("Class starts soon, what do you want to do?");
            System.out.println("1) Start class");
            System.out.println("2) View inventory");
            System.out.println("3) Dropout (Quit)");
            if(has_potions) {
                System.out.println("4) Use Potion");
            }
            System.out.print(BOLDTEXT + "Enter a choice> " + PLAINTEXT);
            show_menu = PerformPreBattleMenuAction(player, has_potions);
        }
    }
    
    /**
     * Perform the action from the menu above
     * Needs refactoring for readability
     * 
     * @param player current player
     * @param has_potions whether the player has potions in inventory
     * @return true or false whether to continue showing menu
     */
    public static boolean PerformPreBattleMenuAction(Student player, boolean has_potions) {
        Scanner input = new Scanner(System.in);
        switch(input.nextInt()) {
            case 1:
                return false;
            case 2:
                player.showPlayerInventory();
                break;
            case 3: 
                System.exit(0);
                break;
            case 4:
                if(has_potions) { player.usePotion(); }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        return true;
    }
    
    public static void GameOver(Student player, Teacher teacher) {
        System.out.println("The classwork was overwhelming! Beaten by " 
                + teacher.getName());
        System.out.println(teacher.getName() + "'s HP remaining: " + teacher.getHP());
        System.out.println(player.getName() + "'s items: ");
        System.exit(0);
    }
    public static void WinScreen(Student player, Teacher teacher) {
        if(teacher == null) { 
            Teacher teacher1 = new Teacher();
            teacher = teacher1;
        }
        System.out.println("Congratulations " + player + 
                ", you passed " + teacher.getName() + "'s class!");
        System.exit(0);
    }
}
