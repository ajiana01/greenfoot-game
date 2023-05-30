import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    private GreenfootImage[] images;
    private int currentImageIndex;
    private GreenfootImage cursorImage;
    private long lastShotTime = 0;
    private long shootDelay = 175;
    int time=0;
    private GreenfootSound sfx;
    
    public player() {
        // Menetapkan ukuran array dan menginisialisasi gambar-gambar
        images = new GreenfootImage[2];
        images[0] = new GreenfootImage("images/subaru-idle.gif");
        images[0].scale(50, 56);
        images[1] = new GreenfootImage("images/subaru-run.gif");
        images[1].scale(50, 56);
        cursorImage = new GreenfootImage("images/spr_holoCursor.png");
        
        // Menetapkan gambar awal dan inisialisasi variabel
        setImage(images[0]);
        currentImageIndex = 0;
    }

    public void act() {
        time++;
        currentImageIndex = 0;
        setImage(images[currentImageIndex]);
        turnAround();
        moveAround();
        shootWeapon();
        hitByShrimp();
        hitByDeadbeat();
        hitByTakodachi();
    }
    
    public void turnAround() {
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            // Mengatur rotasi karakter
            turnTowards(mouse.getX(), mouse.getY());
            // Mengatur flip horizontal karakter
            if (mouse.getX() < getX()) {
                setRotation(0);
                GreenfootImage flippedImage = new GreenfootImage(images[currentImageIndex]);
                flippedImage.mirrorHorizontally();
                setImage(flippedImage);
            } else {
                setRotation(0);
                setImage(images[currentImageIndex]);
            }
        }
    }
    
    public void moveAround() {
        // Mendapatkan tombol yang ditekan
        boolean isUpKeyPressed = Greenfoot.isKeyDown("w");
        boolean isDownKeyPressed = Greenfoot.isKeyDown("s");
        boolean isLeftKeyPressed = Greenfoot.isKeyDown("a");
        boolean isRightKeyPressed = Greenfoot.isKeyDown("d");
        
        // Menggerakkan player sesuai dengan tombol yang ditekan
        if (isUpKeyPressed) {
            currentImageIndex = 1;
            setImage(images[currentImageIndex]);
            setLocation(getX(), getY() - 5);
        }
        if (isDownKeyPressed) {
            currentImageIndex = 1;
            setImage(images[currentImageIndex]);
            setLocation(getX(), getY() + 5);
        }
        if (isLeftKeyPressed) {
            currentImageIndex = 1;
            setImage(images[currentImageIndex]);
            GreenfootImage flippedImage = new GreenfootImage(images[currentImageIndex]);
            flippedImage.mirrorHorizontally();
            setImage(flippedImage);
            setLocation(getX() - 5, getY());
        }
        if (isRightKeyPressed) {
            currentImageIndex = 1;
            setImage(images[currentImageIndex]);
            setLocation(getX() + 5, getY());
        }
    }
    
    public void shootWeapon() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime >= shootDelay && Greenfoot.mousePressed(null)) {
            weapon arahWeapon = new weapon();
            getWorld().addObject(arahWeapon, getX(), getY());
            arahWeapon.setRotation(getRotation());
            arahWeapon.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            lastShotTime = currentTime;
            sfx = new GreenfootSound("sounds/shoot.wav");
            sfx.setVolume(80);
            sfx.play();
        }
        
    }
    
    public boolean hitByShrimp(){
        Actor Shrimp = getOneObjectAtOffset(0,0, shrimp.class);
        if(Shrimp!=null){
            return true;
        } else
        return false;
    
    }
    
    public boolean hitByDeadbeat(){
        Actor Deadbeat = getOneObjectAtOffset(0,0, deadbeat.class);
        if(Deadbeat!=null){
            return true;
        } else
        return false;
    
    }
    
    public boolean hitByTakodachi(){
        Actor Takodachi = getOneObjectAtOffset(0,0, takodachi.class);
        if(Takodachi!=null){
            return true;
        } else
        return false;
    
    }
        
    
}

