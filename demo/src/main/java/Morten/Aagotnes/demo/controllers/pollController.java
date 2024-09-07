package Aagotnes.demo.controllers;

import Aagotnes.demo.domain.Poll;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    private final List<Poll> polls = new ArrayList<>();


    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        polls.add(poll);
        return poll;
    }


    @GetMapping
    public List<Poll> listPolls() {
        return polls;
    }


    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable int id) {
        if (id >= 0 && id < polls.size()) {
            polls.remove(id);
        }
    }
}