import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shrimp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shrimp extends Actor {
    int health = 1;
    int count;
    player Player;
    counter Counter;
    
    public shrimp(player mainPlayer,counter Counter) {
        this.Counter = Counter;
        Player = mainPlayer;
        GreenfootImage shrimpImage = new GreenfootImage("images/shrimp.gif");
        shrimpImage.scale(42, 50); // skala gambar
        setImage(shrimpImage);
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
            Counter.score++;
            Counter.money+=2;
            getWorld().removeObject(this);
        }
    }
    
}
