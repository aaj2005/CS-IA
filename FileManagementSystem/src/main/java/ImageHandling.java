

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.io.FilenameUtils;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class ImageHandling{
   static EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent(); 
    public ImageHandling(){
	
    }
    
    public void setImage(String src, JLabel MainImage) throws IOException, InterruptedException{
		
	
	
	int type = BufferedImage.TYPE_INT_ARGB;
	if(new File(src).isDirectory()){

	}else if(MainGUI.imageTypeList.contains(FilenameUtils.getExtension(src)) ){
	    mediaPlayerComponent.mediaPlayer().controls().stop();
	    MainImage.removeAll();
	    BufferedImage img = ImageIO.read(new File(src));
	    if (img.getWidth() < MainImage.getWidth()/1.5 && img.getHeight() <MainImage.getHeight()/1.5){
		MainImage.setIcon(new ImageIcon(img));
	    }else{
		MainImage.setIcon(new ImageIcon(img.getScaledInstance(MainImage.getWidth(), MainImage.getHeight(),
	    Image.SCALE_SMOOTH)));
	    }
	}else if(MainGUI.videoTypeList.contains(FilenameUtils.getExtension(src)) ){
	    mediaPlayerComponent.mediaPlayer().controls().stop();
	    
	    MainImage.setLayout(new BorderLayout());
	    
	    MainImage.add(mediaPlayerComponent, BorderLayout.CENTER);
	    mediaPlayerComponent.mediaPlayer().media().play(src);

	}
	
    }
    public static void play(){
	mediaPlayerComponent.paused(mediaPlayerComponent.mediaPlayer());
	MainGUI.MainImage.setLayout(new BorderLayout());

	MainGUI.MainImage.add(mediaPlayerComponent, BorderLayout.CENTER);
	   
	mediaPlayerComponent.mediaPlayer().media().play("");

	   
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
