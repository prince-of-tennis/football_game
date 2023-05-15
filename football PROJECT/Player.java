import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
   private boolean hasBall;
   public Player(boolean hasBall){
        this.hasBall = hasBall;
   }    
   public void act()
    {
        checkKeys();
    }    
   public void pass(Entity p2){
       p2.setBall(true);
    }
   public void setBall(boolean b){hasBall =b;}
    private void checkKeys(){
        if(hasBall){
            
        if (Greenfoot.isKeyDown("w")){
            setRotation(270);
            move();
        }else if (Greenfoot.isKeyDown("s")){
            setRotation(90);
            move();
        }
            if (Greenfoot.isKeyDown("a")){
            
        
        } else if (Greenfoot.isKeyDown("d")){
            setRotation(0);
            move();
        }   
        }
    }
}
