package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int x=0;
        int y=0;
        while (true) {
            try {
                super.setX(x);
                Thread.sleep(5);
                
                y=y%7;
                super.setImage(sprite.get(y));
                y++;
                x++;
                if(x==700){
                x=0;
                }

            } 
            catch (InterruptedException ex) {}
        }
    }
}
