import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.ArrayList;

public class Ball extends SmoothMover
{
    private static final int damage = 16;
    private int health = 30;
    private int type=0;
    private int atk=1;
    
    public Ball(int type, int atk, Vector speed, int rotation)
    {
        super(speed);
        this.type=type;
        this.atk=atk;
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    protected int getAtk(){return atk;}
    
    public void act()
    {
        if(getExactX() <= 0 || getExactX() >= 599 || getExactY() <=0 || getExactY() >= 399) {
            getWorld().removeObject(this);
        } 
        else {
            health--;
            move();
            checkBulletHit();
        }
    }
    
    private void checkBulletHit()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null && enemy.getHealth()>0){
            getWorld().removeObject(this);
            enemy.setHealth(enemy.getHealth()-getAtk());
        }
    }
}