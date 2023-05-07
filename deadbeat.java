import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class deadbeat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deadbeat extends Actor
{
    int health = 2;
    int count;
    player Player;
    counter Counter;
    
    public deadbeat(player mainPlayer,counter Counter) {
        this.Counter = Counter;
        Player = mainPlayer;
        GreenfootImage deadbeatImage = new GreenfootImage("images/deadbeat.gif");
        deadbeatImage.scale(42, 50); // skala gambar
        setImage(deadbeatImage);
    }
    
    public void act() {
        count++;
        moveAround();
        hitByWeapon();
    }
    
    public void moveAround() {
        move(2);
        turnTowards(Player.getX(), Player.getY());
    }
    
    public void hitByWeapon() {
        Actor weapon = getOneIntersectingObject(weapon.class);
        if (weapon != null) {
            health--;
            getWorld().removeObject(weapon);
        }
        if (health == 0) {
            Counter.score+=2;
            Counter.money+=3;
            getWorld().removeObject(this);
        }
    }
}
