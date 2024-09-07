package Morten.Aagotnes.demo.controllers;

import Morten.Aagotnes.demo.domain.Poll;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/polls")
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
}