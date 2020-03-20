/**It determines the limitation of clock scopes number
 *
 *@author Alireza Ghafari
 * @version 0.0
 */
public class DisplayNumber{
    private int number;
    private int limit;


    /**
     *this method sets the start time of clock
     * @param value to get the start time from input
     */
    public void setNumber(int value){
        if(value>=0 && value<limit)
            number=value;
    }

    /**
     * this method increases the number of part "second" one by one
     * and checks that number is not out of range
     */
    public void increment(){
        number++;
        number%=limit;
    }

    /**
     * each part of clock display should have a number limit
     * @param limit give the number limit: 60 or 24
     */
    public void setLimit(int limit){
        this.limit=limit;
    }

    /**
     * @return  the number as a string value
     */
    public String getNumber(){
        String str=Integer.toString(number);
        if(number > 9)
            return  str;
        else
            return "0" + str;
    }
}