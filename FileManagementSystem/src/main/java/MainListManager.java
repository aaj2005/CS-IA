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
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import org.apache.commons.io.FilenameUtils;


public class MainListManager extends MainGUI{
    DefaultTreeModel model;
    DefaultMutableTreeNode placeHolderNode;
    public MainListManager() {        
        
    }
    

       

    public void addItemsToMainList(JTree MainFileList, ActionEvent evt){
	if (evt.getActionCommand() == "ApproveSelection") {
            
            MainDirectorySearch = (JFileChooser) evt.getSource();
            //System.out.println(MainDirectorySearch.getSelectedFile());
            MainDirectorySearch.setCurrentDirectory(MainDirectorySearch.getSelectedFile());
	    currentDirectory = MainDirectorySearch.getSelectedFile();
            MainListManager add = new MainListManager();

            try{

                MainFileList.setModel(add.retrieveFileNames(MainDirectorySearch.getSelectedFile(),MainFileList));
            }catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
    
    public DefaultTreeModel retrieveFileNames(File path, JTree MainFileList) throws IOException{
            
            
            
            
            model = (DefaultTreeModel) MainFileList.getModel();
	    //parentFile.add(new DefaultMutableTreeNode(path.getName()));
	    model.setRoot(new DefaultMutableTreeNode(path.getName()));
            getFileNames(path, (DefaultMutableTreeNode)model.getRoot());
            MainFileList = new JTree(model);
            model.reload();
	    return model;
    }
    
    public File getFileNames(File folder, DefaultMutableTreeNode rootNode) throws IOException {

        File[] fileList = folder.listFiles();
        if (fileList == null) {
            return new File("C");
        }
        try{
            for (final File file : fileList ) {
                //Path path = Paths.get(file.toString());
                //BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		if(imageTypeList.contains(FilenameUtils.getExtension(file.toString()))){
                    rootNode.add(new DefaultMutableTreeNode(file.getName()));
		    
		    
                }else if(videoTypeList.contains(FilenameUtils.getExtension(file.toString())) ){
		    rootNode.add(new DefaultMutableTreeNode(file.getName()));
		}else if(zipTypeList.contains(FilenameUtils.getExtension(file.toString()))){
                
		}else if(file.isDirectory() && file.list().length>0){
		    rootNode.add(new DefaultMutableTreeNode(file.getName()));
		    
                    File subFiles = new File(file.toString());
                    getFileNames(subFiles, (DefaultMutableTreeNode) rootNode.getLastChild());
		    if(rootNode.getLastChild().getChildCount()<=0){
		    	rootNode.remove(rootNode.getChildCount()-1);
		    }
                }
		model.reload(rootNode);
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
