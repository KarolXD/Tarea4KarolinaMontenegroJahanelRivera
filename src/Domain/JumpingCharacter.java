package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int y = 360;
        while (true) {

            try {
                int n = 0;

                this.setY(y);
                Thread.sleep(10);

                super.setImage(sprite.get(n));

                if (y == 100) {
                    
                    while (y <= 370) {
                        y++;
                        this.setY(y);
                        Thread.sleep(10);
                        super.setImage(sprite.get(n+1));
                        if(y==370){
                        
                        super.setImage(sprite.get(n+2));
                         Thread.sleep(300);
                        }
                    }

                }
                y--;

            } catch (InterruptedException ex) {
            }
        }
    }
}
