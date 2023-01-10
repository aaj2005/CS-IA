
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

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

    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    
    static TreeInsertionManager treeInserter = new TreeInsertionManager();
    
    public static void addToBasket() throws IOException{
	DefaultTreeModel BasketTreeModel = (DefaultTreeModel) MainGUI.Basket.getModel();
//    DefaultMutableTreeNode componentAdded
	//MainGUI.MainFileList.getSelectionPath().getPath();
	Enumeration e = ((DefaultMutableTreeNode)((DefaultTreeModel)(MainGUI.Basket.getModel())).getRoot()).breadthFirstEnumeration();
	int counter = 1;
	e.nextElement();
	FileClass nextFile;
	FileClass currentFile = (FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject();
	while(e.hasMoreElements()){
	    nextFile = (FileClass)((DefaultMutableTreeNode)e.nextElement()).getUserObject();
	    if(nextFile.getAbsPath().equals(currentFile.getAbsPath())){
		return;
	    }
	    //if(MainGUI.MainFileList.getSelectionPath().getPath()[])
	}
	
	
	
	//System.out.println(((DefaultMutableTreeNode)BasketTreeModel.getRoot()));
	System.out.println(((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject()).getAbsPath());
	FileClass selectedFile = ((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject());
	treeInserter.addFolderToBasket(MainGUI.Basket,selectedFile.getAbsPath() , new File(selectedFile.getAbsPath()));
	//((DefaultMutableTreeNode)BasketTreeModel.getRoot()).add(new DefaultMutableTreeNode(());
	System.out.println(((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject());
	
	((DefaultMutableTreeNode)((DefaultMutableTreeNode)BasketTreeModel.getRoot()).getLastChild()).setUserObject((FileClass)(((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject()));
	//BasketTreeModel.reload();
	MainGUI.Basket.setModel(BasketTreeModel);
	//MainGUI.Basket.setSelectionPath(new TreePath(((DefaultMutableTreeNode)MainGUI.Basket.getModel().getRoot()).getLastLeaf().getPath()));
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
	DefaultMutableTreeNode node = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
	if(node.isLeaf() || node.getDepth()==1 && node.getChildAt(0).isLeaf()){
	    //System.out.println((DefaultMutableTreeNode)parentPath.getParent());
	    removeParentPath(parentPath.getParentPath(),model);
	    
	}
	System.out.println((DefaultMutableTreeNode)parentPath.getLastPathComponent());
	if(!((DefaultMutableTreeNode)parentPath.getLastPathComponent()).equals((DefaultMutableTreeNode)model.getRoot())){
	    model.removeNodeFromParent((DefaultMutableTreeNode)parentPath.getLastPathComponent());
	}
	
    }
    public static void moveFiles(File destination, DefaultMutableTreeNode root) throws IOException{
	
	
	
	    
	    
	    System.out.println("I CAME HERE!!");
	    for(int path=0; path<root.getChildCount();path++){
		System.out.println(destination.getAbsolutePath()+"\\"+root.getChildAt(path));
		
		//System.out.println(((FileClass)(((DefaultMutableTreeNode)(root.getChildAt(path)))).getUserObject()).getAbsPath());
		//System.out.println(new File(MainGUI.moveFileChooser.getSelectedFile().getAbsolutePath()+"\\"+root.getChildAt(path)).exists());
		
	    
		File destinationFile = new File(destination.getAbsolutePath()+"\\"+root.getChildAt(path));
		FileClass fileProperties = (FileClass)(((DefaultMutableTreeNode)(root.getChildAt(path)))).getUserObject();
		File currentFile = new File((fileProperties.getAbsPath()));
		System.out.println(destinationFile.exists());
		if(!(destinationFile.exists()) && (currentFile.exists())){
		   // System.out.println("here");
		    if(currentFile.isDirectory()){
			destinationFile.mkdir();
			moveFiles(destinationFile,(DefaultMutableTreeNode)root.getChildAt(path));
		    }else{
			fileProperties.moveFile(destination.getAbsolutePath());
		    }
		    System.out.println("here");
		    //MainGUI.Basket.getLastPathComponentObject().moveFile(MainGUI.moveFileChooser.getSelectedFile().getAbsolutePath());
		}else if(!(new File(MainGUI.moveFileChooser.getSelectedFile().getAbsolutePath()+"\\"+MainGUI.MainFileList.getLastSelectedPathComponent()).isDirectory())){
		    return;
		    //getLastPathComponentObject().moveFolder(moveFileChooser.getSelectedFile().getAbsolutePath());
		}else{
		    System.out.println("duplicate exists");
		    return;
		}
		
		System.out.println("\n\n");
	   
	    }
	    
	    
	    //System.out.println(moveFileChooser.getSelectedFile());
	
	
	
    
    }
    
    

    public BasketListManager() {
	
    }
    
    
    
    
    
    

    
    
}
