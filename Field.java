import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;

public class Field extends World
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public static ArrayList<FootballPlayer> players = new ArrayList<FootballPlayer>();
    public static ArrayList<Defense> defenders = new ArrayList<Defense>();
    public static int level = 0; 
    public static int win = 0;
    public static int lose = 0;
    public static GreenfootImage bg = null;
    private GreenfootImage field = new GreenfootImage("fieldCropped.jpg");
    public static int curr = 1;
    public static int previousCurr = 1;
    public Field(int lvl)  
    {
        super(WIDTH, HEIGHT, 1);
        curr = lvl;
        previousCurr= lvl;
        field.scale(800, 600);
        setBackground(field);
        level = lvl;
        lose =0; 
        win = 0;
        
        bg = new GreenfootImage("Level "+ level, 150, Color.WHITE, new Color(0, 0, 0, 0));
        bg.setTransparency(80);
        getBackground().drawImage(bg, (getWidth()-bg.getWidth())/2, (getHeight()-bg.getHeight())/2);
        SummonPlayers();
        SummonEnemies();
    }

    private boolean win(){
        
        if(FootballPlayer.X >723){
            win++; 
            if(win ==1){
                
                //if curr == 4
                return true;}
        }
        return false;
    }

    private boolean lose(){
        
        if(lose == 1){return true;}
        else{return false;}
    }
    

    public void act(){
        if(Greenfoot.isKeyDown("backspace")){
            FootballPlayer.activePlayer = 1;
            LevelSelect ls = new LevelSelect();
            Greenfoot.setWorld(ls);
        }
        if(win()){
            if(level == 3){
                haha();
                previousCurr= 1;
                curr =1;
                
                FootballPlayer.X = 0;
                FootballPlayer.Y= 0;
                Greenfoot.playSound("success.mp3");
                Greenfoot.playSound("longCrowdCheering.mp3"); 
                Greenfoot.delay(200);
                Menu menu = new Menu();
                Greenfoot.setWorld(menu);
                
            }
            else{
                touchdown();
                
                FootballPlayer.prevPlayer = 1;
                Greenfoot.playSound("shortCrowdCheering.mp3");
                Greenfoot.delay(200);
                FootballPlayer.X = 0;
                FootballPlayer.Y= 0;
                curr = previousCurr + 1;
                previousCurr = curr;
                Field play = new Field(curr);
                Greenfoot.setWorld(play);
                
                
            }
        }
        if(lose()){
            gameOver();
           
            FootballPlayer.prevPlayer = 1;
            Greenfoot.playSound("failure.mp3"); 
            lose ++;
            Greenfoot.delay(200);
            FootballPlayer.X = 0;
            FootballPlayer.Y= 0;
            Field play = new Field(curr);   
            Greenfoot.setWorld(play);
            
        }

    }

    protected void SummonEnemies(){
        int ySpacing = 85;
        int xSpacing;
        if (level == 1){
            xSpacing = -50;
        }   
        if (level == 2){
                xSpacing = 0;
            }
        else xSpacing = 50;
        int startX = getWidth() / 2+250; 
        int startY = ySpacing;
        int[] speeds = {level, level+1, level+2};
        for (int i = 1; i <= 3; i++) {
                Defense player = new Defense(speeds[i-1]);
                addObject(player, startX + (i-1) * xSpacing /2, startY + (i - 1) * ySpacing);
        }
        for (int i = 4; i <= 6; i++) {
                Defense player = new Defense(speeds[6-i]);
                addObject(player, startX + (6-i) * xSpacing /2, startY + (i - 1) * ySpacing);
        }
    }

    protected void SummonPlayers(){
        int spacing = 50;
        int startX = getWidth() / 2-250; 
        int startY = spacing*3; 
        for (int i = 1; i <= 3; i++) {
            FootballPlayer player = new FootballPlayer(i, 1, i == 1);
            addObject(player, startX + (3-i) * spacing /2, startY + (i - 1) * spacing);
            players.add(player);
        }
        for (int i = 4; i <= 6; i++) {
            FootballPlayer player = new FootballPlayer(i, 1, i == 1);
            addObject(player, startX + (i-4) * spacing /2, startY + (i - 1) * spacing);
            players.add(player);
        }
    }
    
    public void touchdown(){
       GreenfootImage gg = new GreenfootImage("TOUCHDOWN!!!", 120, Color.YELLOW, new Color(0, 0, 0, 0));
       getBackground().drawImage(gg, (getWidth()-gg.getWidth())/2, (getHeight()-gg.getHeight()-50));
    }
    
    public void haha(){
       GreenfootImage gg = new GreenfootImage("YOU WIN!!!", 150, Color.YELLOW, new Color(0, 0, 0, 0));
       getBackground().drawImage(gg, (getWidth()-gg.getWidth())/2, (getHeight()-gg.getHeight()-50));
    }


    public void gameOver() {
       GreenfootImage gg = new GreenfootImage("Game Over", 150, Color.RED, new Color(0, 0, 0, 0));
       getBackground().drawImage(gg, (getWidth()-gg.getWidth())/2, (getHeight()-gg.getHeight()-50));
       
    }

}
