import java.util.ArrayList;
/**
 * this class has any methods related to objects
 * print and draw shapes
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Paint {
    private ArrayList<Shape> shapes;
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;
    public Paint(){
        circles = new ArrayList<Circle>();
        triangles = new ArrayList<Triangle>();
        rectangles = new ArrayList<Rectangle>();
        shapes = new ArrayList<Shape>();
    }
    public void addShapes(Shape shape){
        this.shapes.add(shape);
    }

    /**
     * print shapes quantities
     */
    public void drawAll(){
        for(Shape shape: shapes)
            shape.draw();
        System.out.println();
    }

    public void printAll(){
        for(Shape shape: shapes)
            System.out.println(shape.toString());
        System.out.println("\n");
    }
    public void describeEqualSides(){
        System.out.println("Equality: ");
        for(Shape shape: shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                if(rectangle.isSquare())
                    System.out.println(rectangle.toString());
            }
            if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                if(triangle.isEquilateral())
                    System.out.println(triangle.toString());
            }
        }
    }
}
