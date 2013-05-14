package main;

/**
 * @author Anthony Hill
 * Students Vs Teachers
 * Text-based battle game for CIT 130 class
 * REQUIREMENT 3 methods in main class
 */
public class main {
    /**
     * Send a message to DisplayMessage1
     * @param args 
     */
    public static void main(String[] args) {
        DisplayMessage1("*");
    }
    public static void DisplayMessage1(String message) {
        DisplayMessage2(message + "*");
    }
    public static void DisplayMessage2(String message) {
        StartPlaying(message + "*");
    }
    public static void StartPlaying(String message) {
        System.out.println(message);
        Play.StartPlaying();
    }
}
