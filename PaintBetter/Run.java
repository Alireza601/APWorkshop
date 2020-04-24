/**
 * the Main class that runs main method and creates objects from other calsses
 * @author Alireza Ghafari
 * @version 2.0
 */
public class Run {
    public static void main(String[] args){
        //create objects
        Circle c= new Circle(2);
        Circle c2= new Circle(3);
        Circle c3= new Circle(4);
        Rectangle r=new Rectangle(1,2,1,2);
        Rectangle r2=new Rectangle(3,6,6,4);
        Rectangle r3=new Rectangle(1,3,3,1);
        Rectangle r4=new Rectangle(4,4,4,4);
        Triangle t= new Triangle(3,3,3);
        Triangle t2= new Triangle(6,5,3);

        Paint paint= new Paint();
        paint.addShapes(c);
        paint.addShapes(c2);
        paint.addShapes(c3);
        paint.addShapes(r);
        paint.addShapes(r2);
        paint.addShapes(r3);
        paint.addShapes(r4);
        paint.addShapes(t);
        paint.addShapes(t2);

        paint.drawAll();
        paint.printAll();

        paint.describeEqualSides();
    }
}
