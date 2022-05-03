import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.apache.commons.io.FilenameUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author alial
 */
public class MainGUI extends JFrame {
    
    
    /**
     * Creates new form NewJFrame
     */
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VisibleFilesTitle = new java.awt.Label();
        ImageHolderPanel = new java.awt.Panel();
        MainImage = new javax.swing.JLabel();
        MainDirectorySearch = new javax.swing.JFileChooser();
        MainFileListScroll = new javax.swing.JScrollPane();
        MainFileList = new javax.swing.JTree();
        fileName = new javax.swing.JTextField();
        ApplyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VisibleFilesTitle.setAlignment(java.awt.Label.CENTER);
        VisibleFilesTitle.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N
        VisibleFilesTitle.setText("Visible Files");

        ImageHolderPanel.setBackground(new java.awt.Color(0, 0, 0));
        ImageHolderPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        ImageHolderPanel.setPreferredSize(new java.awt.Dimension(590, 520));

        MainImage.setBackground(new java.awt.Color(0, 0, 0));
        MainImage.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        MainImage.setPreferredSize(new java.awt.Dimension(1040, 768));

        javax.swing.GroupLayout ImageHolderPanelLayout = new javax.swing.GroupLayout(ImageHolderPanel);
        ImageHolderPanel.setLayout(ImageHolderPanelLayout);
        ImageHolderPanelLayout.setHorizontalGroup(
            ImageHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(ImageHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ImageHolderPanelLayout.setVerticalGroup(
            ImageHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(ImageHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MainDirectorySearch.setApproveButtonText("Select Folder");
        MainDirectorySearch.setCurrentDirectory(new java.io.File("D:\\Downloads"));
        MainDirectorySearch.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        MainDirectorySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainDirectorySearchActionPerformed(evt);
            }
        });

        MainFileListScroll.setMinimumSize(new java.awt.Dimension(0, 0));
        MainFileListScroll.setPreferredSize(new java.awt.Dimension(1526, 998));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Files");
        MainFileList.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        MainFileList.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                MainFileListValueChanged(evt);
            }
        });
        MainFileListScroll.setViewportView(MainFileList);

        fileName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ApplyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisibleFilesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(MainFileListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MainDirectorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImageHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(VisibleFilesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImageHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MainDirectorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fileName)
                            .addComponent(ApplyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(MainFileListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(333, 333, 333))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    ImageHandling imageHandler = new ImageHandling();
    public final ArrayList<String> videoTypeList = new ArrayList<>(Arrays.asList("webm","mkv","flv","flv","vob","ogv","ogg","drc","gif","gifv","mng","avi","MTS","M2TS","TS","mov","qt","wmv","yuv","rm","rmvb","viv","asf","amv","mp4","m4p","m4v","mpg","mp2","mpeg","mpe","mpv","mpg","mpeg","m2v","m4v","svi","3gp","3g2","mxf","roq","nsv", "flv","f4v","f4p","f4a","f4b"));
    public final ArrayList<String> imageTypeList = new ArrayList<>(Arrays.asList("jpg","jpeg","jpe","jif","jfif","jfi","png","gif","webp","tiff","tif","raw","arw","cr2","nrw","psd","k25","bmp","dib","heif","heic","indd","ind","indt","jp2","j2k","jpf","jpx","jpm","mj2","svg","svgz","ai","eps"));
    public final ArrayList<String> zipTypeList = new ArrayList<>(Arrays.asList("7z","arj","deb","pkg","rar","rpm","gz","z","zip"));
    public static File currentDirectory;
    
    
    public MainGUI() {
	setSize(new Dimension(1920,1080));
	
	initComponents();
	//panel1.setLayout(new BorderLayout());
	
	MainFileList.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

	setExtendedState(JFrame.MAXIMIZED_BOTH);

	
	
        
	
    }
    
    
    private void MainDirectorySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainDirectorySearchActionPerformed
	MainListManager listManagerClass = new MainListManager();
	
	MainImage.setIcon(null);
	fileName.setText(null);
	
	listManagerClass.addItemsToMainList(MainFileList, evt);
	MainFileList.clearSelection();
	MainFileList.repaint();
    }//GEN-LAST:event_MainDirectorySearchActionPerformed

    private void MainFileListValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_MainFileListValueChanged
        
	//System.out.println(evt.getPath());
	fileName.setText(getFileNameWithoutExtension(evt.getPath()));
	imageHandler.handler(treePathCombiner(evt.getPath(),0), MainImage);
	
	    
	
	
    }//GEN-LAST:event_MainFileListValueChanged

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
        
	if(!"null".equals(MainFileList.getSelectionPath().toString())){
	    //System.out.println(fileName.getText());
	    File originalFile = new File(treePathCombiner(MainFileList.getSelectionPath(),0));
	    System.out.println();
	    TreePath oldPath = MainFileList.getSelectionPath();
	    String newFileName = treePathCombiner(MainFileList.getSelectionPath(),1)+"\\"+fileName.getText()+"."+FilenameUtils.getExtension(originalFile.toString());
	    File renamedFile = new File(newFileName);
	    
	    
	    
	    
	    boolean flag = originalFile.renameTo(renamedFile);
	    if (flag == true) {
		DefaultTreeModel model = (DefaultTreeModel)MainFileList.getModel();
		DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)MainFileList.getSelectionPath().getPath()[MainFileList.getSelectionPath().getPath().length-1];
		childNode.setUserObject(fileName.getText()+"."+FilenameUtils.getExtension(originalFile.toString()));
		model.nodeChanged(childNode);
		MainFileList.setModel(model);
		MainFileList.setSelectionPath(oldPath);
	    }
	    
	    
	    
	    
	    
	}
	
    }//GEN-LAST:event_ApplyButtonActionPerformed

    
    private String treePathCombiner(TreePath treePath, int endIndexRemover){
	StringBuilder finalPath = new StringBuilder();
	finalPath.append(currentDirectory);
	//System.out.println(treePath);
	for(int pathIndex = 1; pathIndex<treePath.getPathCount()-endIndexRemover; pathIndex++){
	    if(treePath.getPathComponent(pathIndex).toString().contains(":\\")){
		finalPath.deleteCharAt(finalPath.length()-1);
	    }else{
		finalPath.append("\\");
		finalPath.append(treePath.getPathComponent(pathIndex).toString());
	    }
	}	
	return finalPath.toString();
    }
    
    private String getFileNameWithoutExtension(TreePath treePath){
	String filename=treePath.getPathComponent(treePath.getPathCount()-1).toString();
	filename = filename.replaceAll("."+FilenameUtils.getExtension(filename), "");
	return filename;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
	
        java.awt.EventQueue.invokeLater(new Runnable(){
	    public void run(){
		MainGUI mainGUI = new MainGUI();
		mainGUI.pack();

		mainGUI.setVisible(true);
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private java.awt.Panel ImageHolderPanel;
    public javax.swing.JFileChooser MainDirectorySearch;
    private javax.swing.JTree MainFileList;
    private javax.swing.JScrollPane MainFileListScroll;
    private javax.swing.JLabel MainImage;
    private java.awt.Label VisibleFilesTitle;
    private javax.swing.JTextField fileName;
    // End of variables declaration//GEN-END:variables
    
}
