package monkey.sandbox;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AssetsTransitionPanel extends JPanel{
    
    private BufferedImage image;

    public AssetsTransitionPanel(String file) {
        
        try {                
            image = ImageIO.read(new File(file));
        } catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    public int getImageWidth(){
        return image.getWidth();
    }
    
    public int getImageHeight(){
        return image.getHeight();
    }
}