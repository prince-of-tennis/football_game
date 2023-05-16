import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Defender extends Entity
{
    public Defender(){
        setImage("enemy.png");
    }
    public void act() 
    {
        isDead();
    }
}
