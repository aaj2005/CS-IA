
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class BasketListManager {
    
    
    public BasketListManager(){
    
    
    }
    
    public static void addToBasket(){
//    DefaultMutableTreeNode componentAdded
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	
	((DefaultMutableTreeNode)model.getRoot()).add((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent());
	
	model.reload();
	MainGUI.Basket.setModel(model);
	
    }
    
    public static void removeFromBasket(){
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	((DefaultMutableTreeNode)model.getRoot()).remove((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent());
	model.reload();
	MainGUI.Basket.setModel(model);
    }
    
    
}
