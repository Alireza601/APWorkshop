/**
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Rectangle extends Polygon {

    public Rectangle(double...sides){
        super(sides);
    }

    /**
     * @return area of the shape
     */
    public double calculateArea(){
        if(sides.get(0) == sides.get(1))
            return sides.get(0) * sides.get(2);
        return sides.get(0)*sides.get(1);
    }
    public boolean isSquare(){
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2));
    }

    /**
     * @return features of rectangular
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " =>  " + super.toString();
    }

    /**
     * print shape quantities
     */
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName() + ": "+
                "  Area = " + calculateArea() +
                "  Perimeter = " + calculatePerimeter());
    }
}
