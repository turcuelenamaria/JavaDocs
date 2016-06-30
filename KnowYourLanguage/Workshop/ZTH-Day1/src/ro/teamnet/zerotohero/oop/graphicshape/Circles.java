package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Elena on 30.06.2016.
 */
public class Circles {
    public double getAreaPub() {
        Circle circle = new Circle();
        return circle.area();
    }

    public void getAreaDef() {
        Circle circle = new Circle();
        circle.fillColor();
        circle.fillColor(10);
        circle.fillColor((float) 20.0);
    }
}
