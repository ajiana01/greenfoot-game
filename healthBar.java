import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthBar extends Actor
{
    int health = 50;
    
    public healthBar(){
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        
    }
    
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX()+5, myWorld.getPlayer().getY()-40);
        loseHealth();
    }
    
    public void loseHealth() {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByShrimp())
        {
            health--;
        }
        if(myWorld.getPlayer().hitByDeadbeat())
        {
            health--;
        }
        if(myWorld.getPlayer().hitByTakodachi())
        {
            health-=5;
        }
        if(health<=0){
            getWorld().showText("YAHAHALOSE!!\nTime survive: " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
