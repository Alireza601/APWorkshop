/**
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    /**
     * @return perimeter of the shape
     */
    public double calculatePerimeter(){
        return Math.PI * 2 * radius;
    }

    public double getRadius() {
        return radius;
    }
    /**
     * @return area of the shape
     */
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
    public void draw(){
        System.out.println(this.getClass().getSimpleName() + ": "+
                "  Area = " + calculateArea() +
                "  Perimeter = " + calculatePerimeter());
    }
    public boolean equals(Circle circle){
        if(circle.radius == radius)
            return true;
        return false;
    }
    /**
     * @return features of shape
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " "+radius;
    }

}
