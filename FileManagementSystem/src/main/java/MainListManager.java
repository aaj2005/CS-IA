/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
///*import java.util.Enumeration;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipFile;*/
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import org.apache.commons.io.FilenameUtils;


public class MainListManager extends MainGUI{
    private MainGUI mainClass = new MainGUI();
    DefaultListModel model;

    public MainListManager() {        
        
    }
    

       

    public void addItemsToMainList(JList<String> MainFileList, ActionEvent evt){
	if (evt.getActionCommand() == "ApproveSelection") {
            
            MainDirectorySearch = (JFileChooser) evt.getSource();
            System.out.println(MainDirectorySearch.getSelectedFile());
            MainDirectorySearch.setCurrentDirectory(MainDirectorySearch.getSelectedFile());
            MainListManager add = new MainListManager();

            try{

                MainFileList.setModel(add.retrieveFileNames(MainDirectorySearch.getSelectedFile(),MainFileList));
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
    
    public DefaultListModel retrieveFileNames(File path, JList<String> MainFileList) throws IOException{
            
            
            
            MainFileList.setModel(new DefaultListModel());   
            model = (DefaultListModel) MainFileList.getModel();
            
            getFileNames(path);
            MainFileList = new JList(model);
            return model;
    }
    public File getFileNames(File folder) throws IOException {

        File[] fileList = folder.listFiles();
        if (fileList == null) {
            return new File("C");
        }
        try{
            for (final File file : fileList ) {
                //Path path = Paths.get(file.toString());
                //BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                if(/*videoTypeList.contains(FilenameUtils.getExtension(file.toString())) ||*/ imageTypeList.contains(FilenameUtils.getExtension(file.toString()))){
                    model.addElement(file.getName());
                }else if(zipTypeList.contains(FilenameUtils.getExtension(file.toString()))){
                }else{
                    File subFiles = new File(file.toString());
                    getFileNames(subFiles);
                }
            }
	}catch(IOException e){
	    System.out.println(e);
	}
	return null;
    }
    
}






//          File[] roots = File.listRoots();
//          getFileNames(new File("C:\\Users\\alial\\Desktop\\Programs\\Java\\Zip"));
//          ZipFile zipFile = new ZipFile("C:\\Users\\alial\\Desktop\\Programs\\Java\\Zip\\compressjpeg (1).zip");
//          Enumeration<? extends ZipEntry> entries = zipFile.entries();
//          while(entries.hasMoreElements()){
//              ZipEntry entry = entries.nextElement();
//              InputStream stream = zipFile.getInputStream(entry);
//              getFileNames(stream);
//          }
//            System.out.println(count);
