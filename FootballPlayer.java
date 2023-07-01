
import greenfoot.*;
import java.util.*;
public class FootballPlayer extends Actor {
    private int playerNumber;
    private boolean active = false;
    public static int activePlayer = 1;
    public static int prevPlayer = 1;
    private int speed;
    public static int X = 0;
    public static int Y = 0;
    
    public FootballPlayer(int number, int playerSpeed, boolean isActive) {
        playerNumber = number;
        active = isActive;
        speed = playerSpeed;
        GreenfootImage playerImage = new GreenfootImage("player.png");
        playerImage.scale(30,30);
        setImage(playerImage);
        if (isActive) {
            activePlayer = number;
            
        }
        setActive();
    }
    public int getNumber(){return playerNumber;}
    public void act() {
        
        checkKeyPress();
        if (playerNumber == activePlayer) {
            X= getX();
            Y = getY();
            handleMovement();
            checkCollisionWithDefense();
        }
    }
    public boolean isActive(){return active;}
    private void checkCollisionWithDefense() {
        Actor defense = getOneIntersectingObject(Defense.class);
        if (defense != null) {
            Field.lose++;
        }
    }

    private void checkKeyPress() {
        if (Greenfoot.isKeyDown(String.valueOf(playerNumber))) {
            if (playerNumber != activePlayer && playerNumber != prevPlayer){
                Greenfoot.playSound("whoosh.mp3");
                switchToPlayer(playerNumber);
            }
        }
        
        else goRight();
    }
    private void goRight(){
        setLocation(getX() + speed, getY());
    }
    

    private void handleMovement() {
        int dx = 1;
        int dy = 0;
        /*
        if (Greenfoot.isKeyDown("a")) {
            dx = -speed;
        }
        */
        if (Greenfoot.isKeyDown("w")) {
            dy -= speed;
        }
        if (Greenfoot.isKeyDown("s")) {
            dy += speed;
        }
        setLocation(getX() + dx, getY() + dy);
    }

    private static void switchToPlayer(int pnum) {
        prevPlayer = activePlayer;
        activePlayer=pnum;
        setActive();
    }

    public static int getActivePlayer() {
        return activePlayer;
    }

    public static void setActive() {
        GreenfootImage playerImage = new GreenfootImage("player_w_football.png");
        playerImage.scale(30,30);
        GreenfootImage playerImage2 = new GreenfootImage("player.png");
        playerImage2.scale(30,30);
        for(FootballPlayer player: Field.players){
            if(player.getNumber() == activePlayer){player.setImage(playerImage);}
            else{player.setImage(playerImage2);}           
        }
}}
