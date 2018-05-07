package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {
Thread thread= new Thread();
    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 4; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Standing"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int n=0;
        while (true) {
            try {
                
                thread.sleep(100);
                n=n%4;
                super.setImage(sprite.get(n));
                n++;
            } 
            catch (InterruptedException ex) { }
        }
    }
}
