/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */

import java.io.File;
import java.io.IOException;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.commons.io.FilenameUtils;


public class TreeInsertionManager{
    
    DefaultTreeModel treeModel;//general tree model
    
    //initialize constructer
    public TreeInsertionManager() {        
        
    }
    

       
    //method called when folders are inserted into main visible file list
    public File addFolderContentToTree(JTree FileTree, String Path,File selectedFile) throws IOException{
            
	    //get tree root
	    treeModel = (DefaultTreeModel) FileTree.getModel();
	    treeModel.setRoot(new DefaultMutableTreeNode(selectedFile.getName()));
            //add files to tree
	    getFileNames(selectedFile, (DefaultMutableTreeNode)treeModel.getRoot());
	    //refresh and update tree model
	    treeModel.reload();
	    FileTree.setModel(treeModel);
	    return MainGUI.MainDirectorySearch.getSelectedFile();
	
    }
    
    //method called when folders are inserted into basket
    public DefaultTreeModel addFolderToBasket(JTree FileTree, String Path,File selectedFile) throws IOException{
	//get tree model and root
	treeModel = (DefaultTreeModel) FileTree.getModel();
	DefaultMutableTreeNode upperRoot = ((DefaultMutableTreeNode)(treeModel.getRoot()));
	
	//for files
	if(selectedFile.isFile()){
	    //add node and add filelass metadata/properties
	    upperRoot.add(new DefaultMutableTreeNode(selectedFile.getName()));
	    upperRoot.getLastLeaf().setUserObject(new FileClass(selectedFile.getName(),
				selectedFile.getAbsolutePath(),
				upperRoot,
				new TreePath(upperRoot.getLastLeaf().getPath()),
				MainGUI.MainDirectorySearch.getSelectedFile(),
				false));
	//for directories
	}else{
	    //add folder name and set metadata
	    upperRoot.add(new DefaultMutableTreeNode(selectedFile.getName()));
	    upperRoot.getLastLeaf().setUserObject(new FileClass(selectedFile.getName(),
				selectedFile.getAbsolutePath(),
				upperRoot,
				new TreePath(upperRoot.getLastLeaf().getPath()),
				MainGUI.MainDirectorySearch.getSelectedFile(),
				true));
	    //add subfolders
	    getFileNames(selectedFile, (DefaultMutableTreeNode)upperRoot.getLastChild());
	}    
	treeModel.reload();
	FileTree.setModel(treeModel);
	return treeModel;
    }
    
    
    //retrieve files/folders from system and insert into tree
    public void getFileNames(File folder, DefaultMutableTreeNode rootNode) throws IOException {
        //retrieve subfolders and files
	File[] fileList;
	fileList = folder.listFiles();
        if (fileList == null) {
	    
        }
	//loop through the filelist array
	for (final File file : fileList ) {
	    //if file is an image or video
	    if(MainGUI.imageTypeList.contains(FilenameUtils.getExtension(file.toString())) ||
		    MainGUI.videoTypeList.contains(FilenameUtils.getExtension(file.toString()))){
		//add media file to tree and set metadata/properties
		rootNode.add(new DefaultMutableTreeNode(file.getName()));
		rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(),
			file.getAbsolutePath(),
			rootNode,
			new TreePath(rootNode.getLastLeaf().getPath()),
			MainGUI.MainDirectorySearch.getSelectedFile(),
			false));
	    //if it is a directory
	    }else if( file.isDirectory() && file.list()!=null){
		//add folder to tree and its properties
		rootNode.add(new DefaultMutableTreeNode(file.getName()));
		File subFiles = new File(file.toString());
		rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(),
			file.getAbsolutePath(),
			rootNode,
			new TreePath(rootNode.getLastLeaf().getPath()),
			MainGUI.MainDirectorySearch.getSelectedFile(),
			false));
		//set the folder as the root node and recurse to retrieve subfolders
		getFileNames(subFiles, (DefaultMutableTreeNode) rootNode.getLastChild());
		//remove extra child node that is added in the process
		if(rootNode.getLastChild().getChildCount()==0){
		    rootNode.remove(rootNode.getChildCount()-1);
		}
	    }
	}
    }
    
}