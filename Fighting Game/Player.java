 
/**
 * Player makes a player with various stats.
 *
 * @author Gwen Bradforth
 * @version 1/13/20
 */
public class Player
{
    private double attack;
    private double health;
    private double level;
    private double xp;
    private String c1;
    private String c2;
    private String weakness;
    private boolean wSneak;
    private boolean sSneak;
    private boolean bSneak;
    private boolean CHb = false;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, String c1, String c2)
    {
        attack = 20;
        health = 200;
        this.c1 = c1;
        this.c2 = c2;
        level = 0;
        xp = 0;
        weakness = "";
        this.name = name;
        
        //initilize characteristics
        if (c1.equalsIgnoreCase("s") || c2.equalsIgnoreCase("s")){
            attack += 10;
            wSneak = true;
        }
        if (c1.equalsIgnoreCase("cu") || c2.equalsIgnoreCase("cu")){
            sSneak = true;
            weakness = "s";
        }
        if (c1.equalsIgnoreCase("co") || c2.equalsIgnoreCase("co")){
            health += 50;
            //levels slower
        }
        if (c1.equalsIgnoreCase("w") || c2.equalsIgnoreCase("w")){
            bSneak = true;
            attack -= 10;
        }
        if (c1.equalsIgnoreCase("ch") || c2.equalsIgnoreCase("ch")){
            CHb = true;
            weakness = "w";
        }
        
    }

    
    public double getAttack(){return attack;}
    
    public double getHealth(){return health;}
    
    public double getLevel(){return level;}
    
    public double getXP(){return xp;}
    
    public String getC1(){return c1;}
    
    public String getC2(){return c2;}
    
    public String getWeakness(){return weakness;}
    
    public String getName() {return name;}
    
    public String getSneakAffinity() 
    {
        if (wSneak)
            return "wSneak";
        else if (sSneak)
            return "sSneak";
        else if (bSneak)
            return "bSneak";
        else
            return "none";
    }
    
    public boolean getCHb(){return CHb;}
    
    /**
     * Adds one to the level and resets xp.
     */
    public void gainLevel()
    {
        level ++;
        xp = 0;
    }
    
    public void setHealth(double newHealth)
    {
        health = newHealth;
    }
    
    
}
