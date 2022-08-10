
/**
 * The Battle class contains actions made between two Player objects.
 *
 * @author Gwen Bradforth
 * @version 1/13/20
 */
public class Battle
{
    /**
     * Constructor for objects of class Battle
     */
    public Battle()
    {

    }

    /**
     * The first player causes damage to the second player.
     * 
     * @param attackingPlayer   player that is attacking
     * @param defendingPlayer   player that is being attacked
     */
    public static boolean attack(Player attackingPlayer,Player defendingPlayer)
    {
        double multiplier = 1;
        boolean critical = false;
        if (defendingPlayer.getWeakness().equalsIgnoreCase(attackingPlayer.getC1()) ||
            defendingPlayer.getWeakness().equalsIgnoreCase(attackingPlayer.getC2()))
            multiplier *= 1.5;
        if (attackingPlayer.getCHb() && Math.random() < .2)
        {
            multiplier *= 1.5;
            critical = true;
        }
        else if (Math.random() < 0.1)
        {
            multiplier *= 1.5;
            critical = true;
        }
        defendingPlayer.setHealth(defendingPlayer.getHealth() - attackingPlayer.getAttack() * multiplier);
        return critical;
    }

    /**
     * The first player causes damage to the second player, 1.5x regular attack.
     * 
     * @param attackingPlayer   player that is attacking
     * @param defendingPlayer   player that is being attacked
     */
    public static boolean sneakAttack(Player attackingPlayer,Player defendingPlayer)
    {
        double multiplier = 1;
        boolean critical = false;
        if (attackingPlayer.getSneakAffinity().equals("sSneak")||
        defendingPlayer.getSneakAffinity().equals("wSneak"))
            multiplier *= 1.5;
        if (defendingPlayer.getSneakAffinity().equals("bSneak"))
            multiplier *= 0.5;
        if (defendingPlayer.getWeakness().equals(attackingPlayer.getC1()) ||
            defendingPlayer.getWeakness().equals(attackingPlayer.getC2()))
            multiplier *= 1.5;
        if (attackingPlayer.getCHb() && (Math.random() < .2))
        {
            multiplier *= 1.5;
            critical = true;
        }
        else if (Math.random() < 0.1)
        {
            multiplier *= 1.5;
            critical = true;
        }
        defendingPlayer.setHealth(defendingPlayer.getHealth() - attackingPlayer.getAttack()*(1.5*multiplier));
        return critical;
    }

}
