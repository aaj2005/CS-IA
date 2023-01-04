
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
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
public class BasketListManager {
    
    JButton removeButton;

    JPanel renderer;

    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    DefaultTreeModel BasketTreeModel = (DefaultTreeModel) MainGUI.Basket.getModel();

    public static void addToBasket(DefaultTreeModel BasketTreeModel){
//    DefaultMutableTreeNode componentAdded
	
	((DefaultMutableTreeNode)BasketTreeModel.getRoot()).add((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent());
	((DefaultMutableTreeNode)BasketTreeModel.getRoot()).getLastLeaf().setUserObject(((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject());
	BasketTreeModel.reload();
	MainGUI.Basket.setModel(BasketTreeModel);
	//MainGUI.Basket.setSelectionPath(new TreePath(((DefaultMutableTreeNode)MainGUI.Basket.getModel().getRoot()).getLastLeaf().getPath()));
	MainGUI.addToBasketButton.setText("-");
    }
    
    public static void removeFromBasket(){
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	MainGUI.Basket.getSelectionPaths();
	for(int path=0; path<MainGUI.Basket.getSelectionPaths().length;path++){
	    ((DefaultMutableTreeNode)model.getRoot()).remove((DefaultMutableTreeNode)MainGUI.Basket.getSelectionPaths()[path].getLastPathComponent());
	    ((FileClass)((DefaultMutableTreeNode)MainGUI.Basket.getSelectionPaths()[path].getLastPathComponent()).getUserObject()).removeFromBasket();
	}
	
	
	model.reload();
	MainGUI.Basket.setModel(model);
	MainGUI.addToBasketButton.setText("+");
    }
    
    

    public BasketListManager() {
    }
    
    
    
    
    

    
    
}
