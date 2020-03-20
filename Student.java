/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author Alireza Ghafari
 * @version 0.0
 */
public class Student {
    // the student’s first name
    private String firstName;
    // the student’s last name
    private String lastName;
    // the student ID
    private String id;
    //the grade
    private int grade;
    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lName last name of student
     * @param sID student ID
     */
    public Student(String fName, String lName, String sID){
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = 0;
    }
    /**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param fName set first name of a student
     */
    public  void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * get the lastname of the student
     * @return lastName field
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lName set lastname of the student
     */
    public void setLastName(String lName) {
        lastName = lName;
    }


    /**
     * @param grade set grade of a student
     */
    public void setGrade(int grade) {
        if (grade > 0) {
            this.grade = grade;
        }else
            System.out.println("The grade must be a positive number!");
    }

    /**
     * get the grade of student
     *
     * @return grade field
     */
    public int getGrade(){
        return grade;
    }


    /**
     * get the id of student
     *
     * @return id field
     */
    public String getId() {
        return id;
    }

    /**
     * @param id set id of a student
     */
    public void setId(String id) {
        if (Integer.parseInt(id) > 0) {
            this.id = id;
        }else
            System.out.println("id must be a positive number!");
    }






    /**
     * Print the student’s last name and ID number to the
     output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }
}
