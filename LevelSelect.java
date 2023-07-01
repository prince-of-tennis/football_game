import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private GreenfootImage field = new GreenfootImage("fieldCropped.jpg");
    public static GreenfootImage bg = null;
    public static GreenfootImage space = null;
    public LevelSelect()
    {    
        super(WIDTH, HEIGHT,1); 
        field.scale(800, 600);
        setBackground(field);
        bg = new GreenfootImage("LEVEL SELECT", 75, Color.YELLOW, new Color(0, 0, 0, 0));
        getBackground().drawImage(bg, (getWidth()-bg.getWidth())/2, (90));
        int leftX = (getWidth()-bg.getWidth())/2+50;
        GreenfootImage l1 = new GreenfootImage("Z - Level 1: Dolphins", 45, Color.CYAN, new Color(0, 0, 0, 0));
        getBackground().drawImage(l1, leftX, (220));
        GreenfootImage l2 = new GreenfootImage("X - Level 2: Rams", 45, Color.BLUE, new Color(0, 0, 0, 0));
        getBackground().drawImage(l2, leftX, (280));
        GreenfootImage l3 = new GreenfootImage("C - Level 3: Raiders", 45, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(l3, leftX, (340));
        space = new GreenfootImage("Press Z, X, or C to select level", 50 , Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(space, (getWidth()-space.getWidth())/2, (440));
    }
    public void act(){
        Field level;
        if(Greenfoot.isKeyDown("Z")){
            level = new Field(1);
            Greenfoot.setWorld(level);
        }
        if(Greenfoot.isKeyDown("X")){
            level = new Field(2);
            Greenfoot.setWorld(level);
        }
        if(Greenfoot.isKeyDown("C")){
            level = new Field(3);
            Greenfoot.setWorld(level);
        }
        
    }
    
}
