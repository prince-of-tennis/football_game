import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.ArrayList;

public class Tile extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    private static ArrayList<Enemy> enemyArray = new ArrayList<Enemy>();
    public Tile()  
    {
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        SummonEnemies(3);
        Player player = new Player(1,10, 10, 10, 10, 10); //int type, int health, int atk, int speed, int r
        addObject(player, getWidth()/2 + 100, getHeight()/2);
    }
    private void SummonEnemies(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            Enemy enem = new Enemy(1, 10, 10, 10, 10);
            addObject(enem, x, y);
            enemyArray.add(enem);
        }
    }
    public static ArrayList<Enemy> getEnemyArray(){
       return enemyArray; 
    }  
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
    }

}