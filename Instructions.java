
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private GreenfootImage field = new GreenfootImage("fieldCropped.jpg");
    public static GreenfootImage bg = null;
    public static GreenfootImage space = null;
    public Instructions()
    {    
        super(WIDTH, HEIGHT,1); 
        field.scale(800, 600);
        setBackground(field);
        int height = 360;
        bg = new GreenfootImage("Instructions", 75, Color.YELLOW, new Color(0, 0, 0, 0));
        getBackground().drawImage(bg, (getWidth()-bg.getWidth())/2, (90));
        int left = (getWidth()-bg.getWidth())/2-130;
        GreenfootImage box = new GreenfootImage("greenBox.png");
        box.scale(620,180);
        getBackground().drawImage(box, (getWidth()-bg.getWidth())/2-140, (210));
        GreenfootImage bkg = new GreenfootImage("You are the coach of Broncos, and your goal is to win the Duper Bowl!", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(bkg, left, (220));
        GreenfootImage inst1 = new GreenfootImage("You can pass the ball to another player by using the number keys 1-6", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst1, left, (height-100));
        GreenfootImage inst2 = new GreenfootImage("You always control the movement of the player with the ball, which is indicated by a", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst2, left, (height-80));
        GreenfootImage inst25 = new GreenfootImage("different-looking player with a ball drawn on it.", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst25, left, (height-60));
        GreenfootImage inst3 = new GreenfootImage("You can move the player you are controlling up and down with W and S, respectively.", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst3,left, (height-40));
        GreenfootImage inst4 = new GreenfootImage("If you want to exit the level during the game, press backspace.", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst4, left, (height-20));
        GreenfootImage inst5 = new GreenfootImage("you may not pass the ball back and forth between two players.", 20, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(inst5, left, (height));
        space = new GreenfootImage("Press W to Select a Level", 50 , Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(space, (getWidth()-space.getWidth())/2, (440));
    }
    public void act(){
        if(Greenfoot.isKeyDown("w")){
            LevelSelect ins = new LevelSelect();
            Greenfoot.setWorld(ins);
        }
    }
    
}
