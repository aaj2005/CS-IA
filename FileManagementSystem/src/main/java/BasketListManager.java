
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.commons.io.FilenameUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class BasketListManager{
    

    

    //create an instance of the treeinsertionmanager class
    static TreeInsertionManager treeInserter = new TreeInsertionManager();
    
    //method responsible for adding files from main file list to the basket
    public static void addToBasket() throws IOException{
	//get basket tree model and enumerate all the tree nodes inside it
	DefaultTreeModel BasketTreeModel = (DefaultTreeModel) MainGUI.Basket.getModel();
	Enumeration e = ((DefaultMutableTreeNode)((DefaultTreeModel)(MainGUI.Basket.getModel()))
		.getRoot()).breadthFirstEnumeration();
	e.nextElement();
	FileClass nextFile;
	//get the metadata of the selected file from the main file list
	FileClass currentFile = (FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList
		.getLastSelectedPathComponent())
		.getUserObject();
	//iterate through all items in the basket
	while(e.hasMoreElements()){
	    nextFile = (FileClass)((DefaultMutableTreeNode)e.nextElement()).getUserObject();
	    //if the file trying to be added to the list already exists in the basket exit
	    if(nextFile.getAbsPath().equals(currentFile.getAbsPath())){
		JOptionPane.showMessageDialog(MainGUI.getWindows()[0], "Selected item is already in Basket!");
		return;
	    }
	}
	
	
	//insert the file/directory to the basket
	FileClass selectedFile = ((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList
		.getLastSelectedPathComponent()).getUserObject());
	BasketTreeModel = treeInserter.addFolderToBasket(MainGUI.Basket,selectedFile.getAbsPath() , new File(selectedFile.getAbsPath()));
	
	((DefaultMutableTreeNode)((DefaultMutableTreeNode)BasketTreeModel.getRoot()).getLastChild())
		.setUserObject((FileClass)(((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject()));
	MainGUI.Basket.setModel(BasketTreeModel);
	
    }
    
    public static void removeFromBasket(){
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	TreePath parentpath=null;
	//loop to support multiselection remove
	for (TreePath selectionPath : MainGUI.Basket.getSelectionPaths()) {
	    System.out.println((DefaultMutableTreeNode) selectionPath.getLastPathComponent());
	    parentpath = selectionPath.getParentPath();
	    //if all files are removed from a directory inside the tree, remove all its subfolders
	    model.removeNodeFromParent((DefaultMutableTreeNode) selectionPath.getLastPathComponent());
	    removeParentPath(parentpath,model);	    
	}
	model.reload();
	MainGUI.Basket.setModel(model);
	MainGUI.addToBasketButton.setText("+");
    }
    
    //remove subfolders of folders with no files
    private static void removeParentPath(TreePath parentPath, DefaultTreeModel model){
	if(!((DefaultMutableTreeNode)parentPath.getLastPathComponent()).equals((DefaultMutableTreeNode)model.getRoot())){
	    model.removeNodeFromParent((DefaultMutableTreeNode)parentPath.getLastPathComponent());
	    return;
	}
	DefaultMutableTreeNode node = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
	
	if(node.isLeaf() || (node.getDepth()==1 && node.getChildAt(0).isLeaf())){
	    removeParentPath(parentPath.getParentPath(),model);
	    
	}
	
	
    }
    
    static int basketElement;
    
    //move the basket to selected folder
    public static void moveFiles(File destination, DefaultMutableTreeNode root) throws IOException{
	MainGUI.MainImage.removeAll();
	ImageHandling.mediaPlayerComponent.mediaPlayer().controls().stop();
	//loop through basket
	for(int path=0; path<root.getChildCount();path++){
	    
	    File destinationFile = new File(destination.getAbsolutePath()+"\\"+root.getChildAt(path));
	    FileClass fileProperties = (FileClass)
		    (((DefaultMutableTreeNode)(root.getChildAt(path)))).getUserObject();
	    File currentFile = new File((fileProperties.getAbsPath()));
	    //if the item is a directory
	    
	    if(!(destinationFile.exists()) && (currentFile.exists())){
		if(currentFile.isDirectory()){
		    // create the folder and recurse through the files/directories inside
		    destinationFile.mkdir();
		    moveFiles(destinationFile,(DefaultMutableTreeNode)root.getChildAt(path));
		}else{
		    //move file
		    fileProperties.moveFile(destination.getAbsolutePath());
		}
		
	    //if there is a file with the same name in the destination folder
	    }else{
		//give option to rename
		int approve = JOptionPane.showConfirmDialog(MainGUI.getWindows()[0],"Error! "+ destination.getName()
			+"\\"+root.getChildAt(path)+" already exists. Would you like to rename it?");
		if(JOptionPane.YES_OPTION==approve){
		    boolean successRename = false;
		    //loop until the file name is not a duplicate or user cancels operation
		    while(!successRename){
			String renamedFile = JOptionPane.showInputDialog("File Name:");
			if(renamedFile==null){
			    return;
			}
			if(currentFile.isDirectory()){
			    destinationFile = new File(destination.getAbsolutePath()+"\\"+renamedFile);
			}else{
			    destinationFile = new File(destination.getAbsolutePath()+"\\"+renamedFile+"."+FilenameUtils
				    .getExtension(currentFile.toString()));
			}
			if(!(destinationFile.exists()) && currentFile.exists()){
			    successRename = true;
			    destinationFile = new File(destination.getAbsolutePath()+"\\"+renamedFile);
			    if(currentFile.isDirectory()){
				destinationFile.mkdir();
				moveFiles(destinationFile,(DefaultMutableTreeNode)root.getChildAt(path));
			    }else{
				fileProperties.moveFile(destination.getAbsolutePath());
			    }
			}
		    }
		}else{
		    return;
		}   
	    }	   
	}
	
    }
    
    

    public BasketListManager() {
	
    }
    
    
    
    
    
    

    
    
}
