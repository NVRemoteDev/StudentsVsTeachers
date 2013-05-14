package main;

/**
 * Play class initiates all functions; initialized by main class
 * @author Anthony Hill
 */
public class Play {
    /**
     * Start playing the game
     */
    public static void StartPlaying() {
        if(Menu.MainMenu()) { // Player chose play
            System.out.println("Starting game...");
        } else {
            System.exit(0);
        }
        
        // Have user create character
        Student player = new Student();
        Menu.CreateCharacterMenu(player);
        
        System.out.println();
        System.out.println("Welcome " + player.getName() + " to Students "
                + "Vs Teachers...");
        // Number of fights, change this to make game shorter or longer
        final int BATTLES = 10;
        for(int i = 1; i < BATTLES; i++ ) { // Do BATTLES battles
            Menu.ShowPreBattleMenu(player);
            Battle.StartBattle(player);
        }
        // Player wins!
        Menu.WinScreen(player, null);
    }
}
