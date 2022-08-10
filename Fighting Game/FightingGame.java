
/**
 * FightingGame runs a fight between the two Player objects until one runs out of Health.
 *
 * @author Gwen Bradforth
 * @version 1/12/20
 */
import java.util.Scanner;
public class FightingGame
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Aerae Finis!");
        System.out.println("Would you like a basic guide? (y/N)");
        String guide = in.nextLine();
        if (guide.substring(0,1).equalsIgnoreCase("y"))
        {
            System.out.println("You will fight 1v1 with another player. Each player can either attack or sneak attack.");
            System.out.println("At base stats, sneak attack is x1.5 the player's attack. Base attack is 20 and base HP is 200.");
            System.out.println("Characteristics affect your base stats. You will choose your character which will have two characteristics of the following.");
            System.out.println("Strength boosts Attack but is weak to sneak attacks.");
            System.out.println("Cunning boosts sneak attack but is weak to Strength types."); 
            System.out.println("Constitution boosts health but levels slower.");
            System.out.println("Wisdom boosts resistance to Sneak Attacks but decreases Attack.");
            System.out.println("Charisma boosts critical hit rate but is weak to Wisdom types.");
        }
        System.out.println("Player 1, choose your character!");
        characterPrint();
        int choice1 = in.nextInt();
        Player player1 = characterSelect(choice1);
        System.out.println("Player 2, choose your character!");
        characterPrint();
        int choice2 = in.nextInt();
        Player player2 = characterSelect(choice2);
        System.out.println("Start!");
        Battle battle = new Battle();
        String answer = "";
        in.nextLine();
        while (player1.getHealth() > 0 || player2.getHealth() > 0)
        {
            System.out.println(player1.getName() + ", choose your attack.");
            System.out.println("[1]Regular Attack    [2]Sneak Attack");
            answer = in.nextLine();
            if (answer.equals("1"))
            {
                if (Battle.attack(player1,player2))
                    System.out.println("Critical hit!");
            }
            else if (answer.equals("2"))
            {
                if (Battle.sneakAttack(player1,player2))
                    System.out.println("Critical hit!");
            }
            else
            {
                System.out.println("Incorrect input. Forfeiting turn.");
            }
            if (player1.getHealth() <= 0 || player2.getHealth() <= 0)
                break;
            System.out.println(player1.getName() + ": " + player1.getHealth());
            System.out.println(player2.getName() + ": " + player2.getHealth());
            System.out.println(player2.getName() + ", choose your attack.");
            System.out.println("[1]Regular Attack    [2]Sneak Attack");
            answer = in.nextLine();
            if (answer.equals("1"))
            {
                Battle.attack(player2,player1);
            }
            else if (answer.equals("2"))
            {
                Battle.sneakAttack(player2,player1);
            }
            else
            {
                System.out.println("Incorrect input. Forfeiting turn.");
            }
            System.out.println(player1.getName() + ": " + player1.getHealth());
            System.out.println(player2.getName() + ": " + player2.getHealth());
            if (player1.getHealth() <= 0 || player2.getHealth() <= 0)
                break;
        }
        System.out.println("Game over!");
        if (player1.getHealth() <= 0)
            System.out.println(player2.getName() + " wins!");
        else 
            System.out.println(player1.getName() + " wins!");
        System.out.println("Thanks for playing Aerae Finis.");    
    }

    public static void characterPrint()
    {
        System.out.println("      (1)Achilles                  (2)Odysseus                 (3)Paris");
        System.out.println("  Strength/Constitution           Cunning/Wisdom           Cunning/Charisma");
        System.out.println("     Myrmidon (Greek)             Ithican (Greek)               Trojan");
        System.out.println("");
        System.out.println("      (4)Socrates                  (5)Leonidas           (6)Alexander the Great");
        System.out.println("     Wisdom/Charisma            Strength/Constitution        Strength/Cunning ");
        System.out.println("     Athenian (Greek)              Spartan (Greek)          Macedonian (Greek)");
        System.out.println("");
        System.out.println("      (7)Aristotle                 (8)Romulus                  (9)Cicero");
        System.out.println("    Wisdom/Constitution           Strength/Cunning            Charisma/Wisdom ");
        System.out.println("    Macedonian (Greek)            Roman/Etruscan (?)             Roman ");
        System.out.println("");
        System.out.println("     (10)Caesar                   (11)Crassus                 (12)Pompey");
        System.out.println("   Cunning/Strength             Cunning/Charisma            Charisma/Strength ");
        System.out.println("        Roman                        Roman                       Roman ");
        System.out.println("");
        System.out.println("     (13)Augustus    ");
        System.out.println("    Charisma/Wisdom  ");
        System.out.println("        Roman  ");
    }

    public static Player characterSelect(int choice)
    {
        if (choice == 1) 
            return new Player("Achilles","s","co");
        else if (choice == 2) 
            return new Player("Odysseus","cu","w");
        else if (choice == 3) 
            return new Player("Paris","ch","cu");
        else if (choice == 4) 
            return new Player("Socrates","w","ch");
        else if (choice == 5) 
            return new Player("Leonidas","s","co");
        else if (choice == 6) 
            return new Player("Alexander the Great","s","cu");    
        else if (choice == 7) 
            return new Player("Aristotle","w","co");    
        else if (choice == 8) 
            return new Player("Romulus","s","cu");
        else if (choice == 9) 
            return new Player("Cicero","ch","w");
        else if (choice == 10) 
            return new Player("Caesar","s","cu");  
        else if (choice == 11) 
            return new Player("Crassus","cu","ch");  
        else if (choice == 12) 
            return new Player("Pompey","ch","s");
        else if (choice == 13) 
            return new Player("Augustus","ch","w");  
        else
            return new Player("Achilles","s","co");
    }
}
