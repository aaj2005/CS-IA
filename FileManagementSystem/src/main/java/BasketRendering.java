
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class BasketRendering extends DefaultTreeCellRenderer implements TreeCellRenderer{
    
    private JPanel leafRenderer = new JPanel();
    public JButton remove = new JButton();
    private JLabel label = new JLabel();
    private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

    Color selectionBorderColor, selectionForeground, selectionBackground,
	textForeground, textBackground;

    protected JPanel getLeafRenderer() {
      return leafRenderer;
    }
    public void setButtonColor(Color color){
	remove.setForeground(color);
    }
    public BasketRendering(){
	super();
	System.out.println("constructor 1");
	
	Font fontValue;
	fontValue = UIManager.getFont("Tree.font");
	if (fontValue != null) {
	  leafRenderer.setFont(fontValue);
	}
	leafRenderer.setLayout(new BoxLayout(leafRenderer, BoxLayout.X_AXIS));
	leafRenderer.setOpaque(false);
	Boolean booleanValue = (Boolean) UIManager
	    .get("Tree.drawsFocusBorderAroundIcon");
	remove.setFocusPainted((booleanValue != null)&& (booleanValue.booleanValue()));
	
	selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
	selectionForeground = UIManager.getColor("Tree.selectionForeground");
	selectionBackground = UIManager.getColor("Tree.selectionBackground");
	textForeground = UIManager.getColor("Tree.textForeground");
	textBackground = UIManager.getColor("Tree.textBackground");
	
   }
 

    
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
	Component returnValue = super.getTreeCellRendererComponent(tree, value, leaf, expanded, leaf, row, hasFocus);
	
	String stringValue = tree.convertValueToText(value, selected,
	    expanded, leaf, row, false);
	MouseListener mouseListener = new MouseListener() {
	  @Override
	  public void mouseClicked(MouseEvent e) {
		remove.removeMouseListener(this);
	      
		DefaultTreeModel model = (DefaultTreeModel) MainGUI.Basket.getModel();
		((DefaultMutableTreeNode)model.getRoot()).remove((DefaultMutableTreeNode)MainGUI.Basket.getLastSelectedPathComponent());
		model.reload();
		MainGUI.Basket.setModel(model);
		MainGUI.addToBasketButton.setText("+");
		((FileClass)((DefaultMutableTreeNode)MainGUI.MainFileList.getLastSelectedPathComponent()).getUserObject()).removeFromBasket();
		ImageHandling.stopAll();
	  }
	  
	  @Override
	  public void mousePressed(MouseEvent e) {

	  }

	  @Override
	  public void mouseReleased(MouseEvent e) {
	      
	  }

	  @Override
	  public void mouseEntered(MouseEvent e) {
	  }

	  @Override
	  public void mouseExited(MouseEvent e) {
	  }
      };
	remove.addMouseListener(mouseListener);
	
	
	
	label.setText(stringValue);
	remove.setText("- Remove");
	

	remove.setEnabled(tree.isEnabled());
	remove.setBorderPainted(false);
	remove.setContentAreaFilled(false);
	remove.setBounds(0, 0, leafRenderer.getWidth(), leafRenderer.getHeight());
	remove.setFont(new Font("Tahoma",Font.PLAIN, 10));
	
	if (selected) {
	  returnValue.setForeground(Color.WHITE);
	  remove.setForeground(Color.WHITE);


	} else {
	  returnValue.setForeground(Color.BLACK);
	  remove.setForeground(Color.BLACK);

	}

	
	if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
	  Object userObject = ((DefaultMutableTreeNode) value)
	      .getUserObject();

	  label.setText(stringValue);
	}
	leafRenderer.add(returnValue);
	leafRenderer.add(remove);
	returnValue = leafRenderer;
	
	return returnValue;

    }    

}

