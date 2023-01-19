
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
    
    //attributes of file
    private String filename;
    private String absPath;    
    private String parentPath;
    private TreePath FilePath;
    private boolean isDirectory;
    
    //constructor to initialize attributes
    public FileClass(String filename, String path, DefaultMutableTreeNode rootFolder, TreePath FilePath,
	    File parentPath, boolean isDirectory){
	this.filename = filename;
	absPath = path;
	this.FilePath = FilePath;
	this.parentPath = parentPath.getAbsolutePath();
	this.isDirectory = isDirectory;
    }
    
    //move a directory
    public void moveFolder(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveDirectoryToDirectory(initialDir, finalDir,false);
    }
    
    //get file path
    public TreePath getFilePath(){
	return FilePath;
    }
    
    //move file
    public void moveFile(String dir2) throws IOException{
	File initialDir = new File(absPath);
	File finalDir = new File(dir2);
	FileUtils.moveFileToDirectory(initialDir, finalDir,false);
    }

    //get full file path
    public String getAbsPath() {
	return absPath;
    }
    
    //get file name
    @Override
    public String toString(){
	return filename;
    }
    
    //check if file is directory
    public boolean isDirectory(){
	return this.isDirectory;
    }
    
    //update file name
    public void setFileNameDirectory(String filename, String fileDirectory){
	absPath = fileDirectory;
	this.filename = filename;
    }
  
}
