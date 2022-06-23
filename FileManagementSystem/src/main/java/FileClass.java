
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class FileClass{
    
    public String filename;
    private String absPath;    
    //private String relPath;
    private long size;
    private String datemod;
    private String datecreated;
    private boolean hidden;
    private boolean readonly;
    private String type;
    private int dimLength;
    private int dimWidth;
    
    public ArrayList<Integer> relPath;
    public FileClass(String filename, String path, DefaultMutableTreeNode rootFolder, ArrayList<Integer> pathDown){
	//super(pathname);
	this.filename = filename;
	absPath = path;
	this.relPath = (ArrayList)pathDown.clone();
    }
    @Override
    public String toString(){
	return filename;
    }
    
    
    
    

}
