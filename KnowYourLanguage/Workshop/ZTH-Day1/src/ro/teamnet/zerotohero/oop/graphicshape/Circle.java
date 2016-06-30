package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Elena on 30.06.2016.
 */
public class Circle extends Shape {
    private int xPos, yPos, radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 10;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    public void fillColor() {
        System.out.println("The circle color is " + super.color);
    }

    public void fillColor(int color) {
        super.color = color;
        System.out.println("The circle color is now " + color);
    }

    public void fillColor(float color) {
        super.saturation = color;
        System.out.println("The saturation is " + this.saturation);
    }

    @Override
    public String toString() {
        return "center = (" + xPos + ", " + yPos + ") and radius = " + radius;
    }
}
