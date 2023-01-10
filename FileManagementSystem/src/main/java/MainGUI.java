import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
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

        moveFileChooser = new javax.swing.JFileChooser();
        VisibleFilesTitle = new java.awt.Label();
        ImageHolderPanel = new java.awt.Panel();
        MainImage = new javax.swing.JLabel();
        MainDirectorySearch = new javax.swing.JFileChooser();
        MainFileListScroll = new javax.swing.JScrollPane();
        MainFileList = new javax.swing.JTree();
        fileName = new javax.swing.JTextField();
        ApplyButton = new javax.swing.JButton();
        BaskScroll = new javax.swing.JScrollPane();
        Basket = new javax.swing.JTree();
        BasketLabel = new java.awt.Label();
        MoveButton = new javax.swing.JButton();
        videoLengthTime = new javax.swing.JLabel();
        videoSlider = new javax.swing.JSlider();
        pausePlayButton = new javax.swing.JButton();
        currentTime = new javax.swing.JLabel();
        addToBasketButton = new javax.swing.JButton();
        MoveBasketButton = new javax.swing.JButton();

        moveFileChooser.setCurrentDirectory(new java.io.File("D:\\"));
            moveFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setMinimumSize(new java.awt.Dimension(644, 399));

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

            treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Basket");
            Basket.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            Basket.setToolTipText("");
            Basket.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
                public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                    BasketValueChanged(evt);
                }
            });
            BaskScroll.setViewportView(Basket);

            BasketLabel.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N
            BasketLabel.setPreferredSize(new java.awt.Dimension(169, 46));
            BasketLabel.setText("Basket");

            MoveButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            MoveButton.setText("Move");
            MoveButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    MoveButtonActionPerformed(evt);
                }
            });

            videoLengthTime.setText("00:00:00");
            videoLengthTime.setAlignmentY(0.0F);

            videoSlider.setMaximum(0);
            videoSlider.setPaintLabels(true);
            videoSlider.setToolTipText("");
            videoSlider.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    videoSliderStateChanged(evt);
                }
            });
            videoSlider.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    videoSliderMousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    videoSliderMouseReleased(evt);
                }
            });

            pausePlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download-icon-play+icon-1320183326084518754_16.png"))); // NOI18N
            pausePlayButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pausePlayButtonActionPerformed(evt);
                }
            });

            currentTime.setText("00:00:00");
            currentTime.setAlignmentY(0.0F);

            addToBasketButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            addToBasketButton.setText("+");
            addToBasketButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    addToBasketButtonActionPerformed(evt);
                }
            });

            MoveBasketButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            MoveBasketButton.setText("Move Basket");
            MoveBasketButton.setActionCommand("");
            MoveBasketButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    MoveBasketButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(MainFileListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BaskScroll)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MainDirectorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(BasketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(addToBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(MoveBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(VisibleFilesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pausePlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(videoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(videoLengthTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(ImageHolderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(197, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(ImageHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(MainDirectorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(videoSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BasketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addToBasketButton)
                                    .addComponent(MoveBasketButton)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BaskScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pausePlayButton)
                                    .addComponent(currentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(videoLengthTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ApplyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MoveButton))
                            .addGap(140, 140, 140))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(VisibleFilesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(MainFileListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents
    
    
    ImageHandling imageHandler = new ImageHandling();
    public static final ArrayList<String> videoTypeList = new ArrayList<>(Arrays.asList("webm","mkv","flv","vob","ogv","ogg"
	    ,"drc","gif","mng","avi","mov","qt","wmv","amv","mp4","m4p","m4v","mpg","mpeg","m4v"));
    public static final ArrayList<String> imageTypeList = new ArrayList<>(Arrays.asList("jpg","jpeg","jpe","jif","jfif","jfi"
	    ,"png","gif","webp","tiff","tif","arw","jp2","j2k","jpf","jpx","jpm"));
    
    
    
    
    public static final ArrayList<String> zipTypeList = new ArrayList<>(Arrays.asList("7z","arj","deb","pkg","rar","rpm","gz","z","zip"));
    public static File currentDirectory;
    
    
    public MainGUI() {
	setSize(new Dimension(1920,1080));
	initComponents();
	setLayout(new BorderLayout());
	MainFileList.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	Basket.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
	MainGUI.Basket.setRootVisible(false);
	MainGUI.MainFileList.setRootVisible(false);
	ImageHandling.play();
	Basket.setEditable(false);
	videoSlider.setEnabled(false);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
/////////////////////////DIRECTORY SEARCH/////////////////////////////////////////

    
    private void MainDirectorySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainDirectorySearchActionPerformed
	
	
	TreeInsertionManager listManagerClass = new TreeInsertionManager();
	
	
	
	MainImage.setIcon(null);
	fileName.setText(null);
	
	try {
	    if ("ApproveSelection".equals(evt.getActionCommand())) {
		JFileChooser chooser = (JFileChooser)evt.getSource();
		currentDirectory = listManagerClass.addFolderContentToTree(MainFileList, chooser.getName(),chooser.getSelectedFile());
		chooser.setCurrentDirectory(chooser.getSelectedFile());
		System.out.println(evt.getSource().getClass());
	    }else{
		currentDirectory = ((JFileChooser)evt.getSource()).getCurrentDirectory();
	    }
	    
	} catch (IOException ex) {
	    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
	}
	MainFileList.clearSelection();
	MainFileList.repaint();
	System.out.println("tree called");
    }//GEN-LAST:event_MainDirectorySearchActionPerformed

    
/////////////////////////MAIN TREE AND BASKET MODIFICATIONS/////////////////////////////////////////    
    
    

    private void MainFileListValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_MainFileListValueChanged
	if(evt.isAddedPath()){
	    Basket.clearSelection();
	    addToBasketButton.setText("+");
	}
	fileName.setText(getFileNameWithoutExtension(evt.getPath()));
	imageHandler.handler(treePathCombiner(evt.getPath(),0), MainImage);
	
    }//GEN-LAST:event_MainFileListValueChanged
  
  
    private void BasketValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_BasketValueChanged
        
	
	if(evt.isAddedPath()){
	    MainFileList.clearSelection();
	    addToBasketButton.setText("-");
	}

    }//GEN-LAST:event_BasketValueChanged
	

    
/////////////////////////BASKET MODIFICATION BUTTONS/////////////////////////////////////////
    
	
    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed

	if(!"null".equals(MainFileList.getSelectionPath().toString())){
	    //System.out.println(fileName.getText());
	    File originalFile = new File(treePathCombiner(MainFileList.getSelectionPath(),0));
	    
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
	    }else{
		System.out.println("exists");
	    } 
	}
	
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void MoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveButtonActionPerformed
        
	if (moveFileChooser.showDialog(this, "Select") == JFileChooser.APPROVE_OPTION){
	    if(MainFileList.getLastSelectedPathComponent()!=null){
		if(!(new File(moveFileChooser.getSelectedFile().getAbsolutePath()+"\\"+MainFileList.getLastSelectedPathComponent()).isFile()) && (new File(getLastPathComponentObject().getAbsPath())).isFile()){

		    try {
			getLastPathComponentObject().moveFile(moveFileChooser.getSelectedFile().getAbsolutePath());
		    } catch (IOException ex) {
			Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}else if(!(new File(moveFileChooser.getSelectedFile().getAbsolutePath()+"\\"+MainFileList.getLastSelectedPathComponent()).isDirectory())){
		    try {
			getLastPathComponentObject().moveFolder(moveFileChooser.getSelectedFile().getAbsolutePath());
		    } catch (IOException ex) {
			Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
	    }
	    
	    
	    
	    //System.out.println(moveFileChooser.getSelectedFile());
	}
	
    }//GEN-LAST:event_MoveButtonActionPerformed


    private void addToBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToBasketButtonActionPerformed
        if(!MainFileList.isSelectionEmpty()){
	    
	    try {
		BasketListManager.addToBasket();
		//setInBasket((DefaultMutableTreeNode)MainFileList.getLastSelectedPathComponent());
		
		//getLastPathComponentObject().setInBasket();
	    } catch (IOException ex) {
		Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	    
	}else if(!Basket.isSelectionEmpty()){
	    BasketListManager.removeFromBasket();
	}
	((DefaultTreeModel)Basket.getModel()).reload();
	
	
	
	
	
    }//GEN-LAST:event_addToBasketButtonActionPerformed
    
    
    
    
    
    private void MoveBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveBasketButtonActionPerformed
        if (MainGUI.moveFileChooser.showDialog(MainGUI.getWindows()[0], "Select") == JFileChooser.APPROVE_OPTION){
	    try {
		BasketListManager.moveFiles(moveFileChooser.getSelectedFile(), ((DefaultMutableTreeNode)MainGUI.Basket.getModel().getRoot()));
	    } catch (IOException ex) {
		Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	}
	
    }//GEN-LAST:event_MoveBasketButtonActionPerformed
    
    
    
    
    
    
    
    
    
/////////////////////////MEDIA CONTROLLER STUFF/////////////////////////////////////////
	
	private void pausePlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausePlayButtonActionPerformed
        ImageHandling.mediaPlayerComponent.mediaPlayer().controls().pause();
	
	
    }//GEN-LAST:event_pausePlayButtonActionPerformed

    private void videoSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videoSliderMouseReleased
        ImageHandling.changeTime(videoSlider.getValue());
	ImageHandling.pausePlay();
    }//GEN-LAST:event_videoSliderMouseReleased

    private void videoSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videoSliderMousePressed
        ImageHandling.pausePlay();
    }//GEN-LAST:event_videoSliderMousePressed

    private void videoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_videoSliderStateChanged
       if(!ImageHandling.isPlaying()){
	   long newLength = videoSlider.getValue();
	   String formattedLength = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(newLength),
		    TimeUnit.MILLISECONDS.toMinutes(newLength) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(newLength)),
		    TimeUnit.MILLISECONDS.toSeconds(newLength) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(newLength)));
		    
	    currentTime.setText(formattedLength);
	    
       }
    }//GEN-LAST:event_videoSliderStateChanged
	
	
	
	
/////////////////////////CUSTOM FUNCTIONS/////////////////////////////////////////	
	
    public FileClass getLastPathComponentObject(){
	return ((FileClass)((DefaultMutableTreeNode)MainFileList.getLastSelectedPathComponent()).getUserObject());
    }
    
    
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

        /* Create and display the GUI */
	
	
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
    public static javax.swing.JScrollPane BaskScroll;
    public static javax.swing.JTree Basket;
    private java.awt.Label BasketLabel;
    public static java.awt.Panel ImageHolderPanel;
    public static javax.swing.JFileChooser MainDirectorySearch;
    public static javax.swing.JTree MainFileList;
    private static javax.swing.JScrollPane MainFileListScroll;
    public static javax.swing.JLabel MainImage;
    public static javax.swing.JButton MoveBasketButton;
    private javax.swing.JButton MoveButton;
    private java.awt.Label VisibleFilesTitle;
    public static javax.swing.JButton addToBasketButton;
    public static javax.swing.JLabel currentTime;
    private javax.swing.JTextField fileName;
    public static javax.swing.JFileChooser moveFileChooser;
    public static javax.swing.JButton pausePlayButton;
    public static javax.swing.JLabel videoLengthTime;
    public static javax.swing.JSlider videoSlider;
    // End of variables declaration//GEN-END:variables
    
}
