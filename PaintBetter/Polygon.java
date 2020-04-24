import java.util.ArrayList;
/**
 * this is an abstract class which is implemented by Rectangle and Triangle Class
 * @author Alireza Ghafari
 * @version 2.0
 */
public abstract class Polygon extends Shape{
    protected ArrayList<Double> sides;

    public ArrayList<Double> getSides() {
        return sides;
    }
    public Polygon(double...sides){
        this.sides = new ArrayList<Double> ();
        for(Double i: sides)
            this.sides.add(i);
    }

    /**
     * a method to state whether objects are equal or not
     * @param object input shape
     * @return are objects equal
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Polygon)) return false;
        Polygon polygon=(Polygon) object;
        boolean flag=true;
        for(Double i: sides)
            if(!(polygon.sides.contains(i)))
                flag = false;
        boolean flag2=true;
        for(Double i: polygon.sides)
            if(!(sides.contains(i)))
                flag = false;
        return flag && flag2;
    }

    /**
     * @return features of polygon
     */
    @Override
    public String toString() {
        String st = " Sides: ";
        for(Double i:sides)
            st += i+ ", ";
        return st;
    }
    /**
     * @return perimeter of the polygon
     */
    @Override
    public double calculatePerimeter() {
        double perimeter= 0;
        for(Double i:sides)
            perimeter += i;
        return perimeter;
    }

}
