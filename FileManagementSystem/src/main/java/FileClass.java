
import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alial
 */
public class FileClass extends File{
    
    private String filename;
    private String path;
    private long size;
    private String datemod;
    private String datecreated;
    private boolean hidden;
    private boolean readonly;
    private String type;
    private int dimLength;
    private int dimWidth;

    public FileClass(String pathname, String filename, String path, long size, String datemod, String datecreated, boolean hidden, boolean readonly, String type, int dimLength, int dimWidth) {
	super(pathname);
	this.filename = filename;
	this.path = path;
	this.size = size;
	this.datemod = datemod;
	this.datecreated = datecreated;
	this.hidden = hidden;
	this.readonly = readonly;
	this.type = type;
	this.dimLength = dimLength;
	this.dimWidth = dimWidth;
    }

    public String getFilename() {
	return filename;
    }

    public String getPath() {
	return path;
    }

    public long getSize() {
	return size;
    }

    public String getDatemod() {
	return datemod;
    }

    public String getDatecreated() {
	return datecreated;
    }

    public boolean isHidden() {
	return hidden;
    }

    public boolean isReadonly() {
	return readonly;
    }

    public String getType() {
	return type;
    }

    public int getDimLength() {
	return dimLength;
    }

    public int getDimWidth() {
	return dimWidth;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public void setHidden(boolean hidden) {
	this.hidden = hidden;
    }

    public void setReadonly(boolean readonly) {
	this.readonly = readonly;
    }
    
    
    

}
