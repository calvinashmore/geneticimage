/*
 * Application.java
 *
 * Created on April 23, 2006, 6:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package geneticimage.ui;

import fileservice.ExtensionFilter;
import fileservice.FileService;
import geneticimage.BreedThread;
import geneticimage.BuilderThread;
import geneticimage.LargeFormatRenderer;
import geneticimage.MutateThread;
import geneticimage.Node;
import geneticimage.NodeBuilder;
import geneticimage.ui.equation.VisualNodeView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Calvin Ashmore
 */
public class Application extends JPanel {

    private static final Color backgroundColor = new Color(180, 180, 180);
    private static final int borderSize = 5;
    private static Application app;

    public static Application getApplication() {
        return app;
    }

    public PalettePanel getPalettePanel() {
        return palettePanel;
    }

    public StoredPanel getStoredPanel() {
        return storedPanel;
    }

    public NodeBuilder getBuilder() {
        return builder;
    }
    private NodeStructure selected;
    private NodeBuilder builder;
    private PalettePanel palettePanel;
    private SelectViewPanel selectViewPanel;
    private StoredPanel storedPanel;
    private VisualNodeView equationPanel;
    private NodeStructure breedSelection;
    private int numberRenderWindows;

    public void incrementNumberRenderWindows(int ammount) {
        numberRenderWindows += ammount;
    }

    public int getNumberRenderWindows() {
        return numberRenderWindows;
    }

    /** Creates a new instance of Application */
    public Application() {

        builder = new NodeBuilder();
        //builder.getImageManager().addFolder("D:\\Projects\\Genetic\\GeneticImage2\\images");

        app = this;

        palettePanel = new PalettePanel();
        selectViewPanel = new SelectViewPanel();
        storedPanel = new StoredPanel();
        equationPanel = new VisualNodeView();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(0, 0));
        topPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        topPanel.add(selectViewPanel);
        topPanel.add(Box.createHorizontalStrut(borderSize));
        topPanel.add(palettePanel);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.setBackground(backgroundColor);
        topPanel.setMinimumSize(new Dimension(
                selectViewPanel.getMinimumSize().width + borderSize + palettePanel.getMinimumSize().width,
                Math.max(selectViewPanel.getMinimumSize().height, palettePanel.getMinimumSize().height)));
        topPanel.setPreferredSize(new Dimension(
                selectViewPanel.getMinimumSize().width + borderSize + palettePanel.getMinimumSize().width,
                Math.max(selectViewPanel.getMinimumSize().height, palettePanel.getMinimumSize().height)));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(topPanel);
        add(Box.createVerticalStrut(borderSize));
        add(storedPanel);
        add(Box.createVerticalStrut(borderSize));
        add(equationPanel);

        setBorder(new EmptyBorder(borderSize, borderSize, borderSize, borderSize));
        setBackground(backgroundColor);
    }

    public void doSelect(NodeStructure structure) {

        if (breedSelection != null) {

            doBreedAction(breedSelection, structure);
        } else {

            if (selected == structure) {
                return;
            }

            selected = structure;
            selectViewPanel.select(selected);
            equationPanel.selectEquation(selected.getNode());

        //System.out.println("selected something");
        }
    }

    public void doNewPalette() {

        breedSelection = null;

        List<ImagePanelContainer> images = getPalettePanel().getImages();

        for (final ImagePanelContainer image : images) {

            new Thread() {

                public void run() {

                    Node newNode = getBuilder().buildStartingNode();
                    NodeStructure structure = new NodeStructure(newNode);
                    image.getImagePanel().setStructure(structure);
                    image.getImagePanel().beginRender();
                }
            }.start();
        }
    }

    public void doMutate(final NodeStructure source) {

        breedSelection = null;

        List<ImagePanelContainer> images = getPalettePanel().getImages();

        for (final ImagePanelContainer image : images) {

            BuilderThread bt = new BuilderThread() {

                private MutateThread t;

                public void terminate() {
                    t.terminate();
                }

                public void run() {

                    t = new MutateThread(getBuilder());
                    t.setParameter(source.getNode());
                    //t.setPriority(Thread.MIN_PRIORITY+1);
                    t.start();
                    synchronized (t) {
                        try {
                            t.wait();
                        } catch (InterruptedException ex) {
                        }
                    }
                    Node newNode = t.getResult();
                    if (newNode == null) {
                        return;
                    }

                    //Node newNode = getBuilder().mutate(source.getNode());
                    NodeStructure structure = new NodeStructure(newNode);
                    image.getImagePanel().setStructure(structure);
                    image.getImagePanel().beginRender();
                }
            };
            image.getImagePanel().setBuilderThread(bt);
            bt.start();
        }
    }

    public void doBreedButton(final NodeStructure source) {

        if (breedSelection != null) {
            doBreedAction(breedSelection, source);
        } else {
            breedSelection = source;
        }
    }

    public void doBreedAction(final NodeStructure source1, final NodeStructure source2) {

        breedSelection = null;

        List<ImagePanelContainer> images = getPalettePanel().getImages();

        for (final ImagePanelContainer image : images) {

            BuilderThread bt = new BuilderThread() {

                private BreedThread t;

                public void terminate() {
                    t.terminate();
                }

                public void run() {

                    t = new BreedThread(getBuilder());
                    t.setParameters(source1.getNode(), source2.getNode());
                    //t.setPriority(Thread.MIN_PRIORITY+1);
                    t.start();
                    synchronized (t) {
                        try {
                            t.wait();
                        } catch (InterruptedException ex) {
                        }
                    }
                    Node newNode = t.getResult();
                    if (newNode == null) {
                        return;
                    }

                    //Node newNode = getBuilder().breed(source1.getNode(), source2.getNode());
                    NodeStructure structure = new NodeStructure(newNode);
                    image.getImagePanel().setStructure(structure);
                    image.getImagePanel().beginRender();
                }
            };
            image.getImagePanel().setBuilderThread(bt);
            bt.start();
        }
    }
    private int defaultResolution = 500;

    public void doRender(final NodeStructure source) {

        breedSelection = null;

        Object r = JOptionPane.showInputDialog(
                this,
                "Select render resolution:",
                "Render Image", JOptionPane.OK_CANCEL_OPTION,
                null, null, "" + defaultResolution);

        if (r != null) {
            int resolution = -1;
            try {
                resolution = Integer.valueOf((String) r);
            } catch (NumberFormatException ex) {
            }

            if (resolution <= 0) {
                JOptionPane.showMessageDialog(this, "Resolution is invalid!");
            } else {
                defaultResolution = resolution;

                if (resolution < LargeFormatRenderer.CELL_SIZE) {
                    RenderWindow renderWindow = new RenderWindow(source, resolution);
                    renderWindow.setVisible(true);
                } else {
                    LargeFormatRenderer renderer = new LargeFormatRenderer();
                    renderer.setResolution(resolution, resolution);
                    renderer.setEvaluator(source.getNode());
                    renderer.start();
                }
            }
        }
    }

    public void doStore(final NodeStructure source) {

        breedSelection = null;

        getStoredPanel().addImage(source);
    }

    public void doNewSingle(final ImagePanel imagePanel) {
        new Thread() {

            public void run() {

                Node newNode = getBuilder().buildStartingNode();
                NodeStructure structure = new NodeStructure(newNode);
                imagePanel.setStructure(structure);
                imagePanel.beginRender();
            }
        }.start();
    }

    public void saveData(final NodeStructure structure) {

        FileService fs = FileService.getInstance(new File("."));
        String exts[] = {"gen"};
        try {
            FileService.Save save = fs.save(null, "", new ExtensionFilter("Genetic Image saves", exts), null, ".gen");

            OutputStream os = save.getOutputStream();
            if (os == null) {
                return;
            }

            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(structure);
            oos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Save failed!");
        }

    /*
    JFileChooser chooser = new JFileChooser();

    chooser.setFileFilter(new FileFilter() {
    public boolean accept(File f) {
    return
    f.isDirectory() ||
    f.getName().endsWith(".gen");
    }
    public String getDescription() {
    return "Genetic Image Saves (*.gen)";
    }
    });

    int returnVal = chooser.showSaveDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
    if(!file.getName().endsWith(".gen"))
    file = new File(file.getParentFile(), file.getName()+".gen");

    try {
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(structure);

    } catch (FileNotFoundException ex) {
    JOptionPane.showMessageDialog(this,"Save failed!");
    ex.printStackTrace();
    } catch (IOException ex) {
    JOptionPane.showMessageDialog(this,"Save failed!");
    ex.printStackTrace();
    }
    }*/
    }

    public NodeStructure loadData() {

        FileService fs = FileService.getInstance(new File("."));
        String exts[] = {"gen"};
        try {
            FileService.Open open = fs.open(null, "", new ExtensionFilter("Genetic Image saves", exts));
            InputStream is = open.getInputStream();
            if (is == null) {
                return null;
            }
            ObjectInputStream ois = new ObjectInputStream(is);
            NodeStructure structure = (NodeStructure) ois.readObject();
            return structure;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Load failed!");
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Load failed!");
            ex.printStackTrace();
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "Load failed!");
            ex.printStackTrace();
        }

        /*
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(new FileFilter() {
        public boolean accept(File f) {
        return
        f.isDirectory() ||
        f.getName().endsWith(".gen");
        }
        public String getDescription() {
        return "Genetic Image Saves (*.gen)";
        }
        });

        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
        ObjectInputStream ois;

        try {
        ois = new ObjectInputStream(new FileInputStream(file));
        NodeStructure structure = (NodeStructure)ois.readObject();
        return structure;

        } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this,"Load failed!");
        ex.printStackTrace();
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(this,"Load failed!");
        ex.printStackTrace();
        } catch (ClassCastException ex) {
        JOptionPane.showMessageDialog(this,"Load failed!");
        ex.printStackTrace();
        }
        }*/
        return null;
    }

    public void saveImage(BufferedImage image) {

        FileService fs = FileService.getInstance(new File("."));
        String exts[] = {"png"};
        try {
            FileService.Save save = fs.save(null, "", new ExtensionFilter("PNG Image file", exts), null, ".png");
            OutputStream os = save.getOutputStream();
            if (os == null) {
                return;
            }

            ImageIO.write(image, "png", os);
            os.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Save failed!");
        }

    /*
    JFileChooser chooser = new JFileChooser();

    chooser.setFileFilter(new FileFilter() {
    public boolean accept(File f) {
    return
    f.isDirectory() ||
    f.getName().endsWith(".png");
    }
    public String getDescription() {
    return "PNG Image file (*.png)";
    }
    });

    int returnVal = chooser.showSaveDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
    if(!file.getName().endsWith(".png"))
    file = new File(file.getParentFile(), file.getName()+".png");

    try {
    ImageIO.write( image, "png", file);

    } catch (IOException ex) {
    JOptionPane.showMessageDialog(this,"Save failed!");
    }

    }*/
    }

    public void updateSelect(Node root) {

        selected = new NodeStructure(selected, root);
        selectViewPanel.select(selected);
        selectViewPanel.beginRender();
    }
}
