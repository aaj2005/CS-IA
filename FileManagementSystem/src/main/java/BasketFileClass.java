
import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class BasketFileClass extends FileClass{
    
    
    
    public BasketFileClass(String filename, String path, DefaultMutableTreeNode rootFolder, TreePath FilePath, File parentPath, boolean inBasket) {
	super(filename, path, rootFolder, FilePath, parentPath, inBasket);
    }
    
    
}
