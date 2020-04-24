/**
 * vote class for voting system
 *
 * @author Alireza Ghafari
 * @version 1.0
 */
import ir.huri.jcal.JalaliCalendar;

public class Vote {
    // person
    private Person person;
    // date of voting
    private String date;

    /**
     * Constructor for Vote
     *
     * @param person who voted
     */
    public Vote(Person person) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();

        this.person = person;
        this.date = jalaliCalendar.getDayOfWeekString();
    }

    /**
     * get person
     *
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * get Date
     *
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /**
     * hashcode for voting
     *
     * @return hashing for each object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((person == null) ? 0 : person.hashCode());
        return result;
    }

    /**
     * check whether is equal or not
     *
     * @return if correct return true otherwise return false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vote other = (Vote) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (person == null) {
            if (other.person != null)
                return false;
        } else if (!person.equals(other.person))
            return false;
        return true;
    }

}
