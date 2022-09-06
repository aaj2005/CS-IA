
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
    
    public static void addToBasket(){
//    DefaultMutableTreeNode componentAdded
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	
	((DefaultMutableTreeNode)model.getRoot()).add((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent());
	((DefaultMutableTreeNode)model.getRoot()).getLastLeaf().setUserObject(((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject());
	model.reload();
	MainGUI.Basket.setModel(model);
	//MainGUI.Basket.setSelectionPath(new TreePath(((DefaultMutableTreeNode)MainGUI.Basket.getModel().getRoot()).getLastLeaf().getPath()));
	MainGUI.addToBasketButton.setText("-");
    }
    
    public static void removeFromBasket(){
	DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
	((DefaultMutableTreeNode)model.getRoot()).remove((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent());
	((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject()).removeFromBasket();
	
	model.reload();
	MainGUI.Basket.setModel(model);
	MainGUI.addToBasketButton.setText("+");
    }

    public BasketListManager() {
    }
    
    
    
    
    

    
    
}
