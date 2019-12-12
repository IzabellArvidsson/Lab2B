package Grafic;


import Model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private HashMap<Vehicle, BufferedImage> imageMap = new HashMap<>();  //kopplar ihop bild med bil(modelnamnet)
    private BufferedImage vehicleImage;

    Font myFont = new Font("Courier New", 1,17);


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        populateCarImageMap(cars);

    }

    public void populateCarImageMap(ArrayList<Vehicle> cars){
        for(Vehicle c : cars){
            String modelName =c.getModelName();
            BufferedImage carImage = null;
            try{
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/Grafic/pics/" + modelName + ".jpg"));
            }catch (IOException e){
                e.printStackTrace();
            }
            imageMap.put(c, carImage);
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (Map.Entry<Vehicle, BufferedImage> map : imageMap.entrySet()){
            g.drawImage(map.getValue(), (int) map.getKey().getX(), (int) map.getKey().getY(), null);

            g.drawString(map.getKey().getModelName(), (int) Math.round(map.getKey().getX()), (int) Math.round(map.getKey().getY() + 70));
        }


    }

}