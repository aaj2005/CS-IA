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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
///*import java.util.Enumeration;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipFile;*/
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.commons.io.FilenameUtils;


public class MainListManager{
    DefaultTreeModel model;
    DefaultMutableTreeNode placeHolderNode;
    static ImageIcon icon = new ImageIcon("//src//main//resources//zip-file.ico");
    public MainListManager() {        
        
    }
    

       

    public void addItemsToMainList(JTree MainFileList, ActionEvent evt) throws IOException{
	if ("ApproveSelection".equals(evt.getActionCommand())) {
            
            MainGUI.MainDirectorySearch = (JFileChooser) evt.getSource();
            //System.out.println(MainDirectorySearch.getSelectedFile());
            MainGUI.MainDirectorySearch.setCurrentDirectory(MainGUI.MainDirectorySearch.getSelectedFile());
	    MainGUI.currentDirectory = MainGUI.MainDirectorySearch.getSelectedFile();
            MainListManager add = new MainListManager();
	    
	    MainFileList.setModel(add.retrieveFileNames(MainGUI.MainDirectorySearch.getSelectedFile(),MainFileList));
        }
    }
    
    
    public DefaultTreeModel retrieveFileNames(File path, JTree MainFileList) throws IOException{
            
            
            
            
            model = (DefaultTreeModel) MainFileList.getModel();
	    //parentFile.add(new DefaultMutableTreeNode(path.getName()));
	    model.setRoot(new DefaultMutableTreeNode(path.getName()));
            getFileNames(path, (DefaultMutableTreeNode)model.getRoot());
            
	    model.reload();
	    
	    return model;
    }
    
    public File getFileNames(File folder, DefaultMutableTreeNode rootNode) throws IOException {

        File[] fileList = folder.listFiles();
        if (fileList == null) {
            //return new File("C");
        }
	
      
            for (final File file : fileList ) {
                //Path path = Paths.get(file.toString());
                //BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		    if(MainGUI.imageTypeList.contains(FilenameUtils.getExtension(file.toString())) || MainGUI.videoTypeList.contains(FilenameUtils.getExtension(file.toString()))){
			
			
			rootNode.add(new DefaultMutableTreeNode(file.getName()));
			//fileMapList.put(file.getName(), file);
			
			rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(), file.getAbsolutePath(), rootNode, folderPos,MainGUI.MainDirectorySearch.getSelectedFile()));
			
			
			
		    }else if( file.isDirectory() && file.list()!=null){
			    rootNode.add(new DefaultMutableTreeNode(file.getName()));
			    
			    File subFiles = new File(file.toString());
			    rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(), file.getAbsolutePath(), rootNode, folderPos, MainGUI.MainDirectorySearch.getSelectedFile()));
			    getFileNames(subFiles, (DefaultMutableTreeNode) rootNode.getLastChild());
			    
			    if(rootNode.getLastChild().getChildCount()<=0){
				
				rootNode.remove(rootNode.getChildCount()-1);
				
			    }
			    
		    }else if(MainGUI.zipTypeList.contains(FilenameUtils.getExtension(file.toString()))){
			//rootNode.add(new DefaultMutableTreeNode(file.getName()));
			//fileMapList.put(file.getName(), file);
			
			/*MainGUI.MainFileList.setCellRenderer(new DefaultTreeCellRenderer() {
			
			@Override
			public Component getTreeCellRendererComponent(JTree tree,
				Object value, boolean selected, boolean expanded,
				boolean isLeaf, int row, boolean focused) {
			    Component c = super.getTreeCellRendererComponent(tree, value,
				    selected, expanded, isLeaf, row, focused);
			    setIcon(icon);
			    return c;
			}
			});*/
		    }
		    
		    
		
                
		
            }
	    
	    model.reload(rootNode);
	
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
