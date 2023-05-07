import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class superPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class superPower extends Actor
{
    final int SUPER_POWER_LIMIT = 100;
    int superCount;
    int count;
    private int scale = 1;
    private int maxScale = 100;
    private int delay = 5; // delay between each scaling operation
    private int timer = 0;
    
    public superPower(){
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT+1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
        
    }
    
    public void act()
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT+1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX()+5, myWorld.getPlayer().getY()-60);
        useSuper();

    }
    
    public void useSuper() {
        count++;
        if(count % 5 == 0)
        superCount++;
        if(superCount>=100) {
            superCount = 0;
        }
    }
    
}
