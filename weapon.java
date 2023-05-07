import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class weapon extends Actor
{
    private int speed = 10;
    
    public void act()
    {
        move(speed);
        
        if (isAtEdge()) {
        getWorld().removeObject(this); // Menghapus objek dari dunia permainan
        }
    }
    
    
}
