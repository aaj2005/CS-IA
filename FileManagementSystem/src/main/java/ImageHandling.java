import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.io.FilenameUtils;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
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
	    BufferedImage img = ImageIO.read(new File(src));
	    if(isPlaying()){mediaPlayerComponent.mediaPlayer().controls().stop();}
	    
	    MainGUI.videoSlider.setEnabled(false);
	    MainGUI.pausePlayButton.setIcon(new ImageIcon(getClass()
		    .getResource("/download-icon-play+icon-1320183326084518754_16.png")));
	    MainImage.removeAll();
	    
	    if (img.getWidth() < MainImage.getWidth()/1.5 && img.getHeight() <MainImage.getHeight()/1.5){
		MainImage.setIcon(new ImageIcon(img));
	    }else{
		MainImage.setIcon(new ImageIcon(img.getScaledInstance(MainImage.getWidth(),
			MainImage.getHeight(),
	    Image.SCALE_SMOOTH)));
	    }
	}else if(MainGUI.videoTypeList.contains(FilenameUtils.getExtension(src)) ){
	    if(isPlaying()){mediaPlayerComponent.mediaPlayer().controls().stop();}
	    MainGUI.videoSlider.setEnabled(true);
	    MainImage.setLayout(new BorderLayout());
	    
	    MainImage.add(mediaPlayerComponent, BorderLayout.CENTER);
	    mediaPlayerComponent.mediaPlayer().media().play(src);
	    MainGUI.pausePlayButton.setIcon(new ImageIcon(getClass()
		    .getResource("/download-icon-pause+icon-1320196062769593213_16.png")));
	    mediaPlayerComponent.mediaPlayer().events()
		    .addMediaPlayerEventListener(new MediaPlayerEventListener(){

		

		@Override
		public void playing(MediaPlayer mediaPlayer) {
		    
		    MainGUI.pausePlayButton.setIcon(new javax.swing.ImageIcon(getClass()
			    .getResource("/download-icon-pause+icon-1320196062769593213_16.png")));

		}

		@Override
		public void paused(MediaPlayer mediaPlayer) {
		    MainGUI.pausePlayButton.setIcon(new javax.swing.ImageIcon(getClass()
			    .getResource("/download-icon-play+icon-1320183326084518754_16.png")));
		}

		@Override
		public void stopped(MediaPlayer mediaPlayer) {
		    MainGUI.currentTime.setText("00:00:00");
		    MainGUI.videoLengthTime.setText("00:00:00");
		    MainGUI.videoSlider.setMaximum(0);
		    MainGUI.videoSlider.setValue(0);
		    MainGUI.pausePlayButton.setIcon(new javax.swing.ImageIcon(getClass()
			    .getResource("/download-icon-play+icon-1320183326084518754_16.png")));
		}

		@Override
		public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
		    MainGUI.videoSlider.setValue((int)newTime);
		    String formattedLength = String.format("%02d:%02d:%02d",
			    TimeUnit.MILLISECONDS.toHours(newTime),
		    TimeUnit.MILLISECONDS.toMinutes(newTime) 
			    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(newTime)),
		    TimeUnit.MILLISECONDS.toSeconds(newTime) 
			    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(newTime)));
		    MainGUI.currentTime.setText(formattedLength);
		}
		
		@Override
		public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
		    MainGUI.videoSlider.setMaximum((int)newLength);
		    String formattedLength = String.format("%02d:%02d:%02d",
			    TimeUnit.MILLISECONDS.toHours(newLength),
		    TimeUnit.MILLISECONDS.toMinutes(newLength) 
			    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(newLength)),
		    TimeUnit.MILLISECONDS.toSeconds(newLength) 
			    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(newLength)));
		    
		    MainGUI.videoLengthTime.setText(formattedLength);    
		}
		
		@Override
		public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
		}

		@Override
		public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
		}

		@Override
		public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
		}

		@Override
		public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
		}

		@Override
		public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
		}
		@Override
		public void mediaChanged(MediaPlayer mediaPlayer, MediaRef media) {
		}

		@Override
		public void opening(MediaPlayer mediaPlayer) {
		}

		@Override
		public void buffering(MediaPlayer mediaPlayer, float newCache) {
		}
		@Override
		public void forward(MediaPlayer mediaPlayer) {
		}

		@Override
		public void backward(MediaPlayer mediaPlayer) {
		}

		@Override
		public void finished(MediaPlayer mediaPlayer) {
		    
		}

		@Override
		public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
		}

		@Override
		public void scrambledChanged(MediaPlayer mediaPlayer, int newScrambled) {
		}

		@Override
		public void elementaryStreamAdded(MediaPlayer mediaPlayer, TrackType type, int id) {
		}

		@Override
		public void elementaryStreamDeleted(MediaPlayer mediaPlayer, TrackType type, int id) {
		}

		@Override
		public void elementaryStreamSelected(MediaPlayer mediaPlayer, TrackType type, int id) {
		}

		@Override
		public void corked(MediaPlayer mediaPlayer, boolean corked) {
		}

		@Override
		public void muted(MediaPlayer mediaPlayer, boolean muted) {
		}

		@Override
		public void volumeChanged(MediaPlayer mediaPlayer, float volume) {
		}

		@Override
		public void audioDeviceChanged(MediaPlayer mediaPlayer, String audioDevice) {
		}

		@Override
		public void chapterChanged(MediaPlayer mediaPlayer, int newChapter) {
		}

		@Override
		public void error(MediaPlayer mediaPlayer) {
		}

		@Override
		public void mediaPlayerReady(MediaPlayer mediaPlayer) {
		}

	    });
	    
	    
	    
	}
	
    }
    public static void stopAll(){
	if(isPlaying()){mediaPlayerComponent.mediaPlayer().controls().stop();}
	MainGUI.MainImage.setIcon(new ImageIcon());
    }
    public static void pausePlay(){
	 mediaPlayerComponent.mediaPlayer().controls().pause();
	
	
    }
    
    public static void changeTime(long time){
	mediaPlayerComponent.mediaPlayer().controls().setTime(time);
	
    }
    public static boolean isPlaying(){
	
	return mediaPlayerComponent.mediaPlayer().status().isPlaying();
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
