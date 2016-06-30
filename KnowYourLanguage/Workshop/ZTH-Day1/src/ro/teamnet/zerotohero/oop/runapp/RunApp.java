package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.oop.graphicshape.Circle;
import ro.teamnet.zerotohero.oop.graphicshape.Circles;
import ro.teamnet.zerotohero.oop.graphicshape.Shape;
import ro.teamnet.zerotohero.oop.graphicshape.Square;
import ro.teamnet.zerotohero.oop.graphicshape.ShapeBehaviour;

/**
 * Created by Elena on 30.06.2016.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles myCircle = new Circles();
        Circle circle = new Circle(2, 3, 34);
        System.out.println(circle.toString());
        System.out.println("The default circle area is " + myCircle.getAreaPub());
        myCircle.getAreaDef();
        // Canvas canvas = new Canvas();
        Shape shape = new Circle(10);
        System.out.println(shape.area());
        ShapeBehaviour shapeBehaviour = new Square(10);
        System.out.println(shapeBehaviour.area());
    }
}
