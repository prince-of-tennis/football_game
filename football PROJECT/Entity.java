import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends SmoothMover
{
    protected int health;
    protected int atk;
    protected int speed;
    protected int reloadTime;
    protected int type; // 1=water,2=fire,3=electric -> can only defeat enemies of your own kind
    protected int reloadDelayCount;
    
    protected int getHealth(){return health;}
    protected int getAtk(){return atk;}
    //protected int getSpeed(){return speed;}
    protected int getReloadTime(){return reloadTime;}
    protected int getType(){return type;}
    
    protected void setHealth(int newHealth){health = newHealth;}
    protected void setAtk(int newHealth){health = newHealth;}
    protected void setSpeed(int newSpeed){health = newSpeed;}
    protected void setReloadTime(int newReloadTime){reloadTime = newReloadTime;}

    public Entity(int type, int health, int atk, int speed, int r) 
    {
        this.type=type;
        this.health=health;
        this.atk=atk;
        this.speed=speed;
        this.reloadTime =r;
    }
    public void attack(Entity e){
        if(e.getType()==type){
            e.setHealth(e.getHealth()-getAtk());
        }
    }
    public abstract void fire();
    public abstract void isDead();
    public void move(){
        move(speed);
    }
}
