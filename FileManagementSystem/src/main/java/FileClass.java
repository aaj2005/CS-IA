
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.io.FileUtils;

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
    public String absPath;    
    public String parentPath;
    private long size;
    private String datemod;
    private String datecreated;
    private boolean hidden;
    private boolean readonly;
    private String type;
    private int dimLength;
    private int dimWidth;
    
    public ArrayList<Integer> relPath;
    public FileClass(String filename, String path, DefaultMutableTreeNode rootFolder, ArrayList<Integer> pathDown, File parentPath){
	//super(pathname);
	this.filename = filename;
	absPath = path;
	this.relPath = (ArrayList)pathDown.clone();
	this.parentPath = parentPath.getAbsolutePath();
	
    }
    
    public void moveFolder(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveDirectoryToDirectory(initialDir, finalDir,false);
    }
    
    public void moveFile(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveFileToDirectory(initialDir, finalDir,false);
    }
    
    
    /*public FileClass(String filename, String path){
	//super(pathname);
	this.filename = filename;
	absPath = path;
	this.relPath = new ArrayList();
    }*/
    @Override
    public String toString(){
	return filename;
    }
    
    
    
    

}
