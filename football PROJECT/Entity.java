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
    protected int speed;
    protected int stoppingPower;

    public Entity(int speed, int stoppingPower) 
    {
        this.speed=speed;
        this.stoppingPower=stoppingPower;
    }    
    public void move(){
        move(speed);
    }
}
