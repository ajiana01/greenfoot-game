import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class counter extends Actor
{
    int score;
    int money;
    
    public counter() {
    setImage(new GreenfootImage("Score: " + score + "\n Coin: " + money, 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }

        
    public void act()
    {
    setImage(new GreenfootImage("Score: " + score + "\n Coin: " + money, 40, Color.BLACK, new Color(0, 0, 0, 0)));        
    }
}
