
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class BasketEditing extends AbstractCellEditor implements TreeCellEditor {
       BasketRendering renderer;

    ChangeEvent changeEvent = null;

    JTree tree;

    public BasketEditing(JTree tree) {
	renderer = new BasketRendering();
	this.tree = tree;
	

	tree.setSelectionPath(MainGUI.Basket.getSelectionPath());
    }

    public Object getCellEditorValue() {
	
	//tree.remove(tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY()));
	return tree.getLastSelectedPathComponent();
      
    }
    
    public boolean isCellEditable(EventObject event) {
      boolean returnValue = false;
      if (event instanceof MouseEvent) {
	MouseEvent mouseEvent = (MouseEvent) event;
	TreePath path = tree.getPathForLocation(mouseEvent.getX(),
	    mouseEvent.getY());
	renderer.getLeafRenderer();
	if (path != null) {
	  Object node = path.getLastPathComponent();
	  if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
	    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
	    FileClass userObject = (FileClass)treeNode.getUserObject();
	    returnValue = true;
	    MainGUI.MainFileList.setSelectionPath(path);
	  }
	}
      }
      
      System.out.println("gere");
      return returnValue;
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value,
	boolean selected, boolean expanded, boolean leaf, int row) {
	System.out.println("get editor");
      Component editor = renderer.getTreeCellRendererComponent(tree, value,
	  true, expanded, leaf, row, true);
      
      // editor always selected / focused
      
      System.out.println(editor);
      if (editor instanceof JPanel) {
	
      }

      return editor;
    }
    /*
    MouseListener mouseListener = new MouseListener() {
	  @Override
	  public void mouseClicked(MouseEvent e) {
	      
	  }

	  @Override
	  public void mousePressed(MouseEvent e) {

	  }

	  @Override
	  public void mouseReleased(MouseEvent e) {
	      
	  }

	  @Override
	  public void mouseEntered(MouseEvent e) {
	    System.out.println("ijfiijifj");
	    ((JButton)e.getComponent()).setForeground(Color.BLUE);
	  }

	  @Override
	  public void mouseExited(MouseEvent e) {
	    ((JButton)e.getComponent()).setForeground(Color.WHITE);
	  }
      };
    */
}
