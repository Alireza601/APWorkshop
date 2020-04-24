/**
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Triangle extends Polygon {

    public Triangle(double...sides){
        super(sides);
    }

    public boolean isEquilateral(){
        if(sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2)))
            return true;
        return false;
    }
    /**
     * @return features of shape
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " =>  " + super.toString();
    }

    /**
     * @return area of the triangle
     */
    @Override
    public double calculateArea() {
        double p = 0.5 * calculatePerimeter();
        double area = Math.sqrt(p);
        for(Double i: sides)
            area *= Math.sqrt(p-i);
        return area;
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
