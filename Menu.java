import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private GreenfootImage field = new GreenfootImage("fieldCropped.jpg");
    public static GreenfootImage bg = null;
    public static GreenfootImage space = null;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(WIDTH, HEIGHT,1); 
        field.scale(800, 600);
        setBackground(field);
        bg = new GreenfootImage("PHOOTBALL", 75, Color.YELLOW, new Color(0, 0, 0, 0));
        getBackground().drawImage(bg, (getWidth()-bg.getWidth())/2+5, (90));
        GreenfootImage ball = new GreenfootImage("newFootball.png");
        ball.scale(230,230);
        getBackground().drawImage(ball, (getWidth()-bg.getWidth())/2+70, (200));
        space = new GreenfootImage("Press Space to Start", 50 , Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(space, (getWidth()-space.getWidth())/2, (440));
    }
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Instructions ins = new Instructions();
            Greenfoot.setWorld(ins);
        }
    }
}
