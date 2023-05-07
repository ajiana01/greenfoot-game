import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class takodachi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class takodachi extends Actor
{
    int health = 5;
    int count;
    player Player;
    counter Counter;
    
    public takodachi(player mainPlayer,counter Counter) {
        this.Counter = Counter;
        Player = mainPlayer;
        GreenfootImage takodachiImage = new GreenfootImage("images/takodachi.gif");
        takodachiImage.scale(50, 58); // skala gambar
        setImage(takodachiImage);
    }
    
    public void act() {
        count++;
        moveAround();
        hitByWeapon();
    }
    
    public void moveAround() {
        move(1);
        turnTowards(Player.getX(), Player.getY());
    }
    
    public void hitByWeapon() {
        Actor weapon = getOneIntersectingObject(weapon.class);
        if (weapon != null) {
            health--;
            getWorld().removeObject(weapon);
        }
        if (health == 0) {
            Counter.score+=4;
            Counter.money+=5;
            getWorld().removeObject(this);
        }
    }
}
