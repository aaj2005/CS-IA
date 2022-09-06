
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
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
    
    private String filename;
    private String absPath;    
    private String parentPath;
    private long size;
    private String datemod;
    private String datecreated;
    private boolean hidden;
    private boolean readonly;
    private String type;
    private int dimLength;
    private int dimWidth;
    private TreePath FilePath;
    private boolean inBasket;
    
    public FileClass(String filename, String path, DefaultMutableTreeNode rootFolder, TreePath FilePath, File parentPath, boolean inBasket){
	//super(pathname);
	this.filename = filename;
	absPath = path;
	this.FilePath = FilePath;
	this.parentPath = parentPath.getAbsolutePath();
	this.inBasket = inBasket;
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

    public String getAbsPath() {
	return absPath;
    }
    public void setInBasket(boolean inBasket) {
	this.inBasket = inBasket;
    }

    public boolean isInBasket() {
	return inBasket;
    }
    public void removeFromBasket(){
	inBasket=false;
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
