/**
 * the Main class that runs main method and creates objects from other calsses
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Run {
    public static void main(String[] args){
        Circle c= new Circle(2);
        Circle c2= new Circle(3);
        Circle c3= new Circle(4);
        Rectangle r=new Rectangle(1,2,1,2);
        Rectangle r2=new Rectangle(3,6,6,4);
        Rectangle r3=new Rectangle(1,3,3,1);
        Rectangle r4=new Rectangle(1,1,4,4);
        Triangle t= new Triangle(2,5,4);
        Triangle t2= new Triangle(6,5,3);
        Triangle t3= new Triangle(6,4,3);

        Paint p= new Paint();
        p.addCircle(c);
        p.addCircle(c2);
        p.addCircle(c3);
        p.addRectangle(r);
        p.addRectangle(r2);
        p.addRectangle(r3);
        p.addRectangle(r4);
        p.addTriangle(t);
        p.addTriangle(t2);
        p.addTriangle(t3);
        p.drawAll();
        p.printAll();
    }
}
