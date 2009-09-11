/*
 * Renderer.java
 *
 * Created on October 2, 2005, 4:09 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package geneticimage;

import geneticimage.ui.Application;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Calvin Ashmore
 */
public class LargeFormatRenderer extends BuilderThread {

    public static final int CELL_SIZE = 1000;

    private double xminimum;
    private double xmaximum;
    private double yminimum;
    private double ymaximum;
    private int xresolution;
    private int yresolution;
    private List<RenderListener> listeners;
    private Node evaluator;

    public LargeFormatRenderer() {
        xminimum = -1;
        xmaximum = 1;
        yminimum = -1;
        ymaximum = 1;

        xresolution = 500;
        yresolution = 500;

        listeners = new ArrayList();
    }

    public void addRenderListener(RenderListener listener) {
        listeners.add(listener);
    }

    public int getXResolution() {
        return xresolution;
    }

    public int getYResolution() {
        return yresolution;
    }

    public void setWindow(double xminimum, double xmaximum, double yminimum, double ymaximum) {
        this.xminimum = xminimum;
        this.xmaximum = xmaximum;
        this.yminimum = yminimum;
        this.ymaximum = ymaximum;
    }

    public void setResolution(int xresolution, int yresolution) {
        this.xresolution = xresolution;
        this.yresolution = yresolution;
    }

    public void setEvaluator(Node evaluator) {
        this.evaluator = evaluator;
    }

    private File showSaveOptions() {
        JFileChooser chooser = new JFileChooser(".");
        FileFilter filter = new FileNameExtensionFilter("PNG file", "png");
        chooser.setFileFilter(filter);
        int result = chooser.showSaveDialog(Application.getApplication());
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileResult = chooser.getSelectedFile();
            // trim the extension from the name.
            if (fileResult.getName().endsWith(".png")) {
                fileResult = new File(fileResult.getParent(), fileResult.getName().substring(0, fileResult.getName().length() - 4));
                return fileResult;//chooser.getSelectedFile();
            }
            return fileResult;
        }
        return null;
    }

    private BufferedImage buildImage() {
        File file = showSaveOptions();
        if (file == null) {
            return null;
        }

        BufferedImage lastImage = null;

        System.out.println("STARTING LARGE FORMAT RENDER");
        // go through each cell
        int xcells = (int) Math.ceil((float) xresolution / CELL_SIZE);
        int ycells = (int) Math.ceil((float) yresolution / CELL_SIZE);
        for (int cellY = 0; cellY < ycells && !isTerminated(); cellY++) {
            for (int cellX = 0; cellX < xcells && !isTerminated(); cellX++) {
                System.out.println("Rendering cell " + (1 + cellX + cellY * xcells) + " out of " + (xcells * ycells));

                int currentXCellSize = Math.min(CELL_SIZE, xresolution - CELL_SIZE * cellX);
                int currentYCellSize = Math.min(CELL_SIZE, yresolution - CELL_SIZE * cellY);

                String filename = file.getName() + "_" + cellX + "_" + cellY + ".png";

                BufferedImage img = new BufferedImage(
                        currentXCellSize,
                        currentYCellSize,
                        BufferedImage.TYPE_INT_ARGB);

                for (int y = 0; y < currentYCellSize && !isTerminated(); y++) {
                    for (int x = 0; x < currentXCellSize && !isTerminated(); x++) {

                        double cx = (double) (x + cellX * CELL_SIZE) / xresolution;
                        double cy = (double) (y + cellY * CELL_SIZE) / yresolution;

                        cx = (double) (xminimum + (xmaximum - xminimum) * cx);
                        cy = (double) (yminimum + (ymaximum - yminimum) * cy);

                        evaluator.setContext(new ContextXY(cx, cy));
                        utils.linear.Color color = (utils.linear.Color) (evaluator.evaluate());

                        img.setRGB(x, y, color.toARGB());
                    }
                    for (RenderListener listener : listeners) {
                        listener.setLine(y + cellY * CELL_SIZE, yresolution);
                        if (y % 50 == 0) {
                            System.out.print(".");
                        }
                    }
                }
                try {
                    System.out.println(" saving...");
                    ImageIO.write(img, "png", new File(file.getParent(), filename));
                } catch (IOException ex) {
                    Logger.getLogger(LargeFormatRenderer.class.getName()).log(Level.SEVERE, null, ex);
                }

                lastImage = img;
            }
        }
        System.out.println("DONE!!!");

        return lastImage;
    }

    @Override
    public void run() {

        BufferedImage image = null;
        try {
            image = buildImage();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        for (RenderListener listener : listeners) {
            if (image != null) {
                listener.setImage(image);
            }
            listener.threadFinished();
        }

    }
}
