import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 *  @author Alireza Ghafari
 *   @version 1.0
 */
public class Voting {
    // type og voting
    private int type;
    // question of question
    private String question;
    // voters who attend in voting
    private ArrayList<Person> voters;
    // choice to person who voted this choice
    private HashMap<String, HashSet<Vote>> polls;
    JalaliCalendar calendar = new JalaliCalendar();

    /**
     * Constructor for card
     *
     * @param type for declare type of voting
     * @param question question of voting
     */
    public Voting(int type, String question) {
        this .type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();

    }

    /**
     * get question
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * give choise & add to polls
     *
     *
     * @param a choice
     */
    public void creatPoll(String a) {
        polls.put(a, new HashSet<Vote>());
    }

    /**
     * give person & his choices & add to voting
     *
     *
     * @param  person & his choices
     */
    public void vote(Person person, ArrayList<String> choices) {
        if(choices.get(0)=="random") {
            Random r = new Random();
            int t=r.nextInt(getPolls().size());
            choices.remove(0);
            choices.add(getPolls().get(t));

        }
        voters.add(person);
        if (type == 1 && choices.size() > 1) {
            System.out.println("you must choose one choice ");
        } else {
            System.out.println("vote submitted ");
            Vote v = new Vote(person);
            for (int i = 0; i < choices.size(); i++) {
                for (String key : polls.keySet()) {
                    if (choices.get(i) == key) {
                        polls.get(key).add(v);
                    }
                }
            }
        }
    }

    /**
     * give person who voted
     */
    public void getVoters() {
        for (int i = 0; i < voters.size(); i++) {
            System.out.println(voters.get(i).toString());
        }
    }

    /**
     * print result of voting
     *
     */
    public void printVotes() {
        for (int i = 0; i < getPolls().size(); i++) {
            System.out.print(getPolls().get(i) + " = " + polls.get(getPolls().get(i)).size() + " ( ");
            for (Vote obj : polls.get(getPolls().get(i))) {
                System.out.print(obj.getPerson().toString() + " voted in " + obj.getDate() + ", ");
            }
            System.out.println(")");
        }
    }

    /**
     * give choices
     *
     * @return choices
     */
    public ArrayList<String> getPolls() {
        ArrayList<String> a = new ArrayList<String>();
        for (String key : polls.keySet()) {
            a.add(key);
        }

        return a;
    }

}
