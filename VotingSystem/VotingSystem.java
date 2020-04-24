
/**
 *  this is a class to manage votes
 *
 *  @author Alireza Ghafari
 *  @version 1.0
 */
import java.util.*;

public class VotingSystem {
    // list of voting
    private ArrayList<Voting> votingList;

    /**
     * Constructor for voting system
     *
     */
    public VotingSystem() {
        votingList = new ArrayList<Voting>();
    }

    /**
     * create new vote
     *
     * @param question  is question
     * @param type type of voting
     * @param choices choices
     */
    public void createVoting(String question, int type, ArrayList<String> choices) {
        Voting m = new Voting(type, question);
        votingList.add(m);
        for (int i = 0; i < choices.size(); i++) {
            m.creatPoll(choices.get(i));
        }
    }

    /**
     * print question
     *
     */
    public void printVotingQuestion() {
        for (int i = 0; i < votingList.size(); i++) {
            System.out.println(votingList.get(i).getQuestion());
        }
    }

    /**
     * print voting
     *
     * @param a of voting
     */
    public void printVoting(int a) {
        System.out.println(votingList.get(a).getQuestion());

        for (int i = 0; i < votingList.get(a).getPolls().size(); i++) {
            System.out.println(votingList.get(a).getPolls().get(i));
        }
    }

    /**
     * voting
     *
     * @param person      is person
     * @param index     of voting
     * @param choices     his choices
     */
    public void vote(Person person, int index, ArrayList<String> choices) {

        votingList.get(index).vote(person, choices);
    }

    /**
     * create voting
     *
     * @param a is number of voting
     */
    public void getResult(int a) {
        votingList.get(a).printVotes();
    }
}
