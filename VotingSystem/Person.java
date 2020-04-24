
/**
 * this is a class for voters specification
 *
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Person {
    // first name
    private String firstName;
    // last name
    private String lastName;

    /**
     * Constructor for person
     *
     * @param firstName of person
     * @param lastName  of person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * get string of person
     *
     *
     * @return complete name
     */
    @Override
    public String toString() {
        return "person [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    /**
     * get first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get last name
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

}
