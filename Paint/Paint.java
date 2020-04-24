import java.util.ArrayList;

/**
 * this class has any methods related to objects
 * print and draw shapes
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Paint {
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;
    public Paint(){
        circles = new ArrayList<Circle>();
        triangles = new ArrayList<Triangle>();
        rectangles = new ArrayList<Rectangle>();
    }
    public void addCircle(Circle circle){
        this.circles.add(circle);
    }
    public void addTriangle(Triangle triangle){
        this.triangles.add(triangle);
    }
    public void addRectangle(Rectangle rectangle){
        this.rectangles.add(rectangle);
    }
    /**
     * print shapes quantities
     */
    public void drawAll(){
        for(Circle circle: circles){
            circle.draw();
        }
        System.out.println();

        for(Triangle triangle: triangles){
            triangle.draw();
        }
        System.out.println();

        for(Rectangle rectangle: rectangles){
            rectangle.draw();
        }
        System.out.println();
    }
    /**
     * print shapes features
     */
    public void printAll(){
        for(Circle circle: circles){
            System.out.print(circle + "\n");
        }
        System.out.println('\n');

        for(Triangle triangle: triangles){
            System.out.print(triangle + "\n");
        }
        System.out.println("\n");

        for(Rectangle rectangle: rectangles){
            System.out.print(rectangle + "\n");
        }
        System.out.println("\n");
    }
}
