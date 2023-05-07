import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    int count = 0;
    int spawnSpeed = 50;
    int randomSpawn;
    public player mainPlayer = new player();
    counter Counter = new counter();
    healthBar HealthBar= new healthBar();
    private GreenfootSound music;

    public MyWorld()
    {    
        super(1280, 720, 1);
        
        prepare();
        act();
        
    }
    
    public player getPlayer(){
        return mainPlayer;
    }
    
    private void prepare()
    {
        addObject(mainPlayer, getWidth() / 2, getHeight() / 2);
        addObject(Counter, 100,80);
        addObject(HealthBar, mainPlayer.getX()+5, mainPlayer.getY() - 40);
    }
    
    public void act() {
        count++;
        spawnShrimps();
        spawnDeadbeat();
        spawnTakodachi();
    }
    
    public void spawnShrimps() {
        if (count % spawnSpeed == 0){
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn) {
                case 0 : addObject(new shrimp(mainPlayer,Counter), 0, 0); break;
                case 1 : addObject(new shrimp(mainPlayer,Counter), getWidth()/2, 0); break;
                case 2 : addObject(new shrimp(mainPlayer,Counter), getWidth(), 0); break;
                case 3 : addObject(new shrimp(mainPlayer,Counter), 0, getHeight()/2); break;
                case 4 : addObject(new shrimp(mainPlayer,Counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new shrimp(mainPlayer,Counter), 0, getHeight()); break;
                case 6 : addObject(new shrimp(mainPlayer,Counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new shrimp(mainPlayer,Counter), getWidth(), getHeight()); break;
            }
        }
    }
    
    public void spawnDeadbeat() {
        if (count % 100 == 0){
            randomSpawn = Greenfoot.getRandomNumber(2);
            switch(randomSpawn) {
                case 0 : addObject(new deadbeat(mainPlayer,Counter), 0, 0); break;
                case 1 : addObject(new deadbeat(mainPlayer,Counter), getWidth()/2, 0); break;
                case 2 : addObject(new deadbeat(mainPlayer,Counter), getWidth(), 0); break;
                case 3 : addObject(new deadbeat(mainPlayer,Counter), 0, getHeight()/2); break;
                case 4 : addObject(new deadbeat(mainPlayer,Counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new deadbeat(mainPlayer,Counter), 0, getHeight()); break;
                case 6 : addObject(new deadbeat(mainPlayer,Counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new deadbeat(mainPlayer,Counter), getWidth(), getHeight()); break;
            }
        }
    }
    
    public void spawnTakodachi() {
        if (count % 200 == 0){
            randomSpawn = Greenfoot.getRandomNumber(1);
            switch(randomSpawn) {
                case 0 : addObject(new takodachi(mainPlayer,Counter), 0, 0); break;
                case 1 : addObject(new takodachi(mainPlayer,Counter), getWidth()/2, 0); break;
                case 2 : addObject(new takodachi(mainPlayer,Counter), getWidth(), 0); break;
                case 3 : addObject(new takodachi(mainPlayer,Counter), 0, getHeight()/2); break;
                case 4 : addObject(new takodachi(mainPlayer,Counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new takodachi(mainPlayer,Counter), 0, getHeight()); break;
                case 6 : addObject(new takodachi(mainPlayer,Counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new takodachi(mainPlayer,Counter), getWidth(), getHeight()); break;
            }
        }
    }
    
    public void started() {
        // memulai pemutaran musik ketika game dimulai
        music = new GreenfootSound("sounds/intro.wav");
        music.playLoop();
        music.setVolume(50);
    }

    public void stopped() {
        // menghentikan pemutaran musik ketika game dihentikan
        music.stop();
    }
}
