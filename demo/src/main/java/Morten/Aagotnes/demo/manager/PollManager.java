package Aagotnes.demo.manager;


import Aagotnes.demo.domain.User;
import Aagotnes.demo.domain.Poll;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {

    private Map<String, User> users = new HashMap<>();
    private Map<String, Poll> polls = new HashMap<>();

    public PollManager(){

    }


    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void addPoll(Poll poll) {
        polls.put(poll.getQuestion(), poll);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public Poll getPoll(String question) {
        return polls.get(question);
    }

}
