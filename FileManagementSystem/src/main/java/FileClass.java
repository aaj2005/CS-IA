
import java.io.File;
import java.io.IOException;
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
    private boolean isDirectory;
    
    public FileClass(String filename, String path, DefaultMutableTreeNode rootFolder, TreePath FilePath,
	    File parentPath, boolean isDirectory){
	this.filename = filename;
	absPath = path;
	this.FilePath = FilePath;
	this.parentPath = parentPath.getAbsolutePath();
	this.isDirectory = isDirectory;
    }
    
    public void moveFolder(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveDirectoryToDirectory(initialDir, finalDir,false);
    }
    
    public TreePath getFilePath(){
	return FilePath;
    }
    
    public void moveFile(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveFileToDirectory(initialDir, finalDir,false);
    }

    public String getAbsPath() {
	return absPath;
    }
    
    @Override
    public String toString(){
	return filename;
    }
    public boolean isDirectory(){
	return this.isDirectory;
    }
    
    public void setFileNameDirectory(String filename, String fileDirectory){
	absPath = fileDirectory;
	this.filename = filename;
    }
  
}
