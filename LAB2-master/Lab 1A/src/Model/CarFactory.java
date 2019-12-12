package Model;

public class CarFactory {

    public static Vehicle createSaab95 (){ return new Saab95(0,5);}

    public static Vehicle createVolvo240(){ return new Volvo240(0,20);}

    public static Vehicle createScania(){return new Scania(0,35,0,70);}


}
