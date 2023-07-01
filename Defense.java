import greenfoot.*;

public class Defense extends Actor {
    private int speed;

    public Defense(int defenseSpeed) {
        speed = defenseSpeed;
        GreenfootImage defenderImage;
        if(Field.level==1){
            defenderImage = new GreenfootImage("dolphin_player.png");
        }else if(Field.level==2){
            defenderImage = new GreenfootImage("ram_player.png");
        }else{
            defenderImage = new GreenfootImage("raider_player.png");
        }
        defenderImage.scale(30,30);
        setImage(defenderImage);
    }

    public void act() {
        turnTowards(FootballPlayer.X, FootballPlayer.Y);
        move(speed);
    }
}
