
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class ImageHandling{
    
    public ImageHandling(){
	
    }
    
    public void setImage(String src, JLabel MainImage) throws IOException, InterruptedException{
		
	
	
	int type = BufferedImage.TYPE_INT_ARGB;
	if(new File(src).isDirectory()){

	}else {
	    BufferedImage img = ImageIO.read(new File(src));
	    if (img.getWidth() < MainImage.getWidth()/1.5 && img.getHeight() <MainImage.getHeight()/1.5){
		MainImage.setIcon(new ImageIcon(img));
	    }else{
		MainImage.setIcon(new ImageIcon(img.getScaledInstance(MainImage.getWidth(), MainImage.getHeight(),
	    Image.SCALE_SMOOTH)));
	    }
	}
	
    }

    public void handler(String src, JLabel MainImage){
	
	try {
	    setImage(src, MainImage);
	} catch (IOException ex) {
	    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ImageHandling.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
	    
	
    
}
