/**
 * @author Alireza Ghafari
 * @version 2.0
 */
import java.util.ArrayList;

public class Rectangle {
    private ArrayList<Double> sides;

    public Rectangle(double a , double b , double c , double d){
        sides = new ArrayList<Double> ();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    /**
     * @return perimeter of the shape
     */
    public double calculatePerimeter(){
        int perimeter = 0;
        for(Double i:sides)
            perimeter += i;
        return perimeter;
    }
    public boolean isSquare(){
        if(sides.get(0) == sides.get(1) && sides.get(0) == sides.get(2) )
            return true;
        return false;
    }
    /**
     * @return area of the shape
     */
    public double calculateArea(){
        if(sides.get(0) == sides.get(1))
            return sides.get(0) * sides.get(2);
        return sides.get(0)*sides.get(1);
    }

    public void draw(){
        System.out.println(this.getClass().getSimpleName() + ": "+
                "  Area = " + calculateArea() +
                "  Perimeter = " + calculatePerimeter());
    }
    public boolean equals(Rectangle rectangle){
        boolean flag=true;
        for(Double i: sides)
            if(!(rectangle.sides.contains(i)))
                flag = false;
        boolean flag2=true;
        for(Double i: rectangle.sides)
            if(!(sides.contains(i)))
                flag = false;
        return flag && flag2;
    }

    public ArrayList<Double> getSides() {
        return sides;
    }
    /**
     * @return features of shape
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " "+getSides();
    }
}
