import java.util.ArrayList;
/**
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Triangle {
    private ArrayList<Double> sides;

    public Triangle(double a , double b , double c){
        sides = new ArrayList<Double> ();
        sides.add(a);
        sides.add(b);
        sides.add(c);
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
    /**
     * @return area of the shape
     */
    public double calculateArea(){
        double p = 0.5 * calculatePerimeter();
        double area = Math.sqrt(p);
        for(Double i: sides)
            area *= Math.sqrt(p-i);
        return area;
    }


    public ArrayList<Double> getSides() {
        return sides;
    }

    public boolean equals(Triangle triangle){
        boolean flag=true;
        for(Double i: sides)
            if(!(triangle.sides.contains(i)))
                flag = false;
        boolean flag2=true;
        for(Double i: triangle.sides)
            if(!(sides.contains(i)))
                flag = false;
        return flag && flag2;
    }
    public boolean isEquilateral(){
        if(sides.get(0) == sides.get(1) && sides.get(0) == sides.get(2))
            return true;
        return false;
    }
    /**
     * @return features of shape
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " "+getSides();
    }
    /**
     * print shapes quantities
     */
    public void draw(){
        System.out.println(this.getClass().getSimpleName() + ": "+
                "  Area = " + calculateArea() +
                "  Perimeter = " + calculatePerimeter());
    }
}
