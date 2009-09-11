/*
 * ImageManager.java
 *
 * Created on October 17, 2005, 6:15 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import utils.*;
import java.util.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.*;
import utils.linear.grid.ColorGrid;
import utils.linear.grid.FColorGrid;

/**
 *
 * @author Calvin Ashmore
 */
public class ImageManager /*implements Serializable*/ {
    
    private static ImageManager gImageManager;
    public static ImageManager getImageManager() {return gImageManager;}
    
    private List<File> imageFiles;
    private List<ColorGrid> imageData;
    
    public int getNumberImages() {return imageFiles.size();}
    
    /** Creates a new instance of ImageManager */
    public ImageManager() {
        gImageManager = this;
        imageFiles = new ArrayList();
        imageData = new ArrayList();
    }
    
    public ColorGrid getImage(int index) {
        
        if(imageData.get(index) != null)
            return imageData.get(index);
        
        File f = imageFiles.get(index);
        if(f == null)
            return null;
        
        System.out.println("ImageManager: building image... " + f.getName());
        
        ColorGrid r = null;
        if(r == null) {
            try {
                BufferedImage img = ImageIO.read(f);
                r = new FColorGrid(img);
                
                imageData.set(index, r);
                
            } catch(IOException e) {}
        }
        
        System.out.println("ImageManager: finished building image");
        
        return r;
    }
    
    /*public String getName(int index) {
        Pair<String, ColorGrid> p = images.get(index);
        if(p == null) return null;
        return p.getLeft();
    }*/
    
    /*public void addImage(String name, BufferedImage image) {
        images.add(new Pair(name, ColorGrid.decodeImage(image)));
    }*/
    
    public void addImage(File imageFile) {
        
        // first try to verify that this is an image
        // ignore??
        
        // extension checking
        String filename = imageFile.getName();
        int extpos = filename.lastIndexOf(".");
        
        Iterator formatters = ImageIO.getImageReadersByFormatName( filename.substring(extpos+1) );
        if(!formatters.hasNext())
            return;
        
        // then add
        imageFiles.add(imageFile);
        imageData.add(null);
        
    }
    
    public void addFolder(String folderName) {
        
        File imageFolder = new File(folderName);
        File files[] = imageFolder.listFiles();
        
        //System.out.println("ImageManager: loading files...");
        for(File file : files)
            if(file.isFile()) 
                addImage(file);
        //System.out.println("ImageManager: done loading files!");
    }
}

