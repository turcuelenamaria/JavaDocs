package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Elena on 30.06.2016.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {
    protected int color;
    protected float saturation;

    @Override
    public double area() {
        double value;
        return 1.0;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
