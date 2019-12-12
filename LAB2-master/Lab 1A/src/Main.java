import Controller.CarController;
import Grafic.CarView;
import Grafic.DrawPanel;
import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static final int delay = 50;
    public static Vehicle volvo;
    public static Vehicle saab;
    public static Vehicle scania;


    public static void main(String[] args) {

        CarController cc = new CarController();
        CarView carView = new CarView("CarSim 1.0");
        ArrayList<Vehicle> cars = new ArrayList<>();
        CarView frame = new CarView("CarSim 1.0");
        DrawPanel panel = new DrawPanel(carView.getWidth(), carView.getHeight(), cars);


        volvo = new Volvo240(0, 500);
        saab = new Saab95(0, 400);
        scania = new Scania(0, 300, 0, 70);
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);


        Timer timer = new Timer(delay, (actionEvent) -> {
            cc.setAllListeners(cars, frame);
            for (Vehicle car : cars) {
                car.move();
                frame.drawPanel.populateCarImageMap(cars);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                //car.update(car);
                if (car.getX() > carView.getWidth() - 120) {
                    car.currentDirection = Vehicle.direction.WEST;
                } else if (car.getX() < 0) {
                    car.currentDirection = Vehicle.direction.EAST;
                }

            }
        });

        timer.start();


    }
}
