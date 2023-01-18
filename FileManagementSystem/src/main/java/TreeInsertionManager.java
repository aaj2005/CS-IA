/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */

import java.io.File;
import java.io.IOException;
///*import java.util.Enumeration;
//import java.util.zip.ZipEntry;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.apache.commons.io.FilenameUtils;


public class TreeInsertionManager{
    DefaultTreeModel treeModel;
    DefaultMutableTreeNode placeHolderNode;
    TreeNode root;
    
    public TreeInsertionManager() {        
        
    }
    

       

    public File addFolderContentToTree(JTree FileTree, String Path,File selectedFile) throws IOException{
            
	    
	    treeModel = (DefaultTreeModel) FileTree.getModel();
	    treeModel.setRoot(new DefaultMutableTreeNode(selectedFile.getName()));
            getFileNames(selectedFile, (DefaultMutableTreeNode)treeModel.getRoot());
	    
	    //treeModel.reload(root);
	    treeModel.reload();
	    FileTree.setModel(treeModel);
	    return MainGUI.MainDirectorySearch.getSelectedFile();
	
    }
    public void addFolderToBasket(JTree FileTree, String Path,File selectedFile) throws IOException{
	treeModel = (DefaultTreeModel) FileTree.getModel();
	
	DefaultMutableTreeNode upperRoot = ((DefaultMutableTreeNode)(treeModel.getRoot()));
	if(selectedFile.isFile()){
	    upperRoot.add(new DefaultMutableTreeNode(selectedFile.getName()));
	    upperRoot.getLastLeaf().setUserObject(new FileClass(selectedFile.getName(),
				selectedFile.getAbsolutePath(),
				upperRoot,
				new TreePath(upperRoot.getLastLeaf().getPath()),
				MainGUI.MainDirectorySearch.getSelectedFile(),
				false));
	}else{
	    upperRoot.add(new DefaultMutableTreeNode(selectedFile.getName()));
	    upperRoot.getLastLeaf().setUserObject(new FileClass(selectedFile.getName(),
				selectedFile.getAbsolutePath(),
				upperRoot,
				new TreePath(upperRoot.getLastLeaf().getPath()),
				MainGUI.MainDirectorySearch.getSelectedFile(),
				true));

	    getFileNames(selectedFile, (DefaultMutableTreeNode)upperRoot.getLastChild());
	}    
	treeModel.reload();
	FileTree.setModel(treeModel);
    }
    
    
    
    public File getFileNames(File folder, DefaultMutableTreeNode rootNode) throws IOException {
        File[] fileList;
	fileList = folder.listFiles();
	
	
        if (fileList == null) {
	    
        }
            for (final File file : fileList ) {
		    if(MainGUI.imageTypeList.contains(FilenameUtils.getExtension(file.toString())) ||
			    MainGUI.videoTypeList.contains(FilenameUtils.getExtension(file.toString()))){
			
			rootNode.add(new DefaultMutableTreeNode(file.getName()));
			rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(),
				file.getAbsolutePath(),
				rootNode,
				new TreePath(rootNode.getLastLeaf().getPath()),
				MainGUI.MainDirectorySearch.getSelectedFile(),
				false));
			
		    }else if( file.isDirectory() && file.list()!=null){
			    rootNode.add(new DefaultMutableTreeNode(file.getName()));
			    File subFiles = new File(file.toString());
			    rootNode.getLastLeaf().setUserObject(new FileClass(file.getName(),
				    file.getAbsolutePath(),
				    rootNode,
				    new TreePath(rootNode.getLastLeaf().getPath()),
				    MainGUI.MainDirectorySearch.getSelectedFile(),
				    false));
			    getFileNames(subFiles, (DefaultMutableTreeNode) rootNode.getLastChild());
			    if(rootNode.getLastChild().getChildCount()==0){
				rootNode.remove(rootNode.getChildCount()-1);
			    }
		    }
            }
	    root = rootNode;
	return null;
    }
    
}

/*else if(MainGUI.zipTypeList.contains(FilenameUtils.getExtension(file.toString()))){
			//rootNode.add(new DefaultMutableTreeNode(file.getName()));
			//fileMapList.put(file.getName(), file);
			
			MainGUI.MainFileList.setCellRenderer(new DefaultTreeCellRenderer() {
			
			@Override
			public Component getTreeCellRendererComponent(JTree tree,
				Object value, boolean selected, boolean expanded,
				boolean isLeaf, int row, boolean focused) {
			    Component c = super.getTreeCellRendererComponent(tree, value,
				    selected, expanded, isLeaf, row, focused);
			    setIcon(icon);
			    return c;
			}
			});
		    }*/








//          File[] roots = File.listRoots();
//          getFileNames(new File("C:\\Users\\alial\\Desktop\\Programs\\Java\\Zip"));
//          ZipFile zipFile = new ZipFile("C:\\Users\\alial\\Desktop\\Programs\\Java\\Zip\\compressjpeg (1).zip");
//          Enumeration<? extends ZipEntry> entries = zipFile.entries();
//          while(entries.hasMoreElements()){
//              ZipEntry entry = entries.nextElement();
//              InputStream stream = zipFile.getInputStream(entry);
//              getFileNames(stream);
//          }
//            System.out.println(count);
