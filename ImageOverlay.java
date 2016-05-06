/*
 * Decompiled with CFR 0_114.
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImageOverlay {
    public static void main(String[] args) {
        BufferedImage fgImage;
        JFrame j = new JFrame();
        BufferedImage bgImage = ImageOverlay.readImage("D:\\snake\\a.jpg");
        BufferedImage overlayedImage = ImageOverlay.overlayImages(bgImage, fgImage = ImageOverlay.readImage("D:\\snake\\ab.jpg"));
        if (overlayedImage != null) {
            System.out.println("Overlay Completed...");
        } else {
            System.out.println("Problem With Overlay...");
        }
    }

    public static BufferedImage overlayImages(BufferedImage bgImage, BufferedImage fgImage) {
        if (fgImage.getHeight() > bgImage.getHeight() || fgImage.getWidth() > fgImage.getWidth()) {
            JOptionPane.showMessageDialog(null, "Foreground Image Is Bigger In One or Both Dimensions\nCannot proceed with overlay.\n\n Please use smaller Image for foreground");
            return null;
        }
        Graphics2D g = bgImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(bgImage, 0, 0, null);
        g.drawImage(fgImage, 0, 0, null);
        g.dispose();
        return bgImage;
    }

    public static BufferedImage readImage(String fileLocation) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileLocation));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void writeImage(BufferedImage img, String fileLocation, String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write((RenderedImage)bi, extension, outputfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

