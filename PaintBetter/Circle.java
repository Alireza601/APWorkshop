/**
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    /**
     * @return area of the shape
     */
    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }

    /**
     * @return perimeter of the shape
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Polygon)) return false;
        Circle circle=(Circle) object;
        return false;
    }
    /**
     * @return features of shape
     */
    @Override
    public String toString() {
        return "Circle(" +
                "radius=" + radius +
                ')';
    }

    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName() + ": "+
                "  Area = " + calculateArea() +
                "  Perimeter = " + calculatePerimeter());
    }
}
