/**
 * this is an abstract class which is implement by shapes classes
 * @author Alireza Ghafari
 * @version 2.0
 */
public abstract class Shape {
    /**
     * @return area of the shape
     */
    public abstract double calculateArea();

    /**
     * @param object input shape
     * @return whether objects are equal or not
     */
    public abstract boolean equals(Object object);
    /**
     * @return features of shape
     */
    public abstract String toString() ;

    /**
     * @return perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * print shape quantities
     */
    public abstract void draw();
}
