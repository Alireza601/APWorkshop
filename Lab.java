/**
 * The Lab class represents a Lab in a student administration system. It holds
 * the Lab details relevant in our context.
 *
 * @author  Alireza Ghafari
 * @version 0.0
 */

public class Lab {

    // list of students
    public Student[] students;

    // the average grade of students of lab
    private int avg;

    // the day that lab will take a place
    private String day;

    // the capacity of a lab
    private int capacity;

    // the current size of a lab
    private int currentSize;

    /**
     * Create a new Lab
     *
     * @param cap    capacity of lab
     * @param day    the day that lab will take a place
     */

    public Lab(int cap, String day) {
        capacity=cap;
        this.day=day;
        this.students=new Student[capacity];
    }


    /**
     * student enrollment in lab
     */

    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }


    /**
     * print properties of lab
     */
    public void print() {
        for (int i = 0; i < currentSize; i++) {
        System.out.println("std fname: " + students[i].getFirstName() + "  std id: "
                + students[i].getId() + "  std grade: " + students[i].getGrade());
    }

    }

    /**
     *
     * @return  the list of students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * set the students
     * @param students
     */
    public void setStudents(Student[] students) {
        for (int i = 0; i < capacity; i++) {
            this.students[i] = students[i];
        }
    }


    /**
     * @return the average grade
     */
    public int getAvg() {
        return avg;
    }

    /**
     * a method to calculate the average of grades
     */
    public void calculateAvg() {
        int sum = 0;
        for (int i = 0; i < currentSize; i++) {
            sum += students[i].getGrade();
        }
        avg = sum / currentSize;
    }

    /**
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * method to set day
     *
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * method to get capacity of the lab
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * method to set the capacity of the lab
     * @param capacity
     */
    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }
}
