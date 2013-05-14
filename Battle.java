package main;

/**
 * Battle class manages in-game battles
 * @author Tony Hill
 */
public class Battle {
    /**
     * Starts a battle
     * @param player current player
     */
    public static void StartBattle(Student player, int battles) {
        Teacher teacher = new Teacher();
        System.out.println("Starting class...");
        //Battle until either the enemy or the teacher run out of hitpoints
        while(teacher.getHP() >= 1 && player.getHP() >= 1) {
            if(Menu.ShowBattleMenu() == 1) { // player attacked
                PlayerAttack(player, teacher);
                if(teacher.getHP() >= 1) {
                    TeacherAttack(player, teacher);
                }
            } else { // dropped out
                Menu.GameOver(player, teacher, battles); 
                System.exit(0);
            }
        }
        
        boolean teacher_beaten = false;
        if(teacher.getHP() < 1) { // Teacher was beaten
            System.out.println("You made it through " + teacher.getName() 
                    + "'s class!");
            teacher_beaten = true;
        }
        // Add a drop to the player's inventory
        if(teacher_beaten) {
            String found_item = teacher.getRandomInventoryItem();
            player.addToInventory(found_item);
            System.out.println("Added " + found_item + " to inventory");
        } else {
            Menu.GameOver(player, teacher, battles);
            System.exit(0);
        }
    }
    
    public static void PlayerAttack(Student player, Teacher teacher) {
        int attack_power = player.getStrength();
        teacher.setHP(teacher.getHP() - attack_power);
        System.out.println(player.getName() + " attacks for " + attack_power + 
                " - " + player.getHP() + "HP left");
    }
    public static void TeacherAttack(Student player, Teacher teacher) {
        int attack_power = teacher.getStrength();
        player.setHP(player.getHP() - attack_power);
        System.out.println(teacher.getName() + " attacks with " + 
                teacher.getRandomAbility() + " for " + attack_power + " - " + 
                teacher.getHP() + "HP left");
    }
}
