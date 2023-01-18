
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    
    JButton removeButton;

    JPanel renderer;

    
    static TreeInsertionManager treeInserter = new TreeInsertionManager();
    
    public static void addToBasket() throws IOException{
	DefaultTreeModel BasketTreeModel = (DefaultTreeModel) MainGUI.Basket.getModel();
	Enumeration e = ((DefaultMutableTreeNode)((DefaultTreeModel)(MainGUI.Basket.getModel()))
		.getRoot()).breadthFirstEnumeration();
	int counter = 1;
	e.nextElement();
	FileClass nextFile;
	FileClass currentFile = (FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList
		.getLastSelectedPathComponent())
		.getUserObject();
	while(e.hasMoreElements()){
	    nextFile = (FileClass)((DefaultMutableTreeNode)e.nextElement()).getUserObject();
	    if(nextFile.getAbsPath().equals(currentFile.getAbsPath())){
		return;
	    }
	}
	FileClass selectedFile = ((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList
		.getLastSelectedPathComponent()).getUserObject());
	treeInserter.addFolderToBasket(MainGUI.Basket,selectedFile.getAbsPath() , new File(selectedFile.getAbsPath()));
	
	((DefaultMutableTreeNode)((DefaultMutableTreeNode)BasketTreeModel.getRoot()).getLastChild())
		.setUserObject((FileClass)(((DefaultMutableTreeNode)MainGUI
			.MainFileList.getLastSelectedPathComponent()).getUserObject()));
	MainGUI.Basket.setModel(BasketTreeModel);
    }
    
    public static void removeFromBasket(){
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	TreePath parentpath=null;
	for (TreePath selectionPath : MainGUI.Basket.getSelectionPaths()) {
	    
	    System.out.println((DefaultMutableTreeNode) selectionPath.getLastPathComponent());
	    //((FileClass) ((DefaultMutableTreeNode) selectionPath.getLastPathComponent()).getUserObject()).removeFromBasket();
	    parentpath = selectionPath.getParentPath();
	    
	    model.removeNodeFromParent((DefaultMutableTreeNode) selectionPath.getLastPathComponent());
	    removeParentPath(parentpath,model);
	    
	}
	
	
	
	model.reload();
	MainGUI.Basket.setModel(model);
	MainGUI.addToBasketButton.setText("+");
    }
    private static void removeParentPath(TreePath parentPath, DefaultTreeModel model){
	System.out.println(parentPath);
	if(!((DefaultMutableTreeNode)parentPath.getLastPathComponent()).equals((DefaultMutableTreeNode)model.getRoot())){
	    model.removeNodeFromParent((DefaultMutableTreeNode)parentPath.getLastPathComponent());
	    return;
	}
	DefaultMutableTreeNode node = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
	
	if(node.isLeaf() || (node.getDepth()==1 && node.getChildAt(0).isLeaf())){
	    //System.out.println((DefaultMutableTreeNode)parentPath.getParent());
	    removeParentPath(parentPath.getParentPath(),model);
	    
	}
	//System.out.println((DefaultMutableTreeNode)parentPath.getLastPathComponent());
	
	
    }
    
    public static void moveFiles(File destination, DefaultMutableTreeNode root) throws IOException{
	    
	    for(int path=0; path<root.getChildCount();path++){
		File destinationFile = new File(destination.getAbsolutePath()+"\\"+root.getChildAt(path));
		FileClass fileProperties = (FileClass)
			(((DefaultMutableTreeNode)(root.getChildAt(path)))).getUserObject();
		File currentFile = new File((fileProperties.getAbsPath()));
		if(!(destinationFile.exists()) && (currentFile.exists())){
		    if(currentFile.isDirectory()){
			destinationFile.mkdir();
			moveFiles(destinationFile,(DefaultMutableTreeNode)root.getChildAt(path));
		    }else{
			fileProperties.moveFile(destination.getAbsolutePath());
		    }
		}else{
		    int approve = JOptionPane.showConfirmDialog(MainGUI.getWindows()[0],"Error! "
			    + destination.getName()
			    +"\\"+root.getChildAt(path)+" already exists. Would you like to rename it?");
		    if(JOptionPane.YES_OPTION==approve){
			boolean successRename = false;
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
	    
	    
	    //System.out.println(moveFileChooser.getSelectedFile());
	
	
	
    
    }
    
    

    public BasketListManager() {
	
    }
    
    
    
    
    
    

    
    
}
