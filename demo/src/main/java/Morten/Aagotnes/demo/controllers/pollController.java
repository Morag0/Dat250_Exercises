package Morten.Aagotnes.demo.controllers;

import Morten.Aagotnes.demo.domain.Poll;
import Morten.Aagotnes.demo.domain.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



@RestController
@RequestMapping("/polls")
@CrossOrigin(origins = "http://localhost:5173")
public class PollController {

    private final List<Poll> polls = new ArrayList<>();
    private final AtomicInteger pollIdCounter = new AtomicInteger();


    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        poll.setId(pollIdCounter.incrementAndGet());
        polls.add(poll);
        return poll;
    }


    @GetMapping
    public List<Poll> listPolls() {
        return polls;
    }


    @GetMapping("/{id}")
    public Poll getPoll(@PathVariable int id) {
        return polls.stream().filter(poll -> poll.getId() == id).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable int id) {
        polls.removeIf(poll -> poll.getId() == id);
    }

    // New method to upvote an option
    @PostMapping("/{pollId}/options/{index}/upvote")
    public void upvoteOption(@PathVariable int pollId, @PathVariable int index) {
        Poll poll = polls.stream().filter(p -> p.getId() == pollId).findFirst().orElse(null);
        if (poll != null && index >= 0 && index < poll.getOptions().size()) {
            VoteOption option = poll.getOptions().get(index);
            option.setVotes(option.getVotes() + 1);
        }
    }

    // New method to downvote an option
    @PostMapping("/{pollId}/options/{index}/downvote")
    public void downvoteOption(@PathVariable int pollId, @PathVariable int index) {
        Poll poll = polls.stream().filter(p -> p.getId() == pollId).findFirst().orElse(null);
        if (poll != null && index >= 0 && index < poll.getOptions().size()) {
            VoteOption option = poll.getOptions().get(index);
            option.setVotes(option.getVotes() - 1);
        }
    }



}