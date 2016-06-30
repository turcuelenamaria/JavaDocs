package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Elena on 30.06.2016.
 */
public class Square extends Shape {
    private int side;

    

    public Square(int side) {

        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
